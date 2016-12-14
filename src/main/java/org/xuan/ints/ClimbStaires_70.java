package org.xuan.ints;

/**
 * Created by xzhou2 on 12/8/16.
 */
public class ClimbStaires_70 {
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 3) {
            return n;
        }
        int pre = 2, prePre = 1, curr = 3;
        while(curr++ < n) {
            int tmp = pre + prePre;
            prePre = pre;
            pre = tmp;
        }
        return pre + prePre;
    }
}
