package org.xuan.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xzhou2 on 2/7/17.
 */
public class SubSequence_392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int tmp = t.indexOf(c, index);
            if (tmp >= 0) {
                index = tmp + 1;
            } else {
                return false;
            }
        }
        return true;
    }

     class Solution {
         List<Integer>[] cache = (List<Integer>[]) new List[26];
         public boolean isSubsequence(String s, String t) {
             if (s.length() > t.length()) {
                 return false;
             }
             if (s.length() == 0) {
                 return true;
             }
             for(int i = 0; i < 26; i++) {
                 cache[i] = new ArrayList<>();
             }
             for(int i = 0; i < t.length(); i++) {
                 cache[t.charAt(i) - 'a'].add(i);
             }
             int last = -1;
             for(int i = 0; i < s.length(); i++) {
                 int index = s.charAt(i) - 'a';
                 List<Integer> list = cache[index];

                 int res = Collections.binarySearch(list, last );
                 int insert = (res < 0 || res >= list.size()) ?  -1 - res : res;
                 if (insert >= list.size() || insert < 0) {
                     return false;
                 }
                 last = list.get(insert) + 1 ;
             }
             return true;

         }
    }
}
