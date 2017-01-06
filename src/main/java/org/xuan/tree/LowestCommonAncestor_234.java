package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 1/5/17.
 */
public class LowestCommonAncestor_234 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        long diff1 = root.val - p.val, diff2 = root.val - q.val;
        if (diff1 * diff2 <= 0) {
            return root;
        } else if (diff1 > 0) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
