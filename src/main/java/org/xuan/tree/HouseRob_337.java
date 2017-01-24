package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 1/20/17.
 */
public class HouseRob_337 {
    public int rob(TreeNode root) {
        int[] cache = helper(root);
        return Math.max(cache[0], cache[1]);
    }

    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{0,0};
        }
        int[] res = new int[2], left = helper(node.left), right = helper(node.right);
        res[1] = left[0] + right[0];
        res[0] = Math.max(node.val + left[1] + right[1], res[1]);
        return res;
    }
}
