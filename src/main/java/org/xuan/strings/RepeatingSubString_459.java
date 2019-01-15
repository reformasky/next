package org.xuan.strings;

/**
 * Created by xzhou2 on 3/2/17.
 */
public class RepeatingSubString_459 {
    public class Solution {
        public boolean repeatedSubstringPattern(String s) {
            int[] countAll = new int[26];
            int[] countFirst = new int[26];
            int len = s.length();
            for(int i = 0; i < len; i++) {
                countAll[s.charAt(i) - 'a']++;
            }
            for(int i = 0; i < len / 2; i ++) {
                countFirst[s.charAt(i) - 'a']++;
                if (len % (i + 1) == 0
                        && isCandidate(countAll, countFirst)
                        && isRepeating(s, i + 1)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isCandidate(int[] countAll, int[] countFirst) {
            int div = -1;
            for(int i = 0; i < 26; i++) {
                if (countAll[i] != 0) {
                    if (countFirst[i] == 0 || countAll[i] % countFirst[i] != 0) {
                        return false;
                    }
                    int tmp = countAll[i] / countFirst[i];
                    if (div < 0) {
                        div = tmp;
                    } else if (div != tmp) {
                        return false;
                    }
                }
            }

            return true;
        }

        private boolean isRepeating(String s, int len) {
            for(int i = len; i < s.length(); i+= len) {
                for(int j = 0; j < len; j++) {
                    if (s.charAt(j) != s.charAt(j + i)) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
