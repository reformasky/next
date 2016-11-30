package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 11/29/16.
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        dfs(candidates, 0, target, current, result);
        return result;
    }

    private void dfs(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        }
        if (index == candidates.length || candidates[index] > target) {
            return;
        }
        current.add(candidates[index]);
        dfs(candidates, index, target - candidates[index], current, result);
        current.remove(current.size() - 1);
        dfs(candidates, index + 1, target, current, result);

    }
}
