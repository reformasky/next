package org.xuan.strings;

/**
 * Created by xzhou2 on 2/20/17.
 */
public class AddStrings_415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int index1 = num1.length() - 1, index2 = num2.length() - 1, carryOver = 0;
        while(index1 >= 0 && index2 >= 0) {
            int curr = num1.charAt(index1--) - '0' + num2.charAt(index2--) - '0' + carryOver;
            sb.append(curr % 10);
            carryOver = curr / 10;
        }
        if (index1 < 0) {
            index1 = index2;
            num1 = num2;
        }
        while(index1 >= 0) {
            int curr = num1.charAt(index1--) - '0' + carryOver;
            sb.append(curr % 10);
            carryOver = curr / 10;
        }
        if (carryOver != 0) {
            sb.append(carryOver);
        }
        return sb.reverse().toString();
    }
}
