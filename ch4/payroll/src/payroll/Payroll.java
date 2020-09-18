// Jackson Miller
// COSC2103 Computer Science 2
// 2020-09-05
// Assignment 4: Payroll exercise 4.23 pg 156
// Prints formatted payroll slip
package payroll;

import java.util.Scanner;

public class Payroll {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee's name: ");
        String name = input.nextLine();

        System.out.print("Enter number of hours worked in a week: ");
        double hours = input.nextDouble();

        System.out.print("Enter hourly rate: ");
        double rate = input.nextDouble();

        System.out.print("Enter federal tax withholding rate: ");
        double ftax = input.nextDouble();

        System.out.print("Enter state tax withholding rate: ");
        double stax = input.nextDouble();

        double total = hours * rate;
        double tax = total * (ftax + stax);

        System.out.printf("\nEmployee Name: %s\n", name);
        System.out.printf("Hours Worked: %.1f\n", hours);
        System.out.printf("Pay Rate: $%.2f\n", rate);

        System.out.printf("Gross Pay: $%.2f\n", total);

        String deductions = "Deductions:\n" +
                            "\t Federal Withholding (%.1f%%): $%.2f\n" +
                            "\t State Withholding (%.1f%%): $%.2f\n" +
                            "\t Total Deduction: $%.2f\n";

        System.out.printf(deductions, ftax * 100, ftax * total, stax * 100, stax * total, tax);

        System.out.printf("Net Pay: $%.2f", total - tax);
        input.close();
    }
}

