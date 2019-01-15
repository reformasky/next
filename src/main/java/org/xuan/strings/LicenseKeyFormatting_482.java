package org.xuan.strings;

/**
 * Created by xzhou2 on 3/7/17.
 */
public class LicenseKeyFormatting_482 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c != '-') {
                if (c >= 'a' && c <= 'z') {
                    c = (char)(c + 'A' - 'a');
                }
                sb.append(c);
                if (++count == K) {
                    sb.append('-');
                    count = 0;
                }
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
