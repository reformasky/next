package org.xuan.strings;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by xzhou2 on 1/13/17.
 */
public class RemoveDuplicate_316 {
    //acvxvzdvadcazcczdvcddxczva
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new LinkedList<>();
        boolean[] visited = new boolean[26], enqued = new boolean[26];
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!visited[c - 'a']) {
                if (!enqued[c - 'a']) {
                    while(!deque.isEmpty() && deque.peekLast() >= c) {
                        enqued[deque.removeLast() - 'a'] = false;;
                    }
                    deque.addLast(c);
                    enqued[c - 'a'] = true;
                }
                if (i == lastIndex[c - 'a']) {
                    while(!deque.isEmpty() && c >= deque.peekFirst()) {
                        char n = deque.removeFirst();
                        visited[n - 'a'] = true;
                        sb.append(n);
                    }
                }
            }
        }
        return sb.toString();
    }
}
