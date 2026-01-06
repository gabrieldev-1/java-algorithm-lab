package utils;

import java.util.Random;
import java.util.Arrays;

public class ArrayUtils {
	/**
	 * Generates a random unordered array
	 * @param size array size
	 * @param min minimum value (inclusive)
	 * @param max maximum value (inclusive)
	 * @return unordered array of integers 
	 */
	public static int[] generateArray(int size, int min, int max) {
		return new Random()
			.ints(size, min, max + 1) // +1 makes the max value inclusive
			.toArray();
	}

	/**
	 * Print arrays of integers
	 */
	public static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}
}
