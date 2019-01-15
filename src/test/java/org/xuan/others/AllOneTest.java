package org.xuan.others;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 2/22/17.
 */
public class AllOneTest {

    @Test
    public void test() {
        AllOne allOne = new AllOne();
        Object[][] input = new Object[][] {
           /* new Object[]{1, "a"}, new Object[]{3, "a"}, new Object[]{4, "a"},
                new Object[]{1, "a"}, new Object[]{3, "a"}, new Object[]{4, "a"},
                new Object[]{1, "b"}, new Object[]{3, "a"}, new Object[]{4, "b"},
                new Object[]{1, "c"},new Object[]{1, "c"},new Object[]{1, "c"},new Object[]{1, "c"}, new Object[]{1, "c"}, new Object[]{3, "c"}, new Object[]{4, "b"},

                new Object[]{2, "a"}, new Object[]{3, "c"}, new Object[]{4, "ab"},
                new Object[]{2, "a"},  new Object[]{3, "c"}, new Object[]{4, "b"},
                new Object[]{2, "b"},  new Object[]{3, "c"}, new Object[]{4, "c"},
                new Object[]{2, "c"},new Object[]{2, "c"},new Object[]{2, "c"},new Object[]{2, "c"},new Object[]{2, "c"},
                new Object[]{3, ""}, new Object[]{4, ""},*/
                new Object[]{1, "a"}, new Object[]{1, "a"},new Object[]{1, "a"},new Object[] {1, "b"},new Object[] {1, "b"},
                new Object[] {2, "b"},new Object[] {1, "b"},new Object[] {1, "b"}, new Object[]{3, "ab"}
        };
        for(Object[] object : input) {
            Integer op = (Integer)object[0];
            String data = (String)object[1];
            Set<String> set = new HashSet<>();
            if (data.length() == 0) {
                set.add("");
            }
            for(char c : data.toCharArray()) {
                set.add(c + "");
            }
            switch (op) {
                case 1: allOne.inc(data);break;
                case 2: allOne.dec(data);break;
                case 3:
                    Assert.assertTrue( set.contains(allOne.getMaxKey()));break;
                case 4:
                    Assert.assertTrue(set.contains(allOne.getMinKey()));break;
            }
        }
        Assert.assertNotNull(allOne);

    }
}
