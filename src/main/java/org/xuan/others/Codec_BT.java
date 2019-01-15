package org.xuan.others;

import org.xuan.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by xzhou2 on 1/10/17.
 */

public class Codec_BT {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            throw new RuntimeException();
        }
        String str = queue.poll();
        if ("#".equals(str)) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(str));
            root.left = deserialize(queue);
            root.right = deserialize(queue);
            return root;
        }
    }
}

