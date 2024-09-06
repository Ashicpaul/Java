/*Write a JAVA program to get a long paragraph of text and find out the followingand
prints the same.
a. Number of spaces
b. Number of words
c. Number of characters
d. Number of lines*/
package ex3a;
import java.util.Scanner;
public class ex3a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ashic Paul PS  URK23CS1021");
        System.out.println("Enter a paragraph of text (end input with an empty line):");

        StringBuilder paragraph = new StringBuilder();
        String line;
        int lineCount = 0;

        // Read input lines until an empty line is entered
        while (!(line = scanner.nextLine()).isEmpty()) {
            paragraph.append(line).append("\n");
            lineCount++;
        }

        String text = paragraph.toString();

        int characterCount = text.length();
        int wordCount = text.split("\\s+").length;
        int spaceCount = text.length() - text.replace(" ", "").length();
        int lineCountFinal = lineCount;

        System.out.println("Number of spaces: " + spaceCount);
        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of characters: " + characterCount);
        System.out.println("Number of lines: " + lineCountFinal);
    }
}
