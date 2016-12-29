package org.xuan.strings;

/**
 * Created by xzhou2 on 12/28/16.
 */
public class ExcelTimeII_171 {
    public class Solution {
        public int titleToNumber(String s) {
            int result = 0;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                result = 26 * result + c - 'A' + 1;
            }
            return result;
        }
    }
}
