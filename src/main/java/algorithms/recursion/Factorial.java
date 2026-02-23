package algorithms.recursion;

public class Factorial {

    /**
     * Calculate the factorial of n;
     * @param n positive integer
     * @return factorial of the n
     */
    public static int calc(int n) {
        if(n <= 1) {
            return 1;
        }

        return n * calc(n - 1);
    }
}
