package org.xuan.array;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 2/23/17.
 */
public class PartitionArrayIntoKGroupsTest {
    @Test
    public void test() {
        int[] nums = new int[]{-2, -1, -1, 1};
        PartitionArrayIntoKGroups p = new PartitionArrayIntoKGroups();
        Assert.assertEquals(p.canPartition(nums, 3), true);
    }
}
