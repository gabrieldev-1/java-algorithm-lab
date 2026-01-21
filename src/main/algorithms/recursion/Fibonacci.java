package algorithms.recursion;

public class Fibonacci {
    /**
     * Calculate the value of position n in the Fibonacci sequence
     * @param n position in sequence
     * @return value of the position
     */
    public static int calc(int n) {
        if(n <= 1) {
            return n;
        }
        return calc(n - 2) + calc(n - 1);

    }
}
