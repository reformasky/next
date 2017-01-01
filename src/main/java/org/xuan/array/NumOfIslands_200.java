package org.xuan.array;

/**
 * Created by xzhou2 on 12/30/16.
 */
public class NumOfIslands_200 {
    private static final int[][] diffs = new int[][]{
            new int[]{1,0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}
    };

    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return result;
        }
        int nRow = grid.length, nCol = grid[0].length;
        boolean[][] visited = new boolean[nRow][nCol];
        for(int i = 0; i < nRow; i++) {
            visited[i] = new boolean[nCol];
        }
        for(int r = 0; r < nRow; r++) {
            for(int c = 0; c < nCol; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    result++;
                    dfs(grid, visited, r, c);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        for(int[] diff : diffs) {
            int nextR = r + diff[0], nextC = c + diff[1];
            if (nextR >= 0 && nextR < grid.length && nextC >= 0 && nextC < grid[0].length
                    && grid[nextR][nextC] == '1' && !visited[nextR][nextC]
                    ) {
                dfs(grid, visited, nextR, nextC);
            }
        }
    }
}
