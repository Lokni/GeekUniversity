package Lesson_2_HW;

   /*
    * This tutorial covers the topic of arrays and loops in Java.
    * Implemented basic methods of working with arrays using loops and branches.
    * The switch statement has not been implemented.
    * The switch statement helps to simplify long branches created with if.
    * Implemented as follows:
    * switch (condition) {
    *   case (value_1):
    *      operation;
    *      break;
    *   case (value_1):
    *      operation;
    *      break;
    *   default:
    *      operation;
    *
    * The break operator is recommended to be used in cases, otherwise,
    * The program will start executing all statements after a match.
    */

import java.util.*;

public class HomeWork2 {
    public static void main(String[] args) {
        // Initialize random.
        Random rand = new Random();
        // Create arrays for tasks 1 through 4.
        int[] arr = new int[10];
        int[] arr2 = new int[8];
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] arr4 = new int[5][5];

        // Loop filling the first array with 0 and 1.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(2);
        }
        // Loop to fill array 2.
        arr2[0] = 0;
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = arr2[i - 1] + 3;
        }
        // Output the resulting array.
        System.out.println("The resulting array for task 1: " + Arrays.toString(arr));

        // Call the method of inverting array 1.
        System.out.println("Inverted array for task 1: " + Arrays.toString(arrayInvertation(arr)));

        // Print the resulting array 2.
        System.out.println("The resulting array for task 2: " + Arrays.toString(arr2));

        // Print the array of task 3.
        System.out.println("Source array for task 3: " + Arrays.toString(arr3));
        // Вывод массива после применения метода измений.
        System.out.println("The resulting array for task 3: " + Arrays.toString(changeArray(arr3)));

        // Print the array of task 4.
        System.out.println("Two-dimensional array of task 4:");
        diagonalFilling(arr4); // Заполняем массив.
        printArr4(arr4); // Выводим при помощи метода.

        // Assignments with stars:
        System.out.println("\nAssignments with stars:\n");

        // Task 5:
        int[] arr5;
        arr5 = new int[10];
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = rand.nextInt(100);
        }
        System.out.println("The resulting array for task 5: " + Arrays.toString(arr5));
        System.out.println("Minimum array element: " + min(arr5));
        System.out.println("Maximum array element: " + max(arr5));
        // Task 6: Check array 5 for a banal balance.
        System.out.println("Is the array balanced: " + isBalanced(arr5));
        // Task 7 based on array 5, offset the element by the specified integer.
        Scanner input = new Scanner(System.in); // Call the user input method.
        System.out.print("\nEnter the number by which you want to shift the elements of the array: ");
        int n = input.nextInt(); // Request the number by which we want to shift the array elements.
        System.out.printf("The array is shifted by %d units: ", n);
        moveIndex(arr5, n);
        input.close();


    }

    // Task 1: Invert the array elements if element = 1, we invert it to 0. And vice versa.
    static int[] arrayInvertation(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        return array;
    }

    // Task 3: Elements less than 6 are multiplied by 2.
    static int[] changeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    // Task 4: method for filling the array along the diagonal.
    static void diagonalFilling(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i + j == array.length - 1) {
                    array[i][j] = 1;
                }
            }
        }
    }

    // Task 4: Output the resulting array.
    public static void printArr4(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.printf("%-4d", anInt);
            }
            System.out.println();
        }
    }

    // Task 5: Find the maximum and minimum element of the array.
    static int min(int[] array) {
        int min = array[0];
        for (int j : array) {
            if (min > j) {
                min = j;
            }
        }
        return min;
    }

    static int max(int[] array) {
        int max = array[0];
        for (int j : array) {
            if (max < j) {
                max = j;
            }
        }
        return max;
    }

    // Task 6: check the array for balance.
    static boolean isBalanced(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += array[j];
            }
            for (int j = i; j < array.length; j++) {
                sum -= array[j];
            }
            if (sum == 0) {
                return true;
            }
        }
        return false;
    }

    // Method for shifting elements by the specified size n.
    public static void moveIndex(int[] array, int n) {
        if (n >= 0) {
            System.out.println(Arrays.toString(rotateRight(array, n)));
        }
        if (n < 0) {
            n = Math.abs(n); // Converting a negative n to positive because otherwise rotate method doesn't work.
            System.out.println(Arrays.toString(rotateLeft(array, n)));
        }
    }

    private static int[] rotateLeft(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int temp = array[0];
            // A for loop was written but IDEA suggested replacing it with System.arraycopy.
            /*
             * for (int j = 0; j < array.length -1; j++) {
             *     array[j] = array[j + 1];
             * }
             */
            System.arraycopy(array, 1, array, 0, array.length - 1);
            array[array.length - 1] = temp;
        }
        return array;
    }

    private static int[] rotateRight(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int temp = array[array.length - 1];
            // A for loop was written but IDEA suggested replacing it with System.arraycopy..
            /*
             * for (int j = array.length - 1; j > 0; j--) {
             *     array[j] = array[j - 1];
             * }
             */
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = temp;
        }
        return array;
    }

}

