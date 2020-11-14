package Lesson8;

import javax.swing.*;
import java.awt.*;

public class Attention extends JFrame {
    static final int POSITION_X = GameWindow.POSITION_X + 100;
    static final int POSITION_Y = GameWindow.POSITION_Y + 100;
    static final int WINDOW_WIDTH = 200;
    static final int WINDOW_HEIGHT = 100;
    public static String text = "";
    private static JLabel label = new JLabel(text);

    public Attention() {

        setTitle("Attention");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton jbAccept = new JButton("OK");
        setBounds(POSITION_X, POSITION_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);

        if (Logic.mapIsFull()) {
            text = "    Dead heat";
        }
        if (Logic.checkWin(Logic.DOT_O)) {
            text = "    AI win!";
        }
        if (Logic.checkWin(Logic.DOT_X)) {
            text = "    Congratulations! You won!";
        }

        label.setText(text);
        add(label, BorderLayout.CENTER);

        add(jbAccept, BorderLayout.SOUTH);
        jbAccept.addActionListener(e -> setVisible(false));
    }
}
