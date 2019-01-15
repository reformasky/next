package org.xuan.array;

/**
 * Created by xzhou2 on 4/3/17.
 */
public class SuperWashMachine_517 {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for(int m : machines) {
            sum += m;
        }
        if (sum % machines.length != 0) {
            return -1;
        }
        int avg = sum / machines.length, runningDiff = 0, result = 0;
        for(int m : machines) {
            runningDiff += m - avg;
            result = max(result, Math.abs(runningDiff), m- avg);
        }
        return result;
    }

    private int max(int ... arr) {
        int result = 0;
        for(int a : arr) {
            result = Math.max(result, a);
        }
        return result;
    }
}
