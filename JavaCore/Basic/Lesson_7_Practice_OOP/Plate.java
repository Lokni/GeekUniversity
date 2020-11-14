package Lesson7;

public class Plate {
    private int foodVolume;
    static int food;

    public Plate(int foodVolume) {
        this.foodVolume = foodVolume;
        this.food = foodVolume * 5;
    }

    public void foodInfo(){
        System.out.printf("There are %d food in the plate.\n", foodVolume);
        System.out.printf("%d food in a shared bowl.\n", food);
    }
    public void decreaseFoodVolume(int h){
        if (h > foodVolume){
            foodVolume = 0;
            return;
        }
        if (foodVolume == 0){
            System.out.println("The food in the bowl has run out.");
        } else {
            foodVolume -= h;
        }
    }
    public void decreaseFood(int h){
        if (h > food){
            food = 0;
            return;
        }
        if (food == 0){
            System.out.println("The food in the bowl has run out.");
        } else {
            food -= h;
        }
    }

    public void setFoodVolume(int foodVolume) {
        this.foodVolume = foodVolume;
    }

    public int getFoodVolume() {
        return foodVolume;
    }

    public void setFood(int food) {
        Plate.food = food;
    }

    public int getFood() {
        return food;
    }
}
