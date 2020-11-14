1. Write a program that guesses a random number from 0 to 9,
   and the user is given 3 attempts to guess this number. With each attempt,
   the computer must report whether the number specified by the user is greater than the guessed one,
   or less.
   After winning or losing, a request is displayed - “Do you want to repeat the game again?
   1 - yes / 0 - no "(1 - repeat, 0 - no).
2 * Create an array of words String [] words = {"apple", "orange", "lemon",
			 "banana", "apricot", "avocado", "broccoli", "carrot",
			 "cherry", "garlic","grape","melon","leak",
			"kiwi","mango ,"mushroom","nut","olive","pea",
			"peanut","pear","pepper", "pineapple", "pumpkin", "potato"};

When the program starts, the computer thinks out a word, asks the user for an answer,
compares it with the hidden word and reports whether the user answered correctly.
If the word is not guessed, the computer shows the letters that are in their places.
apple - hidden
apricot - player response
ap ############# (15 characters so that the user cannot find out the word length)
To compare two words character by character, you can use:
String str = "apple";
str.charAt (0); - method, will return char, which is in the word str in the first position
We play until the player guesses the word
We use only small letters