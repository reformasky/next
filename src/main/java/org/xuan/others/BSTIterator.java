package org.xuan.others;

import org.xuan.util.TreeNode;

import java.util.Stack;

/**
 * Created by xzhou2 on 12/28/16.
 */
public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop(), next = node.right;
        while(next != null) {
            stack.push(next);
            next = next.left;
        }
        return node.val;
    }
}