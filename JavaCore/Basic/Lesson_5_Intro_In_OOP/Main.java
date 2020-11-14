package Lesson5;

public class Main {

    static void ageSort(Person[] array){
        for (Person person : array) {
            if (person.getAge() > 40) {
                person.info();
            }
        }
    }
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan Ivonovich", "Fitter", "vovan1976@mail.ru",
                "+7123456789", 60_000, 44);
        persArray[1] = new Person("Petrov Peter Petrovich", "Manager", "PiterP@yahoo.com",
                "+7198765432", 45_000, 40);
        persArray[2] = new Person("Taratorkina Elizaveta Mihhailovna", "Secretary", "zaika23@mail.ru",
                "+7123459876", 80_000, 24);
        persArray[3] = new Person("Radionov Radion Radionovich", "Director", "Radionov.Radion@gmail.com",
                "+7543216789", 500_000, 52);
        persArray[4] = new Person("Lopushinskiy Nikolay Olegovich", "Courier", "Nickolas777@yandex.ru",
                "+7543219876", 30_000, 22);

        //persArray[3].info();
        ageSort(persArray);
    }
}
