package org.xuan.array;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xzhou2 on 12/8/16.
 */
public class FullyAdustString_68Test {
    FullAdjustStrings_68 obj = new FullAdjustStrings_68();

    @DataProvider(name = "data")
    public Object[][] data() {
        String[] arr = new String[]{"","","","","","","","","","","","","","","","",
                "1","2","3","123", "123456", "12345", "123456", "a", "abc", "abcd", "abcde"};
        return new Object[][] {
/*
                {arr, 6}, {arr, 7}, {arr, 8}, {arr, 9}, {arr, 10}, {arr, 14}, {arr, 15},
*/
                {arr, 19}
        };
    }

    @Test(dataProvider = "data")
    public void test(String[] arrr, int maxWidth) {
        List<String> res = obj.fullJustify(arrr, maxWidth);

        for(String s : res) {
            System.out.println(s.length() + " :" + s );
        }
    }
}
