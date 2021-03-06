package org.suggs.sandbox.algorithms.unionfind;

import static org.suggs.sandbox.algorithms.unionfind.InitialisedArrayBuilder.anInitialisedArray;

public class QuickFind implements UnionFind {

    private final int[] nodeArray;

    public QuickFind(int numberOfNodes) {
        nodeArray = anInitialisedArray().ofLength(numberOfNodes).build();
    }

    @Override
    public void union(int p, int q) {
        int checker = nodeArray[p];
        for (int i = 0; i < nodeArray.length; i++) {
            if (nodeArray[i] == checker) {
                nodeArray[i] = nodeArray[q];
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        if (nodeArray[p] == nodeArray[q]) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nodeArray.length; i++) {
            builder.append(i).append(":").append(nodeArray[i]).append(" ");
        }
        return builder.toString();
    }
}
