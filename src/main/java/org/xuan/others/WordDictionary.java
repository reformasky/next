package org.xuan.others;

/**
 * Created by xzhou2 on 1/2/17.
 */
public class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String s) {
        TrieNode node = root;
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (node.trieNodes[index] == null) {
                node.trieNodes[index] = new TrieNode();
            }
            node = node.trieNodes[index];
        }
        node.isLeave = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String s, int index, TrieNode node) {
        if (index == s.length()) {
            return node != null && node.isLeave;
        }
        if (node == null) {
            return false;
        }
        char c = s.charAt(index);
        if (c == '.') {
            for(TrieNode next : node.trieNodes) {
                if (search(s, index + 1, next)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.trieNodes[c - 'a'] != null) {
                return search(s, index + 1, node.trieNodes[c - 'a']);
            } else {
                return false;
            }
        }
    }

    class TrieNode {
        private static final int len = 26;
        // Initialize your data structure here.
        boolean isLeave;
        TrieNode[] trieNodes;
        public TrieNode() {
            isLeave = false;
            trieNodes = new TrieNode[26];
        }
    }
}