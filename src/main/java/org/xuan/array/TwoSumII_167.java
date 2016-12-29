package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 12/28/16.
 */
public class TwoSumII_167 {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++) {
            int index = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            if (index > i) {
                return new int[]{i + 1, index + 1};
            }
        }
        throw new RuntimeException();
    }
}
