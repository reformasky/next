package org.xuan.others;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xzhou2 on 1/10/17.
 */
public class MedianFinder {
    private Queue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer left, Integer right) {
            return right - left;
        }
    }),
            minQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer left, Integer right) {
                    return left - right;
                }
            });

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxQueue.offer(num);
        minQueue.offer(maxQueue.poll());
        if (minQueue.size() > maxQueue.size() + 1) {
            maxQueue.offer(minQueue.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxQueue.size() == minQueue.size()) {
            return 0.5 * maxQueue.peek() + 0.5 * minQueue.peek();
        } else {
            return 1.0 * minQueue.peek();
        }
    }


};
