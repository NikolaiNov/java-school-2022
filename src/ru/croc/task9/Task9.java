package ru.croc.task9;

public class Task9 {
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        // The answer is "passwrd"
        int threadsAmount = Integer.parseInt(args[0]);
        String destinationHash = args[1];
        Thread[] runningThreads = new Thread[threadsAmount];
        System.out.println("Starting " + threadsAmount + " threads, searching...");
        for (int i = 0; i < threadsAmount; i++) {
            runningThreads[i] = new Thread(new EnumerationThread(i, threadsAmount, alphabet, 7, destinationHash));
            runningThreads[i].start();
        }
        try {
            for (int i = 0; i < threadsAmount; i++)
                runningThreads[i].join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
