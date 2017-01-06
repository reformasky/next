package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 1/3/17.
 */
public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }
}
