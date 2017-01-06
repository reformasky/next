package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 1/5/17.
 */
public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head.next, tmp;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println(slow.val);
        tmp = fast = reverse(slow.next);

        boolean result;
        while (fast != null) {
            if (fast.val != head.val) {
                break;
            }
            fast = fast.next;
            head = head.next;
        }
        result = fast == null;
        slow.next = reverse(tmp);
        return result;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, curr = head, next;
        while (curr.next != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        curr.next = pre;
        return curr;

    }
}