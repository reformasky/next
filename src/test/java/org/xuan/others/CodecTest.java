package org.xuan.others;

import junit.framework.Assert;
import org.testng.annotations.Test;
import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 2/27/17.
 */
public class CodecTest {

    @Test
    public void test() {
        String s = "5,3,2,4,6";
        TreeNode res = new Codec().deserialize(s);
        Assert.assertNotNull(res);
    }
}
