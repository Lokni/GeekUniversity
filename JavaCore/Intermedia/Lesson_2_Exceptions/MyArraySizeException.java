package Lesson_2_Exceptions;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        System.out.println("Array have wrong size, we require only 4x4");
        super.getStackTrace();
    }
}
