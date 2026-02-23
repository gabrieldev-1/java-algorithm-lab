package algorithms.sorting;

public class SelectionSort {
    /** 
     * Sort a list of integers using selection sort
     * 
     * time complexity: O(n^2)
     * space complexity: O(1)
     * 
     * @param list list of integers
     * @return ordered list
     * 
     */
    public static void sort(int[] list) {
        for(int i = 0; i < list.length; i++) {
            int min = i;

            for(int j = i + 1; j < list.length; j++) {
                if(list[j] < list[min]) {
                    min = j;
                        
                }
            }
            int temp = list[i];
            list[i] = list[min];
            list[min] = temp;

        }
    }
}
