package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 1/17/17.
 */
public class WiggleSortII_324 {
   int len;
    public void wiggleSort(int[] nums) {
        len = nums.length;
        if (len == 0) {
            return;
        }
        int median = findKth(nums, len / 2);
        int low = 0, high = len - 1, index = 0;
        while (index < high) {
            int curr = nums[getIndex(index)];
            if (curr > median) {
                swap(nums, getIndex(index++), getIndex(low++));
            } else if (curr < median) {
                swap(nums, getIndex(index), getIndex(high--));
            } else {
                index++;
            }
        }
    }

    private int getIndex(int i) {
        return (2 * i + 1) % (len | 1);
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {return;}
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int findKth(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int left = low, right = high + 1;
            while(left < right) {
                while(left < high && nums[++left] < nums[low]);
                while(nums[--right] > nums[low]);
                if (left > right) {
                    break;
                }
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
            int tmp = nums[low];
            nums[low] = nums[right];
            nums[right] = tmp;
            if (k == right) {
                return nums[right];
            } else if (k > right) {
                low = right + 1;
            } else {
                high = right - 1;
            }
        }
        return nums[low];
    }
}
