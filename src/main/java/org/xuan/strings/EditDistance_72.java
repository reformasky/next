package org.xuan.strings;

import java.util.Arrays;

/**
 * Created by xzhou2 on 12/8/16.
 */
public class EditDistance_72 {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return word1.length() == 0 ? word2.length() : word1.length();
        }
        int len1 = word1.length() + 1, len2 = word2.length() + 1;
        int[][] cache = new int[len1][len2];
        for(int i = 0; i < len1; i++) {
            cache[i] = new int[len2];
            Arrays.fill(cache[i], -1);
        }
        cache[0][0] = 0;
        return minDistance(word1, word2, cache, len1 - 1,  len2 - 1);
    }

    private int minDistance(String word1, String word2, int[][] cache, int row, int col) {
        if (cache[row][col] >= 0) {
            return cache[row][col];
        }
        if (row == 0 || col == 0) {
            return row == 0 ? col : row;
        }
        int pre1 = minDistance(word1, word2, cache, row - 1, col - 1);
        if (word1.charAt(row - 1) == word2.charAt(col - 1)) {
        } else{
            pre1 += 1;
            int pre2 = minDistance(word1, word2, cache, row, col - 1) + 1,
                    pre3 = minDistance(word1, word2, cache, row - 1, col) + 1;
            pre1 = Math.min(pre1, Math.min(pre2, pre3));

        }
        cache[row][col] = pre1;
        return pre1;
    }
}
