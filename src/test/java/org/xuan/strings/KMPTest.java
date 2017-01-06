package org.xuan.strings;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by xzhou2 on 1/3/17.
 */
public class KMPTest {
    @Test
    public void test() {
        Random random = new Random();
        StringBuilder sb1 = new StringBuilder(),
                sb2 = new StringBuilder();
        for(int i = 0; i < 12; i++) {
            sb1.append(random.nextInt(2));
        }
        for(int i = 0; i <30000; i++) {
            sb2.append(random.nextInt(2));
        }

        String text = sb2.toString(), pattern = sb1.toString();
        System.out.println(text + "\n" + pattern);
        int res = KMP.match(text, pattern);
        if (res >=0) {
            Assert.assertEquals(res, text.indexOf(pattern));
        } else {
            Assert.assertFalse(text.contains(pattern));
        }
    }
}
