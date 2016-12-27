package org.xuan.array;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.xuan.strings.StringMultiply_43;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xzhou2 on 12/18/16.
 */
public class WordLadderI_127test {
    WordLadderII_128 w = new WordLadderII_128();

    @Test
    public void test() {
        Set<String> wordList = new HashSet<>(Arrays.asList("hot","dog"));
        String beginWord = "hot", endWord = "dog";
        List<List<String>> res = w.findLadders(beginWord, endWord, wordList);
        Assert.assertEquals(res.size(), 2);
    }
}
