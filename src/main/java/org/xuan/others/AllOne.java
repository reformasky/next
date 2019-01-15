package org.xuan.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou2 on 2/22/17.
 */
public class AllOne {
    Map<String, Node> keyToNode;
    Node head, tail;

    /** Initialize your data structure here. */
    public AllOne() {
        keyToNode = new HashMap<>();
        head = new Node(0);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.pre = head;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Node curr;
        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.removeKey(key);
            if (node.next.count == node.count + 1) {
                curr = node.next;
            } else {
                curr = node.insertAfter(node.count + 1);
            }
            if (node.isEmpty()) {
                node.deleteNode();
            }
        } else {
            if (head.next.count == 1) {
                curr = head.next;
            } else {
               curr = head.insertAfter(1);
            }
        }
        curr.addKey(key);
        keyToNode.put(key, curr);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);

            node.removeKey(key);
            if (node.count == 1) {
                keyToNode.remove(key);
            } else  {
                Node curr;
                if (node.pre.count == node.count - 1) {
                    curr = node.pre;
                } else {
                    curr = node.pre.insertAfter(node.count - 1);
                }
                curr.addKey(key);
                keyToNode.put(key, curr);
            }
            if (node.isEmpty()) {
                node.deleteNode();
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail.pre.isEmpty()) {
            return "";
        }
        return tail.pre.set.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next.isEmpty()) {
            return "";
        }
        return head.next.set.iterator().next();
    }

    class Node{
        int count;
        Set<String> set;
        Node pre, next;


        public Node(int c) {
            count = c;
            set = new HashSet<>();
        }

        public void addKey(String key) {
            set.add(key);
        }

        public void removeKey(String key) {
            set.remove(key);
        }

        public boolean isEmpty() {
            return set.isEmpty();
        }

        public void deleteNode() {
            pre.next = next;
            next.pre = pre;
        }

        public Node insertAfter(int count) {
            Node newNode = new Node(count);
            newNode.pre = this;
            newNode.next = next;
            next.pre = newNode;
            next = newNode;
            return newNode;
        }
    }
}
