package org.xuan.array;

/**
 * Created by xzhou2 on 12/19/16.
 */
public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diff = 0, sum = 0, res = 0;
        for(int i = 0; i < gas.length; i++) {
            int curr = gas[i] - cost[i];
            diff += curr;
            sum += curr;
            if (diff < 0) {
                diff = 0;
                res = i + 1;
            }
        }
        return sum >= 0 ? res : -1;
    }
}
