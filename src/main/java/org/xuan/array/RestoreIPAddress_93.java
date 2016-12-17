package org.xuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 12/15/16.
 */
public class RestoreIPAddress_93 {
    private static final int LEN = 4;
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int[] cache = new int[LEN];
        dfs(s, 0,cache, 0, result);
        return result;
    }

    private void dfs(String s, int indexS, int[] cache, int indexC, List<String> result) {
        if (indexS == s.length() && indexC == LEN) {
            addResult(cache, result);
        } else {
            int curr = 0;
            for(int i = indexS; i < Math.min(s.length(), indexS + 3); i++) {

                curr = curr * 10 + s.charAt(i) - '0';
                int residueLen = s.length() - i;
                if (curr < 256 && residueLen >= (LEN - indexC) && residueLen <= (LEN - indexC) * 3) {
                    cache[indexC] = curr;
                    dfs(s, i + 1, cache, indexC + 1, result);
                }
                if (curr == 0) {
                    break;
                }
            }
        }
    }

    private void addResult(int[] cache, List<String> result) {
        StringBuilder sb = new StringBuilder();
        sb.append(cache[0]);
        for(int i = 1; i < cache.length; i++) {
            sb.append(".");
            sb.append(cache[i]);
        }
        result.add(sb.toString());
    }
}
