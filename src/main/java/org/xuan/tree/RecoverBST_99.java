package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 12/16/16.
 */
public class RecoverBST_99 {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null;
        TreeNode curr = root, pre = new TreeNode(Integer.MIN_VALUE);
        while(curr != null) {
            if (curr.left == null) {
                if (pre.val > curr.val) {
                    if (first == null) {
                        first = pre;
                        second = curr;
                    } else {
                        second = curr;
                        //break;
                    }
                }
                pre = curr;
                curr = curr.right;
            } else {
                TreeNode tmp = curr.left;
                while(tmp.right != null && tmp.right != curr) {
                    tmp = tmp.right;
                }
                if (tmp.right == null) {
                    tmp.right = curr;
                    curr = curr.left;

                } else {
                    tmp.right = null;
                    if (pre.val > curr.val) {
                        if (first == null) {
                            first = pre;
                            second = curr;
                        } else {
                            second = curr;
                            //break;
                        }
                    }
                    pre = curr;
                    curr = curr.right;
                }
            }
        }
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }
}
