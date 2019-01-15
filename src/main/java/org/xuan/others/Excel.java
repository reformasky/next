package org.xuan.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by xzhou2 on 6/26/17.
 */
public class Excel {
    Cell[][] cells;
    public Excel(int H, char W) {
        this.cells = new Cell[H + 1][W - 'A' + 1];
        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new Cell(i + 1, (char)(j + 'A'));
            }
        }
    }

    public void set(int r, char c, int v) {
        cells[r - 1][c - 'A'].set(v, true);
    }

    public int get(int r, char c) {
        return cells[r - 1][c - 'A'].val;
    }

    public int sum(int r, char c, String[] strs) {
        return cells[r-1][c - 'A' ].sum(strs);
    }

    private class Cell{
        int h;
        char w;
        int val;
        Map<Cell, Integer> subscriptions;
        Set<Cell> observing;

        public Cell(int h, char w) {
            this.h = h;
            this.w = w;
            this.val = 0;
            this.subscriptions = new HashMap<>();
            this.observing = new HashSet<>();
        }

        public void set(int val, boolean reset) {
            if (reset) {
                resetObserving();
            }
            int diff = val - this.val;
            this.val = val;
            for(Map.Entry<Cell, Integer> entry : subscriptions.entrySet()) {
                Cell key = entry.getKey();
                int count = entry.getValue();
                key.set(key.val + count * diff, false);
            }
        }

        public int sum(String[] strs) {
            resetObserving();
            int sum = 0;
            for(String str : strs) {
                if (str.contains(":")) {
                    String[] tokens = str.split(":");
                    for(int c = tokens[0].charAt(0); c <= tokens[1].charAt(0); c++) {
                        for(int i = Integer.parseInt(tokens[0].substring(1)); i <= Integer.parseInt(tokens[1]
                                .substring(1)); i++) {
                            Cell cell = cells[i  -1][c - 'A'];
                            sum += cell.val;
                            cell.addSubscription(this);
                            this.observing.add(cell);
                        }
                    }
                } else {
                    Cell cell = cells[str.charAt(1) - '0' - 1][str.charAt(0) - 'A' ];
                    sum += cell.val;
                    cell.addSubscription(this);
                    this.observing.add(cell);
                }
            }
            this.set(sum, false);
            return sum;
        }

        private void resetObserving() {
            for(Cell cell : this.observing) {
                cell.subscriptions.remove(this);
            }
            this.observing = new HashSet<>();
        }

        private void addSubscription(Cell subscription) {
            this.subscriptions.put(subscription, subscriptions.getOrDefault(subscription, 0) + 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return Objects.equals(h, cell.h) &&
                    Objects.equals(w, cell.w);
        }

        @Override
        public int hashCode() {
            return Objects.hash(h, w);
        }
    }

    public static void main(String[] args) {
        /*Excel excel = new Excel(5, 'E');

        *//*
        ["Excel","set","set","set","sum","get","set","get","sum","set","get","get","sum","set","get","get","get","get"]
[[5,"E"],[1,"A",5],[1,"B",3],[1,"C",2],[1,"C",["A1","A1:B1"]],[1,"C"],[1,"B",5],[1,"C"],[1,"B",["A1:A5"]],[5,"A",10],[1,"B"],[1,"C"],[3,"C",["A1:C1","A1:A5"]],[3,"A",3],[1,"B"],[1,"C"],[3,"C"],[5,"A"]]
         *//*

        excel.set(1, 'A', 5);
        excel.set(1, 'B',3);
        excel.set(1, 'C',2);
        System.out.println(excel.sum(1, 'C', new String[]{"A1", "A1:B1"}));

        System.out.println(excel.get(1, 'C'));
        excel.set(1, 'B', 5);
        System.out.println(excel.get(1, 'C'));


        System.out.println(excel.sum(1, 'B', new String[]{"A1:A5"}));
        excel.set(5, 'A', 10);
        System.out.println(excel.sum(1, 'B', new String[]{"A1:A5"}));
        System.out.println(excel.get(1, 'C'));
*/

        Excel excel = new Excel(26, 'Z');
        excel.set(1, 'A', 1);
        excel.set(1, 'I', 1);
        System.out.println(excel.sum(7, 'D', new String[]{"A1:D6","A1:G3","A1:C12"}));
        System.out.println(excel.sum(10, 'G', new String[]{"D1:F10","D3:I8","I1:I9"}));

    }
}
