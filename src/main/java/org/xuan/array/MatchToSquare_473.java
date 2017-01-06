package org.xuan.array;

/**
 * Created by xzhou2 on 1/1/17.
 */
public class MatchToSquare_473 {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        if (sum % 4 != 0 || nums.length < 4) {
            return false;
        }
        return dfs(nums, sum / 4, sum /4, 0, 0, new boolean[nums.length]);
    }

    private boolean dfs(int[] nums, int target, int ori, int side, int index, boolean[] visited) {
        if (target == 0) {
            return dfs(nums, ori, ori, side + 1, 0, visited);
        }
        if (side == 3) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        if (!visited[index] && target >= nums[index]) {
            visited[index] = true;
            if (index == nums.length - 1 && target == nums[index] && dfs(nums, ori, ori, side + 1, 0, visited)) {
                return true;
            } else for(int i = index + 1; i < nums.length; i++) {
                if (dfs(nums, target - nums[index], ori, side, i, visited)) {
                    return true;
                }
            }
            visited[index] = false;
            return false;
        } else {
            return dfs(nums, target, ori, side, index + 1, visited);
        }
    }
}
