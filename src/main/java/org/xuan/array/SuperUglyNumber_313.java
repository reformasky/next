package org.xuan.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xzhou2 on 1/12/17.
 */
public class SuperUglyNumber_313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0 || primes.length == 0) {
            return 0;
        }
        int[] indexes = new int[primes.length];
        int[] result = new int[n];
        result[0] = 1;
        int index = 1;
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair i, Pair j) {
                return i.product - j.product;
            }
        });
        for(int i = 0; i < primes.length; i++) {
            queue.offer(new Pair(i, primes[i] * result[indexes[i]]));
        }

        while(index < n) {
            Pair pair = queue.poll();

            if (pair.product > result[index - 1]) {
                result[index++] = pair.product;
            }
            indexes[pair.index]++;
            queue.offer(new Pair(pair.index, primes[pair.index] * result[indexes[pair.index]]));
        }

        return result[n - 1];
    }

    private class Pair{
        int index;
        int product;

        public Pair(int i, int p) {
            index = i;
            product = p;
        }
    }
}
