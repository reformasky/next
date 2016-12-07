package org.xuan.array;

/**
 * Created by xzhou2 on 12/4/16.
 */
public class NQueensII_52 {
    int result = 0;
    public int totalNQueens(int n) {
        int[] cache = new int[n];
        dfs(0, cache);
        return result;
    }

    private void dfs(int index, int[] cache) {
        if (index == cache.length) {
            result++;
        } else {
            for(int i = 0; i < cache.length; i++) {
                cache[index] = i;
                if (isValid(cache, index)) {
                    dfs(index + 1, cache);
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
}
