package org.xuan.strings;

/**
 * Created by xzhou2 on 12/28/16.
 */
public class CompareVersion_165 {
    public int compareVersion(String version1, String version2) {
        int b1 = 0, b2 = 0, e1 = 0, e2 = 0;
        version1 = version1 + '.';
        version2 = version2 + '.';
        while(e1 < version1.length() && e2 < version2.length()) {
            while(e1 < version1.length() && version1.charAt(e1) != '.') {
                e1++;
            }
            while(e2 < version2.length() && version2.charAt(e2) != '.') {
                e2++;
            }

            int v1 = Integer.parseInt(version1.substring(b1, e1)),
                    v2 = Integer.parseInt(version2.substring(b2, e2));
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
            b1 = ++e1;
            b2 = ++e2;

        }
        if (e1 >= version1.length() && e2 >= version2.length()) {
            return 0;
        }

        int value = 0;
        while(e1 < version1.length()) {
            char c = version1.charAt(e1++);
            if (c != '.' && c != '0') {
                return 1;
            }
        }

        while(e2 < version2.length()) {
            char c = version2.charAt(e2++);
            if (c != '.' && c != '0') {
                return -1;
            }
        }
        return 0;
    }
}
