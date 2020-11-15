package Lesson_1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Task 1.
        String[] strArray = new String[]{"q","e","w","r","t","y"};

        System.out.println("Created array: " + Arrays.toString(strArray));
        System.out.println("Now we will change 2 elements between each other");
        swap(strArray, 1,2);
        System.out.println("Changed array: " + Arrays.toString(strArray));

        // Task 2.
        List<?> arrayList = convertArrayToArrayList(strArray);
        System.out.println(arrayList.getClass().getSimpleName() + " : " + arrayList);

    }

    // Method for task 1, swap two elements.
    private static <T> void swap(T[] array, int index1, int index2){
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // Method for task 2, convert arrays to arrayList.
    private static <T> List  convertArrayToArrayList(T[] array){
        return Arrays.asList(array);
    }
}
