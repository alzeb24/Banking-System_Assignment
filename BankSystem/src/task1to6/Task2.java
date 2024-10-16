package task1to6;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter their current balance
        System.out.print("Enter your current balance: ");
        double balance = scanner.nextDouble();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1: 
                    System.out.println("Your current balance is: " + balance);
                    break;

                case 2: 
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();

                    
                    if (withdrawAmount > balance) {
                        System.out.println("Error: Insufficient funds.");
                    } else {
                        if (withdrawAmount % 100 == 0 || withdrawAmount % 500 == 0) {
                            balance -= withdrawAmount;
                            System.out.println("Withdrawal Successful: " + withdrawAmount + ". New balance: " + balance);
                        } else {
                            System.out.println("Error: Withdrawal amount must be in multiples of 100 or 500.");
                        }
                    }
                    break;

                case 3: // Deposit
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    balance += depositAmount;
                    System.out.println("Successfully deposited: " + depositAmount + ". New balance: " + balance);
                    break;

                case 4: // Exit
                    exit = true;
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
