package Lesson5;


public class Person {
    private String name;
    private String occupation;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String name, String occupation, String email, String phone, int salary, int age) {
        this.name = name;
        this.occupation = occupation;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

        public Person(){
        this.name = "No name";
        this.occupation = "Worker";
        this.email = "example@example.com";
        this.phone = "+1234567890";
        this.salary = 0;
        this.age = 0;
    }
    public void info() {
        System.out.printf("Name: %s.\nOccupation: %s.\nE-mail: %s.\nPhone: %s.\n", name, occupation, email, phone);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
        System.out.println();
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getPhone() {
        return phone;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
