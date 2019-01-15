package org.xuan.strings;

/**
 * Created by xzhou2 on 2/21/17.
 */
public class EnglishToNumber_423 {
    static char[] key = new char[]{'z','w', 'x', 'g', 's', 'v', 'f', 'r', 'i', 'o'};
    static int[] val = new int[]{0,2,6,8,7,5,4,3,9,1};
    static String[] rep = new String[]{"zero", "two", "six", "eight", "seven", "five", "four", "three", "nine", "one"};
    public String originalDigits(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int[] result = new int[10];
        for(int i = 0; i < key.length; i++) {
            int repeat = count[key[i] - 'a'];
            result[val[i]] += repeat;
            remove(count, repeat, rep[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < result[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    private void remove(int[] count, int repeat, String rep) {
        for(int i = 0; i < rep.length(); i++) {
            char c = rep.charAt(i);
            count[c - 'a'] -= repeat;
        }
    }
}
