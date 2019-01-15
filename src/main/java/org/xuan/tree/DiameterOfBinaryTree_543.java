package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 3/23/17.
 */
public class DiameterOfBinaryTree_543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = helper(root);
        return res[0];
    }

    private int[] helper(TreeNode node) {
        int dia = 0, pathLen = 0;
        if (node.left != null && node.right != null) {
            int[] left = helper(node.left),
                    right = helper(node.right);
            dia = max(2 + left[1] + right[1], left[0], right[0]);
            pathLen = 1 + max(left[1], right[1]);
        } else if (node.right != null) {
            int[] right = helper(node.right);
            dia = max(1 + right[1], right[0]);
            pathLen = 1 + right[1];
            return new int[]{dia, pathLen};
        } else if (node.left != null) {
            int[] left = helper(node.left);
            dia = max(1 + left[1], left[0]);
            pathLen = 1 + left[1];
        }
        return new int[]{dia, pathLen};
    }

    private int max(int ... args) {
        int res = 0;
        for(int a : args) {
            res = Math.max(res, a);
        }

        return res;
    }
}
