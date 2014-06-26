package org.suggs.sandbox.algorithms.unionfind;


public class InitialisedArrayBuilder {

    private int length;

    private InitialisedArrayBuilder() {
    }

    public static final InitialisedArrayBuilder anInitialisedArray() {
        return new InitialisedArrayBuilder();
    }

    public InitialisedArrayBuilder ofLength(int aLength) {
        length = aLength;
        return this;
    }

    public int[] build() {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
        return array;
    }
}
