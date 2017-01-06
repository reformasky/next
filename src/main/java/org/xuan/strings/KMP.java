package org.xuan.strings;

/**
 * Created by xzhou2 on 1/3/17.
 */
public class KMP {
    public static int match(String text, String pattern) {
        int[] table = buildPattern(pattern);
        int index = text.charAt(0) == pattern.charAt(0) ? 1 : 0;
        for(int i = 1; i < text.length(); i++) {
            if (index == pattern.length()) {
                return i - index;
            }
            char c = text.charAt(i);
            if (c == pattern.charAt(index)) {
                index++;
            } else {

                while (index > 0 && c != table[index]) {
                    index = table[index - 1];
                }
                if (c == pattern.charAt(index)) {
                    index++;
                }
            }
        }

        return index == pattern.length() ? text.length() - pattern.length() : -1;
    }

    private static int[] buildPattern(String pattern) {
        int[] result = new int[pattern.length()];
        int index = 0;
        for(int i = 1; i < result.length; i++) {
            char c = pattern.charAt(i);
            if (c == pattern.charAt(index)) {
                result[i] = result[i - 1] + 1;
                index++;
            } else {
                index = result[i-1];
                while (index > 0 && c != pattern.charAt(index)) {
                    index = result[index - 1];
                }
                if (c == pattern.charAt(index)) {
                    index++;
                }
                result[i] = index;
            }
        }
        return result;
    }
}
