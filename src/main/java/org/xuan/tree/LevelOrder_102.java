package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xzhou2 on 12/16/16.
 */
public class LevelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offer(root);
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curr = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                curr.add(tmp.val);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }

            result.add(curr);
        }
        return result;
    }
}
