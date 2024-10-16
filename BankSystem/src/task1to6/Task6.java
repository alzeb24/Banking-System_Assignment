package task1to6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> transactions = new ArrayList<>();
        String input;

        // Loop to add transactions
        while (true) {
            System.out.print("Enter transaction (deposit/withdraw <amount>) or 'exit' to finish: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break; // Exit the loop
            }

            // Add the transaction to the list
            transactions.add(input);
        }

        // Display transaction history
        System.out.println("\nTransaction History:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }

        scanner.close();
    }
}

