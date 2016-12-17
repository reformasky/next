package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 12/16/16.
 */
public class ZigzagLevelTranversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>(),
                stack2 = new Stack<>(),
                tmp;
        boolean left = true;
        if (root != null) {
            stack1.push(root);
        }
        while(!stack1.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            while(!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                curr.add(node.val);
                if (left) {
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                }


            }
            left = !left;
            result.add(curr);
            tmp = stack1;
            stack1 = stack2;
            stack2 = tmp;
        }
        return result;
    }
}
