import java.util.Scanner;

// Jackson Miller
// COSC2103 Computer Science 2
// 2020-08-21
// Calculates future investment value (Ch2 2.21)

public class Invest {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Enter investment amount: ");
        double investmentAmount = input.nextDouble();

        System.out.print("Enter annual interest rate in %: ");
        // convert to monthly decimal rate
        double monthlyInterestRate = input.nextDouble() / 12 / 100;

        System.out.print("Enter number of years: ");
        double numberOfYears = input.nextDouble();

        double futureInvestmentValue = investmentAmount * 
          Math.pow(1 + monthlyInterestRate, numberOfYears * 12 );

        System.out.printf("Future value is $%.2f", futureInvestmentValue);

        input.close();
    }
    
}