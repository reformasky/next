package org.xuan.array;

import java.util.Stack;

/**
 * Created by xzhou2 on 3/2/17.
 */
public class OneThreeTwo132Pattern_456 {
    class Pair{
        int min, max;
        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        for(int n : nums) {
            if (stack.isEmpty() || stack.peek().min > n) {
                stack.push(new Pair(n, n));
            } else if (n > stack.peek().min) {
                if (stack.peek().max > n) {
                    return true;
                } else if (stack.peek().max < n) {
                    Pair last = new Pair(stack.peek().min, n);
                    while(!stack.isEmpty() && stack.peek().max <=n) {
                        stack.pop();
                    }
                    if (!stack.isEmpty() && stack.peek().min < n) {
                        return true;
                    }
                    stack.push(last);
                }
            }
        }
        return false;
    }
}
