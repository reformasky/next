package org.xuan.array;

/**
 * Created by xzhou2 on 12/11/16.
 */
public class SortColors_75 {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;
        for(int i = zero; i <= two; i++) {
            while(nums[i] == 2 && i <= two) {
                swap(nums, i, two--);
            }
            while(nums[i] == 0 && i >= zero) {
                swap(nums, i, zero++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
