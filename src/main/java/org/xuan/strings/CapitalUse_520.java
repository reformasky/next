package org.xuan.strings;

/**
 * Created by xzhou2 on 2/20/17.
 */
public class CapitalUse_520 {
    public boolean detectCapitalUse(String word) {
        boolean hasLowerCase = false;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (!hasLowerCase && i > 1) {
                    return false;
                }
                hasLowerCase = true;
            } else if (hasLowerCase) {
                return false;
            }
        }
        return true;
    }
}
