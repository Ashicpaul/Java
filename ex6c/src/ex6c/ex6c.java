package ex6c;
import java.util.Scanner;
import arithmetic.ArithmeticOperations;
import trigonometric.TrigonometricFunctions;

public class ex6c {
 public static void main(String[] args) {
	 System.out.println("URK23CS1021  ASHIC PAUL PS");
     Scanner scanner = new Scanner(System.in);
     ArithmeticOperations arithmetic = new ArithmeticOperations();
     TrigonometricFunctions trig = new TrigonometricFunctions();

     System.out.println("Scientific Calculator");
     System.out.println("1. Addition");
     System.out.println("2. Subtraction");
     System.out.println("3. Multiplication");
     System.out.println("4. Division");
     System.out.println("5. Modulus");
     System.out.println("6. Sine");
     System.out.println("7. Cosine");
     System.out.println("8. Tangent");
     System.out.print("Choose an operation: ");
     
     int choice = scanner.nextInt();
     double a, b, result = 0;
     boolean validOperation = true;

     switch (choice) {
         case 1:
             System.out.print("Enter two numbers: ");
             a = scanner.nextDouble();
             b = scanner.nextDouble();
             result = arithmetic.add(a, b);
             break;
         case 2:
             System.out.print("Enter two numbers: ");
             a = scanner.nextDouble();
             b = scanner.nextDouble();
             result = arithmetic.subtract(a, b);
             break;
         case 3:
             System.out.print("Enter two numbers: ");
             a = scanner.nextDouble();
             b = scanner.nextDouble();
             result = arithmetic.multiply(a, b);
             break;
         case 4:
             System.out.print("Enter two numbers: ");
             a = scanner.nextDouble();
             b = scanner.nextDouble();
             result = arithmetic.divide(a, b);
             break;
         case 5:
             System.out.print("Enter two numbers: ");
             a = scanner.nextDouble();
             b = scanner.nextDouble();
             result = arithmetic.mod(a, b);
             break;
         case 6:
             System.out.print("Enter an angle in degrees: ");
             a = scanner.nextDouble();
             result = trig.sine(a);
             break;
         case 7:
             System.out.print("Enter an angle in degrees: ");
             a = scanner.nextDouble();
             result = trig.cosine(a);
             break;
         case 8:
             System.out.print("Enter an angle in degrees: ");
             a = scanner.nextDouble();
             result = trig.tangent(a);
             break;
         default:
             validOperation = false;
             System.out.println("Invalid choice.");
             break;
     }

     if (validOperation) {
         System.out.println("Result: " + result);
     }

     scanner.close();
 }
}
