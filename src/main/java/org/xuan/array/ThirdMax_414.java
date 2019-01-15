package org.xuan.array;

/**
 * Created by xzhou2 on 2/20/17.
 */
public class ThirdMax_414 {
    public int thirdMax(int[] nums) {
        long first = Integer.MIN_VALUE - 1l, second = Integer.MIN_VALUE - 1l, third = Integer.MIN_VALUE - 1l;
        for(int n : nums) {
            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n < first && n > second) {
                third = second;
                second = n;
            } else if (n < second && n > third) {
                third = n;
            }
        }
        return third == ((long)Integer.MIN_VALUE - 1) ? (int)first : (int)third;
    }
}
