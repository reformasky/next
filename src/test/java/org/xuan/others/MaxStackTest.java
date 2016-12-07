package org.xuan.others;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 12/1/16.
 */
public class MaxStackTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        //0: push + val
        //1: peek + val
        //2: peekMax + val;
        //3: pop + val
        //4: popMax + val
        return new Object[][] {
                {
                        new int[][]{
                                new int[]{0, 5}, new int[]{1,5},
                                new int[]{0, 1}, new int[]{1, 1}, new int[]{2,5},
                                new int[]{0, 4}, new int[]{1, 4}, new int[]{2, 5},
                                new int[]{0, 7}, new int[]{1, 7}, new int[]{2, 7},
                                new int[]{0, 6 },new int[]{1, 6}, new int[]{2, 7},
                                new int[]{4, 7}, new int[]{1, 6}, new int[]{2,6}
                        }
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(int[][] data) {
        MaxStack maxStack = new MaxStack();
        for(int[] d : data) {
            switch (d[0]) {
                case 0: maxStack.push(d[1]);break;
                case 1:
                    Assert.assertEquals(maxStack.peek(), d[1], d[0] + " " + d[1]);break;
                case 2:
                    Assert.assertEquals(maxStack.max(), d[1], d[0] + " " + d[1]);break;
                case 3:
                    Assert.assertEquals(maxStack.pop(), d[1], d[0] + " " + d[1]);break;
                case 4:
                    Assert.assertEquals(maxStack.popMax(), d[1], d[0] + " " + d[1]);break;

            }
        }
    }
}
