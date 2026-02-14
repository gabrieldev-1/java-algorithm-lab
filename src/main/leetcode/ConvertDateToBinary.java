package leetcode;

import java.util.Stack;

// LEETCODE: 3280. Convert Date to Binary

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
