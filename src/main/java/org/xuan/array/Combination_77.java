package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 12/12/16.
 */
public class Combination_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n) {
            return result;
        }
        Integer[] path = new Integer[k];
        dfs(0, n, path, result);
        return result;
    }

    private void dfs(int index, int n, Integer[] path, List<List<Integer>> result) {
        if (index == path.length) {
            result.add(new ArrayList<>(Arrays.asList(path)));
        } else {
            int start = index == 0 ? 1 : (path[index - 1] + 1), k = path.length;
            int max = Math.min(n, n - k + index + 1);
            for(int i = start; i <= max; i++) {
                path[index] = i;
                dfs(index + 1, n, path, result);
            }
        }
    }
}
