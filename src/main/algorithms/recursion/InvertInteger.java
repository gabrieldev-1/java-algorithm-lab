package algorithms.recursion;

public class InvertInteger {

    /**
     * Inverts an integer by converting it to a character array.
     * * This approach demonstrates the use of a recursive "two-pointer" strategy
     * to swap characters from the outside in.
     * * Algorithm:
     * 1. Convert the integer to a String and then to a char array.
     * 2. Recursively swap the characters at the 'left' and 'right' indices.
     * 3. Convert the resulting array back to a String and parse it as an Integer.
     * * Complexity:
     * - Time: O(d), where d is the number of digits in the integer.
     * - Space: O(d) for the character array and recursion stack.
     * * @param n The integer to be inverted.
     * @return The inverted integer.
     */
    public static int invert(int n) {
        String text = String.valueOf(n);
        char[] t = text.toCharArray();

        int l = 0;
        int r = t.length - 1;

        t = invertRec(t, l, r);

        text = new String(t);
        return Integer.parseInt(text);

    }
    
    private static char[] invertRec(char[] t, int l, int r) {
        if(r <= l) {
            return t;
        }

        char aux = t[r];
        t[r] = t[l];
        t[l] = aux;

        r--;
        l++;

        return invertRec(t, l, r);
    }
}
