package org.xuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 1/6/17.
 */
public class MajorityElementII_229 {
    public List<Integer> majorityElement(int[] nums) {
        int a = 0, b = -1, countA = 0, countB = 0;
        for(int n : nums) {
            if (n == a && countA > 0) {
                countA++;
            } else if (n == b && countB > 0) {
                countB++;
            }else if (countA == 0) {
                a = n;
                countA++;
            } else if (countB == 0) {
                b = n;
                countB++;
            } else {
                countA--;
                countB--;
            }

        }
        countA = 0;
        countB = 0;
        for(int n : nums) {
            if (n == a) {
                countA++;
            }else if (n == b) {
                countB++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (countA > nums.length / 3) {
            result.add(a);
        }
        if (countB > nums.length / 3) {
            result.add(b);
        }
        return result;
    }


}
