package org.xuan.array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 1/16/17.
 */
public class CountSmaller_315 {
    public List<Integer> countSmaller(int[] nums) {
        Element[] cache = new Element[nums.length];
        for(int i = 0; i < nums.length; i++) {
            cache[i] = new Element(nums[i], i);
        }
        mergeSort(cache, 0, cache.length - 1, new Element[nums.length]);
        Integer[] counts = new Integer[nums.length];
        for(Element e : cache) {
            counts[e.index] = e.count;
        }
        return Arrays.asList(counts);
    }

    private void mergeSort(Element[] cache, int low, int high, Element[] copy) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(cache, low, mid, copy);
            mergeSort(cache, mid + 1, high, copy);
            merge(cache, low, mid, high, copy);
        }
    }

    private void merge(Element[] cache, int low, int mid, int high, Element[] copy) {
        for(int i = low; i <= high; i++) {
            copy[i] = cache[i];
        }
        int left = low, right = mid + 1, index = low;
        while(left <= mid && right <= high) {
            if (copy[left].val <= copy[right].val) {
                copy[left].count += (right - mid - 1);
                cache[index++] = copy[left++];
            } else {
                cache[index++] = copy[right++];
            }
        }
        while(left <= mid) {
            copy[left].count += (high - mid);
            cache[index++] = copy[left++];
        }
        while(right <= high) {
            cache[index++] = copy[right++];
        }

    }

    private static class Element{
        int val, index, count;

        public Element(int v, int i) {
            val = v;
            index = i;
            count = 0;
        }
    }
}
