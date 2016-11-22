package org.xuan.array;

/**
 * Created by xzhou2 on 11/21/16.
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int index = -1;
        for(int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    public int removeElement_2pointer(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            if (nums[left] == val) {
                while(right > left && nums[right] == val) {
                    right--;
                }
                if (right > left) {
                    nums[left] = nums[right--];
                } else {
                    break;
                }
            }
            left++;
        }
        return left;

    }
}
