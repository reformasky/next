package org.xuan.tree;

import org.xuan.util.TreeLinkNode;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class PopulateNextRightII_117 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode tmp, pre;
        while (root != null) {
            tmp = null;
            pre = null;
            while(root!= null) {
                TreeLinkNode curr = root.left;
                if (curr != null) {
                    if (pre != null) {
                        pre.next = curr;
                    }
                    pre = curr;
                }
                tmp = tmp == null ? pre : tmp;
                curr = root.right;
                if (curr != null) {
                    if (pre != null) {
                        pre.next = curr;
                    }
                    pre = curr;
                }
                root = root.next;
                tmp = tmp == null ? pre : tmp;
            }
            root = tmp;
        }
    }
}
