package org.xuan.others;

/**
 * Created by xzhou2 on 3/30/17.
 */
public class BinaryIndexedTree{
    int[] sums;
    int[] vals;
    public BinaryIndexedTree(int[] arr) {
        sums = new int[arr.length + 1];
        vals = new int[arr.length];
        for(int i = 0; i < vals.length; i++) {
            update(i, arr[i]);
        }
    }

    public void update(int i, int val) {
        int diff = val - vals[i];
        vals[i] = val;
        i++;
        while(i < sums.length) {
            sums[i] += diff;
            i += (i & (-i));
        }
    }

    public int sum(int i) {
        int sum = 0;
        i++;
        while(i > 0) {
            sum += sums[i];
            i -= (i & -i);
        }
        return sum;
    }


}