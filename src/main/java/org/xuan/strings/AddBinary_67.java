package org.xuan.strings;

/**
 * Created by xzhou2 on 12/7/16.
 */
public class AddBinary_67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(Math.max(a.length(), b.length()));
        int carryOver = 0, indexA = a.length() - 1, indexB = b.length() - 1;
        while(indexA >= 0 && indexB >= 0) {
            int curr = carryOver + a.charAt(indexA--) - '0' + b.charAt(indexB--) - '0';
            sb.append(curr % 2);
            carryOver = curr / 2;
        }
        if (indexB >= 0) {
            a = b;
            indexA = indexB;
        }
        while(indexA >= 0) {
            int curr = carryOver + a.charAt(indexA--) - '0';
            sb.append(curr % 2);
            carryOver = curr / 2;
        }
        if (sb.length() == 0 || carryOver != 0) {
            sb.append(carryOver);
        }
        return sb.reverse().toString();
    }
}
