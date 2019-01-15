package org.xuan.ints;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 2/20/17.
 */
public class FizzBuzz_412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for(int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
