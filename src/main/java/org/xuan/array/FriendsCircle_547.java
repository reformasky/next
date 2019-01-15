package org.xuan.array;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xzhou2 on 4/2/17.
 */
public class FriendsCircle_547 {
    public int findCircleNum(int[][] M) {
        if (M.length == 0) {
            return 0;
        }
        int len = M.length;
        UF uf = new UF(len);
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if (M[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            uf.join(curr[0], curr[1]);
        }
        return uf.size();
    }

    private static class UF{
        int[] roots;
        int[] weights;
        int size;

        public UF(int s) {
            size = s;
            roots = new int[s];
            weights = new int[s];
            for(int i = 0; i < s; i++) {
                roots[i] = i;
                weights[i] = 1;
            }
        }

        public int size() {
            return size;
        }

        public void join(int i, int j) {
            int rootI = getRoot(i);
            int rootJ = getRoot(j);
            if (rootI != rootJ) {
                int wI = weights[rootI], wJ = weights[rootJ];
                if (wI >= wJ) {
                    weights[rootI] += wJ;
                    roots[rootJ] = roots[rootI];
                } else {
                    weights[rootJ] += wI;
                    roots[rootI] = roots[rootJ];
                }
                size--;
            }
        }

        private int getRoot(int i) {
            while(roots[i] != i) {
                i = roots[i];
            }
            return i;
        }
    }
}
