package org.xuan.array;

/**
 * Created by xzhou2 on 1/11/17.
 */
public class BullAndCow_299 {
    public String getHint(String secret, String guess) {
        int[] cache = new int[10];
        int as = 0, diffs = 0;
        for(int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i), g = guess.charAt(i);
            if (s == g) {
                as++;
            }
            cache[s - '0']++;
            cache[g - '0']--;
        }
        for(int i : cache) {
            diffs += (i >0) ? i :0;
        }
        int bs =  secret.length() - diffs - as;
        return as +"A"+bs+"B";
    }
}
