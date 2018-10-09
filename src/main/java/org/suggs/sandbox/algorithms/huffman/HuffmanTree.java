package org.suggs.sandbox.algorithms.huffman;

import java.util.Queue;

class HuffmanTree implements Comparable<HuffmanTree> {
    private CharacterFrequency frequency;
    private HuffmanTree left;
    private HuffmanTree right;

    public static HuffmanTree aHuffmanTreeFrom(Queue<HuffmanTree> huffmanForest) {
        while (huffmanForest.size() > 1) {
            huffmanForest.add(new HuffmanTree(huffmanForest.remove(), huffmanForest.remove()));
        }
        return huffmanForest.remove();
    }

    public HuffmanTree(CharacterFrequency characterFrequency) {
        frequency = characterFrequency;
    }

    public HuffmanTree(HuffmanTree tree1, HuffmanTree tree2) {
        left = theLesserOf(tree1, tree2);
        right = theGreaterOf(tree1, tree2);
    }

    private HuffmanTree theGreaterOf(HuffmanTree tree1, HuffmanTree tree2) {
        if (tree1.compareTo(tree2) > 0) {
            return tree1;
        }
        return tree2;
    }

    private HuffmanTree theLesserOf(HuffmanTree tree1, HuffmanTree tree2) {
        if (tree1.compareTo(tree2) <= 0) {
            return tree1;
        }
        return tree2;
    }

    public int cumulativeFrequency() {
        if (thisIsALeafNode()) {
            return frequency.getFrequency();
        }
        return left.cumulativeFrequency() + right.cumulativeFrequency();
    }

    private boolean thisIsALeafNode() {
        return frequency != null
                && left == null
                && right == null;
    }

    @Override
    public int compareTo(HuffmanTree otherTree) {
        if (cumulativeFrequency() == otherTree.cumulativeFrequency()) {
            return 0;
        }
        return cumulativeFrequency() > otherTree.cumulativeFrequency() ? 1 : -1;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        appendEncodingTo(builder);
        return builder.toString();
    }

    private void appendEncodingTo(StringBuilder builder) {
        if(thisIsALeafNode()){
            //builder.
        }
    }

}

