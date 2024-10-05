package ex7b;
import java.util.Scanner;

class BalanceException extends Exception {
    private static final long serialVersionUID = 1L;
    public BalanceException(String msg) {
        super(msg);
    }
}

class WithdrawException extends Exception {
    private static final long serialVersionUID = 1L;
    public WithdrawException(String msg) {
        super(msg);
    }
}

class PinException extends Exception {
    private static final long serialVersionUID = 1L;
    public PinException(String msg) {
        super(msg);
    }
}

interface ATMOperations {
    void checkBalance();
    void deposit(double amount) throws BalanceException;
    void withdraw(double amount) throws WithdrawException;
}

class BankAccount implements ATMOperations {
    private double balance;
    private int pin, pinAttempts = 0;

    public BankAccount(double initialBalance, int pin) throws BalanceException {
        if (initialBalance < 500) 
            throw new BalanceException("Initial Balance < 500");
        this.balance = initialBalance;
        this.pin = pin;
    }

    public boolean verifyPin(int inputPin) throws PinException {
        if (inputPin != pin && ++pinAttempts >= 3) 
            throw new PinException("Blocked: 3 invalid attempts");
        return inputPin == pin;
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    public void deposit(double amount) throws BalanceException {
        if (amount <= 0)
            throw new BalanceException("Invalid Deposit");
        balance += amount;
        System.out.println("Deposit successful. New Balance: " + balance);
    }

    public void withdraw(double amount) throws WithdrawException {
        if (amount > balance)
            throw new WithdrawException("Insufficient funds");
        balance -= amount;
        System.out.println("Withdraw successful. New Balance: " + balance);
    }
}

public class ex7b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Ashic Paul  URK23CS1021\n ");
        BankAccount account = null;

        try {
            System.out.print("Enter initial balance: ");
            double initialBalance = sc.nextDouble();
            System.out.print("Set your 4-digit PIN: ");
            int pin = sc.nextInt();
            sc.nextLine();
            account = new BankAccount(initialBalance, pin);
        } catch (BalanceException e) {
            System.out.println(e.getMessage());
            sc.close();
            return;
        }

        while (true) {
            try {
                System.out.print("Enter PIN: ");
                int pinInput = sc.nextInt();
                sc.nextLine();
                if (!account.verifyPin(pinInput)) continue;

                System.out.println("1. Check Balance 2. Deposit 3. Withdraw 4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        account.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        sc.nextLine();
                        account.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        sc.nextLine();
                        account.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using our ATM!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (PinException | BalanceException | WithdrawException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
