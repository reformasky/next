package org.xuan.strings;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xzhou2 on 12/2/16.
 */
public class GroupAnagram2_49Test {

    @Test
    public void test() {
        GroupAnagrams_49 groupAnagrams_49 = new GroupAnagrams_49();
        List<List<String>> res = groupAnagrams_49.groupAnagrams(new String[]{"",""});
        Assert.assertEquals(res.size(), 1);
    }
}
