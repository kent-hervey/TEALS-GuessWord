import java.util.Random;
import java.util.Scanner;

//various methods for use with hangman game


public class HangmanUtility {

	/**
	 * 
	 * @param dictionary 
	 * @return a String of a single word chosen randomly from dictionary
	 */
	static String getRandomWord(String[] dictionary) {
		Random rand = new Random(); //creates Random object, rand
		int arrayIndexOfWord = rand.nextInt(dictionary.length); //Random class has method nextInt(int bound)  see:  https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#nextInt-int-
		System.out.println(arrayIndexOfWord); //uncomment to see randomly chosen index
		return dictionary[arrayIndexOfWord];
	}
	
    /**
     * 
     *  reads the dictionary file; first line indicates number of words
     * @param input
     * @return array of all words
     */
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
	
    /**
     * Tests an array by outputing to console the first 10 elements
     * @param array
     */
	public static void printFirst10Array(String[] array) {
		System.out.println("First 10 elements of array: ");
		for(int i = 0; i <10; i++)
			System.out.println(array[i]);	
	}

	/**
	 * collects a single letter from user via console; forces repeated attempts if user enters a string with more whan one letter
	 * @return user's entered letter
	 */
	static String getGuessFromUser() {
		Scanner console = new Scanner(System.in);
		String guess = console.next();
		while (guess.length()>1) {
			System.out.println("Please enter a single character");
			guess = console.next();
		}
		return guess;

	}
	

	/**
	 * draws Gallows with size based on the number of badGuesses passed in
	 * @param badGuesses
	 */
    public static void printGallows(int badGuesses) {
        System.out.println(" +--+");
        System.out.println(" |  |");
        if (badGuesses == 0) {
            System.out.println(" |");
        } else {
            System.out.println(" |  O");
        }
        if (badGuesses <= 1) {
            System.out.println(" |");
        } else if (badGuesses <= 4) {
            System.out.println(" |  |");
        } else if (badGuesses == 5) {
            System.out.println(" |  |\\");
        } else {
            System.out.println(" | /|\\");
        }
        if (badGuesses <= 2) {
            System.out.println(" |");
        } else if (badGuesses == 3) {
            System.out.println(" |   \\");
        } else {
            System.out.println(" | / \\");
        }
        System.out.println(" |");
        System.out.println(" +-----");
    }

	static int runSixGuesses(String foundWord) {
		int numWrong =0;
		for(int i =0; i<6; i++) {
			String thisGuess = getGuessFromUser();
			boolean guessRight = HangmanUtility.isUsersGuessInWord(foundWord, thisGuess);
			if(!guessRight) {
				numWrong++;
				System.out.println("sorry, you guessed wrong; total wrong guesss:  " + numWrong + " out of " + (i +1));
			}
			else {
				System.out.println("good guess; " + thisGuess + " is in the word; you only guessed wrong this many times: " + numWrong);
			}
		}
		System.out.println("here is the gallows");
		HangmanUtility.printGallows(numWrong);
		return numWrong;
	}

	static boolean isUsersGuessInWord(String foundWord, String usersGuessedLetter) {
		return foundWord.contains(usersGuessedLetter);
	}

	/**
	 * 
	 * @param foundWord
	 * @return number of failed guesses
	 */
	public static int runSixGuessesTracked(String foundWord) {
		int numWrong = 0;
		String correctlyGuessedLetters = "";
		for(int i=0; i<6; i++) {
			String thisGuess = getGuessFromUser();
			boolean guessRight = HangmanUtility.isUsersGuessInWord(foundWord, thisGuess);
			if(!guessRight) {
				numWrong++;
				System.out.println("sorry, you guessed wrong; total wrong guesss:  " + numWrong + " out of " + (i +1));
			}
			else {
				correctlyGuessedLetters += thisGuess;
				int unfoundLetters = showWordWithRightGuesses(foundWord, correctlyGuessedLetters);
				System.out.println("-good guess; " + thisGuess + " is in the word; you only guessed wrong this many times: " + numWrong);
			}
		}
		return numWrong;
	}

	private static int showWordWithRightGuesses(String foundWord, String correctlyGuessedLetters) {
		//loop through the target/foundWord checking for matches
		int numberUnfoundWordPositions =0; //if word has only distinct letters, then this is also the number of letters unmatched
		for (int i = 0; i <foundWord.length(); i++) {
			char letter = foundWord.charAt(i);
			//if the index is greater than 0, then one of the guessed letters is in the found word.  The index is the right place to either show the word's letter, or a period
			if(correctlyGuessedLetters.indexOf(letter) >= 0) {
				System.out.print(letter);
			} else {
				numberUnfoundWordPositions++;
				System.out.print(".");
			}
		}
		return numberUnfoundWordPositions;
	}
	
	
	public static int runSixGuessesOrMore(String foundWord) {
			int numWrong = 0;
			String correctlyGuessedLetters = "";
			int unfoundLetters = foundWord.length();
			while(unfoundLetters>0 && numWrong<MayClassTester.MAX_GUESSES ) {
				String thisGuess = getGuessFromUser();
				boolean guessRight = HangmanUtility.isUsersGuessInWord(foundWord, thisGuess);
				if(!guessRight) {
					numWrong++;
					System.out.println("sorry, you guessed wrong; total wrong guesss:  " + numWrong);
				}
				else {
					correctlyGuessedLetters += thisGuess;
					unfoundLetters = showWordWithRightGuesses(foundWord, correctlyGuessedLetters);
					System.out.println("-good guess; " + thisGuess + " is in the word; you only guessed wrong this many times: " + numWrong);
				}
			}
			return numWrong;
		}
	
	
}
