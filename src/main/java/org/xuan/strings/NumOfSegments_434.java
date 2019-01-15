package org.xuan.strings;

/**
 * Created by xzhou2 on 2/21/17.
 */
public class NumOfSegments_434 {
    public int countSegments(String s) {
        s = s + " ";
        int result = 0;
        char pre = ' ';
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == ' ') {
                if (pre != ' ') {
                    result++;
                }
            }
            pre = curr;
        }
        return result;
    }
}
