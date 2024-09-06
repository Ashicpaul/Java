/*Write a JAVA program to get a long paragraph of text and find out all the vowels
and replace it with special symbol a user inputted character, finally output the given
text and modified text.*/
package ex3b;
import java.util.Scanner;
public class ex3b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the paragraph of text
        System.out.println("Ashic Paul PS  URK23CS1021");
        System.out.println("Enter a paragraph of text (end input with an empty line):");

        StringBuilder paragraph = new StringBuilder();
        String line;

        // Read input lines until an empty line is entered
        while (!(line = scanner.nextLine()).isEmpty()) {
            paragraph.append(line).append("\n");
        }

        String originalText = paragraph.toString();

        // Prompt user for the special character to replace vowels
        System.out.print("Enter the character to replace all vowels: ");
        char replacementChar = scanner.next().charAt(0);

        // Replace vowels in the text
        String modifiedText = originalText.replaceAll("[AEIOUaeiou]", String.valueOf(replacementChar));

        // Output the original and modified text
        System.out.println("\nOriginal Text:");
        System.out.println(originalText);
        System.out.println("Modified Text:");
        System.out.println(modifiedText);
    }
}
