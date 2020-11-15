package client;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class History {
    private static PrintWriter out;

    private static String getHistoryByLogin (String login){
        return (String.format("./History/history[%s].txt", login));
    }

    public static void start (String login){
        try {
            out = new PrintWriter(new FileOutputStream(getHistoryByLogin(login), true), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void stop (){
        if (out != null){
            out.close();
        }
    }
    public static void writeHistory (String msg){
        out.println(msg);
    }

    public static String getHistory(String login){
        if (!Files.exists(Paths.get(getHistoryByLogin(login)))){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        try {
            List<String>  historyList = Files.readAllLines(Paths.get(getHistoryByLogin(login)));

            int lineLimit = 100;
            int startPosition = 0;

            if (historyList.size() > lineLimit){
                startPosition = historyList.size() - lineLimit;
            }
            for (int i = startPosition; i < historyList.size(); i++) {
                sb.append(historyList.get(i)).append(System.lineSeparator());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}
