// Jackson Miller
// COSC2103 Computer Science 2
// 2020-10-04
// Chapter 10 Assignment: Find Prime Factors

package primefactors;

import java.util.Scanner;

public class PrimeFactors {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();

        StackOfIntegers factors = findFactors(n);

        // Print out factors from the stack. Separate by commas
        System.out.printf("For the number %d the prime factors are: %d", n, factors.pop());
        for (int i = 0, size = factors.getSize(); i < size; i++) {
            System.out.printf(", %d", factors.pop());
        }

        input.close();
    }

    public static StackOfIntegers findFactors(int n) {
        StackOfIntegers result = new StackOfIntegers();

        // Iteratively divide input number and find prime factors
        for (int i = 2; i < n; i++) {
            while (n % i == 0) {
                result.push(i);
                n /= i;
            }
        }

        // Include remaining factor
        if (n > 2) {
            result.push(n);
        }
        return result;
    }

}
