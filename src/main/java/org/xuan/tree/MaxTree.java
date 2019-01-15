package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.Stack;

/**
 * Created by xzhou2 on 4/26/17.
 */
public class MaxTree {
    public TreeNode constructMaxTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        for(int n : nums) {
            TreeNode curr = new TreeNode(n);
            while(!stack.isEmpty() && stack.peek().val < n) {
                TreeNode small = stack.pop();
                if (!stack.isEmpty()  && stack.peek().val < n) {
                    stack.peek().right = small;
                } else {
                    curr.left = small;
                }
            }
            stack.push(curr);
        }
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (!stack.empty()) {
                stack.peek().right = curr;
            } else {
                return curr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node = new MaxTree().constructMaxTree(new int[]{2,5,10,4,7,1,8,6, 111});
        assert node != null;
    }


}
