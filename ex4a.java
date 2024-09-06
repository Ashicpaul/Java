/*Imagine a tollbooth at a bridge. Cars passing by the booth were expected to pay a 50
rupees to toll. Mostly they do, but sometimes a car goes by without paying. The
tollbooth keeps track of the number of cars that have gone by, and of the total amount
of money collected. Model this tollbooth with a class called tollbooth. The two data
items must be a type unsigned int to hold the total number of cars, and a type double to
hold the total amount of money collected. A constructor initializes both of these values
to 0. A member function called payingcar () increments the car total and adds 50 rupees
to the cash total. Another function, called nopaycar (), increments the car total but adds
nothing to the cash total. Finally, a member function called display () displays the two
totals. Make appropriate member functions const.
Include a program to test this class. This program should allow the user to push
one key to count a paying car, and another to count a nonpaying car. Pushing the ESC
key should cause the program to print out the total cars and total cash and then exit.*/
package ex4a;
import java.util.Scanner;

class TollBooth {
    private int totalCars;
    private double totalCash;

    // Constructor to initialize the values
    public TollBooth() {
        totalCars = 0;
        totalCash = 0.0;
    }

    // Method to count a paying car
    public void payingCar() {
        totalCars++;
        totalCash += 50.0;
    }

    // Method to count a non-paying car
    public void noPayCar() {
        totalCars++;
    }

    // Method to display the total cars and cash
    public void display() {
        System.out.println("Total cars: " + totalCars);
        System.out.println("Total cash collected: " + totalCash + " rupees");
    }
}

public class ex4a {
    public static void main(String[] args) {
        TollBooth booth = new TollBooth();
        Scanner scanner = new Scanner(System.in);
        char choice;
        System.out.println("Ashic Paul  URK23CS1021");
        System.out.println("Press 'p' for a paying car, 'n' for a non-paying car, 'e' to exit and display totals.");
        
        while (true) {
            System.out.print("Enter your choice: ");
            choice = scanner.next().charAt(0);
            
            if (choice == 'p') {
                booth.payingCar();
            } else if (choice == 'n') {
                booth.noPayCar();
            } else if (choice == 'e') {
                break;
            } else {
                System.out.println("Invalid choice! Please enter 'p', 'n', or 'e'.");
            }
        }

        // Display the totals before exiting
        booth.display();
        scanner.close();
    }
}
