package Lesson6;

import Lesson6.Animals.*;

public class Main {
    public static void main(String[] args) {
        // Objects can be declared both through their own class and through the general one.
        Animals cat1 = new Cats("Barsik");
        Cats cat2 = new Cats("Murzik"); // Through your own.
        Animals cat3 = new Cats("Matroskin"); // Through the general.
        Cats cat4 = new Cats("Pushok");

        cat1.run(200);
        cat1.run(100);
        cat2.run(150);
        cat3.run(199);
        cat4.run(15);
        cat1.swim(5);
        cat1.catQuantity();

        System.out.println();

        Animals dog1 = new Dogs("Muhtar");
        Dogs dog2 = new Dogs("Polkan");
        Animals dog3 = new Dogs("Rex");

        System.out.println("Имя первой собаки: " + dog1.getName());
        dog1.run(400);
        dog1.swim(5);
        dog2.swim(15);
        dog2.run(500);
        dog3.swim(10);
        dog3.run(342);
        dog1.dogQuantity();
        System.out.println();
        dog3.totalQuantity();
    }
}
