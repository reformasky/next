package org.xuan.array;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 12/13/16.
 */
public class LargestAreaHistogram_84Test {
    LargestAreaHistogram_84 obj = new LargestAreaHistogram_84();

    @Test
    public void test() {
        int[] height = new int[]{3, 1, 3, 2, 2        };
        Assert.assertEquals(obj.largestRectangleArea(height), 10);
     }

}
