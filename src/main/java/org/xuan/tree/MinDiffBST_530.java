package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 3/26/17.
 */
public class MinDiffBST_530 {
    int diff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return diff;
    }

    private int[] helper(TreeNode root) {
        int min, max;
        if (root.left == null && root.right == null) {
            min = root.val;
            max = root.val;
        } else if (root.left == null) {
            int[] right = helper(root.right);
            diff = Math.min(right[0] - root.val, diff);
            min = root.val;
            max = right[1];
        } else if (root.right == null) {
            int[] left = helper(root.left);
            diff = Math.min(root.val - left[1], diff);
            min = left[0];
            max = root.val;
        } else {
            int[] left = helper(root.left), right = helper(root.right);
            diff = Math.min(diff, Math.min(root.val - left[1], right[0] - root.val));
            min = left[0];
            max = right[1];
        }
        return new int[]{min, max};
    }
}
