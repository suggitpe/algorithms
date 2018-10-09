package org.suggs.sandbox.algorithms.huffman;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static org.assertj.core.api.Assertions.assertThat;
import static org.suggs.sandbox.algorithms.huffman.HuffmanTree.aHuffmanTreeFrom;

public class HuffmanTreeTest {

    @Test
    public void canAddASingleFrequency() {
        Queue<HuffmanTree> huffmanForest = createPriorityQueueOfCharacterFrequenciesFrom("A:1");
        assertThat(aHuffmanTreeFrom(huffmanForest).cumulativeFrequency()).isEqualTo(1);
    }

    @Test
    public void canAddTwoFrequenciesAndGetACumulativeFrequency() {
        Queue<HuffmanTree> huffmanForest = createPriorityQueueOfCharacterFrequenciesFrom("A:1", "B:1");
        assertThat(aHuffmanTreeFrom(huffmanForest).cumulativeFrequency()).isEqualTo(2);
    }

    @Test
    public void canAddGreaterFrequenciesToCreateACumulativeFrequency() {
        Queue<HuffmanTree> huffmanForest = createPriorityQueueOfCharacterFrequenciesFrom("A:4", "B:3");
        assertThat(aHuffmanTreeFrom(huffmanForest).cumulativeFrequency()).isEqualTo(7);
    }

    @Test
    public void canAddThreeFrequenciesAndGetACumulativeFrequency() {
        Queue<HuffmanTree> huffmanForest = createPriorityQueueOfCharacterFrequenciesFrom("A:3", "B:2", "C:1");
        assertThat(aHuffmanTreeFrom(huffmanForest).cumulativeFrequency()).isEqualTo(6);
    }

    @Test
    public void canBeConvertedIntoAString(){
        Queue<HuffmanTree> huffmanForest = createPriorityQueueOfCharacterFrequenciesFrom("A:3", "B:2", "C:1");
        //assertThat(aHuffmanTreeFrom(huffmanForest).toString()).isEqualTo();
    }

    private Queue<HuffmanTree> createPriorityQueueOfCharacterFrequenciesFrom(String... someCharacterFrequencies) {
        return Stream.of(someCharacterFrequencies).map(cf -> new HuffmanTree(new CharacterFrequency(cf))).collect(toCollection(() -> new PriorityQueue<HuffmanTree>()));
    }

}