package org.xuan.array;

/**
 * Created by xzhou2 on 3/8/17.
 */
public class CanWin_486 {
    public boolean PredictTheWinner(int[] nums) {
        return predict(nums, 0, nums.length - 1, 0, 0, true);
    }

    private boolean predict(int[] nums, int low, int high, int sum1, int sum2, boolean first) {
        if (low == high) {
            int diff = sum1 + nums[low] - sum2;
            return diff == 0 ? first : diff > 0;
        }
        return  !predict(nums, low + 1, high, sum2, sum1 + nums[low], !first) ||
                !predict(nums, low, high - 1, sum2, sum1+ nums[high], !first);
    }
    public static void main(String[] args) {
        int[] input = {4,2,1,3};
        CanWin_486 c = new CanWin_486();
        boolean p = c.PredictTheWinner(input);
        System.out.print(p);
    }
}
