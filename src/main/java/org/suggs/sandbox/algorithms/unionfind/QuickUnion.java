package org.suggs.sandbox.algorithms.unionfind;


public class QuickUnion implements UnionFind {

    private final int[] intArray;

    public QuickUnion(int n) {
        intArray = new int[n];
        initialiseArray(n);
    }

    private void initialiseArray(int n) {
        for (int i = 0; i < n; i++) {
            intArray[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {

    }

    @Override
    public boolean connected(int p, int q) {
        return false;
    }
}
