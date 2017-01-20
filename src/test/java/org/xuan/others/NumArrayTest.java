package org.xuan.others;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by xzhou2 on 1/11/17.
 */
public class NumArrayTest {
    @Test
    public void test() {
        int[] nums = new int[]{0,1,2,3,4,5,6};
        NumArray numArray = new NumArray(nums);
        Random random = new Random();
        for(int i = 0; i < nums.length; i++) {
            for(int k = 0; k < 100; k++) {
                if (random.nextBoolean()) {
                    int index = random.nextInt(nums.length), val = random.nextInt(50) - 100 ;
                    nums[index] = val;
                    numArray.update(index, val);
                }
            }
            for(int j = i; j < nums.length; j++) {
                Assert.assertEquals(numArray.sumRange(i, j), getSum(nums, i, j));
            }

        }

    }

    private int getSum(int[] nums, int i, int j) {
        int res = 0;
        for(int index = i; index<=j; index++) {
            res += nums[index];
        }
        return res;
    }
}
