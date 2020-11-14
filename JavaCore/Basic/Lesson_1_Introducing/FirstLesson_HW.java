package Geekbrains.AndroiDev.Lesson1_HW;

public class FirstLesson_HW {
    public static void main(String[] args) {
        // Types variable.
        int i = 5;
        float f = 1.2f;
        double d = 3.1416;
        long l = 358694L;
        char ch = '\u2242';
        boolean bool = false;
        String s = "Hello!";

        // Output Variables.
        System.out.println("Integer (int) = " + i);
        System.out.println("float = " + f);
        System.out.println("double = " + d);
        System.out.println("long = " + l);
        System.out.println("char = " + ch);
        System.out.println("boolean = " + bool);
        System.out.println("String = " + s);

        System.out.println("\nMethods results:");
        // Output calculate method.
        System.out.println("Result calculating by formula: a * (b + (c / d)) = " + calculate(5, 8, 7, 9));
        // Output checkSum method.
        System.out.println("Checking sum two numbers if it between 10 and 20 will return" +
                " \"True\": " + checkSum(2, 1));
        // Output positiveOrNegative method.
        positiveOrNegative(-10);
        // Output isNegative method.
        System.out.println("If number is negative, will return \"True\": " + isNegative(-5));
        // Output hello method.
        hello("Mister! :)");
        // Output year.
        year(2020);
    }
    // This method returns the result of a mathematical operation on 4 floating point numbers.
    public static float calculate(float a, float b, float c, float d){
        return (a * (b + (c / d)));
    }
    // This method returns a boolean result if the sum of the numbers is in the range from 10 to 20 (inclusive)
    public static boolean checkSum(int x, int y){
        return (x + y) >= 10 && (x + y) <= 20;
    }
    // This method displays on the screen whether the number is positive or negative.
    public static void positiveOrNegative(int x){
        if (x >= 0){
            System.out.println("Number " + x + " is positive");
        } else {
            System.out.println("Number " + x + " is negative");
        }
    }
    // Method for checking if a number is negative.
    public static boolean isNegative(int x){
        return (x < 0);
    }
    // A method that displays a greeting named.
    public static void hello(String name){
        System.out.println("Hello, " + name);
    }
    // The method checks if the year is a leap year.
    public static void year(int year){
        if (year % 4 != 0 || year % 100 == 0 && year % 400 != 0){
            System.out.println(year + " is normal.");
        } else {
            System.out.println(year + " is a leap");
        }
    }
}
