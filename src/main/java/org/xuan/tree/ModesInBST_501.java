package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 3/12/17.
 */
public class ModesInBST_501 {
    private List<Integer> modes = new ArrayList<>();
    int maxCount = 0;
    int currValue = 0;
    int currCount = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        inorder(root);
        if (currCount > maxCount) {
            modes = new ArrayList<>();
            modes.add(currValue);
        } else if (currCount == maxCount) {
            modes.add(currValue);
        }
        int[] res = new int[modes.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = modes.get(i);
        }
        return res;
    }

    private void inorder(TreeNode node) {
        if (node.left != null) {
            inorder(node.left);
        }
        if (node.val == currValue) {
            currCount++;
        } else {
            if (currCount > maxCount) {
                modes = new ArrayList<>();
                modes.add(currValue);
                maxCount = currCount;
            } else if (currCount == maxCount) {
                modes.add(currValue);
            }
            currCount = 1;
            currValue = node.val;
        }
        if (node.right != null) {
            inorder(node.right);
        }
    }
}
