package org.xuan.others;

/**
 * Created by xzhou2 on 1/1/17.
 */


public class Trie {
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
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String s) {
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

    private TrieNode findNode(String s) {
        TrieNode node = root;
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (node.trieNodes[index] == null) {
                return null;
            }
            node = node.trieNodes[index];
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isLeave;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }
}