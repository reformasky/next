package org.xuan.array;

import org.xuan.util.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou2 on 12/27/16.
 */
public class MaxPointsOnALine_149 {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }

        Comparator<Point> pointComparator = new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2) {
                return p1.x == p2.x ? p1.y - p2.y : p1.x - p2.x;
            }
        };

        Arrays.sort(points, pointComparator);
        int result = 2;
        Map<Integer, Set<Integer>> seen = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            seen.put(i, new HashSet<>());
        }
        Map<Slope, List<Integer>> map;
        for(int s = 0; s < points.length - 2; s++) {
            Point start = points[s], end;
            int base = 1;
            map = new HashMap<>();
            int e = s + 1;
            for(; e < points.length; e++) {
                end = points[e];
                if (end.x == start.x && end.y == start.y) {
                    base++;
                    s++;
                } else {
                    break;
                }
            }
            result = Math.max(result, base);
            for(;e < points.length; e++) {
                if (!seen.get(s).contains(e)) {
                    end = points[e];
                    Slope slope = new Slope(end.x - start.x, end.y - start.y);
                    if (!map.containsKey(slope)) {
                        map.put(slope, new ArrayList<>());
                    }
                    map.get(slope).add(e);
                }
            }
            for(List<Integer> list : map.values()) {
                result = Math.max(result, base + list.size());
                for(int i = 0; i < list.size() - 1; i++) {
                    for(int j = 1; j < list.size(); j++) {
                        map.get(list.get(i)).add(list.get(j));
                    }
                }
            }
        }
        return result;
    }


    class Slope {
        int dx, dy;
        public Slope(int x, int y) {
            if (x == 0 && y == 0) {
                dx = 0;
                dy = 0;
            } else if (x == 0) {
                dx = 0;
                dy = 1;
            } else if (y == 0) {
                dx = 1;
                dy = 0;
            } else {
                int gcd = gcd(x, y);
                dx = x / gcd;
                dy = y / gcd;
            }
        }

        private int gcd(int x, int y) {
            while(y != 0) {
                int r = x % y;
                x = y;
                y = r;
            }
            return x;
        }

        @Override
        public int hashCode() {
            return 31 * dx + dy;
        }

        @Override
        public boolean equals(Object that) {
            if (that instanceof Slope) {
                Slope s = (Slope) that;
                return s.dx == dx && s.dy == dy;
            }
            return false;
        }
    }
}
