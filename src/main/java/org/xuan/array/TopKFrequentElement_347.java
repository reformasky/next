package org.xuan.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xzhou2 on 1/19/17.
 */
public class TopKFrequentElement_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        Queue<Ele> queue = new PriorityQueue<>(k);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Ele ele = new Ele(entry.getKey(), entry.getValue());
            if (queue.size() < k) {
                queue.offer(ele);
            } else if (queue.peek().count < ele.count) {
                queue.poll();
                queue.offer(ele);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(Ele ele : queue) {
            result.add(ele.val);
        }
        return result;
    }

    private static class Ele implements Comparable<Ele> {
        int val;
        int count;

        public Ele(int v, int c) {
            val = v;
            count = c;
        }

        @Override
        public int compareTo(Ele other) {
            return count - other.count;
        }
    }
}
