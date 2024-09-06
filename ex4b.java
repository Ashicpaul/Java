/*Define a class in JAVA with following description:
Private Members
• A data member Flight number of type integer
• A data member Destination of type string
• A data member Distance of type float
• A data member Fuel of type float
• A member function CALFUEL () to calculate the value of Fuel as per the
following criteria:
Public Members
• A function FEEDINFO () to allow user to enter values for Flight Number,
Destination, Distance & call function CALFUEL () to calculate the quantity of
Fuel.
• A function SHOWINFO () to allow user to view the content of all the data
members solution.
Distance                    Fuel
<=1000                      500
More than 1000 and
<=2000                      1100
More than 2000              2200*/
package ex4b;
import java.util.Scanner;

class Flight {
    // Private members
    private int flightNumber;
    private String destination;
    private float distance;
    private float fuel;

    // Private method to calculate fuel based on distance
    private void CALFUEL() {
        if (distance <= 1000) {
            fuel = 500;
        } else if (distance > 1000 && distance <= 2000) {
            fuel = 1100;
        } else {
            fuel = 2200;
        }
    }

    // Public method to input flight details and calculate fuel
    public void FEEDINFO() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Flight Number: ");
        flightNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter Destination: ");
        destination = scanner.nextLine();

        System.out.print("Enter Distance: ");
        distance = scanner.nextFloat();

        // Calculate fuel based on distance
        CALFUEL();
    }

    // Public method to display flight information
    public void SHOWINFO() {
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Destination: " + destination);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fuel Required: " + fuel + " liters");
    }
}

public class ex4b {
    public static void main(String[] args) {
    	System.out.println("Ashic Paul  URK23CS1021");
        Flight flight = new Flight();
        
        // Input flight information
        flight.FEEDINFO();
        
        // Display flight information
        flight.SHOWINFO();
    }
}

