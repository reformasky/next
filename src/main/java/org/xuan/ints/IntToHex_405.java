package org.xuan.ints;

/**
 * Created by xzhou2 on 2/19/17.
 */
public class IntToHex_405 {
    private static final int MASK = 0xf;
    private static final int SHIFT = 4;
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            sb.append(map(num & MASK));
            num >>>= SHIFT;
        }
        return sb.reverse().toString();
    }

    private char map(int num) {
        if (num < 10) {
            return (char)('0' + num);
        } else {
            return (char)('a' + num - 10);
        }
    }
}
