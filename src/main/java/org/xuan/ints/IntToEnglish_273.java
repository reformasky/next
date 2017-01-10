package org.xuan.ints;

/**
 * Created by xzhou2 on 1/8/17.
 */
public class IntToEnglish_273 {
    private static final int[] nums = new int[]{
            1000000000, 1000000, 1000, 100, 90, 80, 70,60, 50, 40, 30, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
    };
    private static final String[] strs = new String[] {
            "Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty", "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb= new StringBuilder();
        for(int i = 0; i < nums.length; i++) {
            if (num >= nums[i]) {
                int q = num / nums[i];
                int r = num % nums[i];
                if (nums[i] >= 100) {
                    sb.append(numberToWords(q));
                    sb.append(" ");
                }

                sb.append(strs[i]);
                if (r > 0) {
                    sb.append(" ");
                    sb.append(numberToWords(r));
                }
                break;
            }
        }
        return sb.toString();
    }
}
