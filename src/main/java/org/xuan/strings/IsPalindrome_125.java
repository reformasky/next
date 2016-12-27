package org.xuan.strings;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class IsPalindrome_125 {
    public boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while(low < high) {
            char left = '0', right = '0';
            while(low <= high) {
                left = s.charAt(low++);
                if (isValid(left)) {
                    break;
                }
            }
            while(low - 1 <= high) {
                right = s.charAt(high--);
                if (isValid(right)) {
                    break;
                }
            }
            if (!isPair(left, right)) {
                return false;
            }
        }
        return true;
    }


    private boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') ||(c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    private boolean isPair(char c1, char c2) {
        return c1 == c2 || (c1 >= 'A' && c2 >= 'A' && (Math.abs(c1 - c2) == 0 || Math.abs(c1 - c2) == 'a' - 'A'));
    }
}
