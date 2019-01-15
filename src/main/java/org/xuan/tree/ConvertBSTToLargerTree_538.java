package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 3/23/17.
 */
public class ConvertBSTToLargerTree_538 {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        helper(root, 0);
        return root;
    }

    private int helper(TreeNode root, int acc) {
        if (root.right != null) {
            acc = helper(root.right, acc);
        }
        acc += root.val;
        root.val = acc;
        if (root.left != null) {
            acc = helper(root.left, acc);
        }
        return acc;
    }
}
