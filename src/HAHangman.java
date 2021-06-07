/* Hudson Arney
 * Mrs. Buske
 * AP Computer Science A
 * 26 May 2021
 * Project: Hangman
 */

//This program plays a game of hangman with the user.  It reads a dictionary
//of words to choose from.

import java.io.*;
import java.util.*;

public class HAHangman {
	
	public static final int MAX_GUESSES = 6;
	
	// PIVs used throughout the program
	private static int wrongGuesses;
	private static int testAid;

 public static void main(String[] args) throws FileNotFoundException {

     // Reads the text file and creates an array of all the words
     Scanner console = new Scanner(System.in);
     Scanner input = new Scanner(new File("hangman.txt"));
     String[] dictionary = readDictionary(input);
     
    // Plays one game of Hangman with a random word from the text file
    int randomNum = (int)((Math.random() * dictionary.length)+1);
    String word = dictionary[randomNum];
    word = "aaaaaaaaaa";
    System.out.println("word is:  " + word);
    String[] wordArray = new String[word.length()];
    
    // Prints the letter if it applies in a line that is the length of the word choosen. The guessed letter will be stored in its correct place throughout the game.
 	for(int i = 0; i < wordArray.length; i++) {
 		wordArray[i] = "_";
 	}
 	
 	// Introduction
 	System.out.println("Get ready because you're about to play Hangman!\nYou will need to guess what the random word that the computer picks!\nChoose wisely, you only have 6 wrong guesses.");
 	int incorrectGuesses = 0;
 	testAid = word.length();
 	
 	// Continues to play the game until there are 6 wrong guesses or the word is completed
 	while(!(incorrectGuesses == 6 || testAid == 0)) {
 		System.out.print("\nWhats your letter guess?: ");
 		
 		String str = console.nextLine();
 		
 		// input is scanner object; word is secret word; str is user's letter guess, wordArray is collection of correct guessed letters and position
 		incorrectGuesses = (playGame(input, wordArray, word, str)); 
 		System.out.println("Result of your guess is:  " + Arrays.toString(wordArray));
 	}
     // Reports the results of the game once it is finished
 	if(incorrectGuesses == 6) {
 	 	System.out.print("\nYou Lose! ");
 	 	System.out.println("The word was: "+ word + "\nFeel free to run the program and try again.");
 	 	}
 	else {
 		System.out.println("\nYou win! Great work on guessing " + word + "! Run to play again.");
 	}
 }

 public static int getwrongGuesses() {
	 return wrongGuesses;
 }
 public static int getcheckHelp() {
	 return testAid;
 }

 // Reads the dictionary file
 public static String[] readDictionary(Scanner input) {
     int count = new Scanner(input.nextLine()).nextInt();
     String[] words = new String[count];
     int i = 0;
     while (input.hasNextLine()) {
         words[i] = input.nextLine();
         i++;
     }
     return words;
 }
 
 // Plays one guessing game and returns the number of guesses needed to win the game.
 //arr is collection of correct guessed letters and position.  Unguessed letters hold underscrore
 //str is user's current guess letter
 //word is secret word
 public static int playGame(Scanner console, String[] arr, String word, String str) {
		 if(word.indexOf(str) >= 0 && !(str.length() == 0) && !(str == null)) {
			 //System.out.println("inside playGame and word is:  " + word);
			 testAid--;
			 int index = word.indexOf(str);
			 System.out.println("index of where word contains guessed letter:  " + index);
			 arr[index] = str; 
			 String wordFix = (word.substring(0, index)+word.substring(index+1));
			 //worFix holds secret word, but excluding the position at index where guessed letter was found
			 if(wordFix.indexOf(str) >= 0) {
				 testAid--;
				 index = (wordFix.indexOf(str)+1);
				 System.out.println("now index is the position of guessed letter in the string that does not include previously found location:  " + index);
				 arr[index] = str; 
			 }
			 
			 for(int i = 0; i < arr.length; i++) {
				 System.out.print(arr[i]);
			 }
			System.out.println();
		 }
			 
		else {
			wrongGuesses ++;

		 }
		 
		 int badguesses = (wrongGuesses);
		 			printGallows(wrongGuesses);
		 return badguesses;
		 }
	 
 
 
 // Draws a Hangman figure with appropriate body parts for the number of incorrect guesses, adding in order: a head, torso, legs, and arms.
 public static void printGallows(int guesses) {
     System.out.println(" +--+");
     System.out.println(" |  |");
     if (guesses == 0) {
         System.out.println(" |");
     } else {
         System.out.println(" |  O");
     }
     if (guesses <= 1) {
         System.out.println(" |");
     } else if (guesses <= 4) {
         System.out.println(" |  |");
     } else if (guesses == 5) {
         System.out.println(" |  |\\");
     } else {
         System.out.println(" | /|\\");
     }
     if (guesses <= 2) {
         System.out.println(" |");
     } else if (guesses == 3) {
         System.out.println(" |   \\");
     } else {
         System.out.println(" | / \\");
     }
     System.out.println(" |");
     System.out.println(" +-----");
 }

 
}