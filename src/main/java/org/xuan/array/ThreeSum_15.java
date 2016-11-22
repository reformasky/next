package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 11/17/16.
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum_twoPointers(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int left = i + 1, right = nums.length - 1;
                while(left < right) {
                    int sum = nums[left] + nums[right] + nums[i];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[++left]) {

                        }
                        while(left < right && nums[right] == nums[--right]){

                        }
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }

                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if (i == 0|| nums[i] != nums[i-1]) {
                int left = i + 1, right = nums.length;
                while(left < right-1) {
                    int key = -nums[i] - nums[left];
                    int index = Arrays.binarySearch(nums, left + 1, right, key);
                    if (index > left) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[index]));
                        right = index;
                    }
                    while(left < right -1 && nums[left] == nums[++left]);
                }
            }
        }
        return result;
    }
}
