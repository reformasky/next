package org.xuan.others;

import org.xuan.util.ListNode;

import java.util.Random;

/**
 * Created by xzhou2 on 1/29/17.
 */
public class ListNodeRandomNode_382 {
    ListNode head;
    Random random;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public ListNodeRandomNode_382(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int count = 0;
        int result = head.val;
        ListNode curr = head;
        while(curr != null) {
            if (random.nextInt(count+1) == count) {
                result = curr.val;
            }
            count++;
            curr = curr.next;
        }
        return result;
    }
}