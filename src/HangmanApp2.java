import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class HangmanApp2 {
	public static final int MAX_GUESSES = 6;

	public static void main(String[] args) {

		printIntroductoryStatement(MAX_GUESSES);
		String[] sourceWords = readTextFileReturnArrayOfWords("hangman.txt");
		
		//temp for testing to confirm sourceWords is valid
		System.out.println("the second word is:  " + sourceWords[1]);

		String chosenWord = chooseWord(sourceWords);
		//temp for testing:
		System.out.println("chosen word is:  " + chosenWord);

		outputInformationChosenWord(chosenWord);

		// loop until word found or guesses consumed

		int numberGuesses = 0;
		boolean notFinished = true;
		boolean guessedCorrect = false;
		while (notFinished) {

			String guessedLetter = fetchLetterFromUser();

			guessedCorrect = processAndReturnResultGuess(guessedLetter);

			if (guessedCorrect) {
				informUserOfWin(numberGuesses);

				notFinished = false;
			} else {
				// user name wrong guess
				informUserOfMissedGuess(numberGuesses);

			}

			numberGuesses++;
			if (numberGuesses >= MAX_GUESSES) {
				informUserOfLoss(numberGuesses);
				notFinished = false;
			}

		}

	}

	private static void informUserOfLoss(int numberGuesses) {
		System.out.println("you lost and etc");

	}

	private static void informUserOfMissedGuess(int numberGuesses) {
		// TODO Auto-generated method stub
		System.out.println("you missed and etc");

	}

	private static void informUserOfWin(int numberGuesses) {
		// TODO Auto-generated method stub
		System.out.println("you won and etc");

	}

	private static boolean processAndReturnResultGuess(String guessedLetter) {
		// TODO Auto-generated method stub
		return false;
	}

	private static String fetchLetterFromUser() {
		// TODO Auto-generated method stub
		return null;
	}

	private static void outputInformationChosenWord(String chosenWord) {
		// Tell user the number of characters in word and maybe more
		System.out.println("target word has " + chosenWord.length() + " number of characters");

	}

	private static String chooseWord(String[] sourceWords) {
		// choosing random word by selecting a random index using random between zero and sourceWords length minus 1
		String choosenWord = "tempWord";
	    Random random = new Random();
	    int randomIndex = random.nextInt(sourceWords.length);
	    //below code block statement for testing purposes
//	    System.out.println("maximum index should be " + (sourceWords.length-1));
//	    System.out.println("final word in list should be:  " + sourceWords[sourceWords.length-1]);
//	    for(int i=0; i<1000000; i++) {
//	    	int randomIndex2 = random.nextInt(sourceWords.length);
//	    	if(randomIndex2==sourceWords.length-1) {
//	    		System.out.println("index is:  " + randomIndex2 + " and resulting word is " + sourceWords[randomIndex2]);
//	    	}
//	    }
		
		return sourceWords[randomIndex];
	}

	private static String[] readTextFileReturnArrayOfWords(String string) {
        Scanner console = new Scanner(System.in);
        Scanner input = null;
		try {
			input = new Scanner(new File("hangman.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String[] dictionary = readDictionary(input);
		return dictionary;
	}

	private static void printIntroductoryStatement(int maximuGuesses) {
		System.out.println("explaining the game");

	}
	
	//copied from assignment
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

	
	

}
