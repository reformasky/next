package org.xuan.linkedlist;

import org.xuan.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xzhou2 on 11/21/16.
 */
public class MergeKLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        for(int size = 2; size < lists.length * 2; size *= 2) {
            for(int i = 0; i < lists.length - size / 2 ; i += size) {
                mergeSort(lists, i, i + size / 2);
            }
        }
        return lists[0];
    }

    private void mergeSort(ListNode[] lists, int left, int right) {
        if (lists[left] == null) {
            lists[left] = lists[right];
        } else if (lists[right] != null) {
            ListNode pre = new ListNode(-1), curr = pre;
            ListNode first = lists[left], second = lists[right];
            while(first != null && second != null) {
                if (first.val <= second.val) {
                    curr.next = first;
                    first = first.next;
                } else {
                    curr.next = second;
                    second = second.next;
                }
                curr = curr.next;
            }
            if (second != null) {
                curr.next = second;
            }
            if (first != null) {
                curr.next = first;
            }
            lists[left] = pre.next;
        }
    }




    public ListNode mergeKLists_pq(ListNode[] lists) {
        ListNode result = new ListNode(-1), curr = result;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            curr.next = node;
            curr = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return result.next;
    }
}
