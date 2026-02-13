package leetcode;

import java.util.Stack;
import java.util.Arrays;
// LEETCODE: 344. Reverse String;

public class ReverseString {
    public static void reverse(char[] s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }

        for(int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
    }
    
    public static void main(String[] args) {
        char[] string = {'s', 't','r', 'i', 'n', 'g'};
        System.out.println(Arrays.toString(string));
        
        reverse(string);

        System.out.println(Arrays.toString(string));

        
    }
}
