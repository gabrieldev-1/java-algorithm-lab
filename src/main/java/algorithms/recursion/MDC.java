package algorithms.recursion;

public class MDC {
    /**
     * Calculate the Greatest Common Divisor using Euclid's Algorithm.
     * @param a First number
     * @param b Second number
     * @return GCD between a and b
     */
    public static int calc(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calc(b, a % b);
    }
}
