package ex5a;
import java.util.Scanner;

//Superclass Shape
class Shape {
 private double dimension1;
 private double dimension2;

 public void setDimension1(double dimension1) {
     this.dimension1 = dimension1;
 }

 public double getDimension1() {
     return dimension1;
 }

 public void setDimension2(double dimension2) {
     this.dimension2 = dimension2;
 }

 public double getDimension2() {
     return dimension2;
 }

 public void find_area() {
     System.out.println("Area calculation is undefined for generic Shape.");
 }
}

//Subclass Triangle
class Triangle extends Shape {
 @Override
 public void find_area() {
     double base = getDimension1();
     double height = getDimension2();
     double area = 0.5 * base * height;
     System.out.println("Area of Triangle: " + area);
 }
}

//Subclass Rectangle
class Rectangle extends Shape {
 @Override
 public void find_area() {
     double length = getDimension1();
     double breadth = getDimension2();
     double area = length * breadth;
     System.out.println("Area of Rectangle: " + area);
 }
}

//Main class with menu-driven interface
public class ex5a {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Shape shape = null;
     int choice;

     while (true) {
    	 System.out.println("Ashic Paul  URK23CS1021");
         System.out.println("===== Shape Area Calculator =====");
         System.out.println("1. Compute Area of Triangle");
         System.out.println("2. Compute Area of Rectangle");
         System.out.println("3. Exit");
         System.out.print("Enter your choice (1-3): ");

         choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 shape = new Triangle();
                 System.out.print("Enter base of the triangle: ");
                 double base = scanner.nextDouble();
                 System.out.print("Enter height of the triangle: ");
                 double height = scanner.nextDouble();
                 shape.setDimension1(base);
                 shape.setDimension2(height);
                 shape.find_area();
                 break;

             case 2:
                 shape = new Rectangle();
                 System.out.print("Enter length of the rectangle: ");
                 double length = scanner.nextDouble();
                 System.out.print("Enter breadth of the rectangle: ");
                 double breadth = scanner.nextDouble();
                 shape.setDimension1(length);
                 shape.setDimension2(breadth);
                 shape.find_area();
                 break;

             case 3:
                 System.out.println("Exiting the application. Goodbye!");
                 scanner.close();
                 System.exit(0);
                 break;

             default:
                 System.out.println("Invalid choice! Please select between 1 and 3.");
         }

         System.out.println(); // Print an empty line for better readability
     }
 }
}
