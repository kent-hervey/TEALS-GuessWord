// This program plays a game of hangman with the user.  It reads a dictionary
// of words to choose from.

import java.io.*;
import java.util.*;

public class Hangman {
    // the computer's word
    public static final int MAX_GUESSES = 6;
    
    // runs the program
    public static void main(String[] args) throws FileNotFoundException {
        introduction();
        Scanner console = new Scanner(System.in);
        Scanner input = new Scanner(new File("hangman.txt"));
        String[] dictionary = readDictionary(input);
        Random rand = new Random();
        playManyGames(console, rand, dictionary);
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

    // plays many games of Hangman
    public static void playManyGames(Scanner console, Random rand,
                                     String[] dictionary) {
        int games = 0;
        int wins = 0;
        
        // loop to play many games
        do {
            games++;
            String word = dictionary[rand.nextInt(dictionary.length)];
            if (playGame(console, word) > 0) {
                wins++;
            }
            System.out.print("Do you want to play again? ");
        }
        while (console.next().toLowerCase().startsWith("y"));
        
        reportStats(games, wins);
    }
    
    // Plays one guessing game and returns the number of
    // guesses needed to win the game.
    public static int playGame(Scanner console, String word) {
        int guesses = 0;
        String guessLetters = "";

        int missing = word.length();
        print(word, guessLetters);
        
        do {
            printGallows(guesses);
            System.out.println("Incorrect guesses = " + guesses);
            guessLetters = getGuess(console, guessLetters);
            
            int oldMissing = missing;
            missing = print(word, guessLetters);
            if (missing == oldMissing) {
                // not found
                guesses++;
            }
        } while (missing > 0 && guesses < MAX_GUESSES);
        
        if (missing == 0) {
            System.out.println("You won in " + guesses + " guesses.");
        } else {
            printGallows(guesses);
            System.out.println("You lose.");
            System.out.println("The correct answer was " + word);
        }
        
        System.out.println();
        
        return guesses;
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

    public static int print(String word, String guesses) {
        int missing = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (guesses.indexOf(letter) >= 0) {
                System.out.print(letter);
            } else {
                System.out.print(".");
                missing++;
            }
        }
        System.out.println();
        return missing;
    }
    
    // Prompts the user for a number guess and returns it.
    public static String getGuess(Scanner console, String guessLetters) {
        System.out.println(guessLetters);
        System.out.print("Guess a letter: ");
        String guess = console.next();
        while (guessLetters.indexOf(guess) >= 0) {
            System.out.print("Invalid letter, try again: ");
            guess = console.next();
        }
        System.out.println();
        return guessLetters + guess;
    }
    
    // Prints introductory information about the program.
    public static void introduction() {
        System.out.println("This program plays the game of hangman.  I will");
        System.out.println("pick a word at random and will allow you to");
        System.out.println("to guess my word.");
        System.out.println();
    }
    
    // Prints the statistical information at the end of the program
    // about all games.
    public static void reportStats(int games, int wins) {
        System.out.println();
        System.out.println("Overall results:");
        System.out.println("total games    = " + games);
        System.out.println("total wins     = " + wins);
        System.out.println("win percentage = " + round2(100.0 * wins / games));
    }
    
    // Rounds the given real number to the nearest hundredth.
    public static double round2(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
