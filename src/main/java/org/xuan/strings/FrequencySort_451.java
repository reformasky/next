package org.xuan.strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xzhou2 on 2/27/17.
 */
public class FrequencySort_451 {
    public String frequencySort(String s) {
        int[][] counts = new int[128][2];
        for(int i = 0; i < 128; i++) {
            counts[i] = new int[2];
            counts[i][0] = i;
        }
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)][1]++;
        }

        Arrays.sort(counts, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        StringBuilder sb = new StringBuilder(s.length());
        for(int[] c : counts) {
            if (c[1] > 0) {
                for(int i = 0; i < c[1]; i++) {
                    sb.append((char)c[0]);
                }
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
