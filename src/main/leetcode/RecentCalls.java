package leetcode;

// Problem: 933. Number of Recent Calls

import java.util.Queue;
import java.util.ArrayDeque;

/**

* Counts the number of recent requests within a time window of 3000 milliseconds.
* Each call to ping(int t) records a new request at time t and removes
* all requests that occurred before (t - 3000), keeping only valid ones.
*
* obs: This solution maintains a sliding time window using a queue.
*
* time complexity: O(1) amortized per call;
* space complexity: O(n);
*
* @param t current timestamp in milliseconds;
* @return number of requests in the range [t - 3000, t].
*

*/
public class RecentCalls {

    private Queue<Integer> queue;

    public RecentCalls() {
        this.queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);

        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}
