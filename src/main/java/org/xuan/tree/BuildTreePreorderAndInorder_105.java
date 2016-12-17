package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 12/16/16.
 */
public class BuildTreePreorderAndInorder_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int low1, int high1, int[] inorder, int low2, int high2) {
        if(low1 > high1) {
            return null;
        }
        if (low1 == high1) {
            return new TreeNode(preorder[low1]);
        }

        int index = findIndex(inorder, low2, high2, preorder[low1]);
        TreeNode root = new TreeNode(preorder[low1]);
        root.left = helper(preorder, low1 + 1,  index - low2 + low1, inorder, low2, index - 1);
        root.right = helper(preorder, index - low2 + low1 + 1, high1, inorder, index + 1, high2);
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
