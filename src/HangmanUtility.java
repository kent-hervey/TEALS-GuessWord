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
	

}
