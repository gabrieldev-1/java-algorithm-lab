package algorithms.recursion;

/**
 * Prints the numbers sequentially, starting from 1 and ending with the last number.
 * 
 * @param finalNumber final number
 */
public class Counter {
    public static int count(int n) {
        if(n <= 1) {
            return 1;
        }
        return n + count(n - 1);

    }

    public static void main(String[] args) {
        int result = count(5);
        System.out.println(result);
    }
}