package org.xuan.strings;

/**
 * Created by xzhou2 on 11/29/16.
 */
public class CountAndSay_38 {
    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder();
        curr.append("1");
        for(int i = 1; i < n; i++) {
            String pre = curr.toString();
            curr = new StringBuilder();
            char val = pre.charAt(0);
            int count = 1;
            for(int j = 1; j < pre.length(); j++) {
                if (val == pre.charAt(j)) {
                    count++;
                } else {
                    curr.append(count);
                    curr.append(val);
                    val = pre.charAt(j);
                    count = 1;
                }
            }
            curr.append(count);
            curr.append(val);
        }
        return curr.toString();
    }
}
