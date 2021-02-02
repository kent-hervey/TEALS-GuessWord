
public class HangmanApp2 {
	public static final int MAX_GUESSES = 6;

	public static void main(String[] args) {

		printIntroductoryStatement(MAX_GUESSES);
		String[] sourceWords = readTextFileReturnArrayOfWords("hangman.txt");

		String chosenWord = chooseWord(sourceWords);

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
		// TODO Auto-generated method stub
		return null;
	}

	private static String[] readTextFileReturnArrayOfWords(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void printIntroductoryStatement(int maximuGuesses) {
		System.out.println("explaining the game");

	}

}
