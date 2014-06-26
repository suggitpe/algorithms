package org.suggs.sandbox.algorithms.unionfind;

import static org.suggs.sandbox.algorithms.unionfind.InitialisedArrayBuilder.anInitialisedArray;

public class WeightedQuickUnion implements UnionFind {

    private final int[] nodeArray;
    private final int[] sizeArray;

    public WeightedQuickUnion(int numberOfNodes) {
        nodeArray = anInitialisedArray().ofLength(numberOfNodes).build();
    }

    @Override
    public void union(int p, int q) {
        int i = findRootOf(p);
        nodeArray[i] = findRootOf(q);
    }

    @Override
    public boolean connected(int p, int q) {
        return findRootOf(p) == findRootOf(q);
    }

    private int findRootOf(int node) {
        while (node != nodeArray[node]) {
            node = nodeArray[node];
        }
        return node;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nodeArray.length; i++) {
            builder.append(i).append(":").append(nodeArray[i]).append(" ");
        }
        return builder.toString();
    }
}
