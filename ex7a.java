/*Create an array of characters which will be initialized during run time with vowels. If user
enters any consonant, your code should generate a user-defined checked exception,
InvalidVowelException. The description or message of InvalidVowelException is
"character is consonant". Handle the exception by using try, catch, finally, throw and
throws.*/
package ex7a;
import java.util.Scanner;
class InvalidVowelException extends Exception {
private static final long serialVersionUID = 1L;
public InvalidVowelException(String message) {
super(message);
}
}
public class ex7a {
public static void checkVowel(char ch) throws InvalidVowelException {
if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' &&
ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U') {
throw new InvalidVowelException("Character is consonant");
}
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(" Ashic Paul  URK23CS1021\n ");
System.out.print("Enter the number of characters: ");
int n = sc.nextInt();
char[] vowels = new char[n];
for (int i = 0; i < n; i++) {
System.out.print("Enter character " + (i + 1) + ": ");
char ch = sc.next().charAt(0);
try {
checkVowel(ch);
vowels[i] = ch;
} catch (InvalidVowelException e) {
System.out.println(e.getMessage());
} finally {
System.out.println("Processed character: " + ch);
}
}
System.out.println("The vowels you entered are: ");
for (char vowel : vowels) {
if (vowel != '\u0000') {
System.out.print(vowel + " ");
}
}
sc.close();
}
}
