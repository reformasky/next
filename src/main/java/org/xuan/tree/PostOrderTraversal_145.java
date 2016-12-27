package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 12/26/16.
 */
public class PostOrderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode pre = new TreeNode(-1);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            TreeNode left = curr.left, right = curr.right;
            if (left == null && right == null) {
                stack.pop();
                result.add(curr.val);
                pre = curr;
            } else if (left == null) {
                if (pre == right) {
                    stack.pop();
                    result.add(curr.val);
                    pre = curr;
                } else {
                    stack.push(right);
                }
            } else if (right == null) {
                if (pre == left) {
                    stack.pop();
                    result.add(curr.val);
                    pre = curr;
                } else {
                    stack.push(left);
                }
            } else {
                if (pre == left) {
                    stack.push(right);
                } else if (pre == right) {
                    stack.pop();
                    result.add(curr.val);
                    pre = curr;
                } else {
                    stack.push(left);
                }
            }
        }
        return result;
    }
}
