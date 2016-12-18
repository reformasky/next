package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class BTMaxPathSum_124 {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        int left = 0, right = 0;
        if (node.left != null && node.right != null) {
            int tmpLeft = dfs(node.left), tmpRight = dfs(node.right);
            left = tmpLeft > 0 ? tmpLeft : 0;
            right = tmpRight > 0 ? tmpRight : 0;
        } else if (node.left != null) {
            int tmpLeft = dfs(node.left);
            left = tmpLeft > 0 ? tmpLeft : 0;
        } else if (node.right != null) {
            int tmpRight = dfs(node.right);
            right = tmpRight > 0 ? tmpRight : 0;
        }
        max = Math.max(node.val + left + right, max);
        return node.val + Math.max(left, right);
    }
}
