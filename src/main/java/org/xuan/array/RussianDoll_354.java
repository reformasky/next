package org.xuan.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xzhou2 on 1/23/17.
 */
public class RussianDoll_354 {
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if (len <= 1) {
            return len;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? (o2[1] - o1[1]) : (o1[0] - o2[0]);
            }
        });

        int[] cache = new int[len];
        int index = 0;
        for(int[] e : envelopes) {
            int res = Arrays.binarySearch(cache, 0, index, e[1]);
            if (res < 0) {
                int insert = -1 - res;
                cache[insert] = e[1];
                if (insert == index) {
                    index++;
                }
            }
        }
        return index;
    }
}
