package Lesson_2_Exceptions;

public class MyArrayDataException extends NumberFormatException {

    public MyArrayDataException() {
        super();
        System.out.println("Symbol or String find in Array!");
    }
}
