package org.xuan.ints;

/**
 * Created by xzhou2 on 3/12/17.
 */
public class Base7_504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean neg = false;
        if (num < 0) {
            num = -num;
            neg = true;
        }
        int base = 7;
        while(num != 0) {
            sb.append(num % base);
            num /= base;
        }
        if (neg) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
