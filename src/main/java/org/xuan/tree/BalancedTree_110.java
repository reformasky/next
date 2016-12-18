package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class BalancedTree_110 {
    class Pair{
        boolean isBalanced;
        int h;

        public Pair(boolean isBalanced, int h) {
            this.isBalanced = isBalanced;
            this.h = h;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    private Pair helper(TreeNode node) {
        if (node == null) {
            return new Pair(true, 0);
        }
        Pair left = helper(node.left);
        if (left.isBalanced) {
            Pair right = helper(node.right);
            if (!right.isBalanced || Math.abs(left.h - right.h) > 1) {
                return new Pair(false, 0);
            } else {
                return new Pair(true, 1 + Math.max(left.h, right.h));
            }
        } else {
            return new Pair(false, 0);
        }
    }
}
