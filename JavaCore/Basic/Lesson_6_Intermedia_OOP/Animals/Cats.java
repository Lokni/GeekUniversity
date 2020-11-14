package Lesson6.Animals;

public class Cats extends Animals {

    public Cats(String name) {
        super(name);
        distance = 200;
        swimDistance = 0;
        super.catCount++;
    }

    @Override
    public void swim(int dist) {
        System.out.println("Cats can't swim, that is, they can but do not like :)");
    }
}
