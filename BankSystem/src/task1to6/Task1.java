package task1to6;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your credit score: ");
        int creditScore = scanner.nextInt();
        
        System.out.print("Enter your annual income: ");
        double annualIncome = scanner.nextDouble();
        
        // Eligibility criteria
        if (creditScore > 700 && annualIncome >= 50000) {
            System.out.println("Congratulations! You are eligible for a loan.");
        } else {
            System.out.println("Sorry, you are not eligible for a loan.");
        }
        
        scanner.close();
    }
}

