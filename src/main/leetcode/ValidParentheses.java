import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    /**
     * Validates whether the given sequence of parentheses is correctly balanced.
     *
     * A string is considered valid if:
     * 
     * Every opening bracket has a corresponding closing bracket.
     * Brackets are closed in the correct order.
     * Only the following bracket types are supported: (), {}, [].
     * 
     * This method uses a stack to track opening brackets and ensures
     * that each closing bracket matches the most recent opening bracket.
     *
     * @param arr an array of characters representing the parentheses sequence
     * @return {@code true} if the sequence is valid; {@code false} otherwise
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

