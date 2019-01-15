package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 2/20/17.
 */
public class Canpartition_416 {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        Arrays.sort(nums);
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2 - nums[nums.length - 1];
        if (target < 0) {
            return false;
        } else if (target == 0) {
            return true;
        }
        boolean[] cache = new boolean[target + 1];
        for(int i = 0; i < nums.length - 1; i++) {
            boolean[] cp = Arrays.copyOf(cache, target + 1);
            for(int j = 0; j < target; j++) {
                int next = nums[i] + j;
                if (next > target) {
                    break;
                }
                if (cache[j]) {
                    cp[next] = true;
                }
            }
            cache = cp;
            if(nums[i] <= target) {
                cache[nums[i]] = true;

            }
            if (cache[target]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
int[] nums = new int[]{2,2,3,5} ;
        Canpartition_416 s = new Canpartition_416();
        boolean b = s.canPartition(nums);
        System.out.println(b);
    }
}