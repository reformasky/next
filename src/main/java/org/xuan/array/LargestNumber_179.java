package org.xuan.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xzhou2 on 12/29/16.
 */
public class LargestNumber_179 {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums.length < 2) {
            for(int num : nums) {
                sb.append(num);
            }
            return sb.toString();
        }
        Integer[] copy = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        Arrays.sort(copy, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                if (a.equals(b)) {
                    return 0;
                }
                return compare(String.valueOf(a), 0,  String.valueOf(b), 0);
            }

            private int compare(String a, int index1, String b, int index2) {
                int tmp1 = index1, tmp2 = index2;
                while(tmp1 < a.length() && tmp2 < b.length()) {
                    if (a.charAt(tmp1) != b.charAt(tmp2)) {
                        return a.charAt(tmp1) - b.charAt(tmp2);
                    }
                    tmp1++;
                    tmp2++;
                }
                if (tmp1 == a.length() && tmp2 == b.length()) {
                    return 0;
                } else if (tmp1 == a.length()) {
                    return compare(a, index1, b, tmp2);
                } else {
                    return compare(a, tmp1, b, index2);
                }
            }
        });

        if(copy[copy.length - 1] == 0) {
            return "0";
        }
        for(int i = copy.length - 1; i >= 0; i--) {
            sb.append(copy[i]);
        }
        return sb.toString();
    }
}
