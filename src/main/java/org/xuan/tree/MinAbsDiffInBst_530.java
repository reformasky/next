package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 3/9/17.
 */
public class MinAbsDiffInBst_530 {
    public int getMinimumDifference(TreeNode root) {
        return getMinMax(root)[2];
    }

    private int[] getMinMax(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[]{root.val,root.val, Integer.MAX_VALUE};
        } else if (root.left == null) {
            int[] right = getMinMax(root.right);
            return new int[]{root.val, right[1], Math.min(right[0] - root.val,right[2])};
        } else if (root.right == null) {
            int[] left = getMinMax(root.left);
            return new int[]{left[0], root.val, Math.min(left[2], root.val - left[1])};
        } else {
            int[] left = getMinMax(root.left);
            int[] right = getMinMax(root.right);
            return new int[]{left[0], right[1], getMin(new int[]{left[2], root.val - left[1], right[0] - root.val, right[2]})};
        }
    }

    private int getMin(int[] arr) {
        int res = Integer.MAX_VALUE;
        for(int i : arr) {
            res = Math.min(res, i);
        }
        return res;
    }

}
