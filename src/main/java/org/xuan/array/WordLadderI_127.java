package org.xuan.array;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xzhou2 on 12/18/16.
 */
public class WordLadderI_127 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        int steps = 0;
        wordList.remove(beginWord);
        wordList.add(endWord);
        char[] arr;
        Queue<String> queue = new  ArrayDeque<>();
        queue.offer(beginWord);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                arr = word.toCharArray();
                for(int j = 0; j < arr.length; j++) {
                    char ori = arr[j];
                    for(int k = 0; k < 26; k++) {
                        if (ori != 'a' + k) {
                            arr[j] = (char)('a' + k);
                            String curr = new String(arr);
                            if(curr.equals(endWord)) {
                                return steps + 2;
                            }
                            if (wordList.contains(curr)) {
                                queue.offer(curr);
                                wordList.remove(curr);
                            }
                        }
                    }
                    arr[j] = ori;
                }
            }
            steps++;
        }
        return 0;
    }
}
