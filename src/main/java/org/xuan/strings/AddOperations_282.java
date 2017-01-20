package org.xuan.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 1/10/17.
 */
public class AddOperations_282 {
    public List<String> addOperators(String num,int target) {
        List<String> result = new ArrayList<>();
        if (num.length() == 0) {
            return result;
        }
        dfs(num, 0, target, new StringBuilder(), 0l, 1, 1l, result);
        return result;
    }

    private void dfs(String num, int index, long target, StringBuilder sb, long curr, int sign, long left, List<String> result) {
        char c = num.charAt(index);
        curr = curr * 10 + c - '0';
        if (index == num.length() - 1) {
            if (target == sign * left * curr) {
                sb.append(num.charAt(index));
                result.add(sb.toString());
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            sb.append(c);
            sb.append("*");
            dfs(num, index + 1, target,sb, 0, sign, curr * left, result);
            sb.deleteCharAt(sb.length() - 1);
            sb.append("+");
            dfs(num, index + 1, target - sign * left * curr,sb, 0, 1, 1, result);
            sb.deleteCharAt(sb.length() - 1);
            sb.append("-");
            dfs(num, index + 1, target - sign * left * curr, sb,0, -1, 1, result);
            sb.deleteCharAt(sb.length() - 1);
            if (sb.length() == 0 || curr != 0 || sb.charAt(sb.length() - 1) != '0') {
                dfs(num, index + 1, target, sb, curr, sign, left, result);
            }
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
