package task1to6;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for the number of customers
        System.out.print("Enter the number of customers: ");
        int numberOfCustomers = scanner.nextInt();

        for (int i = 1; i <= numberOfCustomers; i++) {
            System.out.println("\nCustomer " + i + ":");

            // Prompt user for initial balance
            System.out.print("Enter the initial balance: ");
            double initialBalance = scanner.nextDouble();

            // Prompt user for annual interest rate
            System.out.print("Enter the annual interest rate (in %): ");
            double annualInterestRate = scanner.nextDouble();

            // Prompt user for the number of years
            System.out.print("Enter the number of years: ");
            int years = scanner.nextInt();

            // Calculate future balance
            double futureBalance = initialBalance * Math.pow((1 + annualInterestRate / 100), years);

            // Display the future balance
            System.out.printf("Future balance after " + years+ " years: " + futureBalance);
        }

        scanner.close();
    }
}

