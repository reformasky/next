package org.xuan.array;

import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 1/1/17.
 */
public class MatchToSquare_473Test {
    @Test
    public void test() {
        int[] nums = new int[]{2,2,2,3,4,4,4,5,6};
        MatchToSquare_473 m = new MatchToSquare_473();
        boolean res = m.makesquare(nums);
        Assert.assertTrue(res);
    }
}
