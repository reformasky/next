package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhou2 on 11/17/16.
 */
public class LetterCombination_17 {
    List<Character>[] map = (List<Character>[])new List[8];

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0 || digits.indexOf('0') >= 0 || digits.indexOf('1') >= 0) {
            return result;
        }
        initialize();
        char[] arr = new char[digits.length()];
        dfs(digits, 0, arr, result);
        return result;
    }

    private void dfs(String digits, int index, char[] arr, List<String> result) {
        if (index == digits.length()) {
            result.add(new String(arr));
        } else {
            int num = digits.charAt(index) - '0';
            for(char c : map[num-2]) {
                arr[index] = c;
                dfs(digits, index + 1, arr, result);
            }
        }
    }

    private void initialize() {
        char c = 'a';
        for(int i = 0; i < 8; i++) {
            if (i == 5 || i == 7) {
                map[i] = Arrays.asList((char)(c++), (char)(c++), (char)(c++), (char)(c++));
            } else {
                map[i] = Arrays.asList((char)(c++), (char)(c++), (char)(c++));
            }
        }
    }
}
