package org.xuan.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xzhou2 on 12/18/16.
 */
public class WordLadderII_128 {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        int steps = 1;
        boolean endFound = false;
        List<List<String>> result = new ArrayList<>();
        Set<String> toBeDeleted;
        Queue<String> queue = new ArrayDeque<>();
        Map<String, Set<String>> map = new HashMap<>();
        wordList.remove(beginWord);
        queue.offer(beginWord);
        while(!queue.isEmpty()) {
            int size = queue.size();
            toBeDeleted = new HashSet<>();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] arr = word.toCharArray();
                for(int j = 0; j < arr.length; j++) {
                    char ori = arr[j];
                    for(int k = 0; k < 26; k++) {
                        char curr = (char)(k + 'a');
                        if (curr != ori) {
                            arr[j] = curr;
                            String s = new String(arr);
                            if (s.equals(endWord)) {
                                endFound = true;
                                if (!map.containsKey(s)) {
                                    map.put(s, new HashSet<>());
                                }
                                map.get(s).add(word);

                            } else if ( wordList.contains(s)) {
                                if (!toBeDeleted.contains(s)) {
                                    queue.offer(s);
                                    toBeDeleted.add(s);
                                }
                                if (!map.containsKey(s)) {
                                    map.put(s, new HashSet<>());
                                }
                                map.get(s).add(word);

                            }

                        }
                    }
                    arr[j] = ori;
                }
            }
            steps++;
            if(endFound) {
                break;
            }
            for(String word : toBeDeleted) {
                wordList.remove(word);
            }
        }
        if (endFound) {
            String[] path = new String[steps];
            dfs(map, path, steps - 1, endWord, result);
        }
        return result;
    }

    private void dfs(Map<String, Set<String>> map, String[] path, int index, String to, List<List<String>> result) {

            path[index] = to;
            if (index == 0) {
                List<String> curr = new ArrayList<>(Arrays.asList(path));
                result.add(curr);
            } else {
                for(String s : map.get(to)) {
                    dfs(map, path, index - 1, s, result);
                }
            }
    }
}
