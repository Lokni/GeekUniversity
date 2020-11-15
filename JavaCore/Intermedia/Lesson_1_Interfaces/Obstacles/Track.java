package Lesson_1_Interfaces.Lesson_1_HW.Obstacles;

import Lesson_1_Interfaces.Lesson_1_HW.Person.Actions;

public class Track implements Obstacles {
    private final int LENGTH;

    public Track(int length) {
        this.LENGTH = length;
    }

    @Override
    public void run(Actions r) {
        if (r.getEndurance()>=LENGTH){
            System.out.printf("%s run %d meters!\n",r.getName(), LENGTH);
        } else {
            System.out.printf("%s can't run to much, he have limit in %d meters\n", r.getName(),r.getEndurance());
        }
    }

    @Override
    public void jump(Actions r) {

    }
}
