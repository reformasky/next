package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xzhou2 on 2/18/17.
 */
public class BottomLeftValue_513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int result = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            result = queue.peek().val;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
