package org.xuan.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xzhou2 on 1/18/17.
 */
public class IsValidSerialization_331 {
    public boolean isValidSerialization(String preorder) {
        String[] tokens = preorder.split(",");
        if (tokens.length == 0) {
            return false;
        } else if (tokens.length == 1) {
            return tokens[0].equals("#");
        }
        Queue<String> queue = new ArrayDeque<>();
        for(String t : tokens) {
            queue.offer(t);
        }
        if (dfs(queue) && queue.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean dfs(Queue<String> queue) {
        if (queue.size() == 0) {
            return false;
        } else if(queue.size() == 1) {
            return queue.poll().equals("#");
        } else {
            String t = queue.poll();
            if (t.equals("#")) {
                return true;
            } else {
                return dfs(queue) && dfs(queue);
            }
        }
    }
}
