package org.xuan.array;

import org.xuan.tree.SymmetricTree_101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by xzhou2 on 3/6/17.
 */
public class ConcatenatedWords_472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie root = new Trie();
        for(String w : words) {
            root.addString(w);
        }
        root.isLeaf = false;

        Set<String> result = new HashSet<>(), total = new HashSet<>(Arrays.asList(words)), cache = new HashSet<>();
        total.remove("");
        for(String w : words) {
            helper(w, result, root, total, cache);
        }
        return new ArrayList<>(result);
    }


    private boolean helper(String w, Set<String> set, Trie root, Set<String> total, Set<String> cache) {
        if (cache.contains(w)) {
            return true;
        }
        Trie trie = root;
        for(int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (trie == null || trie.walk(c) == null) {
                return false;
            }
            trie = trie.walk(c);
            if (trie.isLeaf) {
                String next = w.substring(i + 1);
                if (total.contains(next) || helper(next, set, root, total, cache)) {
                    if (total.contains(w)) {
                        set.add(w);
                    }
                    cache.add(w);
                    return true;
                }
            }
        }
        return false;
    }

    class Trie{
        Trie[] next = new Trie[26];
        boolean isLeaf;

        public void addString(String s) {
            Trie trie = this;
            for(int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (trie.next[index] == null) {
                    trie.next[index] = new Trie();
                }
                trie = trie.next[index];
            }
            trie.isLeaf = true;
        }

        public boolean contains(String s) {
            Trie trie = this;
            for(int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (trie.next[index] == null) {
                    return false;
                }
                trie = trie.next[index];
            }
            return trie.isLeaf;
        }

        public Trie walk(char c) {
            return next[c - 'a'];
        }
    }

    public static void main(String[] args) {
        String[] strings = {"a", "ab","b","abcd", "cd",""};
        ConcatenatedWords_472 c = new ConcatenatedWords_472();
        List<String> res = c.findAllConcatenatedWordsInADict(strings);
        System.out.print(res.size());
    }
}
