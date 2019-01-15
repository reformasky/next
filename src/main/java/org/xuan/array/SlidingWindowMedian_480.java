package org.xuan.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by xzhou2 on 3/11/17.
 */
public class SlidingWindowMedian_480 {
    public List<Integer> list = new ArrayList<>();

    public double[] medianSlidingWindow_insertSort(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }
        double[] ret = new double[nums.length - k + 1];
        ret[0] = getmean();
        for (int i = k; i < nums.length; i++) {
            add(nums[i]);
            remove(nums[i - k]);
            ret[i - k + 1] = getmean();
        }
        return ret;
    }

    public double getmean() {
        int size = list.size();
        if (size % 2 == 1) return list.get(size / 2) * 1.0;
        else return (list.get(size / 2) * 0.5 + list.get(size / 2 - 1) * 0.5) ;
    }

    public void remove(int i) {
        list.remove(find(i));
    }

    public void add(int i) {
        list.add(find(i),  i);
    }

    public int find(int i) {
        int index =  Collections.binarySearch(list, i);
        return index >= 0 ? index : -1 - index;
    }


    public double[] medianSlidingWindow_stream(int[] nums, int k) {
        double[] result = new double[Math.max(0, nums.length - k + 1)];
        if (nums.length < k) {
            return result;
        }
        ExtendedMap left = new ExtendedMap(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        ExtendedMap right = new ExtendedMap(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                int removedKey = nums[i - k];
                if (right.containsKey(removedKey)) {
                    right.remove(removedKey);
                } else {
                    left.remove(removedKey);
                }
            }
            left.inc(nums[i]);
            right.inc(left.decFirst());
            while (right.count > left.count + 1) {
                left.inc(right.decFirst());
            }

            if (i >= k - 1) {
                result[i - k + 1] = k % 2 == 0 ? (0.5 * left.firstKey() + 0.5 * right.firstKey()) :
                        1.0 * (left.count > right.count ? left.firstKey() : right.firstKey());

            }
        }
        return result;
    }


    class ExtendedMap extends TreeMap<Integer, Integer> {
        int count;

        public ExtendedMap(Comparator<Integer> c) {
            super(c);
            count = 0;
        }

        public void inc(Integer k) {
            count++;
            super.put(k, getOrDefault(k, 0) + 1);
        }

        @Override
        public Integer remove(Object k) {
            count--;
            int v = super.get(k);
            if (v == 1) {
                super.remove(k);
            } else {
                super.put((Integer) k, v - 1);
            }
            return v;
        }

        public Integer decFirst() {
            Integer k = firstKey();
            remove(k);
            return k;
        }
    }
}
