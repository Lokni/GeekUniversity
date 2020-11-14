package Lesson6.Animals;

public class Animals {
     private String name;
     protected static int dogCount = 0;
     protected static int catCount = 0;
     protected int distance;
     protected int swimDistance;

     public Animals(String name){
         this.name = name;
         this.distance = 0;
     }



    public void run(int dist) {
        if (distance == 0){
            System.out.printf("%s tired and can't run anymore.\n", name);
        }
        if (distance < dist && distance > 0){
            System.out.printf("%s can run %d more meters. \n",name, distance);
        } else if (distance > 0){
            System.out.printf("%s ran %d meters.\n", name, dist);
            distance -= dist;
        }
    }
    public void swim(int dist) {
        if (swimDistance < dist){
            System.out.printf("%s can swim only up to %d meters.\n", name, swimDistance);
        } else if (swimDistance > 0){
            System.out.printf("%s swam %d meters.\n", name, dist);
            swimDistance -= dist;
        } else {
            System.out.printf("%s tired and can't swim anymore.\n", name);
        }
    }

    public String getName() {
        return name;
    }

    public void dogQuantity(){
        System.out.println("We have " + dogCount + " dogs.");
    }

    public void catQuantity(){
        System.out.println("We have " + catCount + " cats.");
    }
    public void totalQuantity(){
        System.out.println("In general, we have " + (catCount + dogCount) + " animals.");
    }
}
