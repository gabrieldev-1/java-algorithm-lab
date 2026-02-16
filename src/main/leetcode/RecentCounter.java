package leetcode;

import java.util.Queue;
import java.util.ArrayDeque;

// [t - 3000, t]

public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);
        int couter = 0;

        for (Integer item : queue) {
            if (item >= (t - 3000)) {
                couter++;
            }
        }

        return couter;
    }
}
