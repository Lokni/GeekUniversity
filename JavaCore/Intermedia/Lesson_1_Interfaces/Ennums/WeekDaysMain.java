package Lesson_1_Interfaces.Lesson_1_HW.Ennums;

public class WeekDaysMain {
    public static void main(String[] args) {
        workingHours(WeekDays.Saturday);

    }

    public static void workingHours(WeekDays days) {
        int numbersOfDays = 0;
        for (WeekDays d: WeekDays.values()) {
            if (d.getWorkingHours() > 0){
                numbersOfDays++;
            }
        }
        switch (days) {
            case Monday -> System.out.println("Stay " + (WeekDays.Monday.getWorkingHours() * numbersOfDays) + " hours");
            case Tuesday -> System.out.println("Stay " + (WeekDays.Tuesday.getWorkingHours() * (numbersOfDays - 1)) + " hours");
            case Wednesday -> System.out.println("Stay " + (WeekDays.Wednesday.getWorkingHours() * (numbersOfDays - 2)) + " hours");
            case Thursday -> System.out.println("Stay " + (WeekDays.Thursday.getWorkingHours() * (numbersOfDays - 3)) + " hours");
            case Friday -> System.out.println("Stay " + (WeekDays.Friday.getWorkingHours() * (numbersOfDays - 4)) + " hours");
            case Saturday, Sunday -> System.out.println("Today is weekend");
        }
    }
}
