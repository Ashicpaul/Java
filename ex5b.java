package ex5b;
import java.util.Scanner;

//Superclass FUEL
class FUEL {
 protected String fuel_name;
 protected String state;
 protected double cost_per_litre;
 
 public void setFuelName(String fuel_name) {
     this.fuel_name = fuel_name;
 }

 public void setState(String state) {
     this.state = state;
 }

 public void setCost(double cost_per_litre) {
     this.cost_per_litre = cost_per_litre;
 }
 
 public double calculateCost(double liters) {
     return liters * cost_per_litre;
 }
}

//Tamil Nadu subclass
class TamilNadu extends FUEL {
 public TamilNadu(String fuel_name) {
     setFuelName(fuel_name);
     setState("Tamil Nadu");
     
     // Set cost per litre based on the fuel type
     switch (fuel_name.toLowerCase()) {
         case "petrol":
             setCost(97.46);
             break;
         case "diesel":
             setCost(96.08);
             break;
         case "kerosene":
             setCost(25.7);
             break;
         case "auto lpg":
             setCost(70.33);
             break;
         default:
             System.out.println("Invalid fuel type for Tamil Nadu.");
     }
 }
}

//Kerala subclass
class Kerala extends FUEL {
 public Kerala(String fuel_name) {
     setFuelName(fuel_name);
     setState("Kerala");
     
     // Set cost per litre based on the fuel type
     switch (fuel_name.toLowerCase()) {
         case "petrol":
             setCost(98.35);
             break;
         case "diesel":
             setCost(97.37);
             break;
         case "kerosene":
             setCost(26.4);
             break;
         case "auto lpg":
             setCost(71.27);
             break;
         default:
             System.out.println("Invalid fuel type for Kerala.");
     }
 }
}

//Karnataka subclass
class Karnataka extends FUEL {
 public Karnataka(String fuel_name) {
     setFuelName(fuel_name);
     setState("Karnataka");
     
     // Set cost per litre based on the fuel type
     switch (fuel_name.toLowerCase()) {
         case "petrol":
             setCost(99.61);
             break;
         case "diesel":
             setCost(98.61);
             break;
         case "kerosene":
             setCost(27.6);
             break;
         case "auto lpg":
             setCost(72.08);
             break;
         default:
             System.out.println("Invalid fuel type for Karnataka.");
     }
 }
}

//Main class with menu-driven interface
public class ex5b {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     FUEL fuel = null;
     System.out.println("Ashic Paul  URK23CS1021");
     System.out.print("Enter your name: ");
     String customerName = scanner.nextLine();
     
     System.out.print("Enter the state (Tamil Nadu, Kerala, Karnataka): ");
     String state = scanner.nextLine();

     System.out.print("Enter fuel type (Petrol, Diesel, Kerosene, Auto LPG): ");
     String fuelType = scanner.nextLine();

     System.out.print("Enter the number of liters required: ");
     double liters = scanner.nextDouble();

     // Determine the state and create the appropriate fuel object
     switch (state.toLowerCase()) {
         case "tamil nadu":
             fuel = new TamilNadu(fuelType);
             break;
         case "kerala":
             fuel = new Kerala(fuelType);
             break;
         case "karnataka":
             fuel = new Karnataka(fuelType);
             break;
         default:
             System.out.println("Invalid state entered.");
             System.exit(0);
     }

     // Calculate the total cost
     double totalCost = fuel.calculateCost(liters);

     // Display the final result
     System.out.println("\n===== Fuel Cost Calculation =====");
     System.out.println("Customer Name: " + customerName);
     System.out.println("State: " + fuel.state);
     System.out.println("Fuel Type: " + fuel.fuel_name);
     System.out.println("Number of Liters Consumed: " + liters);
     System.out.println("Total Cost: ₹" + totalCost);

     scanner.close();
 }
}
