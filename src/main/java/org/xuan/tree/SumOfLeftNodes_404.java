package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xzhou2 on 2/17/17.
 */
public class SumOfLeftNodes_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        Queue<Object[]> queue = new ArrayDeque<Object[]>();
        if (root != null) {
            queue.offer(new Object[]{root, false});
        }
        while(!queue.isEmpty()) {

            Object[] objs = queue.poll();
            TreeNode node = (TreeNode)objs[0];
            Boolean left = (Boolean)objs[1];
            if (node.left != null) {
                queue.offer(new Object[] {node.left, true});
            }
            if (node.right != null) {
                queue.offer(new Object[]{node.right, false});
            }
            if (left && node.left == null && node.right == null) {
                result += node.val;
            }
        }
        return result;
    }



}
