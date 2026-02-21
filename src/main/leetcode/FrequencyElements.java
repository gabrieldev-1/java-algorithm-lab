package leetcode;

import java.util.HashMap;

public class FrequencyElements {
    public static HashMap<Integer, Integer> find(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        return map;
    }
}
