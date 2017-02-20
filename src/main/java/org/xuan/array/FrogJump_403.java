package org.xuan.array;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xzhou2 on 2/18/17.
 */
public class FrogJump_403 {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int last = stones[stones.length - 1];
        for(int i : stones) {
            map.put(i, new HashSet<>());
        }
        map.get(0).add(0);
        for(int i = 0; i < stones.length - 1; i++) {
            int curr = stones[i];
            int min = stones[i + 1] - curr;
            Set<Integer> steps = map.get(curr);
            for(int s : steps) {
                int[] nextSteps = new int[]{s - 1, s , s + 1};
                for(int n : nextSteps) {
                    if (n >= min) {
                        int nextPosition = n + curr;
                        if (map.containsKey(nextPosition)) {
                            map.get(nextPosition).add(n);
                            if (last == nextPosition) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0,1,3,6,10,15,19,21,24,26,30,33};
        FrogJump_403 f = new FrogJump_403();
        boolean b = f.canCross(input);
        assert b;
    }
}
