package org.xuan.array;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 2/23/17.
 */
public class ContinuousArray_525Test {
    @Test
    public void test() {
        int[] num = new int[]{0,0,0,1,1,0,1,1,0,1};
        ContinuousArray_525 continuousArray_525 = new ContinuousArray_525();
        Assert.assertEquals(continuousArray_525.findMaxLength(num), 10);
    }
}
