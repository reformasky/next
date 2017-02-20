package org.xuan.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xzhou2 on 2/19/17.
 */
public class TrappingRainWaterII_407 {
    int[][] diffs = new int[][]{{1,0}, {0,1}, {-1, 0}, {0, -1}};
    public int trapRainWater(int[][] h) {
        if (h.length == 0 || h[0].length == 0) {
            return 0;
        }
        int nRow = h.length, nCol = h[0].length;
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return h[a[0]][a[1]] - h[b[0]][b[1]];
            }
        });
        boolean[][] visited = new boolean[nRow][nCol];
        for(int i = 0; i < nRow; i++) {
            queue.offer(new int[]{i, 0, h[i][0]});
            visited[i][0] = true;
        }
        for(int i = 1; i < nCol; i++) {
            queue.offer(new int[]{0, i,  h[0][i]});
            visited[0][i] = true;
        }
        for(int i = 1; i < nRow; i++) {
            queue.offer(new int[]{i, nCol - 1,  h[i][nCol - 1]});
            visited[i][nCol - 1] = true;
        }
        for(int i = 1; i < nCol - 1; i++) {
            queue.offer(new int[]{nRow - 1, i,  h[nRow - 1][i]});
            visited[nRow - 1][i] = true;
        }
        int result = 0;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            result += Math.max(curr[2] - h[curr[0]][curr[1]] , 0);
            for(int[] diff : diffs) {
                int r = diff[0] + curr[0], c = diff[1] + curr[1];
                if (r >= 0 && r < nRow && c >= 0 && c < nCol && !visited[r][c]) {
                    visited[r][c] = true;
                    queue.offer(new int[]{r, c, Math.max(h[r][c], curr[2])});
                }
            }
        }
        return result;
    }
}
