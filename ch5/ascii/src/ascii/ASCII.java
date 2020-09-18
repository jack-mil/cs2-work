// Jackson Miller
// COSC2103 Computer Science 2
// 2020-09-09
// Assignment 5.15: Display the ASCII character table in a 10x10 grid

/* (Display the ASCII character table) Write a program that prints the characters in
the ASCII character table from ! to ~. Display 10 characters per line. The ASCII
table is given in Appendix B. Characters are separated by exactly one space. */

package ascii;

public class ASCII {
    public static void main(String[] args) {

        // Print header row
        System.out.println("   | 0 1 2 3 4 5 6 7 8 9\n" +
                           "-- + - - - - - - - - - -");

        // Begin printing grid
        // Row and column indices make up the character code
        // start '!': 33 (0x21) to '~': 126 (0x7E)

        // Rows represent the 10s (and 100s) place in decimal ASCII code
        for (int row = 3; row <= 12; row++) {

            // Print the row label left justified
            System.out.printf("%-2d | ", row);
            
            // Columns represent the 1s place in Decimal ASCII code
            for (int col = 0; col <= 9; col++) {

                // Calculate the current ASCII code point
                int code = row * 10 + col;
                
                // Only print the character if it is in the printable range
                if (code > 32 && code < 127) {
                    System.out.print((char) code + " ");
                } else {
                    System.out.print("  ");
                }
            }
            // Print a new line to end the row
            System.out.print('\n');
        }
    }

}
