package org.xuan.linkedlist;

import org.xuan.util.ListNode;

/**
 * Created by xzhou2 on 12/27/16.
 */
public class GetIntersectionNode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int length1 = 1, length2 = 1;
        ListNode currA = headA, currB = headB;
        while(currA.next != null) {
            currA = currA.next;
            length1++;
        }
        while(currB.next != null) {
            currB = currB.next;
            length2++;
        }

        if (currA != currB) {
            return null;
        }
        int step;
        if (length1 >= length2) {
            currA = headA;
            currB = headB;
            step = length1 - length2;
        } else {
            currA = headB;
            currB = headA;
            step = length2 - length1;
        }
        while(step-- > 0) {
            currA = currA.next;
        }
        while(currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;

    }
}
