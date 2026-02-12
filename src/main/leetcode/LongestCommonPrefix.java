package leetcode;

// LEETCODE: 014. Longest Commom Prefix;

public class LongestCommonPrefix {
    /**
     * Solves the Longest Common Prefix problem using Horizontal Scanning.
     * * Algorithm:
     * 1. Assume the first string as the initial prefix.
     * 2. Iteratively compare the prefix with each subsequent string.
     * 3. Shorten the prefix using substring() until a match is found at the start of the current string.
     * * Complexity Analysis:
     * - Time: O(S), where S is the sum of all characters in all strings (worst case).
     * - Space: O(1), as it only stores the prefix string regardless of input array size.
     * * @param strs Array of strings to analyze.
     * @return The longest common prefix or an empty string if none exists.
     */
    public String solution(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                
                if (prefix.isEmpty()) return "";
            
            }
        }
        return prefix;

    }
}
