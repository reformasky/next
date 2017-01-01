package org.xuan.linkedlist;

/**
 * Created by xzhou2 on 12/30/16.
 */
public class CountPrime_204 {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] cache = new boolean[n];
        long prime = 2, factor = 1, prod;
        int result = 1;
        while((prod = (++factor) * prime) < n) {
            cache[(int)prod] = true;
        }
        prime = 3; factor = 1;
        while(prime < n) {
            if (! cache[(int)prime]) {
                result++;
                cache[(int)prime] = true;
                while((prod = (++factor) * prime) < n) {
                    cache[(int)prod] = true;
                }
            }
            prime += 2;
            factor = 1;
        }
        return result;
    }
}
