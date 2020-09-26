// Jackson Miller
// COSC2103 Computer Science 2
// 2020-09-25
// Largest Row and Column. Print the row and column with largest sum 
// in a randomly generated sqaure matrix

package largest;

import java.util.Random;
import java.util.Scanner;

public class Largest {

    public static void main(String[] args) {

        // Get user input in desired range ( 4 >= x <= 16 )
        Scanner input = new Scanner(System.in);
        int size;
        while (true) {
            System.out.println("Enter desired size: ");
            size = input.nextInt();
            if (size >= 4 && size <= 16)
                break;
            System.out.println("INVALID: size should be between 4 and 16");
        }

        // Fill the matrix with random 1s or 0s
        Random r = new Random();
        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = r.nextInt(2);

        // Inilize some stuff for counting rows and columns
        int rowIndex = 0;
        int colIndex = 0;
        int maxRowSum = 0;
        int maxColSum = 0;

        // We sum the row and columns at the same time for effeciency
        // `i` and `j` are used for both row and column indices
        for (int i = 0; i < matrix.length; i++) {
            int rsum = 0;
            int csum = 0;

            for (int j = 0; j < matrix.length; j++) {

                // sum left to right
                rsum += matrix[i][j];

                // sum top to bottem
                csum += matrix[j][i];

                // print the rows
                System.out.printf("%d ", matrix[i][j]);
            }

            // after adding a row (or column) compare to the last maximum
            if (rsum > maxRowSum) {
                // save index and value of current maximum for next iteration
                rowIndex = i;
                maxRowSum = rsum;
            }

            if (csum > maxColSum) {
                colIndex = i;
                maxColSum = csum;
            }

            System.out.println();
        }

        // print final results
        System.out.printf("Largest row index: %d (sum %d)\n", rowIndex, maxRowSum);
        System.out.printf("Largest column index: %d (sum %d)\n", colIndex, maxColSum);

    }

}
