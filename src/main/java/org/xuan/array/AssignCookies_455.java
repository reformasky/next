package org.xuan.array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xzhou2 on 2/28/17.
 */
public class AssignCookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0, indexG = 0, indexS = 0;
        while(indexG < g.length && indexS < s.length) {
            if (s[indexS] >= g[indexG]) {
                indexG++;
                result++;
            }
            indexS++;
        }
        return result;
    }

}
