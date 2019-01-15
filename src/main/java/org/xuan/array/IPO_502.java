package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by xzhou2 on 3/11/17.
 */
public class IPO_502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int len = Capital.length;
        int[][] cache = new int[len][2];
        for(int i = 0; i < len; i++) {
            cache[i] = new int[]{Profits[i], Capital[i]};
        }

        Arrays.sort(cache, (o1, o2) -> o1[1] - o2[1]);
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int index = 0;
        for(int i = 0; i < k; i++) {
            while (index < len && cache[index][1] <= W) {
                queue.offer(cache[index][0]);
                index++;
            }
            if (queue.isEmpty()) {
                break;
            }
            W += queue.poll();
        }
        return W;
    }
}
