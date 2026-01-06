package algorithms.sorting;

public class BubbleSort {
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
}
