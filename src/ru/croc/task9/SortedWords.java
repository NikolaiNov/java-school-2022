package ru.croc.task9;

public class SortedWords {
    final private int wordLength;
    final private char[] alphabet;
    final private int alphabetLength;

    SortedWords(int wordLength, char[] alphabet) {
        this.wordLength = wordLength;
        this.alphabet = alphabet;
        this.alphabetLength = alphabet.length;
    }

    String decodeByPosition(long position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.wordLength; i++) {
            stringBuilder.append(this.alphabet[(int) (position % this.alphabetLength)]);
            position /= this.alphabetLength;
        }
        return stringBuilder.toString();
    }
}
