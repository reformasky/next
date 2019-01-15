package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhou2 on 3/11/17.
 */
public class IncreasingSubSequence_491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 2) {
            return result;
        }
        int size = 0;
        List<List<Integer>>[] cache = (List<List<Integer>>[]) new List[nums.length];
        Map<Integer, Integer> lastIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> curr = new ArrayList<>();
            int start = 0;
            if (lastIndex.containsKey(nums[i])) {
                start = lastIndex.get(nums[i]);
            } else {
                curr.add(Arrays.asList(nums[i]));
            }
            for(int j = start; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    List<List<Integer>> pre = cache[j];
                    for(List<Integer> p : pre) {
                        ArrayList<Integer> c = new ArrayList<>(p.size() + 1);
                        for(int k : p) {
                            c.add(k);
                        }
                        c.add(nums[i]);
                        curr.add(c);
                        size++;
                    }
                }
            }
            lastIndex.put(nums[i], i);
            cache[i] = curr;
        }
        result = new ArrayList<>(size);
        for(int i = 0; i < nums.length; i++) {
            for(List<Integer> l : cache[i]) {
                if (l.size() > 1) {
                    result.add(l);
                }
            }
        }
        return result;
    }
}
