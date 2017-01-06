package org.xuan.others;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xzhou2 on 1/5/17.
 */
public class MyStack {
    // Push element x onto stack.
    Queue<Integer> queue1 = new ArrayDeque<>(),
            queue2 = new ArrayDeque<>(),
            tmp;

    public void push(int x) {
        queue1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (queue1.isEmpty()) {
            tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }
        while(queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        queue1.poll();
    }

    // Get the top element.
    public int top() {
        if (queue1.isEmpty()) {
            tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }
        while(queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        return queue1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
