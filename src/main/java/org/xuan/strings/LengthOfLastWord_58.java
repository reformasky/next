package org.xuan.strings;

/**
 * Created by xzhou2 on 12/2/16.
 */
public class LengthOfLastWord_58 {
    public int lengthOfLastWord(String s) {
        int result = 0, end = -1;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (end >= 0) {
                    return end - i;
                }
            } else {
                if (end < 0) {
                    end = i;
                }
            }
        }
        return end >= 0 ? end + 1 : 0;
    }
}
