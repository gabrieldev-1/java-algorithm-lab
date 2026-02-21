package leetcode;

// Problem: 3280. Convert Date to Binary

import java.util.Stack;

/**

* Converts a date in the format "yyyy-MM-dd" into its binary representation.
* Each component (year, month, day) is individually converted from decimal
* to binary and then concatenated using the same separator format.
*
* obs: The decimal-to-binary conversion is performed using a stack
* to reverse the remainder sequence obtained from successive divisions by 2.
*
* time complexity: O(log n);
* space complexity: O(log n);
*
* @param date string representing a date in the format "yyyy-MM-dd";
* @return a string where year, month, and day are represented in binary format.
*

*/
public class ConvertDateToBinary {
    public static String convert(String date) {
        String[] parts = date.split("-");

        String year = convertToBinary(parts[0]);
        String month = convertToBinary(parts[1]);
        String day = convertToBinary(parts[2]);

        return year + "-" + month + "-" + day;
    }

    public static String convertToBinary(String s) {
        int n = Integer.parseInt(s);

        if (n == 0) return "0";

        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            stack.push(n % 2);
            n /= 2;
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
