package org.xuan.array;

/**
 * Created by xzhou2 on 2/23/17.
 */
public class PartitionArrayIntoKGroups {
    public boolean canPartition(int[] nums, int k) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        int target = sum / k;
        int[] subSetSum = new int[k];
        return dfs(0, target, visited, nums, subSetSum);

    }

    private boolean dfs(int currSubset, int target, boolean[] visited, int[] nums, int[] subSetSum) {
        if (subSetSum[currSubset] == target) {
            return currSubset == subSetSum.length - 2 || dfs(currSubset + 1, target, visited, nums, subSetSum);
        }
        for(int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int tmpSum = subSetSum[currSubset] + nums[i];
                if (tmpSum <= target) {
                    visited[i] = true;
                    subSetSum[currSubset] = tmpSum;
                    boolean curr = dfs(currSubset, target, visited, nums, subSetSum);
                    visited[i] = false;
                    subSetSum[currSubset] -= nums[i];
                    if (curr) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
