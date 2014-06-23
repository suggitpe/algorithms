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
        int i = findRoot(p);
        intArray[i] = findRoot(q);
    }

    @Override
    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int id) {
        while (id != intArray[id]) {
            id = intArray[id];
        }
        return id;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            builder.append(i).append(":").append(intArray[i]).append(" ");
        }
        return builder.toString();
    }
}
