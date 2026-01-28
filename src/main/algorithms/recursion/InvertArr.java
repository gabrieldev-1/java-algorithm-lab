package algorithms.recursion;

public class InvertArr {

    /**
     * Public wrapper to reverse an array in-place using recursion.
     * @param arr The array of integers to be reversed.
     * @return The same array, now reversed.
     */
    public static int[] invert(int[] arr) {
        return invertRec(arr, 0, arr.length - 1);

    }

    private static int[] invertRec(int[] arr, int left, int right) {
        if(right <= left) {
            return arr;
        }

        int aux = arr[left];
        arr[left] = arr[right];
        arr[right] = aux;

        return invertRec(arr, left + 1, right - 1);
    }
}
