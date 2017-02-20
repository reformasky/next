package org.xuan.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by xzhou2 on 2/9/17.
 */
public class RandomPick_398 {
    Map<Integer, List<Integer>> map;
    Random random = new Random();
    public RandomPick_398(int[] nums) {
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> curr;
            if (!map.containsKey(nums[i])) {
                curr = new ArrayList<>();
                map.put(nums[i], curr);
            } else {
                curr = map.get(nums[i]);
            }
            curr.add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
