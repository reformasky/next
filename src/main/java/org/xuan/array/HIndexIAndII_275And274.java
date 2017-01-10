package org.xuan.array;

/**
 * Created by xzhou2 on 1/8/17.
 */
public class HIndexIAndII_275And274 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len == 0) {
            return 0;
        }
        //Arrays.sort(citations);
        int result = 0;
        int low = 0, high = len - 1;
        while(low <= high) {
            int mid = low + (high - low) /2;
            if (citations[mid] < (len - mid)) {
                low = mid + 1;
            } else if (citations[mid] == len - mid){
                return len - mid;
            } else {
                if (mid == 0 || citations[mid - 1] < (len - mid + 1)) {
                    return len - mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return citations[high] >= len - high ? len - high : len - high - 1;
    }
}
