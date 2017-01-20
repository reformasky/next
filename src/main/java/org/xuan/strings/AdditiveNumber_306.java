package org.xuan.strings;

/**
 * Created by xzhou2 on 1/11/17.
 */
public class AdditiveNumber_306 {
    public boolean isAdditiveNumber(String num) {
        for(int i = 0; i < num.length(); i++) {
            for(int j = i + 1; Math.max(i + 1, j - i) <= num.length() - j - 1;j++) {
                if (helper(num, 0, i, i + 1, j)) {
                    return true;
                }
                if (num.charAt(i + 1) == '0') {
                    break;
                }
            }
            if (num.charAt(0) == '0') {
                break;
            }
        }
        return false;
    }

    private boolean helper(String num, int b1, int e1, int b2, int e2) {
        String sum = add(num, b1, e1, b2, e2);
        int len = sum.length();
        if (num.length() < e2 + len + 1 || !sum.equals(num.substring(e2 + 1, e2 + 1 + len))) {
            return false;
        }
        if (e2 + len + 1 == num.length()) {
            return true;
        }
        return helper(num, b2, e2, e2 + 1, e2 + len);
    }

    private String add(String num, int b1, int e1, int b2, int e2) {
        StringBuilder sb = new StringBuilder();
        int carryOver = 0;
        int index1 = e1, index2 = e2;
        while(index1 >= b1 && index2 >= b2) {
            carryOver += num.charAt(index1--) - '0' + num.charAt(index2--) - '0';
            sb.append(carryOver % 10);
            carryOver /= 10;
        }
        if (index1 < b1) {
            index1 = index2;
            b1 = b2;
        }
        while(index1 >= b1) {
            carryOver += num.charAt(index1--) - '0';
            sb.append(carryOver % 10);
            carryOver /= 10;
        }
        if (carryOver != 0 || sb.length() == 0) {
            sb.append(carryOver);
        }
        return sb.reverse().toString();
    }
}
