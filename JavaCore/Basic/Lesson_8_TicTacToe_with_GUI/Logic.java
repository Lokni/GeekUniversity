package Lesson8;

import java.util.Random;
import java.util.Scanner;

public class Logic {
    static Random rand = new Random();
    static char[][] map;
    static int size;
    public static int dotForWin;
    static final char DOT_EMPTY = '\u2022';
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static boolean isFinishedGame;

    static void initMap() {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= size; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.printf("%3d", i + 1);
            for (int j = 0; j < size; j++) {
                System.out.printf("%3c", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void playerTurn(int x, int y) {
        if (!isCellValid(x, y)) {
            return;
        }
        map[x][y] = DOT_X;
        go();
    }


    static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) return false;
        return (map[x][y] == DOT_EMPTY);
    }


    static void aiTurn() {
        int x;
        int y;


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)) {
                        System.out.printf("AI turn in a point x = %d y = %d\n", i + 1, j + 1);
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        map[i][j] = DOT_O;
                        System.out.printf("AI turn in a point x = %d y = %d\n", i + 1, j + 1);
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        do {
            x = rand.nextInt(size);
            y = rand.nextInt(size);
        } while (!isCellValid(x, y));
        System.out.printf("AI turn in a point x = %d y = %d\n", x + 1, y + 1);
        map[x][y] = DOT_O;

    }

    static boolean checkColumn(char symb) {
        boolean win = false;
        int count;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                count = 0;
                for (int k = 0; k < dotForWin; k++) {
                    if (map[i][j] != symb) {
                        break;
                    } else {
                        if ((i + k) < size && map[i + k][j] == symb) {
                            count++;
                            if (count == dotForWin || count == size) {
                                win = true;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return win;
    }

    static boolean checkRow(char symb) {
        boolean win = false;
        int count;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                count = 0;
                for (int k = 0; k < dotForWin; k++) {
                    if (map[i][j] != symb) {
                        break;
                    } else {
                        if ((j + k) < size && map[i][j + k] == symb) {
                            count++;
                            if (count == dotForWin || count == size) {
                                win = true;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return win;
    }

    static boolean checkDiagonal(char symb) {
        boolean win = false;
        int count;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                count = 0;
                for (int k = 0; k < dotForWin; k++) {
                    if (map[i][j] != symb) {
                        break;
                    } else {
                        if ((i + k) < size && (j + k) < size && map[i + k][j + k] == symb) {
                            count++;
                            if (count == dotForWin || count == size) {
                                win = true;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return win;
    }

    static boolean checkDiagonalReverse(char symb) {
        boolean win = false;
        int count;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                count = 0;
                for (int k = 0; k < dotForWin; k++) {
                    if (map[i][j] != symb) {
                        break;
                    } else {
                        if ((i + k) < size && (j - k) >= 0 && map[i + k][j - k] == symb) {
                            count++;
                            if (count == dotForWin || count == size) {
                                win = true;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return win;
    }

    static boolean checkWin(char symb) {
        return (checkColumn(symb) || checkRow(symb) || checkDiagonal(symb) || checkDiagonalReverse(symb));
    }

    static boolean mapIsFull() {
        for (char[] chars : map) {
            for (int j = 0; j < map[0].length; j++) {
                if (chars[j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void go() {
        isFinishedGame = true;
        printMap();
        if (checkWin(DOT_X)) {
            System.out.println("Congratulations, You won!!!");

            return;
        }
        if (mapIsFull()) {
            System.out.println("Dead heat");

            return;
        }
        aiTurn();
        printMap();

        if (checkWin(DOT_O)) {
            System.out.println("AI win!");


            return;
        }

        if (mapIsFull()) {
            System.out.println("Dead heat");
            return;
        }
        isFinishedGame = false;
    }
}
