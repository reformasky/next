package algs.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 4/5/17.
 */
public class PermutationWithNoDuplicate {

    public List<int[]> permutation(int[] nums) {
        int len = nums.length;
        int total = getTotal(len);
        List<int[]> result = new ArrayList<>(total);
        if (nums.length == 0) {
            return result;
        }

        int[] cache = new int[len];
        boolean[] visited = new boolean[len];
        dfs(result, cache, visited, nums, 0);
        return result;
    }


    private void dfs(List<int[]> result, int[] cache, boolean[] visited, int[] nums, int index) {
        if (index == cache.length) {
            result.add(Arrays.copyOf(cache, cache.length));
        } else for(int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cache[index] = nums[i];
                dfs(result, cache, visited, nums, index + 1);
                visited[i] = false;
            }
        }
    }

    private int getTotal(int l) {
        int res = 1;
        for(int i = 1; i <= l; i++) {
            res *= i;
        }
        return res;
    }

    public List<int[]> permutationNoDfs(int [] nums) {
        int len = nums.length;
        int total = getTotal(len);
        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>(total);
        if (nums.length == 0) {
            return result;
        }
        return helper(nums, len - 1);
    }

    private List<int[]> helper(int[] nums, int index) {
        List<int[]> res = new ArrayList<>();
        if (index == 0) {
            int[] curr = {nums[0]};
            res.add(curr);
            return res;
        }
        List<int[]> pre = helper(nums, index - 1);
        for(int[] p : pre) {
            addToResult(p, nums[index], res);
        }
        return res;
    }

    private void addToResult(int[] pre, int n, List<int[]> res) {
        int[] curr ;
        for (int i = index(pre, n); i < pre.length; i++) {
            curr = new int[pre.length + 1];
            System.arraycopy(pre, 0, curr, 0, i);
            curr[i] = n;
            System.arraycopy(pre, i, curr, i + 1, pre.length - i);
            res.add(curr);
        }
        curr = new int[pre.length + 1];
        System.arraycopy(pre, 0, curr, 0, pre.length);
        curr[pre.length] = n;
        res.add(curr);
    }

    private int index(int[] nums, int v) {
        int res = nums.length - 1;
        for(; res >= 0; res--) {
            if (nums[res] == v) {
                return res + 1;
            }
        }
        return res + 1;
    }

}
