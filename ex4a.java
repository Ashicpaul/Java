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
