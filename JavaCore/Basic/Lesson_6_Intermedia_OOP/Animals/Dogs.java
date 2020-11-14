package Lesson6.Animals;

public class Dogs extends Animals{

    public Dogs(String name) {
        super(name);
        distance = 500;
        swimDistance = 10;
        super.dogCount++;
    }
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void dogQuantity() {
        super.dogQuantity();
    }
}
