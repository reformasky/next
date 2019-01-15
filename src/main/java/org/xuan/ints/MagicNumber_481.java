package org.xuan.ints;

/**
 * Created by xzhou2 on 3/7/17.
 */
public class MagicNumber_481 {
    public int magicalString(int n) {
        boolean[] arr = new boolean[n + 1];
        int pre = 1;
        int result = 0;
        //false : 2; true : 1
        for(int i = 1; i <= n; ) {
            arr[i] = !arr[i-1];
            if (arr[pre]) {
                result += arr[i] ? 1 : 0;
                i++;
            } else {
                result += arr[i] ? 1 : 0;
                if (i < n) {
                    arr[i + 1] = arr[i];
                    result += arr[i] ? 1 : 0;
                }
                i += 2;
            }
            pre++;
        }
        return result;
    }
}
