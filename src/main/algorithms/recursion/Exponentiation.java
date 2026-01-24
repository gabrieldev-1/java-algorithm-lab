package algorithms.recursion;

public class Exponentiation {
    /**
     * Calculates k raised to the power of n using the Binary Exponentiation algorithm.
     * This approach reduces time complexity from O(n) to O(log n) by squaring 
     * the base and halving the exponent at each step.
     * * @param k The base
     * @param n The exponent
     * @return The result of k^n
     */
    public static int calc(int k, int n) {
        if (n == 0) return 1;
        
        int half = calc(k, n / 2);
        int result = half * half;
        
        if (n % 2 != 0) {
            result = result * k;
        }
        
        return result;
    }
}