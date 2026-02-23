package algorithms.recursion;

public class Occurrence {
    /**
     * Counts the occurrences of a specific digit within an integer using recursion.
     * * This solution uses mathematical operators to process digits one by one,
     * avoiding String conversion overhead and utilizing tail recursion logic.
     * * Algorithm:
     * 1. Base case: If the number (n) reaches 0, return the accumulated count.
     * 2. Check current digit: Use (n % 10) to isolate the last digit and compare with target.
     * 3. Recursive step: Divide n by 10 to move to the next digit and pass the updated accumulator.
     * * Complexity:
     * - Time: O(log10(n)), as it processes each digit once.
     * - Space: O(log10(n)) for the call stack.
     * * @param n The number to be analyzed.
     * @param target The digit to count.
     * @param acc The current count of occurrences.
     * @return Total number of times the target digit appears in n.
     */
    public static int calc(int n, int target) {
        return calcRec(n, target, 0);
    }

    private static int calcRec(int n, int target, int acc) {
        if(n == 0) {
            return acc;
        }

        if((n % 10) == target) {
            acc++;
        }

        return calcRec(n / 10, target, acc);

    }
}
