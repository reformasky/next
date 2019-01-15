package org.xuan.ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 2/2/17.
 */
public class LexicalOrder_386 {
    public List<Integer> lexicalOrder_recursive(int n) {
        int curr = 1;
        List<Integer> result = new ArrayList<>();
        helper(result, n, curr);
        return result;
    }

    private void helper(List<Integer> result, int max, int curr) {
        result.add(curr);
        if (curr * 10l <= max) {
            helper(result, max, curr * 10);
        }
        if (curr + 1l <= max && curr % 10 != 9) {
            helper(result, max, curr + 1);
        }
    }



    public List<Integer> lexicalOrder(int n) {
        Integer[] res = new Integer[n];
        int curr = 1;
        int index = 0;
        while(index < n) {
            res[index++] = curr;
            curr = next(curr, n);
        }
        return Arrays.asList(res);
    }

    private int next(int curr, int max) {
        if (curr * 10 <= max) {
            return curr * 10;
        } else if ((curr + 1) % 10 == 0) {
            curr++;
            while(curr % 10 == 0) {
                curr /= 10;
            }
            return curr;
        } else if (curr + 1 <= max) {
            return curr + 1;
        } else {
            curr =  curr / 10 + 1;
            while(curr % 10 == 0) {
                curr /= 10;
            }
            return curr;
        }
    }
}
