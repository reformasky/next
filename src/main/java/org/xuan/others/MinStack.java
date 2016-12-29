package org.xuan.others;

import java.util.Stack;

/**
 * Created by xzhou2 on 12/27/16.
 */
public class MinStack {
    Stack<Integer> mins, values;


    /** initialize your data structure here. */
    public MinStack() {
        mins = new Stack<>();
        values = new Stack<>();
    }

    private boolean isEmpty() {
        return values.isEmpty();
    }

    public void push(int x) {
        if (isEmpty()) {
            mins.push(x);
            values.push(x);
        } else {
            values.push(x);
            mins.push(Math.min(x, mins.peek()));
        }
    }

    public void pop() {

        mins.pop();
        values.pop();
    }

    public int top() {

        return values.peek();
    }

    public int getMin() {

        return mins.peek();
    }
}
