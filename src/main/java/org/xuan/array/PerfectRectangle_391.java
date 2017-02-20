package org.xuan.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 2/18/17.
 */
public class PerfectRectangle_391 {
    public boolean isRectangleCover(int[][] rectangles) {
        long accumulatedArea = 0;
        Set<Point> points = new HashSet<>();
        for(int[] p : rectangles) {
            Point[] corners = new Point[] {
                    new Point(p[0], p[1]), new Point(p[0], p[3]), new Point(p[2], p[1]), new Point(p[2], p[3])
            };
            accumulatedArea += (corners[3].x - corners[0].x) * (corners[3].y - corners[0].y);
            for(Point c : corners) {
                if (points.contains(c)) {
                    points.remove(c);
                } else {
                    points.add(c);
                }
            }
        }
        if (points.size() != 4) {
            return false;
        }
        long minX = Integer.MAX_VALUE,
                minY = Integer.MAX_VALUE,
                maxX = Integer.MIN_VALUE,
                maxY = Integer.MIN_VALUE;
        for(Point p : points) {
            minX = Math.min(minX, p.x);
            maxX = Math.max(maxX, p.x);
            minY = Math.min(minY, p.y);
            maxY = Math.max(maxY, p.y);
        }
        return (maxX - minX) * (maxY - minY) == accumulatedArea;
    }


    private class Point {
        long x, y;
        public Point(int _x, int _y) {
            this.x = (long)_x;
            this.y = (long)_y;
        }

        @Override
        public boolean equals(Object that) {
            if (that == this) {
                return true;
            }
            if (that == null) {
                return false;
            }
            if (that instanceof Point) {
                Point t = (Point)that;
                return x == t.x && y == t.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (int)(31 * x + y);
        }
    }
}
