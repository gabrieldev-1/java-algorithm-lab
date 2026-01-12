// Problem: 01.Two Sum;

import java.util.Map;
import java.util.HashMap;

/**
 * Iterates through an array of integers and finds the indices of the values ​​that, when added together, result in the target.
 * 
 * obs: This solution assumes that the array contains only one sum that results in the target;
 * 
 * time complexity: O(n);
 * space complexity: O(n);
 * 
 * @param nums arrray of Integers;
 * @param target target to be found;
 * @return indexes of the elements that, when added together, result in the target.
 * 
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[] { map.get(complement), i };

            }
            map.put(nums[i], i);

        }
        return new int[0];

    }
}