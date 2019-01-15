package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 3/29/17.
 */
public class MostFrequentSubtreeSum_508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        return mostFrequent(map);
    }

    private int helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int val = root.val + helper(root.left, map) + helper(root.right, map);
        map.put(val, map.getOrDefault(val, 0) + 1);
        return val;
    }

    private int[] mostFrequent(Map<Integer, Integer> map) {
        int max = Integer.MIN_VALUE, count = 0;
        for(int v : map.values()) {
            if (v > max) {
                count = 1;
                max = v;
            } else if (v == max) {
                count++;
            }
        }
        if (max <= 0) {
            return new int[0];
        }
        int[] res = new int[count];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                res[--count] = entry.getKey();
            }
        }
        return res;
    }
}
