package algorithms.recursion;

public class Sum {
    /**
     * Calculates the sum of all natural numbers from n down to 1.
     * * This implementation uses Tail Recursion with an accumulator to optimize 
     * performance and avoid additional operations after the recursive call.
     * * Algorithm:
     * 1. Base case: If n reaches 0, return the accumulated sum.
     * 2. Recursive step: Decrement n and add the current n to the running total (sum).
     * * Complexity:
     * - Time: O(n), as it makes one recursive call for each number.
     * - Space: O(n) for the recursion stack (in standard Java).
     * * @param n The starting natural number.
     * @param sum The accumulated total passed through recursive calls.
     * @return The sum of natural numbers from 1 to n.
     */
    public static int calc(int n) {
        return calcRec(n, 0);
    }

    public static int calcRec(int n, int sum) {
        if(n <= 0) {
            return sum;
        }
        return calcRec(n - 1, n + sum);
    }
}
