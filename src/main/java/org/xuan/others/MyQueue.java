package org.xuan.others;

import java.util.Stack;

/**
 * Created by xzhou2 on 1/8/17.
 */
class MyQueue {
    private Stack<Integer> stack1 = new Stack<>(),
            stack2 = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();

    }

    // Get the front element.
    public int peek() {
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}