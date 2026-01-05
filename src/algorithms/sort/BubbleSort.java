import java.util.Random;
import java.util.Arrays;

public class BubbleSort {
	public static int[] generateArray(int n, int min, int max) {
		return new Random()
			.ints(n, min, max)
			.toArray();
	
	}

	public static void sort(int[] list) {
		for(int i = 0; i < list.length; i++) {
			for(int j = 0; j < list.length - 1 - i; j++) {
				if(list[j] > list[j + 1]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}

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
