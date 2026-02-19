package leetcode;

import java.util.HashSet;

public class ContainsDuplicate {
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