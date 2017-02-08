package org.xuan.ints;

/**
 * Created by xzhou2 on 1/24/17.
 */
public class WaterAndJug_365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) {
            return false;
        }
        if (x * y == 0) {
            return z == x || z == y;
        }
        return z % gcd(x, y) == 0;
    }

    private int gcd(int x, int y) {
        while(y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}
