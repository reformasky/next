package org.xuan.array;

/**
 * Created by xzhou2 on 3/4/17.
 */
public class MinimalMoveToEqualArrayII_462 {
    public int minMoves2(int[] nums) {
        int mid = getKth(nums, nums.length / 2, 0, nums.length - 1);
        long[] diffs = getDiff(mid, nums);
        return (int)(diffs[0] + diffs[1]);
    }

    private static int getKth(int[] nums, int k, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int n = nums[low];
        int indexL = low + 1, indexH = high;
        while(true) {
            while(indexL <= high && nums[indexL] <= n) {
                indexL++;
            }
            while(nums[indexH] > n) {
                indexH--;
            }

            if (indexH <= indexL) {
                break;
            }
            int tmp = nums[indexH];
            nums[indexH] = nums[indexL];
            nums[indexL] = tmp;
        }
        nums[low] = nums[indexH];
        nums[indexH] = n;
        if (indexH == k) {
            return n;
        } else if (indexH > k) {
            high = indexH - 1;
        } else {
            low = indexH + 1;
        }
        return getKth(nums, k, low, high);
    }


    private static long[] getDiff(int target, int[] nums) {
        long pos = 0, neg = 0;
        for(int n : nums) {
            if (n > target) {
                pos += n - target;
            } else {
                neg += target - n;
            }
        }
        return new long[]{pos, neg};
    }

    public static void main(String[] args) {
        int[] n = {1,2,3,4,5,6,7};
        System.out.println(getKth(n, n.length/ 2, 0, n.length - 1));
        int target = 1;
        long diff = 10001 * 10001;
        for(int i = 1; i <= 10001; i++) {
            long[] diffs = getDiff(i, n);
            if (diffs[0] + diffs[1]< diff) {
                target = i;
                diff = diffs[0] + diffs[1];
            }
        }
        System.out.print(target + " " + diff);
    }
}
