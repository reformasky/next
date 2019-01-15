package org.xuan.others;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 3/2/17.
 */
public class LFUCache {
    Map<Integer, Node> map;
    int size, capacity;
    Node head, tail;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        int value = node.get(key);
        Node next = node.next.count == node.count + 1 ?
                node.next : new Node(node.count + 1);
        next.put(key, value);
        node.insertAfterSelf(next);
        node.removeKey(key);
        map.put(key, next);
        return value;
    }

    public void put(int key, int value) {
        if(capacity > 0) {
            Node node = map.get(key);
            Node next;
            if (node == null) {
                if (size == capacity) {
                    int recentKey = head.next.removeRecentKey();
                    map.remove(recentKey);
                } else {
                    size++;
                }
                next = head.next.count == 1 ? head.next : new Node(1);
                head.insertAfterSelf(next);
            }  else {
                next = node.next.count == node.count + 1 ?
                        node.next : new Node(node.count + 1);
                node.insertAfterSelf(next);
                node.removeKey(key);
            }
            next.put(key, value);
            map.put(key, next);
        }
    }

    class Node{
        int count;
        Map<Integer, Integer> keyToValue;
        Map<Integer, InnerNode> keyToNode;
        Node pre, next;
        InnerNode head, tail;
        public Node(int c) {
            keyToValue = new HashMap<>();
            keyToNode = new HashMap<>();
            count = c;
            head = new InnerNode(-1);
            tail = new InnerNode(-1);
            head.next = tail;
            tail.pre = head;
        }

        public Node insertAfterSelf(Node n) {
            if (next != n) {
                n.pre = this;
                n.next = next;
                next.pre = n;
                next = n;
            }
            return n;
        }

        public Node remove() {
            pre.next = next;
            next.pre = pre;
            return this;
        }

        public int get(int key) {
            return keyToValue.get(key);
        }

        public void put(int key, int value) {
            InnerNode innerNode = new InnerNode(key);
            tail.insertBefore(innerNode);
            keyToValue.put(key, value);
            keyToNode.put(key, innerNode);
        }

        public int removeKey(int key) {
            int value =  keyToValue.remove(key);
            InnerNode node = keyToNode.remove(key);
            node.remove();
            if (keyToValue.isEmpty()) {
                remove();
            }
            return value;
        }

        public int removeRecentKey() {
            int key = head.next.key;
            removeKey(key);
            return key;
        }

        class InnerNode{
            int key;
            InnerNode pre, next;

            InnerNode(int k){
                key = k;
            }

            InnerNode remove() {
                pre.next = next;
                next.pre = pre;
                return this;
            }

            InnerNode insertBefore(InnerNode preNode) {
                if (pre != preNode) {
                    preNode.pre = pre;
                    preNode.next = this;
                    pre.next = preNode;
                    pre = preNode;
                }
                return preNode;
            }

        }
    }
}