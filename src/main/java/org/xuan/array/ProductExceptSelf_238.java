package org.xuan.array;

/**
 * Created by xzhou2 on 1/6/17.
 */
public class ProductExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int num = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] = num * nums[i];
            num = result[i];
        }
        num = 1;
        for(int i = 0; i < nums.length; i++) {
            result[i] = ((i < nums.length - 1) ? result[i + 1] : 1) * num;
            num *= nums[i];
        }
        return result;
    }
}
