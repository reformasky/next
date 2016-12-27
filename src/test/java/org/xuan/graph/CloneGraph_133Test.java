package org.xuan.graph;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.xuan.util.UndirectedGraphNode;

import java.util.Arrays;

/**
 * Created by xzhou2 on 12/18/16.
 */
public class CloneGraph_133Test {
    CloneGraph_133 c = new CloneGraph_133();

    @Test
    public void test() {
        UndirectedGraphNode n0 = new UndirectedGraphNode(0),
                n1 = new UndirectedGraphNode(1),
                n2 = new UndirectedGraphNode(2);
        n0.neighbors.addAll(Arrays.asList(n1, n2));
        n1.neighbors.addAll(Arrays.asList(n0, n2));
        n2.neighbors.addAll(Arrays.asList(n0, n1, n2));
        UndirectedGraphNode res = c.cloneGraph(n0);
        Assert.assertEquals(res.label, 0);

    }
}
