package org.xuan.algs.dfs;

import algs.dfs.PermutationWithNoDuplicate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xzhou2 on 4/5/17.
 */
public class PermutationWithNoDuplicateTest {
    PermutationWithNoDuplicate obj = new PermutationWithNoDuplicate();

    @Test
    public void test() {
        int[] arr = {1,1,2,2};
        List<int[]> res = obj.permutationNoDfs(arr);
        String[] s = new String[res.size()];
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s.length; i++) {
            stringBuilder.delete(0, stringBuilder.length());
            for(int j : res.get(i)) {
                stringBuilder.append(j);
            }
            s[i] = stringBuilder.toString();
        }
        Assert.assertEqualsNoOrder(s, new Object[]{"1122","1212", "1221", "2112", "2121", "2211"});
    }
}
