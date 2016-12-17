package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 12/15/16.
 */
public class InorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root, pre;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    result.add(curr.val);
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
    }


    public List<Integer> inorderTraversal_stack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            root = root.right;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        return result;
    }
}
