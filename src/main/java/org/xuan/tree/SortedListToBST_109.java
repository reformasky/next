package org.xuan.tree;

import org.xuan.util.ListNode;
import org.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class SortedListToBST_109 {
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode tmp = head;
        while(tmp != null) {
            len++;
            tmp = tmp.next;
        }
        this.head = head;
        return helper(len);
    }

    private TreeNode helper(int len) {
        if (len == 0) {
            return null;
        }
        TreeNode left = helper(len / 2);

        TreeNode root = new TreeNode(head.val);
        head = head.next;

        TreeNode right =  helper(len - 1 - len / 2);
        root.left = left;
        root.right = right;
        return root;
    }
}
