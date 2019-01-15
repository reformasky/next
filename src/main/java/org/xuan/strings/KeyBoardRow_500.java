package org.xuan.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 3/9/17.
 */
public class KeyBoardRow_500 {
    public String[] findWords(String[] words) {
        int[] rows = new int[26];
        String[] keys = {"qwertyuiop","asdfghjkl","zxcvbnm"};
        for(int i = 0; i < keys.length; i++) {
            for(char c : keys[i].toCharArray()) {
                rows[c - 'a'] = i;
            }
        }
        List<String> result = new ArrayList<>();
        for(String w : words) {
            if (w.length() == 0) {
                result.add(w);
                continue;
            }
            int row = rows[getIndex(w.charAt(0))];
            boolean valid = true;
            for(int i = 1; i < w.length(); i++) {
                int index = getIndex(w.charAt(i));
                if (row != rows[index]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result.add(w);
            }
        }
        String[] arr = new String[result.size()];
        return result.toArray(arr);
    }

    private int getIndex(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else {
            return c - 'A';
        }

    }
}
