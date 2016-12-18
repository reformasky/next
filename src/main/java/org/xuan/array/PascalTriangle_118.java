package org.xuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>(i + 1);
            curr.add(1);
            if (i > 0) {
                List<Integer> pre = result.get(i - 1);
                for(int j = 0; j < pre.size() - 1; j++) {
                    curr.add(pre.get(j) + pre.get(j + 1));
                }
                curr.add(1);
            }
            result.add(curr);
        }
        return result;
    }
}
