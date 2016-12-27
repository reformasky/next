package org.xuan.array;

import java.util.List;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] cache = new int[triangle.size() + 1];
        for(int row = triangle.size() - 1; row >= 0; row--) {
            List<Integer> curr = triangle.get(row);
            for(int i = 0; i < curr.size(); i++) {
                cache[i] = Math.min(cache[i], cache[i + 1]) + curr.get(i);
            }
        }
        return cache[0];
    }
}
