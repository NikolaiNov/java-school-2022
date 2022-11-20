package ru.croc.task9;

import static ru.croc.task9.Hasher.hashPassword;

public class EnumerationThread implements Runnable {
    private static volatile boolean passwordFound = false;
    final private int threadNumber;
    final private int threadsAmount;
    final private char[] alphabet;
    final private int wordLength;
    final private long wordAmount;
    final private String destinationHash;

    public EnumerationThread(int threadNumber, int threadsAmount, char[] alphabet, int wordLength, String destinationHash) {
        this.threadNumber = threadNumber;
        this.threadsAmount = threadsAmount;
        this.alphabet = alphabet;
        this.wordLength = wordLength;
        this.wordAmount = (long) Math.pow(alphabet.length, wordLength);
        this.destinationHash = destinationHash;
    }

    public void run() {
        long beginWord = (this.threadNumber * this.wordAmount) / this.threadsAmount;
        long endWord = ((this.threadNumber + 1) * this.wordAmount) / this.threadsAmount;
        SortedWords sortedWords = new SortedWords(this.wordLength, alphabet);
        String word;
        for (long i = beginWord; i < endWord && !passwordFound; i++) {
            word = sortedWords.decodeByPosition(i);
            if (hashPassword(word).equals(destinationHash)) {
                System.out.println(word);
                passwordFound = true;
            }
        }
    }
}
