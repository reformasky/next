package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 12/14/16.
 */
public class SubsetII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        int preSize = 1, size = 1;
        for(int i = 0; i < nums.length; i++) {
            size = result.size();
            if (i == 0 || nums[i] != nums[i - 1]) {
                for(int j = 0; j < size; j++) {
                    List<Integer> curr = new ArrayList<>(result.get(j));
                    curr.add(nums[i]);
                    result.add(curr);
                }
            } else {
                for(int j = preSize; j < size; j++) {
                    List<Integer> curr = new ArrayList<>(result.get(j));
                    curr.add(nums[i]);
                    result.add(curr);
                }
            }
            preSize = size;
        }
        return result;
    }
}
