package org.xuan.others;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 2/27/17.
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node != null) {
            if (sb.length() != 0) {
                sb.append(",");
            }
            sb.append(node.val);
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] tokens = data.split(",");
        int[] preorder = new int[tokens.length];
        for(int i = 0; i < preorder.length; i++) {
            preorder[i] = Integer.parseInt(tokens[i]);
        }
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] arr, int low, int high) {
        if (low == high) {
            return new TreeNode(arr[low]);
        }
        if (low > high) {
            return null;
        }
        TreeNode root = new TreeNode(arr[low]);
        int index = getFirstLarger(arr, low + 1, high);
        root.left = helper(arr, low + 1, index - 1);
        root.right = helper(arr, index, high);
        return root;
    }

    private int getFirstLarger(int[] arr, int low, int high) {
        for(int i = low ; i <= high; i++) {
            if (arr[i] > arr[low - 1]) {
                return i;
            }
        }
        return high + 1;
    }
}
