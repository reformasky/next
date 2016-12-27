package org.xuan.graph;

import org.xuan.util.UndirectedGraphNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xzhou2 on 12/18/16.
 */
public class CloneGraph_133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        queue.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while(!queue.isEmpty()) {
            UndirectedGraphNode ori = queue.poll(), des;
            if(!visited.contains(ori)) {
                des = map.get(ori);
                for(UndirectedGraphNode next : ori.neighbors) {
                        if (!map.containsKey(next)) {
                            map.put(next, new UndirectedGraphNode(next.label));
                        }
                        UndirectedGraphNode nextDes = map.get(next);
                        des.neighbors.add(nextDes);
                        queue.offer(next);
                }
            }
            visited.add(ori);
        }
        return map.get(node);
    }
}
