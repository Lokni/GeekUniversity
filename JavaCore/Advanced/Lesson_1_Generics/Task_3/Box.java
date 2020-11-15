package Lesson_1.Task_3;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private List<T> fruitsBox = new ArrayList<>();

    public List<T> getFruitsBox() {
        return fruitsBox;
    }

    public void addFruitInBox(T fruit) {
        fruitsBox.add(fruit);
    }

    public void info (){
        if (fruitsBox.isEmpty()){
            System.out.println("Box is empty");
        } else {
            System.out.println("In box " + fruitsBox.size() + " "
                    + fruitsBox.get(0).getClass().getSimpleName() + "'s");
        }
    }
    public float getWeight(){
        if (fruitsBox.isEmpty()){
            return 0;
        }
        return fruitsBox.size() * fruitsBox.get(0).getWeight();
    }

    public void moveTo (Box<T> box){
        box.getFruitsBox().addAll(fruitsBox);
        fruitsBox.clear();
    }

    public boolean compare(Box<? extends Fruit> box){
        return this.getWeight() == box.getWeight();
    }


}
