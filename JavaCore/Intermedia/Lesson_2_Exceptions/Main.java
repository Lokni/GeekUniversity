package Lesson_2_Exceptions;

public class Main {
    static void arrayIntConverterAndSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int[][] converted = new int[4][4];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array.length != 4 || array[i].length != 4) {
                    throw new MyArraySizeException();
                } else {
                    try {
                        converted[i][j] = Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e){
                        System.out.printf("Wrong data in array[%d][%d] = %s\n", i, j, array[i][j]);
                        throw new MyArrayDataException();
                    }
                    sum += converted[i][j];
                }
            }

        }
        System.out.println("Summary number is array is: " + sum);
    }

    public static void main(String[] args) {
        String[][] ar = new String[][]{{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "1", "2", "3"},
                {"4", "5", "6", "7"}};
        System.out.println("Array 1: All data is correct!");
        try {
            arrayIntConverterAndSum(ar);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        System.out.println("\nArray #2: In array may contains symbols or strings!");

        String[][] ar1 = new String[][]{{"1", "z", "3", "'A'"},
                {"5", "6", "7", "8"},
                {"9", "l", "z", "3"},
                {"4", "5", "6", "7"}};
        try {
            arrayIntConverterAndSum(ar1);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        System.out.println("\nArray #3: Changed array size!");

        String[][] ar2 = new String[][]{{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "1", "2", "3"}};

        try {
            arrayIntConverterAndSum(ar2);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
