// Jackson Miller
// COSC2103 Computer Science 2
// 2020-10-03
// Chapter 9 Program: The Location Class
// This program demonstrates a data class that stores information about 
// the largest element in a 2D matrix

package locationclassdemo;

import java.util.Scanner;

public class LocationClassDemo {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter the number of rows and columns: ");
		int rows = input.nextInt();
		int cols = input.nextInt();

		// Get matrix from user
		double[][] array = new double[rows][cols];
		System.out.println("Enter the array:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				array[i][j] = input.nextDouble();
			}
		}


		// Calculate and display largest value
		Location result = locateLargest(array);
		System.out.printf("The location of the largest element is %f at (%d, %d)",
							result.maxValue, result.row, result.col);

		input.close();
	}

	public static Location locateLargest(double[][] a) {

		int row = 0;
		int col = 0;
		double maxValue = a[row][col];

		// Basic largest element search [O(n)]
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] > maxValue) {
					maxValue = a[i][j];
					row = i;
					col = j;
				}
			}
		}
		return new Location(row, col, maxValue);
	}
}
