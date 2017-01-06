package org.xuan.array;

/**
 * Created by xzhou2 on 1/5/17.
 */
public class RectangleArea_223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int result = (C - A) * (D-B) + (G-E) * (H-F);
        int c1 = Math.max(A, E),
                c2 = Math.max(B, F),
                c3 = Math.min(C, G),
                c4 = Math.min(D, H);
        if (c1 >= c3 || c2 >= c4) {
            return result;
        }
        return result - (c3 - c1) * (c4 - c2);

    }
}
