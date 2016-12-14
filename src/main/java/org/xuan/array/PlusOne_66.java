package org.xuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 12/7/16.
 */
public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        List<Integer> tmp = new ArrayList<>(digits.length);
        int carryOver = 1, curr;
        for(int i = digits.length - 1; i >= 0; i--) {
            curr = digits[i] + carryOver;
            tmp.add(curr % 10);
            carryOver = curr / 10;
        }
        if (carryOver != 0) {
            tmp.add(carryOver);
        }
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = tmp.get(res.length - 1 - i);
        }
        return res;
    }
}
