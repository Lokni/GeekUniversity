package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class GameXO {
    private static Random rand = new Random();
    private static Scanner input = new Scanner(System.in);
    private static char[][] map; // The field for the game.
    private static final int SIZE = 5; // We set the size of the playing field, the value is assigned to "Constant".
    public static final int DOT_FOR_WIN = 4; // The number of chips to win.
    private static final char DOT_EMPTY = '\u2022'; // Symbol for an empty cell.
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

     /*
      * Field initialization method.
      * When starting the program, you must initialize the field
      * And fill its cells with a character from DOT_EMPTY.
      */
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    // Method for outputting the field to the console.
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%3d", i + 1);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%3c", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Add a player's turn method.
    public static void playerTurn() {
        int x, y;
        do {
            System.out.println("Enter coordinates in X and Y format\n (X) - Vertical; (Y) - Horizontal.");
            x = input.nextInt() - 1;
            y = input.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }

    // The method of checking cells, for the possibility of installing a chip in the specified cell.
    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return  (map[x][y] == DOT_EMPTY);
    }

    // We create a method AI turn.
    private static void aiTurn() {
        int x;
        int y;

        // An attempt to win yourself.
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)){
                        System.out.printf("The computer turn on a point x = %d y = %d\n", i + 1, j + 1);
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        // An attempt to prevent the enemy from winning.
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)){
                        map[i][j] = DOT_O;
                        System.out.printf("The computer turn on a point x = %d y = %d\n", i + 1, j + 1);
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        // Random turn.
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.printf("The computer turn on a point x = %d y = %d\n", x + 1, y + 1);
        map[x][y] = DOT_O;

    }

    // Check Column
    private static boolean checkColumn(char symb) {
        boolean win = false;
        int count;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                count = 0;
                for (int k = 0; k < DOT_FOR_WIN; k++) {
                    if (map[i][j] != symb) {
                        break;
                    } else {
                        if ((i + k) < SIZE && map[i + k][j] == symb) {
                            count++;
                            if (count == DOT_FOR_WIN || count == SIZE) {
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

    // Check row.
    private static boolean checkRow(char symb) {
        boolean win = false;
        int count;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                count = 0;
                for (int k = 0; k < DOT_FOR_WIN; k++) {
                    if (map[i][j] != symb) {
                        break;
                    } else {
                        if ((j + k) < SIZE && map[i][j + k] == symb) {
                            count++;
                            if (count == DOT_FOR_WIN || count == SIZE) {
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

    // Check diagonal from (0,0) to (n,n).
    private static boolean checkDiagonal(char symb) {
        boolean win = false;
        int count;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                count = 0;
                for (int k = 0; k < DOT_FOR_WIN; k++) {
                    if (map[i][j] != symb) {
                        break;
                    } else {
                        if ((i + k) < SIZE && (j + k) < SIZE && map[i + k][j + k] == symb) {
                            count++;
                            if (count == DOT_FOR_WIN || count == SIZE) {
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

    // Check diagonal from (0,n) to (n,0).
    private static boolean checkDiagonalReverse(char symb) {
        boolean win = false;
        int count;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                count = 0;
                for (int k = 0; k < DOT_FOR_WIN; k++) {
                    if (map[i][j] != symb) {
                        break;
                    } else {
                        if ((i + k) < SIZE && (j - k) >= 0 && map[i + k][j - k] == symb) {
                            count++;
                            if (count == DOT_FOR_WIN || count == SIZE) {
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


    // Win verification method.
    private static boolean checkWin(char symb) {
        return (checkColumn(symb) || checkRow(symb) || checkDiagonal(symb) || checkDiagonalReverse(symb));
    }

    // The method for checking the list is full.
    private static boolean mapIsFull() {
        for (char[] chars : map) {
            for (int j = 0; j < map[0].length; j++) {
                if (chars[j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    // The method of the game.
    public static void game() {
        initMap();
        printMap();
        while (true) {
            playerTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Congratulations, you won!");
                break;
            }
            if (mapIsFull()) {
                System.out.println("Dead heat");
                break;
            }
            aiTurn();
            printMap();

            if (checkWin(DOT_O)) {
                System.out.println("AI win!");
                break;
            }

            if (mapIsFull()) {
                System.out.println("Dead heat");
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome in TicTacToe game!");
        while (true) {
            System.out.println("Let's play?\nYes-[1]; No-[2]");
            int userAnswer = input.nextInt();
            if (userAnswer == 1) {
                game();
            } else {
                System.out.println("Good bye!");
                break;
            }
        }
    }

}
