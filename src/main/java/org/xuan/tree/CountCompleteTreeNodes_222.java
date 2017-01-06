package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 1/5/17.
 */
public class CountCompleteTreeNodes_222 {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int height = 0;
        TreeNode node = root.left;
        while(node != null) {
            height++;
            node = node.left;
        }
        return countNodes(root, height);
    }

    private int countNodes(TreeNode root, int height) {
        if (root == null) {
            return 0;
        }
        if (height == 0) {
            return 1;
        }
        int rightHeight = 0;
        TreeNode node = root.left;
        while(node != null) {
            rightHeight++;
            node = node.right;
        }
        if (rightHeight == height) {
            return (1 << height) + countNodes(root.right);
        } else {
            return (1 << rightHeight) + countNodes(root.left, height - 1);
        }
    }
}
