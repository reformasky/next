package org.xuan.strings;

import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 11/22/16.
 */
public class SubStringConcatenation_30Test {
    SubStringConcatenation_30 obj = new SubStringConcatenation_30();
    @Test
    public void test() {
        String s = "barfoofoobarthefoobarman";
String[] words = new String[]{"bar","foo","the"};
        obj.findSubstring(s, words);
    }
}
