package org.xuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 1/5/17.
 */
public class SummaryRange_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int begin =nums[0], pre = begin;
        for(int i = 1; i < nums.length; i++) {
            if (pre == nums[i] - 1) {
                pre = nums[i];
            } else {
                result.add(pre == begin ? String.valueOf(begin) : begin + "->" + pre);
                begin = pre = nums[i];
            }
        }
        int end = nums[nums.length - 1];
        result.add(end == begin ? String.valueOf(begin) : begin + "->" + end);
        return result;
    }
}
