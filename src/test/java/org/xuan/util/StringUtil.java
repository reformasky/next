package org.xuan.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 11/9/16.
 */
public class StringUtil {
    //[a,b]
    public static List<String> strToList(String str) {
        if (str.charAt(0) == '[') {
            str = str.substring(0, str.length() - 1);
        }
        String[] tokens = str.split(",");
        List<String> res = new ArrayList<>();
        for(String token : tokens) {
            res.add(token);
        }
        return res;
    }

    public static List<Integer> strToIntList(String str) {
        List<String> tmp = strToList(str);
        List<Integer> res = new ArrayList<>(tmp.size());
        for(String t : tmp) {
            res.add(Integer.parseInt(t));
        }
        return res;
    }

    public static int[] strToIntArr(String str) {
        List<Integer> tmp = strToIntList(str);
        int[] res = new int[tmp.size()];
        int index = 0;
        for(int t : tmp) {
            res[index++] = t;
        }
        return res;
    }
}

