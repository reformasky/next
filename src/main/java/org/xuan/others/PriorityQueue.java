package org.xuan.others;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by xzhou2 on 4/3/17.
 */
public class PriorityQueue<E> {
    private Comparator<? super E> comparator;
    private static final int DEFAULT_SIZE = 11;

    private E[] values;
    private int size = 1;
    private int capacity;
    public PriorityQueue(int size) {
        this(size, null);
    }

    public PriorityQueue(Comparator<? super E> cmp) {
        this(DEFAULT_SIZE, cmp);
    }

    public PriorityQueue(int size, Comparator<? super E> cmp) {
        capacity = size;
        values = (E[]) (new Object[size]);
        comparator = cmp;
    }

    private void resize(int targetCapacity) {
        this.capacity = targetCapacity;
        E[] cp = (E[]) new Object[capacity];
        System.arraycopy(values, 0, cp, 0, size);
        values = cp;
    }

    public void offer(E curr) {
        if (size == capacity) {
            resize(2 * capacity);
        }
        values[size++] = curr;
        swim(size - 1);
    }

    public E poll() {
        E res = values[1];
        values[1] = values[size - 1];
        values[--size] = null;
        sink(1);
        return res;
    }

    public E peek() {
        return values[1];
    }

    public int size() {
        return size - 1;
    }



    private void swim(int index) {
        E curr = values[index];
        while(index > 1) {
            int parent = index / 2;
            if (cmp(curr, values[parent]) < 0) {
                values[index] = values[parent];
                index = parent;
            } else {
                break;
            }

        }
        values[index] = curr;
    }

    private void sink(int index) {
        E curr = values[index];
        while(index < size) {
            int left = 2 * index;
            int right = 2 * index + 1;
            if (left >= size) {
                break;
            } else if (right >= size) {
                if (cmp(curr, values[left]) > 0) {
                    values[index] = values[left];
                    index = left;
                } else {
                    break;
                }

            } else {
                E l = values[left], r = values[right];
                if (cmp(l, r) < 0) {
                    if (cmp(curr, l) > 0) {
                        values[index] = l;
                        index = left;
                    } else {
                        break;
                    }
                } else {
                    if (cmp(curr, r) > 0) {
                        values[index] = r;
                        index = right;
                    } else {
                        break;
                    }
                }
            }
        }
        values[index] = curr;
    }

    private int cmp(E a, E b) {
        return comparator.compare(a, b);
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5, (a, b) -> (a.compareTo(b)));
        Random random = new Random();
        for(int i = 0; i < 200; i++) {
            pq.offer(random.nextInt(1000));
        }

        while(pq.size() > 0) {
            System.out.println(pq.poll());
        }
    }
}