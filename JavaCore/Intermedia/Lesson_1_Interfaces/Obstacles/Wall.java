package Lesson_1_Interfaces.Lesson_1_HW.Obstacles;

import Lesson_1_Interfaces.Lesson_1_HW.Person.Actions;

public class Wall implements Obstacles {
    private final int HEIGHT;

    public Wall(int height) {
        this.HEIGHT = height;
    }

    @Override
    public void jump(Actions r) {
        if (r.getJumpAbilities()>=HEIGHT){
            System.out.printf("%s jump at %d meters!\n",r.getName(), HEIGHT);
        } else {
            System.out.printf("%s can't jump to high, he have limit in %d meters in high\n", r.getName(),r.getJumpAbilities());
        }
    }

    @Override
    public void run(Actions r) {

    }
}
