package org.xuan.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 11/20/16.
 */
public class GenerateParanthesis_22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        char[] c = new char[2 * n];
        dfs(c, 0, 0, 0, result);
        return result;
    }

    private void dfs(char[] c, int index, int left, int right, List<String> result) {
        if (index == c.length) {
            result.add(new String(c));
        } else {
            if (left < c.length / 2) {
                c[index] = '(';
                dfs(c, index + 1, left + 1, right, result);
            }
            if (right < left) {
                c[index] = ')';
                dfs(c, index + 1, left, right + 1, result);
            }
        }
    }
}
