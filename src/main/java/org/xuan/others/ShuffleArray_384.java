package org.xuan.others;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by xzhou2 on 1/29/17.
 */
public class ShuffleArray_384 {
    int[] nums;
    Random random;
    public ShuffleArray_384(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] copy = Arrays.copyOf(nums, nums.length);
        for(int i = 0; i < copy.length; i++) {
            int index = random.nextInt(i + 1);
            swap(copy, i, index);
        }
        return copy;
    }

    private void swap(int[] copy, int i, int j) {
        int tmp = copy[i];
        copy[i] = copy[j];
        copy[j] = tmp;
    }
}