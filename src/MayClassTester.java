import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MayClassTester {

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
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
