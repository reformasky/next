package org.xuan.linkedlist;

import org.xuan.util.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 12/21/16.
 */
public class CopyRandomList_138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        if (head == null) {
            return null;
        }
        RandomListNode ori = head.next, des, preD = new RandomListNode(head.label);
        map.put(head, preD);
        while(ori != null) {
            des = new RandomListNode(ori.label);
            map.put(ori, des);
            preD.next = des;
            preD = des;
            ori = ori.next;
        }

        ori = head;
        while(ori != null) {
            if (ori.random != null) {
                map.get(ori).random = map.get(ori.random);
            }
            ori = ori.next;
        }

        return map.get(head);
    }
}
