package Lesson_3_Collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create ArrayList with String value.
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Mellon");
        list.add("Broccoli");
        list.add("Cucumber");
        list.add("Potato");
        list.add("Pineapple");
        list.add("Coconut");
        list.add("Tomato");
        list.add("Carrot");
        list.add("Orange");
        list.add("Lime");
        list.add("Lemon");
        list.add("Mellon");
        list.add("Cucumber");
        list.add("Peach");
        list.add("Apple");
        list.add("Banana");
        list.add("Peach");
        list.add("Tomato");
        list.add("Lemon");

        // Print result.
        System.out.println("List with vegetables without any operations:\n" + list);

        // Convert list to hash set for show unique names.
        Set<String> set = new HashSet<>(list);
        // Print result.
        System.out.println("Unique values from list:\n" + set);

        // Create map for calculating how many times the words in it are repeated.
        Map<String, Integer> mapList = new HashMap<>();
        // Cycle what will check all list.
        for (String s : list) {
            Integer count = mapList.getOrDefault(s, 0);
            mapList.put(s, count + 1);
        }
        // Print result.
        System.out.println("The list that show how many times the words in it are repeated:\n" + mapList);
    }
}
