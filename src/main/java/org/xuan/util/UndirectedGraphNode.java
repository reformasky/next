package org.xuan.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 12/18/16.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public  UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
