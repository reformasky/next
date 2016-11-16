package org.xuan.array;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xuan.util.StringUtil;

/**
 * Created by xzhou2 on 11/9/16.
 */
public class TwoSum1Test {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        "1,2,3,1",2, "0,3"
                },
                {
                        "1,2,3,1",3, "0,1"
                }

        };
    }

    @Test(dataProvider = "data")
    public void test(String arr, int target, String output) {
        int[] nums = StringUtil.strToIntArr(arr);
        int[] res = new TwoSum_1().twoSum(nums, target);
        Assert.assertArrayEquals(res, StringUtil.strToIntArr(output));
    }
}
