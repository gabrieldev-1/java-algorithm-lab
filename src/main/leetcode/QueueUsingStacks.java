package leetcode;

import java.util.Stack;

// LEETCODE: 232. Implement a queue using Stacks

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
