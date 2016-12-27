package org.xuan.strings;

/**
 * Created by xzhou2 on 12/21/16.
 */
public class ReverseWords_151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = " " + s;
        int end = s.length();
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (end != i + 1) {
                    sb.append(s.substring(i + 1, end));
                    sb.append(" ");
                }
                end = i;
            }
        }
        if(sb.length() > 0 ) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
