package quarter01.level01.lesson08;

import java.util.Random;

public class Logic {
    static final char DOT_EMPTY = '•';
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final Random random = new Random();

    private boolean isGameOver;
    private char[][] battlefield;
    private int fieldSize;
    private int dotsToWin;
    private String winnerText;

    void startNewGame(int fieldSize, int dotsToWin) {
        this.isGameOver = false;
        this.fieldSize = fieldSize;
        this.dotsToWin = dotsToWin;
        this.winnerText = "";

        initBattlefield();
        printBattlefield();
        clearWinLine();
    }

    private void initBattlefield() {
        battlefield = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                battlefield[i][j] = DOT_EMPTY;
            }
        }
    }

    private void printBattlefield() {
        for (int i = 0; i <= fieldSize; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < fieldSize; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < fieldSize; j++) {
                System.out.print(battlefield[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void clearWinLine() {
        WinLine.positionX = 0;
        WinLine.positionY = 0;
        WinLine.routeX = 0;
        WinLine.routeY = 0;
        WinLine.dotsToWin = 0;
    }

    boolean isGameOver() {
        return isGameOver;
    }

    String getWinnerText() {
        return winnerText;
    }

    char getDotBattlefield(int cellX, int cellY) {
        return battlefield[cellX][cellY];
    }

    boolean executeStep(int cellX, int cellY) {
        if (!humanStep(cellX, cellY)) {
            return false;
        }
        printBattlefield();
        if (checkWin(DOT_X, dotsToWin)) {
            winnerText = "Человек победил!";
            isGameOver = true;
            System.out.println(winnerText);
            return true;
        }
        if (isBattlefieldFull()) {
            winnerText = "Ничья!";
            isGameOver = true;
            clearWinLine();
            System.out.println(winnerText);
            return true;
        }

        aiStep();
        printBattlefield();
        if (checkWin(DOT_O, dotsToWin)) {
            winnerText = "Компьютер победил!";
            isGameOver = true;
            System.out.println(winnerText);
            return true;
        }
        if (isBattlefieldFull()) {
            winnerText = "Ничья!";
            isGameOver = true;
            clearWinLine();
            System.out.println(winnerText);
            return true;
        }
        return true;
    }

    private boolean humanStep(int cellX, int cellY) {
        if (!isCellValid(cellY, cellX)) {
            return false;
        }
        battlefield[cellY][cellX] = DOT_X;
        return true;
    }

    private void aiStep() {
        // Попытка победить самому
        // (если остался 1 ход до победы)
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (isCellValid(i, j)) {
                    battlefield[i][j] = DOT_O;
                    if (checkWin(DOT_O, dotsToWin)) {
                        return;
                    }
                    battlefield[i][j] = DOT_EMPTY;
                }
            }
        }

        // Попытка заблокировать победу игрока
        // (если остался 1 ход до победы)
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (isCellValid(i, j)) {
                    battlefield[i][j] = DOT_X;
                    if (checkWin(DOT_X, dotsToWin)) {
                        battlefield[i][j] = DOT_O;
                        return;
                    }
                    battlefield[i][j] = DOT_EMPTY;
                }
            }
        }

        // Попытка победить самому
        // (если осталось 2 хода до победы)
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (isCellValid(i, j)) {
                    battlefield[i][j] = DOT_O;
                    if (checkWin(DOT_O, dotsToWin - 1)) {
                        return;
                    }
                    battlefield[i][j] = DOT_EMPTY;
                }
            }
        }

        // Попытка заблокировать победу игрока
        // (если осталось 2 хода до победы)
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (isCellValid(i, j)) {
                    battlefield[i][j] = DOT_X;
                    if (checkWin(DOT_X, dotsToWin - 1)
                            && Math.random() < 0.5) { // Фактор случайности (чтобы блокировал не все время)
                        battlefield[i][j] = DOT_O;
                        return;
                    }
                    battlefield[i][j] = DOT_EMPTY;
                }
            }
        }

        // Ход в произвольную, не занятую ячейку
        int cellX;
        int cellY;
        do {
            cellX = random.nextInt(fieldSize);
            cellY = random.nextInt(fieldSize);
        } while (!isCellValid(cellY, cellX));

        battlefield[cellY][cellX] = DOT_O;
    }

    private boolean isCellValid(int cellY, int cellX) {
        return (battlefield[cellY][cellX] == DOT_EMPTY);
    }

    private boolean isBattlefieldFull() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (battlefield[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkWin(char dot, int dotsToWin) {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (checkLine(i, j, 0, 1, dot, dotsToWin)
                        || checkLine(i, j, 1, 0, dot, dotsToWin)
                        || checkLine(i, j, 1, 1, dot, dotsToWin)
                        || checkLine(i, j, -1, 1, dot, dotsToWin)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLine(int x1, int y1, int x2, int y2, char dot, int dotsToWin) {
        if (y1 + y2 * (dotsToWin - 1) > fieldSize - 1
                || x1 + x2 * (dotsToWin - 1) > fieldSize - 1
                || x1 + x2 * (dotsToWin - 1) < 0) {
            return false;
        }
        for (int i = 0; i < dotsToWin; i++) {
            if (battlefield[x1 + i * x2][y1 + i * y2] != dot) {
                return false;
            }
        }
        WinLine.positionX = x1;
        WinLine.positionY = y1;
        WinLine.routeX = x2;
        WinLine.routeY = y2;
        WinLine.dotsToWin = dotsToWin;
        return true;
    }
}
