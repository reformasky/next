package org.xuan.array;

/**
 * Created by xzhou2 on 12/29/16.
 */
public class RotateArray_189 {
    public void rotate_inPlace(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1 || k == 0) {
            return;
        }
        k %= len;
        int gcd = gcd(len, k);
        for(int i = 0; i < gcd; i++) {
            int index = i, value = nums[i], next;
            while((next = (index + k) % len) != i) {
                int tmp = nums[next];
                nums[next] = value;
                value = tmp;
                index = next;
            }
            nums[i] = value;
        }
    }

    private int gcd(int a, int b) {
        while(b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public void rotate_copy(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1 || k == 0) {
            return;
        }
        k %= len;
        int[] tmp = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            tmp[i] = nums[len - k + i];
        }

        for(int i = 1; i <= len - k ; i++) {
            nums[len -  i] = nums[len - i - k];
        }

        for(int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }

    }

    public void rotate_reverse(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1 || k == 0) {
            return;
        }
        k %= len;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int low, int high) {
        while(low < high) {
            int tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
            low++;
            high--;
        }
    }
}
