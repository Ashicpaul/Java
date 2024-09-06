/*Write a menu driven application to maintain the department details of a School using Java to
demonstrate the concept of Inheritance. Your application must contain the following functionalities
along with the use of method overriding, and super keyword. Consider the example of school of CST
having three departments CSE, AI&DS and CE.
a. For each department maintain the following details.
i. deptName
ii. hodName
iii. noOfFaculty
iv. noOfStudents
v. noOfPrograms
b. Get the department details from user(admin)
c. Display the Department list with all details in a proper and neat format.
d. In the menu give an option to display department wise details.*/
package ex5c;
import java.util.Scanner;

//Superclass Department
class Department {
 protected String deptName;
 protected String hodName;
 protected int noOfFaculty;
 protected int noOfStudents;
 protected int noOfPrograms;

 // Method to get department details from the user
 public void getDetails() {
     Scanner scanner = new Scanner(System.in);
     System.out.print("Enter Department Name: ");
     deptName = scanner.nextLine();
     System.out.print("Enter HOD Name: ");
     hodName = scanner.nextLine();
     System.out.print("Enter Number of Faculty: ");
     noOfFaculty = scanner.nextInt();
     System.out.print("Enter Number of Students: ");
     noOfStudents = scanner.nextInt();
     System.out.print("Enter Number of Programs: ");
     noOfPrograms = scanner.nextInt();
 }

 // Method to display department details
 public void displayDetails() {
     System.out.println("Department Name: " + deptName);
     System.out.println("HOD Name: " + hodName);
     System.out.println("Number of Faculty: " + noOfFaculty);
     System.out.println("Number of Students: " + noOfStudents);
     System.out.println("Number of Programs: " + noOfPrograms);
 }
}

//Subclass CSE (Computer Science & Engineering)
class CSE extends Department {
 public CSE() {
     super();
     deptName = "CSE";  // Set specific department name
 }

 @Override
 public void displayDetails() {
     System.out.println("===== CSE Department Details =====");
     super.displayDetails();  // Calling the superclass method to avoid redundancy
 }
}

//Subclass AI&DS (Artificial Intelligence & Data Science)
class AIDS extends Department {
 public AIDS() {
     super();
     deptName = "AI&DS";  // Set specific department name
 }

 @Override
 public void displayDetails() {
     System.out.println("===== AI&DS Department Details =====");
     super.displayDetails();
 }
}

//Subclass CE (Computer Engineering)
class CE extends Department {
 public CE() {
     super();
     deptName = "CE";  // Set specific department name
 }

 @Override
 public void displayDetails() {
     System.out.println("===== CE Department Details =====");
     super.displayDetails();
 }
}

//Main class with menu-driven application
public class ex5c {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Department cseDept = new CSE();
     Department aidsDept = new AIDS();
     Department ceDept = new CE();
     
     int choice;

     while (true) {
    	 System.out.println("Ashic Paul  URK23CS1021");
         System.out.println("===== School Department Management =====");
         System.out.println("1. Enter CSE Department Details");
         System.out.println("2. Enter AI&DS Department Details");
         System.out.println("3. Enter CE Department Details");
         System.out.println("4. Display All Departments");
         System.out.println("5. Display CSE Department Details");
         System.out.println("6. Display AI&DS Department Details");
         System.out.println("7. Display CE Department Details");
         System.out.println("8. Exit");
         System.out.print("Enter your choice (1-8): ");
         choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 System.out.println("Enter details for CSE Department:");
                 cseDept.getDetails();
                 break;
             case 2:
                 System.out.println("Enter details for AI&DS Department:");
                 aidsDept.getDetails();
                 break;
             case 3:
                 System.out.println("Enter details for CE Department:");
                 ceDept.getDetails();
                 break;
             case 4:
                 System.out.println("\nDisplaying all department details:");
                 cseDept.displayDetails();
                 System.out.println();
                 aidsDept.displayDetails();
                 System.out.println();
                 ceDept.displayDetails();
                 System.out.println();
                 break;
             case 5:
                 System.out.println("\nDisplaying CSE Department details:");
                 cseDept.displayDetails();
                 break;
             case 6:
                 System.out.println("\nDisplaying AI&DS Department details:");
                 aidsDept.displayDetails();
                 break;
             case 7:
                 System.out.println("\nDisplaying CE Department details:");
                 ceDept.displayDetails();
                 break;
             case 8:
                 System.out.println("Exiting the application. Goodbye!");
                 scanner.close();
                 System.exit(0);
             default:
                 System.out.println("Invalid choice! Please select between 1 and 8.");
         }

         System.out.println();  // Print an empty line for better readability
     }
 }
}

