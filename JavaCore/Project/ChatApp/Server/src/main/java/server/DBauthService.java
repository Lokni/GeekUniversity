package server;

import java.sql.*;

public class DBauthService implements AuthService {
    private static Connection connection;
    private static Statement stmt;

    public DBauthService() {
        try {
            connect();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        int hashPwd = password.hashCode() * 34 % 100;
        try {
            connect();
            try (PreparedStatement select = connection.prepareStatement(
                    "SELECT login, password, nickname FROM users WHERE login = ? AND password = ?")) {
                select.setString(1, login);
                select.setInt(2, hashPwd);
                try (ResultSet rs = select.executeQuery()) {
                    while (rs.next()) {
                        String calledLgn = rs.getString("login");
                        int calledPwd = rs.getInt("password");
                        String calledNick = rs.getString("nickname");
                        if (calledLgn.equals(login) && calledPwd == hashPwd) {
                            return calledNick;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public boolean registration(String login, String password, String nickname) {
        int hashPwd = password.hashCode() * 34 % 100;
        try {
            connect();
            PreparedStatement prepStmt = connection.prepareStatement(
                    "INSERT INTO users (login, password, nickname) VALUES (?,?,?);"
            );
            prepStmt.setString(1, login);
            prepStmt.setInt(2, hashPwd);
            prepStmt.setString(3, nickname);
            prepStmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            disconnect();
        }
    }

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:usersData.db");
        stmt = connection.createStatement();
    }

    @Override
    public boolean changeNick(String oldNick, String newNick) {
        try {
            connect();
            PreparedStatement prepStmt = connection.prepareStatement(
                    "UPDATE users SET nickname = ? WHERE nickname = ?"
            );
            prepStmt.setString(1, newNick);
            prepStmt.setString(2, oldNick);
            prepStmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            disconnect();
        }
    }

    public static boolean messageLogInDB(String sender, String receiver, String text, Date date) {
        try {
            connect();
            PreparedStatement psMesage = connection.prepareStatement("INSERT INTO messages (Sender, Receiver, Message, Date)" +
                    "VALUES (" +
                    "(SELECT id FROM users WHERE nickname = ?)," +
                    "(SELECT id FROM users WHERE nickname = ?)," +
                    "?, ?)");

            psMesage.setString(1, sender);
            psMesage.setString(2, receiver);
            psMesage.setString(3, text);
            psMesage.setDate(4, date);
            psMesage.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
            disconnect();
        }
    }

    private static void disconnect() {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
