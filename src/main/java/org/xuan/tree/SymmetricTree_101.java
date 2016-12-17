package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 12/16/16.
 */
public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
