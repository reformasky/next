package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 11/17/16.
 */
public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int tmp;
        int max = nums[nums.length -1];
        for(int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                for(int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j-1]) {
                        if (nums[i] + 3 * nums[j] > target) {
                            break;
                        }
                        if (nums[i] + nums[j] + 2 * max < target) {
                            continue;
                        }
                        int left = j + 1, right = nums.length - 1;
                        while(left < right) {
                            int sum = nums[i] + nums[j] + nums[left] + nums[right];
                            if (sum == target) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                tmp = nums[left];
                                while(left < right && nums[++left] == tmp);
                                tmp = nums[right];
                                while(left < right && nums[--right] ==tmp);
                            } else if (sum > target) {
                                tmp = nums[right];
                                while(left < right && nums[--right] ==tmp);
                            } else{
                                tmp = nums[left];
                                while(left < right && nums[++left] == tmp);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
