package org.xuan.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xzhou2 on 1/1/17.
 */
public class ScheduleCourse_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        Set<Integer>[] from = (Set<Integer>[]) new Set[numCourses],
                to = (Set<Integer>[]) new Set[numCourses];
        for(int i = 0; i < numCourses; i++) {
            from[i] = new HashSet<>();
            to[i] = new HashSet<>();
        }
        for(int[] p : prerequisites) {
            from[p[1]].add(p[0]);
            to[p[0]].add(p[1]);
        }
        for(int i = 0; i < numCourses; i++) {
            if (from[i].isEmpty()) {
                count++;
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int i : to[curr]) {
                from[i].remove(curr);
                if (from[i].isEmpty()) {
                    count++;
                    queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}
