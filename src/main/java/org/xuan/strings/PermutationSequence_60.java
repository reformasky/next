package org.xuan.strings;

/**
 * Created by xzhou2 on 12/6/16.
 */
public class PermutationSequence_60 {
    public String getPermutation(int n, int k) {
        k -= 1;
        int[] cache = new int[n];
        cache[0] = 1;
        for(int i = 1; i < n; i++) {
            cache[i] = i * cache[i - 1];
        }
        char[] arr = new char[n];
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            int index = k / cache[n - i - 1];
            int val = findVal(index, visited);
            arr[i] = (char)(val + '1');
            visited[val] = true;
            k %= cache[n - i - 1];
        }
        return new String(arr);
    }

    private int findVal(int index, boolean[] visited) {
        int count = 0;
        for(int i = 0; i < visited.length; i++) {
            if (!visited[i] && count++ == index) {
                return i;
            }
        }
        throw new RuntimeException();
    }
}
