package Lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;
    private int hungry;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = appetite * 5;
    }

    public void eat(Plate p) {
        if (p.getFoodVolume() == 0 || appetite > p.getFoodVolume()) {
            System.out.println("Not enough food in the bowl.");
            return;
        }
        if (!satiety() && p.getFoodVolume() > 0) {
            p.decreaseFoodVolume(appetite);
            System.out.printf("%s ate %d units from my bowl.\n", name, appetite);
        } else if (satiety()) {
            System.out.printf("%s full and does not want to eat anymore\n", name);
        }
    }

    public void eatFromJointPlate(Plate h) {
        if (h.getFood() == 0 || appetite > h.getFood()) {
            System.out.println("Not enough food in the bowl.");
            return;
        }
        if (!satiety() && h.getFood() > 0) {
            h.decreaseFood(appetite);
            System.out.printf("%s ate %d units from my bowl.\n", name, appetite);
        } else if (satiety()) {
            System.out.printf("%s full and does not want to eat anymore\n", name);
        }
    }

    public boolean satiety() {
        if (hungry <= 0) {
            satiety = true;
        } else {
            hungry -= appetite;
        }
        return satiety;
    }

    public void getHungry() {
        System.out.printf("%s can eat another %d in food units.\n", name, hungry);
    }

    public int getAppetite() {
        return appetite;
    }
}
