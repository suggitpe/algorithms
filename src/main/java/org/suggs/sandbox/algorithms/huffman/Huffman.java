package org.suggs.sandbox.algorithms.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Huffman {
    public int encode(String aStringToEncode) {
        return createHuffmanCodeUsing(anOrderedFrequencyStreamFrom(aStringToEncode));
    }

    private Stream<CharacterFrequency> anOrderedFrequencyStreamFrom(String aStringToEncode) {
        Map<Character, CharacterFrequency> mapOfCharFrequencies = new HashMap<>();
        aStringToEncode.chars().forEach(c -> updateCharacterFrequenciesMapWith(mapOfCharFrequencies, Character.valueOf((char) c)));
        return mapOfCharFrequencies.values().stream().sorted();
    }

    private void updateCharacterFrequenciesMapWith(Map<Character, CharacterFrequency> mapOfCharFrequencies, Character character) {
        if (!mapOfCharFrequencies.containsKey(character)) {
            mapOfCharFrequencies.put(character, new CharacterFrequency(character));
        } else {
            mapOfCharFrequencies.get(character).increaseFrequency();
        }
    }

    private int createHuffmanCodeUsing(Stream<CharacterFrequency> characterFrequenciesStream) {
        return 0;
    }
}
