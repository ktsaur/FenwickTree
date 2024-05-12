package org.example;

import java.util.Arrays;

public class FenwickTree {
    int[] tree;
    int iterations;

    public FenwickTree(int size) {
        this.tree = new int[size + 1];
    }

    public void add(int index, int value) {
        for (int i = index + 1; i < tree.length; i += i & -i) {
            tree[i] += value;
            iterations++;
        }
    }

    public int sum(int index) {
        int result = 0;
        for (int i = index ; i != 0; i -= i & -i) {
            result += tree[i];
            iterations++;
        }
        return result;
    }

    public void delete(int i) {
        int value = sum(i) - sum(i - 1);
        add(i, -value);
    }

    public int sumRange(int left, int right) {
        return sum(right) - sum(left - 1);
    }

}
