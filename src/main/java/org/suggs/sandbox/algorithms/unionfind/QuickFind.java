package org.suggs.sandbox.algorithms.unionfind;

public class QuickFind implements UnionFind {

    private final int[] intArray;

    public QuickFind(int n) {
        intArray = new int[n];
        initialiseArray(n);
    }

    private void initialiseArray(int n) {
        for(int i = 0; i < n; i++){
            intArray[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int checker = intArray[p];
        for(int i = 0; i < intArray.length; i++){
            if( intArray[i] == checker ){
                intArray[i] = intArray[q];
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        if (intArray[p] == intArray[q]) {
            return true;
        }
        return false;
    }

    public String dumpArray(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < intArray.length; i++){
            builder.append(i).append(":").append(intArray[i]).append(" ");
        }
        return builder.toString();
    }
}
