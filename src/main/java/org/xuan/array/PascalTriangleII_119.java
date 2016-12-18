package org.xuan.array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class PascalTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        Arrays.fill(result, 0);
        for(int i = 0; i <= rowIndex; i++) {
            result[0] = 1;
            int tmp = 1, pre = 1;
            for(int j = 1; j < i + 1; j++) {
                tmp = result[j];
                result[j] = pre + tmp;
                pre = tmp;
            }
        }
        return Arrays.asList(result);
    }
}
