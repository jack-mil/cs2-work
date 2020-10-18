// Jackson Miller
// COSC2103 Computer Science 2
// 2020-10-11
// 11.13: Remove Duplicate integers from a list and sort it
// This implementation allows any size of integer list to be entered

package removeduplicates;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicates {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// A new ArrayList to hold the input
		ArrayList<Integer> numbers = new ArrayList<>();
		System.out.print("Enter some integers (end with newline): ");

		// Read the whole line, and split into a string array using
		// regular expressions (\s+ matches any amount of whitespace)
		String readLine = input.nextLine();
		String[] stringList = readLine.split("\\s+");

		// Convert the array of number strings into an Integer ArrayList
		// using parseInt()
		for (int i = 0; i < stringList.length; i++) {
			numbers.add(Integer.parseInt(stringList[i]));
		}

		System.out.print("The distinct integers are ");
		removeDuplicates(numbers);

		input.close();
	}

	/**
	 * Take a ArrayList of integers, remove the duplicates, and print the sorted
	 * result to the terminal
	 * 
	 * @param list the list to be processed
	 */
	public static void removeDuplicates(ArrayList<Integer> list) {

		// Filter input list into a new list, excluding the duplicates
		ArrayList<Integer> distinct = new ArrayList<>();
		for (Integer value : list) {
			if (!distinct.contains(value)) {
				distinct.add(value);
			}
		}

		// Sort the distinct numbers in ascending order
		java.util.Collections.sort(distinct);

		// Print sorted and distinct numbers
		for (int element : distinct) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

}
