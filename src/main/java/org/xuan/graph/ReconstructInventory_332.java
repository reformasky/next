package org.xuan.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by xzhou2 on 1/19/17.
 */
public class ReconstructInventory_332 {
    private static final String ORI = "JFK";
    public List<String> findItinerary(String[][] tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        int count = 1;
        for(String[] ticket : tickets) {
            String ori = (ticket[0]), des = (ticket[1]);
            Queue<String> curr;
            if (!map.containsKey(ori)) {
                curr = new PriorityQueue<>();
                map.put(ori, curr);
            } else {
                curr = map.get(ori);
            }
            curr.offer(des);
            count++;
        }
        Stack<String> main = new Stack<>(), copy = new Stack<>();
        String ori = (ORI);
        while(main.size() + copy.size() < count -1) {
            Queue<String> curr = map.get(ori);
            if (curr == null || curr.isEmpty()) {
                copy.push(ori);
                ori = main.pop();
            } else {
                main.push(ori);
                ori = curr.poll();
            }
        }
        main.push(ori);
        while(!copy.isEmpty()) {
            main.push(copy.pop());
        }
        String[] result = new String[count];
        while(!main.isEmpty()) {
            result[--count] = main.pop();
        }
        return Arrays.asList(result);
    }
}
