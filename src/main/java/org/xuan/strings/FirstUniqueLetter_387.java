package org.xuan.strings;

/**
 * Created by xzhou2 on 1/29/17.
 */
public class FirstUniqueLetter_387 {
    public int firstUniqChar(String s) {
        long[] index = new long[26];
        for(int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (index[curr] == 0) {
                index[curr] = i + 1l;
            } else if (index[curr] > 0) {
                index[curr] = -1;
            }
        }
        long result = Integer.MAX_VALUE + 2l;
        for(long i : index) {
            if (i > 0) {
                result = Math.min(i - 1, result);
            }
        }
        return result == (Integer.MAX_VALUE + 2l) ? -1 : (int)result;
    }
}
