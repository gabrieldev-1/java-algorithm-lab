package leetcode;

// Problem: 344. Reverse String;

import java.util.Stack;

public class ReverseString {
    /**
    * Reverses the elements of a character array using a stack data structure.
    * The method pushes all characters onto the stack and then pops them back
    * into the array to produce the reversed order.
    *
    * obs: This implementation uses extra space proportional to the array size.
    *
    * time complexity: O(n);
    * space complexity: O(n);
    *
    * @param s array of characters to be reversed;
    * @return void.
    *
    */
    public static void reverse(char[] s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }

        for(int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
    }
}
