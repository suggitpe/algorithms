package org.suggs.sandbox.algorithms.huffman;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HuffmanTest {

    @Test
    public void createsHuffmanCode(){
        Huffman huffman = new Huffman();
        assertThat(huffman.encode("AAAAABBBBCCCCDDE")).isEqualTo(0x876876);
    }


}
