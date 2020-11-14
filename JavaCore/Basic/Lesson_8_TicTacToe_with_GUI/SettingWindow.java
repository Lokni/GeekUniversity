package Lesson8;

import javax.swing.*;
import java.awt.*;

public class SettingWindow extends JFrame {
    private GameWindow gameWindow;
    static final int POSITION_X = GameWindow.POSITION_X + 50;
    static final int POSITION_Y = GameWindow.POSITION_Y + 50;
    static final int WINDOW_WIDTH = 400;
    static final int WINDOW_HEIGHT = 400;
    static final int MODE_H_VS_AI = 0;
    static final int MODE_H_VS_H = 1;
    private static final int MIN_LENGTH_SIZE = 3;
    private static final int MAX_LENGTH_SIZE = 21;

    private JRadioButton humVShum;
    private JRadioButton humVSai;
    private ButtonGroup gameModeGroup;

    private JSlider sliderFieldSize;
    private JSlider sliderWinLength;

    public SettingWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBounds(POSITION_X, POSITION_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Settings");

        setLayout(new GridLayout(8, 1));
        add(new JLabel("Chose Game Mod:"));

        humVSai = new JRadioButton("Human VS AI", true);
        humVShum = new JRadioButton("Human VS Human");
        gameModeGroup = new ButtonGroup();
        gameModeGroup.add(humVSai);
        gameModeGroup.add(humVShum);
        add(humVSai);
        add(humVShum);
        humVShum.setEnabled(false);

        add(new JLabel("Chose Field Size:"));
        sliderFieldSize = new JSlider(MIN_LENGTH_SIZE, MAX_LENGTH_SIZE, MIN_LENGTH_SIZE);
        sliderFieldSize.setMajorTickSpacing(2);
        sliderFieldSize.setPaintLabels(true);
        sliderFieldSize.setPaintTicks(true);
        add(sliderFieldSize);


        add(new JLabel("Chose Length For Win:"));
        sliderWinLength = new JSlider(MIN_LENGTH_SIZE, MIN_LENGTH_SIZE, MIN_LENGTH_SIZE);
        sliderWinLength.setMajorTickSpacing(1);
        sliderWinLength.setPaintLabels(true);
        sliderWinLength.setPaintTicks(true);
        add(sliderWinLength);

        sliderFieldSize.addChangeListener(e -> {
            if (sliderFieldSize.getValue() % 2 == 0) {
                sliderFieldSize.setValue(sliderFieldSize.getValue() - 1);
            }
            sliderWinLength.setMaximum(sliderFieldSize.getValue());
        });

        JButton buttonStartGame = new JButton("Start Game!");
        add(buttonStartGame);
        buttonStartGame.addActionListener(e -> {
            int mode;
            if (humVSai.isSelected()) {
                mode = MODE_H_VS_AI;
            } else {
                mode = MODE_H_VS_H;
            }
            int fieldSize = sliderFieldSize.getValue();
            int winLength = sliderWinLength.getValue();

            Logic.size = fieldSize;
            Logic.dotForWin = winLength;
            Logic.initMap();
            Logic.isFinishedGame = false;

            gameWindow.startNewGame(mode, fieldSize, winLength);

            setVisible(false);
        });
        setVisible(false);
    }
}
