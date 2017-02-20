package org.xuan.ints;

/**
 * Created by xzhou2 on 2/16/17.
 */
public class NthDigits_400 {
    private static long[] lowest = new long[10], start = new long[10];
    static {
        long l = 1, s = 1;
        for(int i = 0; i < 10; i++) {
            lowest[i] = l;
            start[i] = s;
            l += 9 * s * (i + 1);
            s *= 10;
        }
        for(int i = 0; i < 10; i++) {
            System.out.println(i + 1 + " " + lowest[i] + " " + start[i]);
        }
    }
    public int findNthDigit(int n) {
        int digits = 10;
        for(int i = 0; i < 10; i++) {
            if (n < lowest[i]) {
                digits = i;
                break;
            }
        }

        long diff = n - lowest[digits - 1];
        return getNth(diff/ digits + start[digits - 1], digits - diff % digits - 1);
    }

    private int getNth(long num, long index) {
        System.out.print(num);
        while(index-- > 0) {
            num /= 10;
        }
        return (int)(num % 10);
    }
}
