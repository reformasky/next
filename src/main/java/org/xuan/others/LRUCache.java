package org.xuan.others;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 12/26/16.
 */
public class LRUCache {
    Map<Integer, ListNode> map;
    int size, capacity;
    ListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        ListNode curr = map.get(key);
        if (curr == null) {
            return -1;
        } else {
            if(curr != tail.pre) {
                addLast(remove(curr));
            }
            return curr.val;
        }
    }

    public void set(int key, int value) {
        ListNode curr = map.get(key);
        if (curr != null) {
            curr.val = value;
            if (curr != tail.pre) {
                addLast(remove(curr));
            }
        } else {
            curr = new ListNode(key, value);
            if (size < capacity) {
                size++;
            } else {
                ListNode rm = head.next;
                map.remove(rm.key);
                remove(rm);
            }
            addLast(curr);
            map.put(key, curr);
        }
    }

    private ListNode remove(ListNode curr) {
        ListNode pre = curr.pre, next = curr.next;
        pre.next = next;
        next.pre = pre;
        return curr;
    }

    private void addLast(ListNode node) {
        ListNode last = tail.pre;
        last.next = node;
        node.next = tail;
        tail.pre = node;
        node.pre = last;
    }

    class ListNode{
        int key;
        int val;

        ListNode pre, next;

        public ListNode(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
}