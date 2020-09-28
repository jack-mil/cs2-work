// Jackson Miller
// COSC2103 Computer Science 2
// 2020-09-27
// Chapter 7, Exercise 7.20: Descending Bubble Sort
// Take 10 doubles and sort them in descending order

/* NOTE
* Exercise 7.20 is not about selection sort, as indicated in Canvas. Instead,
* it involves Bubble Sort. The text is below. I wrote to Jeff Sanford asking
* if this was a mistake, but didn't hear back from him in time. I hope this
* assignment is all right. Wasn't sure what to follow.
* 
* Exercise 7.20 from page 304:
* (Descending Bubble Sort) Modify the bubble sort method of 
* Programming Exercise 7.18, and sort the elements in the array in descending
* order instead of ascending order. Write a test program that reads 10 double
* numbers, invokes the method, and displays the sorted numbers in descending order
*/

package bubblesort;

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create 10 element sequence
        double[] values = new double[10];

        System.out.println("Enter 10 doubles to sort");
        for (int i = 0; i < values.length; i++) {
            values[i] = input.nextDouble();
        }

        sort(values);

        // Display sorted sequence
        for (double d : values) {
            System.out.print(d + " ");
        }

        input.close();
    }

    public static void sort(double[] list) {
        /** Descending Bubble sort with O(n²) complexity (inefficient) */

        int l = list.length;
        // Loop through every pair of elements
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - 1; j++) {

                // Swap elements out of order
                if (list[j] < list[j + 1]) {
                    double temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

}
