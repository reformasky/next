package org.xuan.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 11/16/16.
 */
public class RomanToInt_13 {
    private static int[] vals = new int[]{1, 5, 10, 50, 100, 500, 1000};
    private static char[] chars = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private static Map<Character, Integer> map = new HashMap<>();
    static {
        for(int i = 0; i < chars.length; i++) {
            map.put(chars[i], vals[i]);
        }
    }

    public int romanToInt(String s) {
        int res = 0;
        int curr, next;
        curr = map.get(s.charAt(0));
        for(int i = 0; i < s.length() - 1; i++) {
            next = map.get(s.charAt(i + 1));
            if (next > curr) {
                res -= curr;
            } else {
                res += curr;
            }
            curr = next;
        }
        res += curr;
        return res;
    }
}
