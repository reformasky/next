package org.xuan.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xzhou2 on 2/20/17.
 */
public class PacificAtlantic_417 {
    int[][] diffs = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int nRow = matrix.length, nCol = matrix[0].length;
        boolean[][] visited = new boolean[nRow][nCol];

        byte[][] ocean = new byte[nRow][nCol];
        for(int i = 0; i < nRow; i++) {
            visited[i] = new boolean[nCol];
            ocean[i] = new byte[nCol];
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < nRow; i++) {
            queue.offer(new int[]{i, 0});
        }
        for(int j = 1; j < nCol; j++) {
            queue.offer(new int[] {0, j});
        }
        dfs(queue, visited, ocean, matrix);
        for(int i = 0; i < nRow; i++) {
            visited[i] = new boolean[nCol];
        }
        for(int i = 0; i < nRow; i++) {
            queue.offer(new int[]{i, nCol - 1});
        }
        for(int j = 0; j < nCol - 1; j++) {
            queue.offer(new int[]{nRow - 1, j});
        }
        dfs(queue, visited, ocean, matrix);

        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
                if (ocean[i][j] == 2) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }


    private void dfs(Queue<int[]> queue, boolean[][] visited, byte[][] ocean, int[][] matrix) {
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1];
            if (!visited[i][j]) {
                visited[i][j] = true;
                ocean[i][j]++;
                for(int[] diff : diffs) {
                    int r = i + diff[0], c = j + diff[1];
                    if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && !visited[r][c]
                            && matrix[r][c] >= matrix[i][j]) {
                        queue.offer(new int[]{r, c});
                    }
                }
            }

        }
    }
}
