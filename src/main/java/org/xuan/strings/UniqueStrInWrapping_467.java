package org.xuan.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 3/5/17.
 */
public class UniqueStrInWrapping_467 {
    public int findSubstringInWraproundString(String p) {
        int[] len = new int[26];
        if (p.length() == 0) {
            return 0;
        }
        int begin = 0;
        char pre = p.charAt(0);

        for(int i = 0; i < p.length(); i++) {
            char next = p.charAt(i);
            int index = next - 'a';
            if (!isNext(pre, next)) {
                len[index] = Math.max(len[index], 1);
                begin = i;
            } else {
                len[index] = Math.max(len[index], i - begin + 1);
            }
            pre = next;
        }
        return collectResult(len);
    }

    private boolean isNext(char p, char n) {
        return (p - 'a' + 1) % 26 == (n - 'a') % 26;
    }

    private int collectResult(int[] len) {
        int result = 0;
        for(int i : len) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "acdefdefg";
        UniqueStrInWrapping_467 u = new UniqueStrInWrapping_467();
        System.out.println(u.findSubstringInWraproundString(s));

    }
}
