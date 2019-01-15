package org.xuan.array;

/**
 * Created by xzhou2 on 3/3/17.
 */
public class IslandPerimeter_463 {
    public int islandPerimeter(int[][] grid) {
        int size = 0, join = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    size++;
                    if (i > 0 && grid[i-1][j] == 1) {
                        join++;
                    }
                    if (j > 0 && grid[i][j-1] == 1) {
                        join++;
                    }
                }
            }
        }
        return 4 * size - 2 * join;
    }
}
