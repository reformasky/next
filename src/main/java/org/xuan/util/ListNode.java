package org.xuan.util;


import java.util.Objects;

/**
 * Created by xzhou2 on 11/9/16.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int v) {
        val = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return Objects.equals(val, listNode.val) &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
