package org.xuan.ints;

/**
 * Created by xzhou2 on 3/12/17.
 */
public class ConstructRectangle_492 {
    public int[] constructRectangle(int area) {
        int w = (int)(Math.sqrt(area));
        while(area % w != 0) {
            w--;
        }
        return new int[]{area/w, w};
    }
}
