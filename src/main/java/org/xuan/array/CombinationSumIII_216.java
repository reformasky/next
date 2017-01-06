package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 1/4/17.
 */
public class CombinationSumIII_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, new Integer[k], n, result);
        return result;
    }

    private void dfs(int index, Integer[] path, int sum, List<List<Integer>> result) {
        if (index == path.length && sum == 0) {
            result.add(new ArrayList<Integer>(Arrays.asList(path)));
        } else {
            int count = path.length - index;
            for(int i = index == 0 ? 1 : (path[index-1] + 1); i <= 9; i++) {
                if (
                        (i + (9 + 9 - count + 2) * (count - 1) /2) >= sum
                                && (i + i + count - 1) * count / 2 <= sum) {
                    path[index] = i;
                    dfs(index+1, path, sum - i, result);
                }

            }
        }
    }




}
