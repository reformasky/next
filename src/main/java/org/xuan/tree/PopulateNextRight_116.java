package org.xuan.tree;

import org.xuan.util.TreeLinkNode;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class PopulateNextRight_116 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode tmp;
        if (root != null)
            while(root.left != null) {
                tmp = root.left;
                while(root.next != null) {
                    root.left.next = root.right;
                    root.right.next = root.next.left;
                    root = root.next;
                }
                root.left.next = root.right;
                root = tmp;
            }
    }
}
