package org.xuan.strings;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 11/18/16.
 */
public class ValidParanthesis19_test {
    ValidParanthesis_20 v = new ValidParanthesis_20();
    @Test
    public void test() {
        Assert.assertTrue(v.isValid("[]"));
    }
}
