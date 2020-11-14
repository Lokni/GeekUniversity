package Lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int POSITION_X = 450;
    static final int POSITION_Y = 150;
    static final int WINDOW_WIDTH = 500;
    static final int WINDOW_HEIGHT = 500;

    private BattleField battleField;
    private SettingWindow settingWindow;

    public GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POSITION_X, POSITION_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");

        battleField = new BattleField(this);
        add(battleField, BorderLayout.CENTER);

        settingWindow = new SettingWindow(this);

        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        JButton buttonNewGame = new JButton("Start New Game");
        JButton buttonExit = new JButton("Exit");

        jPanel.add(buttonNewGame);
        jPanel.add(buttonExit);
        add(jPanel, BorderLayout.SOUTH);

        buttonNewGame.addActionListener(e -> settingWindow.setVisible(true));
        buttonExit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public void startNewGame(int mode, int fieldSize, int winLength){
        battleField.startNewGame(mode, fieldSize, winLength);
    }

}
