package benchmarks;

import utils.ArrayUtils;
import algorithms.sorting.*;
import java.util.Arrays;

public class Sorting {

    @FunctionalInterface
    interface SortAlgorithm {
        void sort(int[] array);
    }
    
    /**
     * Tests and displays the performance of the following algorithms:
     * -> Insertion Sort
     * -> Bubble Sort 
     * -> Selection Sort
     * 
     * @param size length of random array using for test
     * @param min minimum value that a number can have in the array
     * @param max maximum value that a number can have in the array
     */
    public static void runTest(int size, int min, int max) {
        int[] originalArray = ArrayUtils.generateArray(size, min, max);
        
        System.out.println("=== Sorting Benchmark (Size: " + size + ") ===");
        runAlgorithm("Bubble sort", Arrays.copyOf(originalArray, originalArray.length), BubbleSort::sort);
        runAlgorithm("Selection sort", Arrays.copyOf(originalArray, originalArray.length), SelectionSort::sort);
        runAlgorithm("Insertion sort", Arrays.copyOf(originalArray, originalArray.length), InsertionSort::sort);

        
    }

    /**
     * Auxiliary class to 'runTest'. Runs and displays the algorithms and their respective times individually.
     * 
     * @param name name of the algorithm
     * @param copyArray copy of original array
     * @param algorithm algorithm to be tested
     */
    private static void runAlgorithm(String name, int[] copyArray, SortAlgorithm algorithm) {
        long startTime = System.currentTimeMillis();

        algorithm.sort(copyArray);

        long endTime = System.currentTimeMillis();

        System.out.printf("%s | Time: %d ms%n", name, (endTime - startTime));
    }
    

    public static void main(String[] args) {
        // test 01
        runTest(1000, 0, 1000);
        System.out.println("==============================================");

        // test 02
        runTest(10000, 0, 10000);
        System.out.println("==============================================");

        // test 03
        runTest(100000, 0, 100000);
        System.out.println("==============================================");
    }    
}