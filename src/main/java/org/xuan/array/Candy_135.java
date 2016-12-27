package org.xuan.array;

/**
 * Created by xzhou2 on 12/19/16.
 */
public class Candy_135 {
    public int candy(int[] ratings) {
        if (ratings.length < 2) {
            return ratings.length;
        }
        int result = 1;
        int leftIndex = 0, leftValue = 1, lastValue = 1;
        for(int i = 1; i < ratings.length; i++) {
            if (ratings[i] == ratings[i - 1]) {
                result += 1;
                leftIndex = i;
                lastValue = 1;
                leftValue = 1;
            } else if (ratings[i] > ratings[i - 1]) {
                result += ++lastValue;
                leftIndex = i;
                leftValue = lastValue;
            } else {
                result += (i - leftIndex);
                if (i - leftIndex >= leftValue) {
                    leftValue++;
                    result++;
                }
                lastValue = 1;
            }
        }

        return result;
    }
}
