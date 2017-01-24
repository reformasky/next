package org.xuan.array;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xzhou2 on 1/20/17.
 */
public class SelfCross_335 {
    public boolean isSelfCrossing(int[] x) {
        int[] start = new int[]{0,0}, end;
        Queue<Line> vQ = new ArrayDeque<>(3), hQ = new ArrayDeque<>(3);
        for(int i = 0; i < x.length; i++) {
            end = new int[2];
            if (i % 2 == 0) {
                end[0] = start[0];
                end[1] = start[1] + (i % 4 == 0 ? x[i] : -x[i]);
            } else {
                end[1] = start[1];
                end[0] = start[0] + (i % 4 == 1 ? -x[i] : x[i]);
            }
            if (i == 4 && end[0] == 0 && end[1] >= 0) {
                return true;
            }
            Line curr = new Line(start, end);
            if (i % 2 == 0) {
                if (hQ.size() > 2 && hQ.poll().cross(curr)) {
                    return true;
                }
                if (hQ.size() > 1 && hQ.peek().cross(curr)) {
                    return true;
                }
                vQ.offer(curr);
            } else {
                if (vQ.size() > 2 && vQ.poll().cross(curr)) {
                    return true;
                }
                if (vQ.size() > 1 && vQ.peek().cross(curr)) {
                    return true;
                }
                hQ.offer(curr);
            }
            start = end;
        }
        return false;

    }

    private class Line{
        int x1, y1, x2, y2;
        public Line(int[] start, int[] end) {
            this(start[0], start[1], end[0], end[1]);
        }

        public Line(int _x1, int _y1, int _x2, int _y2) {
            if (_x1 == _x2) {
                x1 = _x1;
                x2 = _x2;
                y1 = Math.min(_y1, _y2);
                y2 = Math.max(_y1, _y2);
            } else {
                x1 = Math.min(_x1, _x2);
                x2 = Math.max(_x1, _x2);
                y1 = _y1;
                y2 = _y2;
            }
        }

        private boolean isVertical() {
            return x1 == x2;
        }

        public boolean cross(Line that) {
            boolean res;
            if (isVertical()) {
                res =  that.y1 >= y1 && that.y2 <= y2 && that.x1 <= x1 && that.x2 >= x2;
            } else {
                res =  that.x1 >= x1 && that.x2 <= x2 && that.y1 <= y1 && that.y2 >= y2;
            }
            return res;
        }
    }
}
