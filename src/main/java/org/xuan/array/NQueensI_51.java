package org.xuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 12/4/16.
 */
public class NQueensI_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] cache = new int[n];
        dfs(0, cache, result);
        return result;
    }

    private void dfs(int index, int[] cache, List<List<String>> result) {
        if (index == cache.length) {
            addResult(cache, result);
        } else {
            for(int i = 0; i < cache.length; i++) {
                cache[index] = i;
                if (isValid(cache, index)) {
                    dfs(index + 1, cache, result);
                }
            }
        }
    }

    private boolean isValid(int[] cache, int index) {
        for(int i = 0; i < index; i++) {
            if (cache[i] == cache[index]) {
                return false;
            }
            if (cache[i] - cache[index] == i - index || cache[i] - cache[index] == index - i) {
                return false;
            }
        }
        return true;
    }

    private void addResult(int[] cache, List<List<String>> result) {
        List<String> curr = new ArrayList<>(cache.length);
        StringBuilder sb;
        for (int aCache : cache) {
            sb = new StringBuilder(cache.length);
            for (int j = 0; j < aCache; j++) {
                sb.append('.');
            }
            sb.append('Q');
            for (int j = aCache + 1; j < cache.length; j++) {
                sb.append('.');
            }
            curr.add(sb.toString());
        }
        result.add(curr);
    }
}
