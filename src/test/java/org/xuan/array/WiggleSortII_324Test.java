package org.xuan.array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by xzhou2 on 1/17/17.
 */
public class WiggleSortII_324Test {
    WiggleSortII_324 w = new WiggleSortII_324();
    Random random = new Random();
    @Test
    public void findKthTest() {
        int len = 1000;
        int[] nums = new int[len];
        for(int i = 0; i < len; i++) {
            nums[i] = random.nextInt(len);
        }

        for(int i = 0; i < len; i++) {
            int[] copy = Arrays.copyOf(nums, len);
            int res = w.findKth(copy, i);
            Arrays.sort(copy);
            Assert.assertEquals(res, copy[i]);
        }
    }


}
