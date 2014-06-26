package org.suggs.sandbox.algorithms.unionfind;


import static org.suggs.sandbox.algorithms.unionfind.InitialisedArrayBuilder.anInitialisedArray;

public class QuickUnion implements UnionFind {

    private final int[] nodeArray;

    public QuickUnion(int numberOfNodes) {
        nodeArray = anInitialisedArray().ofLength(numberOfNodes).build();
    }

    @Override
    public void union(int p, int q) {
        int i = findRoot(p);
        nodeArray[i] = findRoot(q);
    }

    @Override
    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int id) {
        while (id != nodeArray[id]) {
            id = nodeArray[id];
        }
        return id;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nodeArray.length; i++) {
            builder.append(i).append(":").append(nodeArray[i]).append(" ");
        }
        return builder.toString();
    }
}
