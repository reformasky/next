package org.xuan.others;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 3/30/17.
 */
public class BinaryIndexedTreeTest {
    @Test
    public void testInit() {
        int[] arr = {1,2,3,4,5};
        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree(arr);
        Assert.assertNotNull(binaryIndexedTree);

    }
}
