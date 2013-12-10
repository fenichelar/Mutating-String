import java.util.*;

/**
 *This class creates a mutating string and includes the methods that can be executed on it
 *@author Alec Fenichel
 *@version 1.0
 *Homework 4
 *I worked on this assignment alone
 */



public class MutatingDriver {
	
	/**
	 *This method is used for mutating a string to a target string.
	 *It uses the MutatingString class.
	 *@param args  Unused strings.
	 */
	
	public static void main(String[] args) {
		boolean again = true;
		while(again) {
			String target, response, yes, firstMutator, finalMutator;
			int generation;
			Scanner scan = new Scanner(System.in);
			System.out.print("Please enter a string: ");
			target = scan.nextLine();
			target = target.toUpperCase();
			MutatingString ms = new MutatingString(target);
			firstMutator = ms.getMutator();
			System.out.println("Target String: " + target);
			System.out.println("Mutated String: " + firstMutator);
			System.out.print("Would you like to mutate to target?: ");
			response = scan.nextLine();
			yes = "y";
			if(response.substring(0,1).equalsIgnoreCase(yes)) {
				ms.mutateToTarget();
				finalMutator = ms.getMutator();
				generation = ms.getGeneration();
				
				System.out.println("Original String: " + firstMutator);
				System.out.println("Final String: " + finalMutator);
				System.out.println("Number of Generations: " + generation);
			}
			else {
				System.out.println("But then how can I show you my awesome program!?");
				System.out.println("Now I am mad! :(");
			}
			System.out.print("Do you want to go again?:");
			response = scan.nextLine();
			if(response.substring(0,1).equalsIgnoreCase(yes)==false) {
				again = false;
				System.out.println("Bye!");
				System.out.println("Now I am sad :(");
			}
		}
	}
}