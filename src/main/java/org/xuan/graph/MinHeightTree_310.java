package org.xuan.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xzhou2 on 1/12/17.
 */
public class MinHeightTree_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        Set<Integer>[] graph = (Set<Integer>[])new Set[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for(int[] edge : edges) {
            graph[edge[1]].add(edge[0]);
            graph[edge[0]].add(edge[1]);
        }
        int deleted = 0;
        Queue<Integer> next = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            if (graph[i].size() <= 1) {
                next.offer(i);
            }
        }
        while(!next.isEmpty() && deleted < n - 2) {
            int size = next.size();
            deleted += size;
            for(int i = 0; i < size; i++) {
                int f = next.poll();
                for(int v : graph[f]) {
                    graph[v].remove(f);
                    if (graph[v].size() == 1) {
                        next.offer(v);
                    }
                }
            }
        }
        while(!next.isEmpty()) {
            result.add(next.poll());
        }
        return result;
    }
}
