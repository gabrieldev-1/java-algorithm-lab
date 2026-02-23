package leetcode;

// Problem: 014. Longest Commom Prefix;

public class LongestCommonPrefix {
    /**

    * Finds the longest common prefix among an array of strings.
    * The method iteratively reduces the prefix candidate until it matches
    * the beginning of every string in the array.
    *
    * obs: This solution compares each string against a shrinking prefix
    * derived from the first string.
    *
    * time complexity: O(n * m);
    * space complexity: O(1);
    *
    * @param strs array of strings to be analyzed;
    * @return the longest common prefix shared among all strings, or an empty string if none exists.
    *

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
