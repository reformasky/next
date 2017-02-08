package org.xuan.strings;

import org.xuan.util.NestedInteger;

import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 2/2/17.
 */
public class MinParser_385 {
    public NestedInteger deserialize(String s) {
        if (s.length() == 0) {
            return new NestedInteger();
        } else if (s.charAt(0) != '[') {
            NestedInteger res = new NestedInteger();
            res.setInteger(Integer.parseInt(s));
            return res;
        } else {
            Stack<NestedInteger> stack = new Stack<>();
            int val = 0;
            int sign = 1;
            boolean isInt = false;
            NestedInteger curr = null;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '[') {
                    stack.push(new NestedInteger());
                    curr = new NestedInteger();
                } else if (c == ']') {
                    if (isInt) {
                        curr.setInteger(sign * val);
                        val = 0;
                    }
                    if (s.charAt(i - 1) != '[') {
                        stack.peek().add(curr);

                    }
                    curr = stack.pop();
                    isInt = false;
                    sign = 1;

                } else if (c == ',') {
                    if (isInt) {
                        curr.setInteger(sign * val);
                        val = 0;
                    }
                    stack.peek().add(curr);
                    curr = new NestedInteger();
                    isInt = false;
                    sign = 1;
                } else if (c == '-'){
                    sign = -1;
                }  else {
                    val = 10 * val + c - '0';
                    isInt = true;
                }
            }
            return curr;
        }
    }
    private class NestedInteger implements org.xuan.util.NestedInteger {


        @Override
        public boolean isInteger() {
            return false;
        }

        @Override
        public Integer getInteger() {
            return null;
        }

        @Override
        public List<org.xuan.util.NestedInteger> getList() {
            return null;
        }

        @Override
        public void setInteger(int i) {

        }

        @Override
        public void add(org.xuan.util.NestedInteger n) {

        }
    }
}
