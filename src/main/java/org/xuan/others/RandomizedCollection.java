package org.xuan.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by xzhou2 on 1/26/17.
 */
public class RandomizedCollection {
    ArrayList<Integer> array;
    Map<Integer, Set<Integer>> map;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        random = new Random();
        map = new HashMap<>();
        array = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean result = map.containsKey(val);
        if (result) {
            map.get(val).add(array.size());
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(array.size());
            map.put(val, set);
        }
        array.add(val);

        return !result;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean result = map.containsKey(val);
        if (result) {
            Set<Integer> set = map.get(val);
            Iterator<Integer> iterator = set.iterator();
            int lastVal = array.get(array.size() - 1);
            if (val == lastVal) {
                set.remove(array.size() - 1);
            } else {
                int index = iterator.next();
                Set<Integer> nextSet = map.get(lastVal);
                nextSet.remove(array.size() - 1);
                nextSet.add(index);
                array.set(index, lastVal);
                set.remove(index);
            }
            array.remove(array.size() - 1);
            if (set.isEmpty()) {
                map.remove(val);
            }
        }
        return result;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return array.get(random.nextInt(array.size()));
    }
}