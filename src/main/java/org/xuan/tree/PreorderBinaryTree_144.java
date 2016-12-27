package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 12/20/16.
 */
public class PreorderBinaryTree_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode pre;
        while(root != null) {
            if (root.left == null) {
                result.add(root.val);
                root = root.right;
            } else {
                pre = root.left;
                while(pre.right != null && pre.right != root) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    result.add(root.val);
                    pre.right = root;

                    root = root.left;
                } else {
                    pre.right = null;
                    root = root.right;
                }
            }
        }
        return result;
    }



    public List<Integer> preorderTraversal_stack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
