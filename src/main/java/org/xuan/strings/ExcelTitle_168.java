package org.xuan.strings;

/**
 * Created by xzhou2 on 12/28/16.
 */
public class ExcelTitle_168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        do {
            char c = (char)(--n % 26 + 'A');
            sb.append(c);
            n /= 26;
        } while(n > 0);
        return sb.reverse().toString();
    }
}
