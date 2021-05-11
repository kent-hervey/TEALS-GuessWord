import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.bind.annotation.W3CDomHandler;

public class MayClassTester {
	
	public static final int MAX_GUESSES = 6;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String filename = "hangman.txt";
		
		
		//testing readDictionary to see if it reads all words from input file of words
		String[] dictionary = HangmanUtility.readDictionary(new Scanner(new File(filename)));
		
		//testing dictionary by seeing output
		HangmanUtility.printFirst10Array(dictionary);
		
		//tests getRandomWord which should return a word from dictionary
		String foundWord = HangmanUtility.getRandomWord(dictionary);
		System.out.println("random word found:  " + foundWord);
		
//		String usersGuessedLetter = HangmanUtility.getGuessFromUser();
//		System.out.println("user entered this letter:  " + usersGuessedLetter);
//		
//		boolean letterInWord = HangmanUtility.isUsersGuessInWord(foundWord, usersGuessedLetter);
//		System.out.println("word is " + foundWord + " and letter is in it? " + letterInWord);
		
		//test gallows with 1-6 bad guesses
//		for(int i = 0; i <7; i++) {
//			HangmanUtility.printGallows(i);
//		}
		
		//asks user six times for letters, then checks if each is in foundWord
		//returns number of failed guesses
//		int numberBadGuessesOfSix = HangmanUtility.runSixGuesses(foundWord); 
//		System.out.println("for the word " + foundWord + " you guessed 6 times, with this many wrong guesses:  " + numberBadGuessesOfSix);
		
		//asks user six times for letters, then checks if each is in foundWord, tracking how many letters missing
		//returns number of failed guesses
//		int numberBadGuessesOfSixTracked = HangmanUtility.runSixGuessesTracked(foundWord); 
//		System.out.println("xfor the word " + foundWord + " you guessed 6 times, with this many wrong guesses:  " + numberBadGuessesOfSixTracked);
		
		//asks user until word complete or 6 failures for letters, then checks if each is in foundWord, tracking how many letters missing
		//returns number of failed guesses
		int numberBadGuessesOfSixOrMore = HangmanUtility.runSixGuessesOrMore(foundWord); 
		System.out.println("zfor the word " + foundWord + " you guessed with this many wrong guesses:  " + numberBadGuessesOfSixOrMore);

	}

}
