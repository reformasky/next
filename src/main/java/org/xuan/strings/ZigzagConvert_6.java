package org.xuan.strings;

/**
 * Created by xzhou2 on 11/15/16.
 */
public class ZigzagConvert_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {return s;}
        StringBuilder sb = new StringBuilder(s.length());
        int segmentLength = 2 * (numRows - 1);
        for(int r = 0; r < numRows; r++) {
            for(int c = 0; c + r < s.length(); c += segmentLength) {
                if (r < numRows - 1) {
                    sb.append(s.charAt(c + r));
                }
                if (r > 0) {
                    if (c + segmentLength  - r < s.length()) {
                        sb.append(s.charAt(c + segmentLength - r));
                    } else {
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}
