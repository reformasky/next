package org.xuan.strings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by xzhou2 on 12/8/16.
 */
public class SimplyPath_71 {
    public String simplifyPath(String path) {
        path = path + "/";
        StringBuilder sb = new StringBuilder(), curr = new StringBuilder();
        sb.append("/");
        Deque<String> tokens = new ArrayDeque<>();

        for(int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if(c == '/') {
                if (curr.toString().equals("..")) {
                    if (!tokens.isEmpty()) {
                        tokens.removeLast();
                    }
                } else if (! curr.toString().equals(".") && curr.length() > 0) {
                    tokens.addLast(curr.toString());
                }
                curr = new StringBuilder();
            } else {
                curr.append(c);
            }
        }

        while(!tokens.isEmpty()) {
            sb.append(tokens.pollFirst());
            if (tokens.size() > 0) {
                sb.append("/");
            }
        }
        return sb.toString();

    }
}
