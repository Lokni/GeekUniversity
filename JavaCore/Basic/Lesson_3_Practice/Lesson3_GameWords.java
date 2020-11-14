package Lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3_GameWords {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
                "potato"};

        System.out.println("Welcome to guess the word game!");
        int index = random.nextInt(words.length);
        System.out.println("One of these words was conceived\n" + Arrays.toString(words));

        // We put the word into the character array.
        char[] chars = words[index].toCharArray();
        // Create an array for checking 15 characters so that the user cannot guess the word by length.
        char[] hiddenWord = new char[15];
        // We fill the word with grids.
        for (int i = 0; i < 15; i++) {
            hiddenWord[i] = '#';
        }
        // We start the game loop.
        while (true) {
            System.out.print("Please enter a word: ");
            String userAnswer = input.nextLine().toLowerCase(); // Invert the input to lowercase.
            if (userAnswer.equals(words[index])) {
                System.out.println("Congratulations! You guessed!");
                break;
            } else {
                System.out.println("You haven't guessed...");
                char[] charsUserAnswer = userAnswer.toCharArray(); // We translate the user's response into a character array.
                for (int i = 0; i < chars.length; i++) {
                    if (i >= charsUserAnswer.length) {   // If the user's answer is less than the word length, we break the loop.
                        break;
                    }
                    if (chars[i] == charsUserAnswer[i]) { // We substitute the matching letters into the hidden word.
                        hiddenWord[i] = chars[i];
                    }
                }
                System.out.println(String.valueOf(hiddenWord)); // We display the encrypted word with the guessed letters.
            }
        }
    }
}
