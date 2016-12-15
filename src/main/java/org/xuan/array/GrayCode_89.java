package org.xuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 12/14/16.
 */
public class GrayCode_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(1 << n);
        result.add(0);
        int shift = 0;
        while(result.size() < (1 << n)) {
            int size = result.size(), mask = 1 << shift;
            for(int i = size - 1; i >= 0; i--) {
                result.add(mask | result.get(i));
            }
            shift++;
        }
        return result;
    }
}
