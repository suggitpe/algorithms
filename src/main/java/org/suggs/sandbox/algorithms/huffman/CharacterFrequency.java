package org.suggs.sandbox.algorithms.huffman;

public class CharacterFrequency implements Comparable<CharacterFrequency> {
    private Character character;
    private int frequency = 1;

    public CharacterFrequency(Character aCharacter) {
        character = aCharacter;
    }

    public CharacterFrequency(String aCodedCharacterFrequency) {
        character = getCharacterFrom(aCodedCharacterFrequency);
        frequency = getFrequencyFrom(aCodedCharacterFrequency);
    }

    private char getCharacterFrom(String aCodedCharacterFrequency) {
        return aCodedCharacterFrequency.charAt(0);
    }

    private Integer getFrequencyFrom(String aCodedCharacterFrequency) {
        return Integer.valueOf(aCodedCharacterFrequency.substring(2, aCodedCharacterFrequency.length()));
    }

    public void increaseFrequency() {
        frequency++;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return new String(character.toString()) + frequency;
    }

    @Override
    public int compareTo(CharacterFrequency otherCharacterFrequency) {
        if (otherCharacterFrequency.frequency > frequency) {
            return -1;
        } else if (otherCharacterFrequency.frequency < frequency) {
            return 1;
        } else if (otherCharacterFrequency.character.equals(character)) {
            return 0;
        } else {
            return otherCharacterFrequency.character > character ? -1 : 1;
        }
    }
}
