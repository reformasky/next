package org.xuan.strings;

/**
 * Created by xzhou2 on 11/30/16.
 */
public class StringMultiply_43 {
    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        result.append('0');
        for(int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder curr = multiply(num1, num2.charAt(i) - '0', -i + num2.length() - 1);
            result = add(curr, result);
        }
        return result.reverse().toString();
    }

    //result is a reverse.
    private StringBuilder multiply(String num1, int num2, int shift) {
        StringBuilder sb = new StringBuilder(num1.length() + 1 + shift);
        if (num2 == 0) {
            return sb.append('0');
        }

        for(int i = 0; i < shift; i++) {
            sb.append("0");
        }
        int carryOver = 0;
        for(int i = num1.length() - 1; i >= 0; i--) {
            int curr = (num1.charAt(i) - '0') * num2 + carryOver;
            sb.append(curr % 10);
            carryOver = curr / 10;
        }
        if (carryOver != 0) {
            sb.append(carryOver);
        }
        return sb;
    }

    private StringBuilder add(StringBuilder curr, StringBuilder sb) {
        StringBuilder result = new StringBuilder();
        int carryOver = 0;
        int i = 0, j = 0;
        while(i < curr.length() && j < sb.length()) {
            int val = curr.charAt(i++) - '0' + sb.charAt(j++) - '0' + carryOver;
            result.append(val % 10);
            carryOver = val / 10;
        }
        if (j < sb.length()) {
            i = j;
            curr = sb;
        }
        while(i < curr.length()) {
            int val = curr.charAt(i++) - '0' + carryOver;
            result.append(val % 10);
            carryOver = val / 10;
        }
        if (carryOver != 0) {
            result.append(carryOver);
        }
        return result;
    }
}
