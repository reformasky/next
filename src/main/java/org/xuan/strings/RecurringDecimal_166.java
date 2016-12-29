package org.xuan.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 12/28/16.
 */
public class RecurringDecimal_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator, den = denominator;
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return "0";
        }
        boolean neg = false;
        if (num < 0) {
            num = -num;
            neg = !neg;
        }
        if (den < 0) {
            den = -den;
            neg = !neg;
        }
        if (neg) {
            sb.append('-');
        }
        sb.append(num / den);
        num %= den;
        if (num == 0) {
            return sb.toString();
        } else {
            sb.append('.');
        }
        Map<Long, Integer> map = new HashMap<>();
        while(num != 0) {
            if (map.containsKey(num)) {
                int index = map.get(num);
                sb.insert(index, '(');
                sb.append(")");
                return sb.toString();
            }
            long tmp = num * 10;
            sb.append(tmp / den);
            map.put(num, sb.length() - 1);
            tmp %= den;
            num = tmp;

        }
        return sb.toString();
    }
}
