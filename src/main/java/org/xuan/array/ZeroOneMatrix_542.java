package org.xuan.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Created by xzhou2 on 3/23/17.
 */
public class ZeroOneMatrix_542 {
    private static final int[][] diffs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        if (matrix.size() == 0 || matrix.get(0).size() == 0) {
            return new ArrayList<>();
        }
        int row = matrix.size(), col = matrix.get(0).size();
        List<List<Integer>> result = new ArrayList<>(row);

        for(int i = 0; i < row; i++) {
            Integer[] curr = new Integer[col];
            Arrays.fill(curr, -1);
            result.add(new ArrayList<>(Arrays.asList(curr)));
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (matrix.get(i).get(j) == 0) {
                    queue.offer(new int[]{i, j});
                    result.get(i).set(j, 0);
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] diff : diffs) {
                int r = curr[0] + diff[0], c = curr[1] + diff[1];
                if (r >= 0 && r < row && c >= 0 && c < col && result.get(r).get(c) < 0) {
                    result.get(r).set(c, result.get(curr[0]).get(curr[1]) + 1);
                    queue.offer(new int[]{r, c});
                }
            }
        }
        return result;
    }
}
