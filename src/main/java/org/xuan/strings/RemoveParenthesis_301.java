package org.xuan.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xzhou2 on 1/11/17.
 */
public class RemoveParenthesis_301 {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        dfs(s, 0, left, right, 0, new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    private void dfs(String s, int index, int left, int right, int open, StringBuilder sb, Set<String> result) {
        if (index == s.length()) {
            if (left == 0 && right == 0) {
                assert open == 0;
                result.add(sb.toString());
            }
        } else if (left >= 0 && right >= 0 && open >= 0){
            char c = s.charAt(index);
            if (c == '(') {
                sb.append(c);
                dfs(s, index + 1, left, right, open + 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
                dfs(s, index + 1, left - 1, right, open, sb, result);
            } else if (c == ')') {
                sb.append(c);
                dfs(s, index + 1, left, right, open - 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
                dfs(s, index + 1, left, right - 1, open, sb, result);
            } else {
                sb.append(c);
                dfs(s, index + 1, left, right, open, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
