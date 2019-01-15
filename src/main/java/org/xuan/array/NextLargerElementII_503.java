package org.xuan.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by xzhou2 on 4/2/17.
 */
public class NextLargerElementII_503 {
    public int[] nextGreaterElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            max = Math.max(max, n);
            while(!stack.isEmpty() && n > stack.peek()[1]) {
                int[] pre = stack.pop();
                result[pre[0]] = n;
            }
            stack.push(new int[]{i, n});
        }
        for(int n : nums) {
            while(n > stack.peek()[1]) {
                int[] pre = stack.pop();
                result[pre[0]] = n;
            }
            if (stack.peek()[1] == max) {
                break;
            }
        }
        return result;
    }
}
