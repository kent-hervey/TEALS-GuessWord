Chapter 7, pp2  Question
Write a game of Hangman using arrays. Allow the user to guess letters and represent which letters have been guessed in an array.

Programming Project - Hangman						Date: _________________

Objective:  Write a game of Hangman using arrays. Allow the user to guess letters and represent which letters have been guessed in an array.

In this program, you will write methods that will play a game of hangman. Your program should do the following:

Print an introductory statement when the game first starts
Read from a file of 100 words into an array variable
Choose a word at random from your array
Ask the user to enter letter guesses for your random word
Determine if the letter guessed is present in the word
If so, display the word with all correct letter guesses
Determine if the letter guessed is not present in the word
If so, draw the hangman with the appropriate amounts of body parts (incorrect guesses)
Game should loop until word is correctly guessed or number of incorrect guesses exceeds limit

Start with the code below. Please note that the code to read in the 100 word into an array is given to you, along with the method to draw the hangman progress (printGallows() ).





// This program plays a game of hangman with the user.  It reads a dictionary
// of words to choose from.

import java.io.*;
import java.util.*;

public class hangman {
    // the computer's word
    public static final int MAX_GUESSES = 6;
    
    // runs the program
    public static void main(String[] args) throws FileNotFoundException {
        // Method to print introductory information about the program

    	// Read in list of words
        Scanner console = new Scanner(System.in);
        Scanner input = new Scanner(new File("hangman.txt"));
        String[] dictionary = readDictionary(input);
        
        // Method to play one game of hangman with a random word from the array
        
        // Method to report the results of the game (win or lose, and what the word was if they lost)
    }

    // reads the dictionary file; first line indicates number of words
    public static String[] readDictionary(Scanner input) {
        // read first line, extract int
        int count = new Scanner(input.nextLine()).nextInt();
        String[] words = new String[count];
        int i = 0;
        while (input.hasNextLine()) {
            words[i] = input.nextLine();
            i++;
        }
        return words;
    }
    
    // Plays one guessing game and returns the number of
    // guesses needed to win the game.
    public static int playGame(Scanner console, String word) {
    	// Write a loop that asks to enter a letter
    	// Check entered letter to see if it exists in word
    	// If letter exists in word
    	//    display word with instances of letter
    	// else
    	//    increment number of incorrect guesses
    	// Display hangman progress (call printGallows method) - exit loop when word guessed or too many incorrect guesses
    }
    
    // Draws a hangman figure with appropriate body parts for the number
    // of incorrect guesses, adding a head, torso, legs, and arms.
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
