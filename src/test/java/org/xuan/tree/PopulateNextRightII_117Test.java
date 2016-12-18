package org.xuan.tree;

import junit.framework.Assert;
import org.testng.annotations.Test;
import org.xuan.util.TreeLinkNode;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class PopulateNextRightII_117Test {
    PopulateNextRightII_117 p = new PopulateNextRightII_117();
    @Test
    public void test() {
        TreeLinkNode node1, node2, node3, node4, node5;
        node1 = new TreeLinkNode(1);
        node2 = new TreeLinkNode(2);
        node3 = new TreeLinkNode(3);
        node4 = new TreeLinkNode(4);
        node5 = new TreeLinkNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        p.connect(node1);
        Assert.assertNotNull(node1);
    }

}
