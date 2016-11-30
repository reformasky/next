package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 11/29/16.
 */
public class CombinationSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        dfs(candidates, 0, target, false, current,  result);
        return result;
    }

    private void dfs(int[] candidates, int index, int target, boolean skip, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        }
        if (index == candidates.length || candidates[index] > target) {
            return;
        }
        if (index == 0 || !skip || candidates[index] != candidates[index - 1]) {
            skip = (skip && (candidates[index] == candidates[index - 1])) ;
            current.add(candidates[index]);
            dfs(candidates, index + 1, target - candidates[index], skip, current, result);
            current.remove(current.size() - 1);
        }
        dfs(candidates, index + 1, target, true, current, result);

    }
}
