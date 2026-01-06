package algorithms.sorting;

import java.util.Random;
import java.util.Arrays;

public class BubbleSort {
	public static int[] generateArray(int n, int min, int max) {
		return new Random()
			.ints(n, min, max)
			.toArray();
	
	}

	/**
	 * Sort a list of integers using bubble sort.
	 * 
	 * time complexity: O(n^2)
	 * space complexity: 0(1)
	 *
	 * @param list list of integers
	 * @return ordered list
	 *
	 */
	public static void sort(int[] list) {
		for(int i = 0; i < list.length; i++) {
			Boolean swapped = false;

			for(int j = 0; j < list.length - 1 - i; j++) {
				if(list[j] > list[j + 1]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;

					swapped = true;
				}
			}
			
			if(!swapped) {
				break;
			}

		}
	}

	public static void main(String[] args) {
		int[] list = generateArray(10, 0, 25);
		
		System.out.println("unsorted array: " + Arrays.toString(list));
		
		sort(list);
		
		System.out.println("ordered array: " + Arrays.toString(list));

	}
}
