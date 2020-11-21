// Jackson Miller
// COSC2103 Computer Science 2
// 2020-11-21
// Chapter 18 Assignment: Decimal to Binary conversion

package decimaltobinary;

import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a decimal number to convert to binary: ");
        int value = input.nextInt();

        System.out.printf("%d in binary is %s", value, dec2Bin(value));

        input.close();
    }

    /**
     * Public decimal to binary string converter
     * 
     * @param value The number to convert
     * @return A string representation of the binary number
     */
    public static String dec2Bin(int value) {
        // To avoid returning an empty string when 0 is entered
        if (value == 0) {
            return "0";
        } else {
            // Calculate the binary number recursively
            return dec2Bin(value, "");
        }
    }

    /**
     * Recursive Helper method that keeps track of the building string
     * 
     * @param quotient
     * @param bits
     * @return The current binary string
     */
    private static String dec2Bin(int quotient, String bits) {
        // Stop condition when quotient is 0, return the current string
        if (quotient == 0) {
            return bits;
        } else {
            // Calculate the next iteration, by dividing by 2. The modulo (remainder) of the
            // current quotient is inserted at the beginning of the current bit-string, as the
            // next binary digit
            return dec2Bin(quotient / 2, Integer.toString(quotient % 2) + bits);
        }
    }

}
