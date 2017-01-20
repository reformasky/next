package org.xuan.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xzhou2 on 1/16/17.
 */
public class MaxProduct_318 {
    public int maxProduct(String[] words) {
        int result = 0;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                return j.length() - i.length();
            }
        });
        int[] cache = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            String str = words[i];
            int curr = 0;
            for(int j = 0; j < str.length(); j++) {
                curr |= 1 << (str.charAt(j) - 'a');
            }
            cache[i] = curr;
        }
        for(int i = 0; i < words.length - 1; i++) {
            for(int j = i + 1; j < words.length; j++) {
                int prod = words[i].length() * words[j].length();
                if (prod <= result) {
                    break;
                }
                if ((cache[i] & cache[j]) == 0) {
                    result = prod;
                    break;
                }
            }
        }
        return result;
    }
}
