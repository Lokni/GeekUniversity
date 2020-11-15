package Lesson_3_Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    // Create basic hash map list for collect our data.
    // Phone numbers must be unique than that will be key in String format.
    // Names can repeat and will be values.
    private static HashMap<String, String> phoneBook = new HashMap<>();

    private static void add (String phone, String name){
        phoneBook.put(phone, name);
    }
    private static void get (String name){
        List<String> result = new ArrayList<>();
        phoneBook.forEach((key, value) -> {
            if (name.equalsIgnoreCase(value)) {
                result.add(key);
            }
        });
        if (result.size() == 0){
            System.out.println("No subscriber with this name found.");
        } else {
            System.out.println("Under name " + name + " we have next number/s\n" + result);
        }

    }

    public static void main(String[] args) {
        add("123456789", "Boris");
        add("123456780", "Dmitri");
        add("123456781", "Nikolai");
        add("123456782", "Vladimir");
        add("123456783", "Sergei");
        add("123456784", "Juri");
        add("123456785", "Boris");
        add("123456786", "Dmitri");
        add("123456787", "Denis");
        add("123456788", "Anton");
        add("123456790", "Igor");
        add("123456779", "Ivan");
        add("123456769", "Petr");
        add("123456759", "Mihail");
        add("123456749", "Demid");
        add("123456739", "Afonasy");
        add("123456729", "Nikolay");
        add("123456719", "Evgeniy");
        add("123456709", "Oleg");
        add("123456700", "Alexandr");

        get("Nikolay");
        System.out.println();
        get("Dmitri");
        System.out.println();
        get("Boris");
    }

}
