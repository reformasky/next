package org.xuan.others;

import org.xuan.util.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 1/22/17.
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    Integer integer;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
        integer = null;
        init();
    }

    private void init() {
        if (integer == null) {
            while(!stack.isEmpty()) {
                NestedInteger curr = stack.pop();
                if (curr.isInteger()) {
                    integer = curr.getInteger();
                    break;
                } else {
                    List<NestedInteger> nexts = curr.getList();
                    for(int i = nexts.size() - 1; i >= 0; i--) {
                        stack.push(nexts.get(i));
                    }
                }
            }
        }
    }

    @Override
    public Integer next() {
        init();
        Integer result = integer;
        integer = null;
        return result;
    }

    @Override
    public boolean hasNext() {
        init();
        return integer != null;
    }
}