package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 12/16/16.
 */
public class BuildTreeInorderAndPostorder_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int low1, int high1, int[] postorder, int low2, int high2) {
        if (low1 > high1) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[high2]);
        int index = findIndex(inorder, low1, high1, root.val);
        root.left = helper(inorder, low1, index - 1, postorder, low2, index - 1 - low1 + low2);
        root.right = helper(inorder, index + 1, high1, postorder, index - low1 + low2, high2 - 1);

        return root;
    }


    private int findIndex(int[] inorder, int low, int high, int target) {
        for(int i = low; i <= high; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        throw new RuntimeException();
    }
}
