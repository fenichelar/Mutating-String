import java.util.*;

/**
 *This class creates a mutating string and includes the methods that can be executed on it.
 *@author Alec Fenichel
 *@version 1.0
 *Homework 4
 *I worked on this assignment alone.
 */


public class MutatingString {

	private String mutator;
	private String target;
	private final double RATE = 0.05;
	private final int ITERATIONS = 200;
	private int generation = 0;
	private static Random rand = new Random();

	/**
	 *This statement constructs an instance of MutatingString class.
	 *@param target  This is the target string.
	 */


	public MutatingString(String target) {
		this.target = target.toUpperCase();
		mutator = getRandomString(this.target.length());
	}
	
	/**
	 *This method returns a random character that is either a capital letter, a number from 0 to 9, or a space.
	 *@return A random character.
	 */

	public static char getRandomCharacter() {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 "; // add stuff in here to do other characters
		int i = rand.nextInt(str.length());
		char c = str.charAt(i);
		
		return c;
	}

	/**
	 *This method takes in a length and creates a random string by calling the getRandomCharacter() method.
	 *It concatenates random characters to the string until it reaches the length of the string.
	 *@param length  This is the length of the target string.
	 *@return The new random string.
	 */

	public static String getRandomString(int length) {
		String randomString = "";
		for (int i = 0; i < length; i++) {
			randomString = randomString + Character.toString(getRandomCharacter());
		}
		return randomString;
	}

	/**
 	 *This method mutates the string if the random number it generates is less than RATE.
 	 *@return The string with the mutation in it from getRandomCharacter() method.
 	 */

	public String mutate() {
		double random;
		String str = "";

		for (int k = 0; k < mutator.length(); k++) {
			random = rand.nextDouble();

			if (random <= RATE) {
				str += getRandomCharacter();
			}
			else {
				str += mutator.charAt(k);
			}
		}
		return str;
	
	}
	
	/**
	 *This method counts how many characters the target string and the mutating string have in common.
	 *@param myString  This is the current mutate string.
	 *@return The number of characters that are the same between the target and current mutate.
	 */

	public int score (String myString) {

		int c = 0;

			for (int i = 0; i < myString.length(); i++) {
				if (target.charAt(i) == myString.charAt(i)) {
					c++;
				}
			}
		return c;
	}
	
	/**
	 *This method calls mutate and forces the mutating string to mutate until it is the same as the target string.
	 *It also prints out the original string, the final string, and the number of generations each time.
	 */

	public void mutateToTarget() {

		String s1 = "";
		String s2 = mutator;
		int scoring = 0;
		
		while (target.equals(mutator)==false)  {
			generation++;
			for (int i = 0; i < ITERATIONS; i++) {
				s1 = mutate();
					if (score(s1) > score(s2)) {
						s2 = s1;
					}
			}

			mutator=s2;
			scoring = score(mutator);
			System.out.println("This is generation: " + generation);
			System.out.println("The mutator is now: " + mutator);
			System.out.println("The mutator's score is: " + scoring);
			String str = "";
			int x = rand.nextInt(5);
			switch (x) {
				case 0:
					str = "Almost there..";
					break;
				case 1:
					str = "Getting close..";
					break;
				case 2:
					str = "Getting closer..";
					break;
				case 3:
					str = "Got it!.. Actually no..";
					break;
				case 4:
					str = "This is taking forever..";
					break;
			}
			System.out.println(str);
		}
	}

	/**
	 *This method gets the mutator string.
	 *@return The mutating string.
	 */

	public String getMutator() {
		String s = mutator;
		return s;
	}
	
	/**
	 *This method gets the target string.
	 *@return The target string.
	 */
	
	public String getTarget() {
		String s = target;
		return s;
	}
	
	/**
	 *This method gets the number of generations.
	 *@return The number of generations.
	 */
	
	public int getGeneration() {
		int k = generation;
		return k;
	}
	
	
} 