package org.xuan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xzhou2 on 2/26/17.
 */
public class BeautifulArrangement_526 {
    int result = 0;
    public int countArrangement(int N) {
        @SuppressWarnings("unchecked")
        List<Integer>[] candidates = (List<Integer>[])new List[N];
        for(int i = 0; i < N; i++) {
            candidates[i] = new ArrayList<>(N);
            for(int j = 0; j < N; j++) {
                if ((j + 1) % (i + 1) == 0 || (i + 1) % (j + 1) == 0) {
                    candidates[i].add(j);
                }
            }
        }
        Arrays.sort(candidates, new Comparator<List>() {
            @Override
            public int compare(List a, List b) {
                return a.size() - b.size();
            }
        });
        boolean[] visited = new boolean[N];
        dfs(candidates, visited, 0);
        return result;
    }

    private void dfs(List<Integer>[] candidates, boolean[] visited, int index) {
        if (index >= visited.length) {
            result++;
        } else {
            for(Integer i : candidates[index]) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(candidates, visited, index + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
