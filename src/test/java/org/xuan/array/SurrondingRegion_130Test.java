package org.xuan.array;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 12/18/16.
 */
public class SurrondingRegion_130Test {
    @Test
    public void test(){
        String[] strs = new String[]{
                "XOXX","OXOX","XOXO","OXOX","XOXO","OXOX"
        };
        char[][] board = new char[strs.length][strs[0].length()];
        for(int i = 0; i < strs.length; i++) {
            board[i] = strs[i].toCharArray();
        }
        SurroundingRegion_130 s = new SurroundingRegion_130();
        s.solve(board);
        Assert.assertNotNull(board);
    }
}
