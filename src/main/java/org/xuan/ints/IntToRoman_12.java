package org.xuan.ints;

/**
 * Created by xzhou2 on 11/16/16.
 */
public class IntToRoman_12 {
    private int[] vals = new int[]{1, 5, 10, 50, 100, 500, 1000};
    private char[] chars = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        boolean ten = true;
        for(int i = vals.length - 1; i > 0; i--) {
            int count = num / vals[i];
            num %= vals[i];
            for(int j = 0; j < count; j++) {
                sb.append(chars[i]);
            }
            int diff = ten ? vals[i] - vals[i - 2] : vals[i] - vals[i - 1];
            if (num >= diff) {
                num -= diff;
                sb.append(ten ? chars[i - 2] : chars[i-1]);
                sb.append(chars[i]);
            }
            ten = !ten;
        }
        for(int j = 0; j < num; j++) {
            sb.append(chars[0]);
        }
        return sb.toString();

    }
}
