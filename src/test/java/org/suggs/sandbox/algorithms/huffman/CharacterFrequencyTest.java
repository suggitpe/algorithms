package org.suggs.sandbox.algorithms.huffman;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterFrequencyTest {

    @Test
    public void canBeComparedAgainstALesserFrequency() {
        assertThat(new CharacterFrequency("A:1").compareTo(new CharacterFrequency("B:2"))).isEqualTo(-1);
    }

    @Test
    public void canBeComparedAgainstTheSameFrequencyButALesserCharacter() {
        assertThat(new CharacterFrequency("A:1").compareTo(new CharacterFrequency("B:1"))).isEqualTo(-1);
    }

    @Test
    public void canBeComparedAgainstAGreaterFrequency() {
        assertThat(new CharacterFrequency("B:2").compareTo(new CharacterFrequency("A:1"))).isEqualTo(1);
    }

    @Test
    public void canBeComparedAgainstTheSameFrequencyButAGreaterCharacter() {
        assertThat(new CharacterFrequency("B:1").compareTo(new CharacterFrequency("A:1"))).isEqualTo(1);
    }

    @Test
    public void canBeComparedAgainstATheSameFrequency() {
        assertThat(new CharacterFrequency("A:1").compareTo(new CharacterFrequency("A:1"))).isEqualTo(0);
    }


}