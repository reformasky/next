package org.xuan.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 2/26/17.
 */
public class Boomerang_447 {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dist = getDistance(points[i], points[j]);
                    int val = map.getOrDefault(dist, 0);
                    result += val;
                    map.put(dist, val + 1);
                }
            }
            map.clear();
        }
        return result * 2;
    }

    private int getDistance(int[] i, int [] j) {
        int dx = i[0] - j[0], dy = i[1] - j[1];
        return dx * dx + dy * dy;
    }
}
