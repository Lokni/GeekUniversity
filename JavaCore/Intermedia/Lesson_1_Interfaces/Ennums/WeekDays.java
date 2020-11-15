package Lesson_1_Interfaces.Lesson_1_HW.Ennums;

public enum WeekDays {
    Monday(8), Tuesday(8),
    Wednesday(8), Thursday(8),
    Friday(8), Saturday(0),
    Sunday(0) ;

    private final int WORKING_HOURS;

    WeekDays(int workingHours) {
        this.WORKING_HOURS = workingHours;
    }

    public int getWorkingHours() {
        return WORKING_HOURS;
    }

}
