package org.xuan.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by xzhou2 on 3/7/17.
 */
public class NextGreaterI_496 {
    public int[] nextGreaterElement_stack(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            while(!stack.isEmpty() && stack.peek() < n) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }
        int[] res = new int[findNums.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = map.getOrDefault(findNums[i], -1);
        }
        return res;
    }

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] nexts = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            getNext(i, nums, nexts);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], nexts[i] > 0 ? nums[nexts[i]] : - 1);
        }
        int[] result = new int[findNums.length];
        for(int i = 0; i < result.length; i++) {
            result[i] = map.get(findNums[i]);
        }
        return result;

    }

    private int getNext(int index, int[] nums, int[] nexts) {
        if (index == nums.length - 1) {
            nexts[index] = -1;
            return nexts[index];
        }
        if (nexts[index] != 0) {
            return nexts[index];
        }
        int n = index + 1;
        while(n < nums.length && n > 0 && nums[index] > nums[n]) {
            n = getNext(n, nums, nexts);
        }
        nexts[index] = n;
        return nexts[index];
    }
}
