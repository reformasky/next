package org.xuan.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xzhou2 on 1/26/17.
 */
public class KthSmallest_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int low = matrix[0][0], high = matrix[len - 1][len - 1];
        while(low < high) {
            int mid = low + (high - low) / 2;
            int lessOrEqual = lessOrEqual(mid, matrix);
            if (lessOrEqual < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int lessOrEqual(int target, int[][] matrix) {
        int result = 0, len = matrix.length;
        int i = len - 1, j = 0;
        while(i >= 0 && j < len) {
            if (matrix[i][j] > target) {
                i--;
            } else {
                result += i + 1;
                j++;
            }
        }
        return result;
    }

    public int kthSmallest_pq(int[][] matrix, int k) {
        int len = matrix.length, counter = 0;
        boolean larger = (len * len / 2) >= k;
        k = larger ? len * len - k + 1 : k;
        boolean[][] visited = new boolean[len][len];

        int[][] diffs = larger ? new int[][]{new int[]{-1, 0}, new int[]{0, -1}}
                : new int[][]{new int[]{1, 0}, new int[]{0, 1}};
        Queue<int[]> queue = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] left, int[] right) {
                        int res = matrix[left[0]][left[1]] - matrix[right[0]][right[1]];
                        return larger ? -res : res;
                    }
                }
        );
        queue.offer(larger ? new int[]{len-1, len-1} : new int[]{0,0});
        while(counter < k) {
            int[] curr = queue.poll();
            counter++;
            if (counter == k) {
                return matrix[curr[0]][curr[1]];
            }
            for(int[] diff : diffs) {
                int row = curr[0] + diff[0], col = curr[1] + diff[1];
                if (((larger && row >= 0 && col >= 0) || (!larger && row < len && col < len)) && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.offer(new int[]{row, col});
                }
            }
        }
        throw new RuntimeException();
    }

}
