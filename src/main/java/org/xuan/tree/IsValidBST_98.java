package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 12/16/16.
 */
public class IsValidBST_98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE - 1l, Integer.MAX_VALUE + 1l);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
