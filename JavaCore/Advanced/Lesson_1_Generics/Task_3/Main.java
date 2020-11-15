package Lesson_1.Task_3;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        for (int i = 0; i <= 5; i++) {
            appleBox1.addFruitInBox(new Apple());
        }
        for (int i = 0; i <= 4; i++) {
            orangeBox.addFruitInBox(new Orange());
        }

        appleBox1.info();
        appleBox2.info();
        orangeBox.info();
        System.out.println();
        System.out.println("Apple box 1 weight is: " + appleBox1.getWeight());
        System.out.println("Apple box 2 weight is: " + appleBox2.getWeight());
        System.out.println("Orange box weight is: " + orangeBox.getWeight());
        System.out.println();
        System.out.println("Now we move to fruits in second box: " );
        appleBox1.moveTo(appleBox2);
        System.out.println("Apple box 1 weight is: " + appleBox1.getWeight());
        System.out.println("Apple box 2 weight is: " + appleBox2.getWeight());
//        appleBox2.moveTo(orangeBox); // Error: different types.
        System.out.println();
        System.out.println("Compare boxes apple and orange: " + appleBox2.compare(orangeBox));

    }
}
