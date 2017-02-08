package org.xuan.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by xzhou2 on 1/26/17.
 */
public class RandomizedSet {
    Random random;
    ArrayList<Integer> collection;
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        random = new Random();
        collection = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, collection.size());
            collection.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int lastVal = collection.get(collection.size() - 1);
            if (val == lastVal) {
                map.remove(val);
            } else {
                int index = map.remove(val);
                collection.set(index, lastVal);
                map.put(lastVal, index);
            }
            collection.remove(collection.size() - 1);
            return true;
        }
        return false;
    }


    /** Get a random element from the set. */
    public int getRandom() {
        return collection.get(random.nextInt(collection.size()));
    }
}

