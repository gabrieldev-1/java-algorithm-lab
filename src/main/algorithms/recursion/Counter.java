package algorithms.recursion;

public class Counter {
    /* 
    * Prints the numbers sequentially, starting from N and ending with the one.
    * @param n start number 
    */
    public static int count(int n) {
        if(n <= 1) {
            return 1;
        }
        return count(n - 1);

    }
}