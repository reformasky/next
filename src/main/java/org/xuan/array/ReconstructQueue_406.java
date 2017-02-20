package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xzhou2 on 2/19/17.
 */
public class ReconstructQueue_406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length <= 1) {
            return people;
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        List<int[]> array = new ArrayList<>();
        for(int i = people.length - 1; i >= 0; i--) {
            int[] p = people[i];
            array.add(p[1], p);
        }
        return array.toArray(new int[people.length][2]);
    }
}
