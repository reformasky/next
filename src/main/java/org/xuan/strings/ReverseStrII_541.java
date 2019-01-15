package org.xuan.strings;

/**
 * Created by xzhou2 on 3/23/17.
 */
public class ReverseStrII_541 {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s.length());
        for(int i = 0; i < s.length(); i += 2 * k) {
            int end1 = Math.min(s.length(), i + k);
            sb.append(new StringBuilder(s.substring(i, end1)).reverse());
            if (end1 < s.length()) {
                int end2 = Math.min(s.length(), i + 2 * k);
                sb.append(s.substring(end1, end2));
            }
        }
        return sb.toString();
    }
}
