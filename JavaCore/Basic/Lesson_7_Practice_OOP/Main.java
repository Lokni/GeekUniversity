package Lesson7;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 5);
        Plate plate = new Plate(23);

        plate.foodInfo();
        cat.eat(plate);
        cat.eat(plate);
        cat.eat(plate);
        cat.getHungry();
        cat.eat(plate);
        cat.eat(plate);
        System.out.println("Add one more portion.");
        plate.setFoodVolume(5);
        cat.eat(plate);
        cat.getHungry();
        plate.foodInfo();

        System.out.println("\nCats from the cattery:\n");

        Cat[] cats = {
                new Cat("Murzik", 6),
                new Cat("Snezhok", 3),
                new Cat("Matroskin", 7),
                new Cat("Vaska", 5),
                new Cat("Tom", 4),
        };
        // Counter of cats that are already full.
        int count = 0;
        do {
            for (Cat value : cats) {
                value.eatFromJointPlate(plate);
                value.getHungry();
                plate.foodInfo();
                System.out.println();
                // If the cat is full, then it is considered and continues to feed the rest
                if (value.satiety()) {
                    count++;
                    continue;

                }
                // If the bowl runs out of food, add it.
                if (plate.getFood() < value.getAppetite() || plate.getFood() == 0) {
                    System.out.println("Added 25 food units to the common bowl.");
                    plate.setFood(25);
                }
            }
        } while (count < cats.length - 1);
    }
}
