package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 1/5/17.
 */
public class LowestCommonAncestorII_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) {
            return p;
        }
        return helper(root, p, q)[0];
    }

    private TreeNode[] helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        TreeNode[] left = helper(root.left, p, q);
        if (left[0] != null && left[1] != null) {
            return left;
        }
        TreeNode[] result = left;
        if (root == p) {
            result[0] = root;
        }
        if (root == q) {
            result[1] = root;
        }
        if(result[0] != null && result[1] != null) {
            return new TreeNode[]{root, root};
        }
        TreeNode[] right = helper(root.right, p, q);
        if (right[0] != null && right[1] != null) {
            return right;
        }
        result[0] = right[0] != null ? right[0] : result[0];
        result[1] = right[1] != null ? right[1] : result[1];
        if(result[0] != null && result[1] != null) {
            return new TreeNode[]{root, root};
        }
        return result;
    }
}
