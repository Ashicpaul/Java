/* Develop an application in Java for automating the Banking Operations using
interfaces. Create an interface called “Transaction” which contains the functions such
as deposit, withdraw, and viewBalance. Create another interface called “Displayable”
which contains the Display () function to display the account details.
 Create an abstract class called “Account” with bank account detailssuch as acc_name,
acc_no, and balance. Add necessary constructors.
 Create a “Bank” class which implements the “Transaction”, “Displayable” interfaces
and inherits “Account” class.
 Perform menu driven operations like Deposit, Withdraw and Balance Enquiry, View
Account Details from a Main class. Write logics in the corresponding methods.*/
package ex6b;
import java.util.Scanner;

//Transaction Interface with required methods
interface Transaction {
 void deposit(double amount);
 void withdraw(double amount);
 double viewBalance();
}

//Displayable Interface to show account details
interface Displayable {
 void display();
}

//Abstract Account class holding account details
abstract class Account {
 String acc_name;
 String acc_no;
 double balance;

 // Constructor
 public Account(String acc_name, String acc_no, double balance) {
     this.acc_name = acc_name;
     this.acc_no = acc_no;
     this.balance = balance;
 }
}

//Bank class inheriting Account and implementing Transaction, Displayable
class Bank extends Account implements Transaction, Displayable {
 
 // Constructor to initialize account details
 public Bank(String acc_name, String acc_no, double balance) {
     super(acc_name, acc_no, balance);
 }

 // Method to deposit amount into account
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposit successful! Your new balance is: " + balance);
     } else {
         System.out.println("Invalid deposit amount!");
     }
 }

 // Method to withdraw amount from account
 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawal successful! Your new balance is: " + balance);
     } else if (amount > balance) {
         System.out.println("Insufficient balance for the withdrawal!");
     } else {
         System.out.println("Invalid withdrawal amount!");
     }
 }

 // Method to view the current balance
 public double viewBalance() {
     return balance;
 }

 // Method to display account details
 public void display() {
     System.out.println("\nAccount Details:");
     System.out.println("Account Name: " + acc_name);
     System.out.println("Account Number: " + acc_no);
     System.out.println("Current Balance: " + balance);
 }
}

//Main class to handle menu-driven operations
public class ex6b {
 public static void main(String[] args) {
	 System.out.println("URK23CS1021  ASHIC PAUL PS");
     Scanner scanner = new Scanner(System.in);

     // Creating a Bank object with some initial details
     Bank bankAccount = new Bank("Ashic Paul PS", "7418240230", 5000.0);

     // Menu-driven operations
     int choice;
     do {
         System.out.println("\n===== Bank Menu =====");
         System.out.println("1. Deposit");
         System.out.println("2. Withdraw");
         System.out.println("3. View Balance");
         System.out.println("4. View Account Details");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();

         switch (choice) {
             case 1: // Deposit
                 System.out.print("Enter the amount to deposit: ");
                 double depositAmount = scanner.nextDouble();
                 bankAccount.deposit(depositAmount);
                 break;
             case 2: // Withdraw
                 System.out.print("Enter the amount to withdraw: ");
                 double withdrawAmount = scanner.nextDouble();
                 bankAccount.withdraw(withdrawAmount);
                 break;
             case 3: // View Balance
                 System.out.println("Your current balance is: " + bankAccount.viewBalance());
                 break;
             case 4: // View Account Details
                 bankAccount.display();
                 break;
             case 5: // Exit
                 System.out.println("Exiting the application.");
                 break;
             default:
                 System.out.println("Invalid choice! Please try again.");
                 break;
         }
     } while (choice != 5);

     scanner.close();
 }
}
