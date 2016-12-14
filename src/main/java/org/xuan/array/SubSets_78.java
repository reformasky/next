package org.xuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 12/12/16.
 */
public class SubSets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> pre, List<List<Integer>> result) {
        for(int i = index; i < nums.length; i++) {
            List<Integer> curr = new ArrayList<>(pre);
            curr.add(nums[i]);
            result.add(curr);
            dfs(nums, i + 1, curr, result);
        }
    }


    public List<List<Integer>> subsets_dfs1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        dfs(nums, 0, result);
        return result;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> result) {
        if (index < nums.length) {
            int size = result.size();
            for(int i = 0; i < size; i++) {
                List<Integer> curr = new ArrayList<>(result.get(i));
                curr.add(nums[index]);
                result.add(curr);
            }
            dfs(nums, index + 1, result);
        }
    }

    public List<List<Integer>> subsets_iterative(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lastIndex = new ArrayList<>(), pre;
        result.add(new ArrayList<>());
        lastIndex.add(-1);
        int size1 = 0, size2 = 1;
        pre = new ArrayList<>();
        while(pre.size() < nums.length) {
            for(int j = size1; j < size2; j++) {
                pre = result.get(j);
                for(int i = lastIndex.get(j) + 1; i < nums.length; i++) {
                    List<Integer> curr = new ArrayList<>(pre);
                    curr.add(nums[i]);
                    result.add(curr);
                    lastIndex.add(i);
                }
            }
            size1 = size2;
            size2 = result.size();
        }

        return result;
    }
}
