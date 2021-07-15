package quarter.one.level.one.lesson.eight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private final GameWindow gameWindow;
    private final Logic logic;

    private boolean isInit;
    private int fieldSize;
    private int cellWidth;
    private int cellHeight;

    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        this.logic = new Logic();
        setBackground(Style.BACKGROUND_COLOR);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                if (!isInit || logic.isGameOver()) {
                    return;
                }
                int cellX = mouseEvent.getX() / cellWidth;
                int cellY = mouseEvent.getY() / cellHeight;

                if (logic.executeStep(cellX, cellY)) {
                    repaint();
                }
            }
        });
    }

    void startNewGame(int fieldSize, int dotsToWin) {
        this.isInit = true;
        this.fieldSize = fieldSize;

        logic.startNewGame(fieldSize, dotsToWin);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (!isInit) {
            return;
        }
        graphics.setColor(Style.LINE_COLOR);
        ((Graphics2D) graphics).setStroke(Style.LINE_WIDTH);

        int panelWidth = getWidth();
        int panelHeight = getHeight();
        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;

        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellWidth;
            graphics.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            graphics.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (logic.getDotBattlefield(i, j) == Logic.DOT_X) {
                    drawDotX(graphics, j, i);
                } else if (logic.getDotBattlefield(i, j) == Logic.DOT_O) {
                    drawDotO(graphics, j, i);
                }
            }
        }

        if (logic.isGameOver()) {
            drawWinLine(graphics);
            printWinnerText(graphics, logic.getWinnerText());
        }
    }

    private void drawDotX(Graphics graphics, int x, int y) {
        graphics.setColor((!logic.isGameOver()) ? Style.LINE_DOT_X_COLOR : Style.LINE_GAME_OVER_COLOR);
        ((Graphics2D) graphics).setStroke(Style.LINE_DOT_X_WIDTH);

        graphics.drawLine(
                x * cellWidth + Style.PADDING,
                y * cellHeight + Style.PADDING,
                (x + 1) * cellWidth - Style.PADDING,
                (y + 1) * cellHeight - Style.PADDING);

        graphics.drawLine(
                x * cellWidth + Style.PADDING,
                (y + 1) * cellHeight - Style.PADDING,
                (x + 1) * cellWidth - Style.PADDING,
                y * cellHeight + Style.PADDING);
    }

    private void drawDotO(Graphics graphics, int x, int y) {
        graphics.setColor((!logic.isGameOver()) ? Style.LINE_DOT_O_COLOR : Style.LINE_GAME_OVER_COLOR);
        ((Graphics2D) graphics).setStroke(Style.LINE_DOT_O_WIDTH);

        graphics.drawOval(
                x * cellWidth + Style.PADDING,
                y * cellHeight + Style.PADDING,
                cellWidth - Style.PADDING * 2,
                cellHeight - Style.PADDING * 2);
    }

    private void printWinnerText(Graphics graphics, String text) {
        graphics.setColor(Style.WINNER_TEXT_COLOR);
        graphics.setFont(Style.WINNER_TEXT_FONT);
        ((Graphics2D) graphics).setStroke(Style.WINNER_TEXT_WIDTH);

        graphics.drawString(text, 50, 100);
    }

    private void drawWinLine(Graphics graphics) {
        if (WinLine.dotsToWin == 0) {
            return;
        }
        graphics.setColor(Style.LINE_WIN_COLOR);
        ((Graphics2D) graphics).setStroke(Style.LINE_WIN_WIDTH);

        int x1 = WinLine.positionY * cellWidth;
        int y1 = WinLine.positionX * cellHeight;
        int x2 = (x1 + (cellWidth * WinLine.dotsToWin)) * WinLine.routeY;

        int y2;
        if (WinLine.routeX >= 0) {
            y2 = (y1 + (cellHeight * WinLine.dotsToWin)) * WinLine.routeX;
        } else {
            y1 += cellHeight;
            y2 = (y1 - (cellHeight * WinLine.dotsToWin)) * (-WinLine.routeX);
        }

        // Корректируем значения, чтобы линия проходила посередине ячеек
        if (WinLine.routeX == 0) {
            y1 += cellHeight / 2;
            y2 = y1;
        }
        if (WinLine.routeY == 0) {
            x1 += cellWidth / 2;
            x2 = x1;
        }

        graphics.drawLine(x1, y1, x2, y2);
    }
}
