package leetcode;

// Problem: 20. Valid Parentheses

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    /**
    * Iterates through an array of characters representing brackets and verifies whether the sequence is valid.
    * A sequence is valid if every opening bracket has a corresponding closing bracket in the correct order.
    *
    * obs: This solution assumes the input contains only bracket characters: (), {}, [].
    *
    * time complexity: O(n);
    * space complexity: O(n);
    *
    * @param arr array of characters containing bracket symbols;
    * @return true if the bracket sequence is valid; false otherwise.
    *
    */
    public static boolean isValid(char[] arr) {

        Stack<Character> stack = new Stack<>();

        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put(')', '(');
        bracketPairs.put('}', '{');
        bracketPairs.put(']', '[');

        for (char current : arr) {

            // If it is a closing bracket
            if (bracketPairs.containsKey(current)) {

                if (stack.isEmpty()) {
                    return false;
                }

                char lastOpened = stack.pop();

                if (lastOpened != bracketPairs.get(current)) {
                    return false;
                }

            } else {
                // Opening bracket
                stack.push(current);
            }
        }

        // If stack is empty, all brackets were matched
        return stack.isEmpty();
    }
}

