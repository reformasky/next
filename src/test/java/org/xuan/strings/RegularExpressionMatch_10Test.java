package org.xuan.strings;

import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 11/16/16.
 */
public class RegularExpressionMatch_10Test {
    RegularExpressionMatch_10 r = new RegularExpressionMatch_10();
    @Test
    public void test(){
        String s = "aaabbcb";
        String p = ".*c.*";
        Assert.assertTrue(r.isMatch(s,p));
    }
}
