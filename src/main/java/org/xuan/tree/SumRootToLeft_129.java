package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class SumRootToLeft_129 {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        if (root != null) {
            dfs(root, 0);
        }
        return result;
    }

    private void dfs(TreeNode node, int sum) {
        int next = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            result += next;
        } else if (node.left == null){
            dfs(node.right, next);
        } else if (node.right == null) {
            dfs(node.left, next);
        } else{
            dfs(node.left, next);
            dfs(node.right, next);
        }
    }
}
