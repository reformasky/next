package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 12/16/16.
 */
public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
