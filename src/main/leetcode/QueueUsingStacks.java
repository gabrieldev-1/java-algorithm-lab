package leetcode;

// Problem: 232. Implement a queue using Stacks

import java.util.Stack;

/**
* Implements a queue data structure using two stacks.
* The push operation rearranges elements to maintain FIFO order,
* ensuring that the top of stackOne always represents the front of the queue.
*
* obs: This implementation makes the push operation costly in order to
* keep pop and peek operations in constant time.
*
* time complexity: O(n) for push; O(1) for pop, peek, and empty;
* space complexity: O(n);
*
* @param x value to be inserted at the end of the queue (push method);
* @return pop returns and removes the front element; peek returns the front element;
* empty returns true if the queue is empty, false otherwise.
*
*/
public class QueueUsingStacks {
    private Stack<Integer> stackOne;
    private Stack<Integer> stackTwo;

    public QueueUsingStacks() {
        this.stackOne = new Stack<>();
        this.stackTwo = new Stack<>();

    }
    
    public void push(int x) {
        while(!stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }

        stackOne.push(x);

        while(!stackTwo.isEmpty()) {
            stackOne.push(stackTwo.pop());

        }
    }
    
    public int pop() {
        return stackOne.pop();
    }
    
    public int peek() {
        return stackOne.peek();
    }
    
    public boolean empty() {
        return stackOne.isEmpty();
    }
}
