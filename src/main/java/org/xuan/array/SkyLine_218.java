package org.xuan.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xzhou2 on 1/7/17.
 */
public class SkyLine_218 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if (buildings.length == 0) {
            return result;
        }
        Queue<int[]> pq = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        return a[1] == b[1] ? a[2] - b[2] : a[1] - b[1];
                    }
                }
        );
        for(int[] b : buildings) {
            pq.offer(new int[]{0, b[0], b[2]});
            pq.offer(new int[]{1, b[1], b[2], b[0]});
        };
        int h = 0, index;
        while(!pq.isEmpty()) {
            int[] point = pq.poll();
            index = point[1];
            while(!pq.isEmpty() && pq.peek()[1] == index) {
                point = pq.poll();
            }
            if (point[0] == 0) {
                if (h < point[2]) {
                    h = point[2];
                    result.add(new int[]{index, h});
                }
            } else if (h == point[2]) {
                int next = 0;
                for(int[] p : pq) {
                    if (p[0] == 1 && p[3] <= point[1]) {
                        if (p[2] >= h) {
                            next = h;
                            break;
                        }
                        next = Math.max(next, p[2]);
                    }
                }
                if (next < h) {
                    h = next;
                    result.add(new int[]{index, h});
                }
            }
        }
        return result;
    }
}
