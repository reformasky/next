package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.Stack;

/**
 * Created by xzhou2 on 1/5/17.
 */
public class KthSmallest_230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 1;
        TreeNode node = root;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        while(!stack.isEmpty()) {
            node = stack.pop();
            if (count++ == k) {
                return node.val;
            }
            if (node.right != null) {
                node = node.right;
                while(node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return -1;
    }
}
