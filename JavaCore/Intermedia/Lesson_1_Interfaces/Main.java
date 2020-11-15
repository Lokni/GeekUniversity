package Lesson_1_Interfaces.Lesson_1_HW;

import Lesson_1_Interfaces.Lesson_1_HW.Obstacles.Obstacles;
import Lesson_1_Interfaces.Lesson_1_HW.Obstacles.Track;
import Lesson_1_Interfaces.Lesson_1_HW.Obstacles.Wall;
import Lesson_1_Interfaces.Lesson_1_HW.Person.Actions;
import Lesson_1_Interfaces.Lesson_1_HW.Person.Cat;
import Lesson_1_Interfaces.Lesson_1_HW.Person.Human;
import Lesson_1_Interfaces.Lesson_1_HW.Person.Robot;

public class Main {


    public static void main(String[] args) {
        Actions[] racers = {new Human("Arkadiy", 8000, 2),
                new Robot("Samovar", 12000, 0),
                new Cat("Matroskin", 1500, 1)};
        Obstacles[] obstacles = {new Wall(1), new Track(5000)};

        for (Obstacles o : obstacles) {
            for (Actions r : racers) {
                o.run(r);
                o.jump(r);
            }
        }
    }

}
