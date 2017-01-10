package org.xuan.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 1/9/17.
 */
public class WordPattern_290 {
    public boolean wordPattern(String pattern, String str) {
        String[] cToW = new String[26];
        Map<String, Character> wToC = new HashMap<>();
        int index = 0, begin = 0;
        str = str + " ";
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                if (i != begin) {
                    String curr = str.substring(begin, i);

                    if (index >= pattern.length()) {
                        return false;
                    }
                    Character p = pattern.charAt(index++);
                    //System.out.println(curr + " " + p);
                    if (cToW[p - 'a'] != null) {

                        if (!wToC.containsKey(curr) || !p.equals(wToC.get(cToW[p - 'a'])) || !curr.equals(cToW[wToC.get(curr) - 'a']) ) {
                            return false;
                        }
                    } else if (wToC.containsKey(curr)) {
                        return false;
                    } else {
                        cToW[p - 'a'] = curr;
                        wToC.put(curr, p);
                    }
                }
                begin = i + 1;
            }
        }
        return index == pattern.length();
    }
}
