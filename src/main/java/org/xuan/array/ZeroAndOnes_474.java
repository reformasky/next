package org.xuan.array;

import java.util.Comparator;

/**
 * Created by xzhou2 on 3/6/17.
 */
public class ZeroAndOnes_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] count = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            count[i] = new int[n + 1];
        }
        for (String str : strs) {
            int z = 0, o;
            for (int i = 0; i < str.length(); i++) {
                z += (str.charAt(i)== '0') ? 1 : 0;
            }
            o = str.length() - z;
            for (int j = m; j >= z; j--) {
                for (int k = n; k >= o; k--) {
                    count[j][k] = Math.max(count[j][k], 1 + count[j - z][k - o]);
                }
            }
        }
        return count[m][n];
    }

    class CMP implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return 0;
        }
    }
}
