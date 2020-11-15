package Lesson_1_Interfaces.Lesson_1_HW.Person;

public class Human implements Actions {
    private final String NAME;
    private final int ENDURANCE;
    private final int JUMP_ABILITIES;

    public Human(String name, int endurance, int jumpAbilities) {
        this.NAME = name;
        this.ENDURANCE = endurance;
        this.JUMP_ABILITIES = jumpAbilities;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getJumpAbilities() {
        return JUMP_ABILITIES;
    }

    @Override
    public int getEndurance() {
        return ENDURANCE;
    }

}
