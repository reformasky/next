package org.xuan.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou2 on 2/9/17.
 */
public class EvaluateDivision_399 {
    Map<String, Map<String, Double>> map = new HashMap<>();
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        for(int i = 0; i < values.length; i++) {
            String d0 = equations[i][0], d1 = equations[i][1];
            double v = values[i];
            addToMap(d0, d1, v);
        }
        double[] result = new double[queries.length];
        for(int i = 0; i < result.length; i++) {
            String d0 = queries[i][0], d1 = queries[i][1];
            Double curr = calc(d0, d1, new HashSet<>());
            result[i] = curr == null ? -1 : curr;
        }
        return result;
    }

    private Double calc(String d0, String d1, Set<String> visited) {
        if (!map.containsKey(d0) || !map.containsKey(d1)) {
            return null;
        }
        if (d0.equals(d1)) {
            return 1.0;
        }
        Map<String, Double> curr = map.get(d0);
        if (curr.containsKey(d1)) {
            return curr.get(d1);
        }
        visited.add(d0);
        Double result = null;
        for(Map.Entry<String, Double> entry : curr.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            if (!visited.contains(key) && value != null) {
                Double next = calc(key, d1, visited);
                if (next != null) {
                    result = value * next;
                    break;
                }
            }
        }

        addToMap(d0, d1, result);
        visited.remove(d0);
        return result;

    }

    private void addToMap(String src, String des, Double val) {
        Map<String, Double> from, to;
        if (map.containsKey(src)) {
            from = map.get(src);
        } else {
            from = new HashMap<>();
            map.put(src, from);
        }
        if (map.containsKey(des)) {
            to = map.get(des);
        } else {
            to = new HashMap<>();
            map.put(des, to);
        }
        from.put(des, val);
        if (val == null) {
            to.put(src, null);
        } else {
            to.put(src, 1 / val);
        }
    }



    public static void main(String[] args) {
        String[][] eq = new String[][] {
                new String[]{"a", "b"}, new String []{"c", "d"}, new String[]{"b","c"}, new String[]{"g","h"}
        };
        double[] values = new double[]{2,3,4,5};
        System.out.print(Arrays.toString(new EvaluateDivision_399().calcEquation(eq, values, new String[][]{
                {"a", "d"}, {"d", "h"}, {"g", "f"}, {"c", "g"}
        })));
    }
}
