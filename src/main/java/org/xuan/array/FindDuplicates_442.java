package org.xuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 2/24/17.
 */
public class FindDuplicates_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val == i + 1) {
                continue;
            }
            nums[i] = 0;
            while(val > 0 && val != nums[val - 1]) {
                int tmp = nums[val - 1];
                nums[val - 1] = val;
                val = tmp;
            }
            if (val > 0) {
                result.add(val);
            }
        }

        return result;
    }
}
