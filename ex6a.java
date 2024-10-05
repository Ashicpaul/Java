package ex6a;
import java.util.Scanner;

class Shape {
    String color;
    int sides;

    public Shape(String color, int sides) {
        this.color = color;
        this.sides = sides;
    }

    double calcArea() {
        return 0;
    }

    public void display() {
        System.out.println("Color: " + color);
        System.out.println("Sides: " + sides);
        System.out.println("Area: " + calcArea());
    }
}

class Square extends Shape {
    double sideLength;

    public Square(String color, double sideLength) {
        super(color, 4);
        this.sideLength = sideLength;
    }

    double calcArea() {
        return sideLength * sideLength;
    }
}

class Rectangle extends Shape {
    double length;
    double breadth;

    public Rectangle(String color, double length, double breadth) {
        super(color, 4);
        this.length = length;
        this.breadth = breadth;
    }

    double calcArea() {
        return length * breadth;
    }
}

public class ex6a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("URK23CS1021  ASHIC PAUL PS");

        System.out.println("Enter the shape type (Square/Rectangle): ");
        String shapeType = scanner.nextLine();
        System.out.println("Enter the color of the shape: ");
        String color = scanner.nextLine();

        Shape shape;

        if (shapeType.equalsIgnoreCase("Square")) {
            System.out.println("Enter the side length of the square: ");
            double sideLength = scanner.nextDouble();
            shape = new Square(color, sideLength);
        } else if (shapeType.equalsIgnoreCase("Rectangle")) {
            System.out.println("Enter the length of the rectangle: ");
            double length = scanner.nextDouble();
            System.out.println("Enter the breadth of the rectangle: ");
            double breadth = scanner.nextDouble();
            shape = new Rectangle(color, length, breadth);
        } else {
            System.out.println("Invalid shape type entered!");
            scanner.close();
            return;
        }

        shape.display();
        scanner.close();
    }
}
