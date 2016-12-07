package org.xuan.others;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by xzhou2 on 12/1/16.
 */
public class MaxStack{
    static class Node implements Comparable<Node>{
        public int val;
        public Node pre, next;
        public Node(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return o.val - val;
        }

    }

    Queue<Node> maxStack;
    Node tail;
    int size;

    public MaxStack() {
        maxStack = new PriorityQueue<>();
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int peek() {
        return tail.val;
    }

    public int max() {
        return maxStack.peek().val;
    }

    public int pop() {
        if (maxStack.peek() == tail) {
            maxStack.poll();
        }
        int res = tail.val;
        tail = tail.pre;
        size--;
        return res;
    }

    public int popMax() {
        Node pop = maxStack.poll();
        if (pop == tail) {
            tail = tail.pre;
        } else {
            pop.next.pre = pop.pre;
            if (pop.pre != null) {
                pop.pre.next = pop.next;
            }
        }
        size--;
        return pop.val;
    }

    public void push(int val) {
        Node node = new Node(val);
        if (tail == null) {
            tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        maxStack.offer(node);
        size++;
    }
}