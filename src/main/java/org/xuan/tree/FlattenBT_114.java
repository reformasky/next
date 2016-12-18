package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class FlattenBT_114 {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root);
    }

    private TreeNode[] helper(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new TreeNode[]{node, node};
        }  else if (node.left == null) {
            TreeNode[] right = helper(node.right);
            node.right = right[0];
            return new TreeNode[]{node, right[1]};
        } else if (node.right == null) {
            TreeNode[] left = helper(node.left);
            node.right = left[0];
            node.left = null;
            return new TreeNode[]{node, left[1]};
        } else {
            TreeNode[] left = helper(node.left),
                    right = helper(node.right);
            node.right = left[0];
            node.left = null;
            left[1].right = right[0];
            return new TreeNode[]{node, right[1]};
        }
    }
}
