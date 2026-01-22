package algorithms.recursion;

public class InvertIntegerMath {
    /**
     * Inverts an integer using purely mathematical operations.
     * * This approach is memory-efficient as it avoids converting the number 
     * to a String or array, working directly with primitive types.
     * * Algorithm:
     * 1. Extract the last digit using the modulo operator (n % 10).
     * 2. Build the inverted number by shifting the current result (result * 10).
     * 3. Reduce the original number by removing the last digit (n / 10).
     * * Complexity:
     * - Time: O(log10(n)), proportional to the number of digits.
     * - Space: O(log10(n)) due to the recursion stack depth.
     * * @param n The integer to be inverted.
     * @param accumulated The current state of the inverted number during recursion.
     * @return The fully inverted integer.
     */
    public static int invert(int n) {
        return invertRec(n, 0); 
    }

    private static int invertRec(int n, int accumulated) {
        if(n == 0) {
            return accumulated;
        }

        return invertRec(n / 10, (accumulated * 10) + (n % 10));
    }
}
