package org.xuan.ints;

/**
 * Created by xzhou2 on 1/25/17.
 */
public class GuessNumber_374 {
    public int guessNumber(int n) {
        int low = 1, high = n;
        while(low <= high) {
            int mid = low + (high - low) / 2,
                    guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        throw new RuntimeException();
    }
    int guess(int num) {
        return 0;
    }
}
