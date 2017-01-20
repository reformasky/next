package org.xuan.ints;

/**
 * Created by xzhou2 on 1/16/17.
 */
public class BulbSwitch_319 {
    public int bulbSwitch_binary(int n) {
        long low = 0, high = n;
        while(low <= high) {
            long mid = (high + low) / 2;
            long curr = mid * mid;
            if (curr == n) {
                return (int)mid;
            } else if (curr > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)high;
    }


    public int bulbSwitch(int n) {
        int count = 0;
        long curr = 1;
        while(curr * curr <= n) {
            count++;
            curr++;
        }
        return count;
    }
}
