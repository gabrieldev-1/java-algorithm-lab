package algorithms.sorting;

public class InsertionSort {
    /**
     * Sort a list integers using insertion sort
     * 
     * time complexity: O(n^2)
     * space complexity: O(1)
     * 
     * @param list list of integers
     * @return ordered list
     */
    public static void sort(int[] list) {
        for(int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i - 1;

            while(j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j--;
            }

            list[j + 1] = key;

        }
    }
}
