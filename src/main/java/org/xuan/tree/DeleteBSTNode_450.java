package org.xuan.tree;

import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 2/19/17.
 */
public class DeleteBSTNode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            TreeNode curr = root.right, tmp = root.right;
            if (curr == null) {
                return root.left;
            }
            while(curr.left != null) {
                tmp = curr;
                curr = curr.left;
            }
            tmp.left = curr.right;
            curr.left = root.left;
            curr.right = curr == root.right ? curr.right : root.right;
            return curr;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}
