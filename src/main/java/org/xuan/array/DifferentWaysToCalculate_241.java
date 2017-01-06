package org.xuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 1/4/17.
 */
public class DifferentWaysToCalculate_241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> operands = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        int curr = 0;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= '0' && c <= '9') {
                curr = curr * 10 + c - '0';
            } else {
                operators.add(c);
                operands.add(curr);
                curr = 0;
            }
        }
        if (input.length() > 0) {
            operands.add(curr);
        }
        List<Integer> result = new ArrayList<>();
        if (operators.isEmpty() ) {
            if (!operands.isEmpty()) {
                result.add(operands.get(0));
            }
            return result;
        }
        @SuppressWarnings("unchecked")
        List<Integer>[][] cache = (List<Integer>[][]) new List[operands.size()][operands.size()];
        for(int i = 0; i < cache.length; i++) {
            cache[i][i] = new ArrayList<>(1);
            cache[i][i].add(operands.get(i));
        }
        for(int diff = 1; diff < cache.length; diff++) {
            for(int i = 0; i + diff < cache.length; i++) {
                int j = i + diff;
                cache[i][j] = new ArrayList<>();
                for(int k = i; k < j; k++) {
                    List<Integer> left = cache[i][k],
                            right = cache[k + 1][j];
                    for(int l : left) {
                        for(int r : right) {
                            cache[i][j].add(calculate(l, r, operators.get(k)));
                        }
                    }
                }
            }
        }
        return cache[0][cache.length - 1];
    }

    private int calculate(int lhs, int rhs, char op) {
        switch(op) {
            case '+': return lhs + rhs;
            case '-': return lhs - rhs;
            case '*': return lhs * rhs;
        }
        throw new IllegalArgumentException();
    }
}
