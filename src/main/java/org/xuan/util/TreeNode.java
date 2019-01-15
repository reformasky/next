package org.xuan.util;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xzhou2 on 12/15/16.
 */
public class TreeNode {
    public TreeNode left, right;
    public int val;
    public TreeNode(Integer v) {
        if (v != null) {
            this.val = v;
        }
    }

    public static TreeNode fromInt(Integer v) {
        return v == null ? null : new TreeNode(v);
    }

    public static TreeNode fromList(Integer[] list) {
        TreeNode root = fromInt(list[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for(int index = 1; index < list.length; index += 2) {
            TreeNode parent = null;
            while (parent == null) {
                parent = queue.poll();
            }

            if (index < list.length) {
                parent.left = fromInt(list[index]);
                queue.offer(parent.left);
            }
            if (index + 1 < list.length) {
                parent.right = fromInt(list[index + 1]);
                queue.offer(parent.right);
            }
        }

        return root;
    }
}
