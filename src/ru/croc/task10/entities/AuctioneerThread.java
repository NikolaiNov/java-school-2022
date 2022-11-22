package ru.croc.task10.entities;

import java.util.concurrent.locks.ReentrantLock;

public class AuctioneerThread implements Runnable {
    private final ReentrantLock locker;
    private final Auction auction;
    private final String name;
    private long currentPrice;
    private final int deltaPrice;

    public AuctioneerThread(ReentrantLock locker, Auction auction, String name, int firstPrice, int deltaPrice) {
        this.locker = locker;
        this.auction = auction;
        this.name = name;
        this.currentPrice = firstPrice;
        this.deltaPrice = deltaPrice;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            currentPrice += deltaPrice;
            locker.lock();
            try {
                auction.makeBet(this.name, currentPrice);
            } finally {
                locker.unlock();
            }
        }
    }
}
