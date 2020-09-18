// Jackson Miller
// COSC2103 Computer Science 2
// 2020-08-24
// Assignment 3 ex. 3.31 pg116 Financials: Currency Exchange
// Exchanges USD to RMB or vice versa, given current exchange rate.
package financials;

import java.util.Scanner;

public class Financials {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Get exchange rate
        System.out.print("Input current exchange USD ($) to RMB (¥): ");
        double exchangeRate = input.nextDouble();

        // Get choice
        System.out.print("Enter 0 to convert USD to RMB and 1 vice versa: ");
        int choice = input.nextInt();

        // Conditional output
        // Exit if choice out of range
        switch (choice) {
            case 0:
                System.out.print("Enter USD amount: ");
                break;
            case 1:
                System.out.print("Enter RMB amount: ");
                break;
            default:
                System.out.println("Please enter 0 or 1!");
                input.close();
                return;
        }

        // Calculate converted amount using ternary operator (my favorite)
        // `amount` * `exchangeRate` for USD to RMB, divide for RMB to USD
        double amount = input.nextDouble();
        double converted = (choice == 0) ? amount * exchangeRate : amount / exchangeRate;

        // Print formatted output given choice
        if (choice == 0) {
            System.out.printf("$%.2f is ¥%.2f", amount, converted);
        } else {
            System.out.printf("¥%.2f is $%.2f", amount, converted);
        }

        input.close();
    }
}