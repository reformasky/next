package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 12/16/16.
 */
public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
