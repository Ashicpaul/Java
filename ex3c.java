/*Write a program to delete all vowels from a given sentence. Assume that the sentence is not more than
80 characters long.*/
package ex3c;
import java.util.Scanner;
public class ex3c {

	public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Prompt user for the sentence
	        System.out.println("Ashic Paul PS  URK23CS1021");
	        System.out.print("Enter a sentence (max 80 characters): ");
	        String sentence = scanner.nextLine();

	        // Ensure the sentence is not more than 80 characters long
	        if (sentence.length() > 80) {
	            System.out.println("The sentence is longer than 80 characters. Please try again.");
	            return;
	        }

	        // Remove all vowels
	        String sentenceWithoutVowels = sentence.replaceAll("[AEIOUaeiou]", "");

	        // Output the modified sentence
	        System.out.println("Sentence after removing vowels:");
	        System.out.println(sentenceWithoutVowels);
	    }
	}
