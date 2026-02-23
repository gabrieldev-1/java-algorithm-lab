package leetcode;

// Problem: 217. Contains Duplicate;

import java.util.HashSet;

public class ContainsDuplicate {
    /**

    * Determines whether an integer array contains any duplicate values.
    * The method iterates through the array and uses a HashSet to track
    * previously seen elements. If an element is already present in the set,
    * a duplicate has been found.
    *
    * obs: This solution leverages constant-time average lookup and insertion
    * provided by a hash-based set.
    *
    * time complexity: O(n);
    * space complexity: O(n);
    *
    * @param arr array of integers to be analyzed;
    * @return true if the array contains at least one duplicate value; false otherwise.
    *

    */
    public boolean solution(int[] arr) {
        HashSet<Integer> map = new HashSet<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(map.contains(arr[i])) {
                return true;
            }
            map.add(arr[i]);

        }

        return false;

    }
}