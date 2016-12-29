package org.xuan.array;

/**
 * Created by xzhou2 on 12/28/16.
 */
public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        int result = 0, count = 0;
        for(int num : nums) {
            if (count == 0) {
                result = num;
                count = 1;
            } else if (result != num){
                count--;
            } else {
                count++;
            }
        }
        return result;
    }
}
