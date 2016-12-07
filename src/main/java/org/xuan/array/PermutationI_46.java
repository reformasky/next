package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 12/1/16.
 */
public class PermutationI_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Integer[] curr = new Integer[nums.length];
        boolean[] visited = new boolean[nums.length];
        dfs(nums, curr, visited, 0, result);
        return result;
    }

    private void dfs(int[] nums, Integer[] curr, boolean[] visited, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(Arrays.asList(curr)));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    curr[index] = nums[i];
                    dfs(nums, curr, visited, index + 1, result);
                    visited[i] = false;
                }
            }
        }
    }
}
