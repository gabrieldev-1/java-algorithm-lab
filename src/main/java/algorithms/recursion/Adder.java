package algorithms.recursion;

public class Adder {
    /**
     * Sum all the positive integers preceding n
     * @param n limit value
     * @return sum of elements
     */

    public static int calc(int n) {
        if(n <= 1) {
            return n;
        }
        return n + calc(n - 1);
    }
}
