package Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleField extends JPanel {
    private GameWindow gameWindow;
    private Attention attention;

    private int mode;
    private int fieldSize;
    private int winLength;

    int cellWidth;
    int cellHeight;

    private boolean isInit = false;

    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.CYAN);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (!Logic.isFinishedGame){
                    Logic.playerTurn(cellY, cellX);

                    if (Logic.isFinishedGame){
                        attention = new Attention();
                        attention.setVisible(true);
                    }
                }
                repaint();
            }
        });
    }

    public void startNewGame(int mode, int fieldSize, int winLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winLength = winLength;

        isInit = true;

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit) {
            return;
        }
        cellWidth = getWidth() / fieldSize;
        cellHeight = getHeight() / fieldSize;

        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);
        }
        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
        }

        for (int i = 0; i < Logic.size; i++) {
            for (int j = 0; j < Logic.size; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }
    }

    private void drawO(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(8));
        g.setColor(Color.RED);
        g.drawOval(cellX * cellWidth, cellY * cellHeight,
                cellWidth, cellHeight);
    }

    private void drawX(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(8));
        g.setColor(Color.GREEN);
        g.drawLine(cellX * cellWidth, cellY * cellHeight,
                (cellX + 1) * cellWidth, (cellY + 1) * cellHeight);
        g.drawLine((cellX + 1) * cellWidth, cellY * cellHeight,
                cellX * cellWidth, (cellY + 1) * cellHeight);
    }
}
