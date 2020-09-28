// Jackson Miller
// COSC2103 Computer Science 2
// 2020-09-27
// Chapter 7, Exercise 7.20: Revise Selection sort
// Take 10 doubles and sort them in ascending order

package selectionsort;

import java.util.Scanner;

public class SelectionSort {

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
        /** Ascending Selection sort */

        int l = list.length;
        // Iterate from back to front of list
        for (int i = l - 1; i >= 0; i--) {

            double currentMax = list[i];
            int currentMaxIndex = i;

            // Identify any elements larger than current element
            for (int j = i - 1; j >= 0; j--) {
                if (currentMax < list[j]) {
                    currentMax = list[j];
                    currentMaxIndex = j;
                }
            }

            // Swap elements if out of order
            if (currentMaxIndex != i) {
                list[currentMaxIndex] = list[i];
                list[i] = currentMax;
            }
        }
    }

}
