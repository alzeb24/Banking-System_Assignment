package task1to6;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Create a password for your bank account: ");
        String password = scanner.nextLine();

        boolean hasUppercase = false;
        boolean hasDigit = false;

        if (password.length() >= 8) {
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) hasUppercase = true;
                if (Character.isDigit(c)) hasDigit = true;
            }
        }

        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
        } else if (!hasUppercase) {
            System.out.println("Password must contain at least one uppercase letter.");
        } else if (!hasDigit) {
            System.out.println("Password must contain at least one digit.");
        } else {
            System.out.println("Your password is valid.");
        }

        scanner.close();
    }
}
