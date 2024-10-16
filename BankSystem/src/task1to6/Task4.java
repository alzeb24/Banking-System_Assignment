package task1to6;

import java.util.Scanner;

class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define arrays for account numbers and balances
        String[] accountNumbers = {"1001", "1002", "1003", "1004"};
        double[] balances = {1500.00, 2500.50, 3000.75, 1200.00};

        while (true) {
            // Ask the user for their account number
            System.out.print("Enter your account number: ");
            String accountNumber = scanner.nextLine();

            // Validate the account number
            int index = -1; // Initialize index for account number
            for (int i = 0; i < accountNumbers.length; i++) {
                if (accountNumbers[i].equals(accountNumber)) {
                    index = i; // Found the account number
                    break;
                }
            }

            // Check if the account number is valid
            if (index != -1) {
                // If valid, display the balance
                double balance = balances[index];
                System.out.println("Account Number: " + accountNumber + ", Balance: $" + balance);
                break; // Exit the loop
            } else {
                System.out.println("Invalid account number. Please try again.");
            }
        }

        scanner.close();
    }
}
