package org.xuan.ints;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 3/3/17.
 */
public class CanIWin_464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        return canIWin(0, maxChoosableInteger, desiredTotal, new HashMap<Integer, int[]>());
    }

    private boolean canIWin(int used, int maxChoosableInteger, int sum, Map<Integer, int[]> map) {
        int[] status = getStatus(used, maxChoosableInteger);
        if (status[0] < sum) {
            return false;
        } else if (status[0] == sum) {
            return status[1] % 2 != 0;
        }

        int[] cache = map.get(used);
        if (cache == null || (sum > cache[0] && sum < cache[1])) {
            cache = cache == null ? new int[]{0, Integer.MAX_VALUE} : cache;
            int tmp = used;
            boolean res = false;
            for(int i = maxChoosableInteger - 1; i >= 0 ;i--) {
                if ((used & (1 << i)) == 0) {
                    used |= 1 << i;
                    if (sum <= i + 1 || !canIWin(used, maxChoosableInteger, sum - i - 1, map)) {
                        res = true;
                        break;
                    }
                    used = tmp;
                }
            }
            if (res) {
                cache[0] = sum;
            } else {
                cache[1] = sum;
            }
            map.put(tmp, cache);
            return res;
        } else {
            return cache[0] >= sum;
        }
    }

    private int[] getStatus(int used, int maxChoosableInteger) {
        int sum = 0, count = 0;
        for(int i = 0 ; i < maxChoosableInteger; i++) {
            if ((used & (1 << i)) == 0) {
                sum += i + 1;
                count ++;
            }
        }
        return new int[]{sum, count};
    }
}
