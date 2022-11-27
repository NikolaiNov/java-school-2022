package ru.croc.task10.entities;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class Auction {
    private long currentPrice;
    private String name;
    private final LocalDateTime endTime;
    private final ReentrantLock locker;

    public Auction(int beginPrice, LocalDateTime endTime) {
        this.currentPrice = beginPrice;
        this.name = "-";
        this.endTime = endTime;
        this.locker = new ReentrantLock();
    }

    public void makeBet(String name, long newPrice) {
        locker.lock();
        try {
            if (this.currentPrice < newPrice && endTime.isBefore(LocalDateTime.now())) {
                this.name = name;
                this.currentPrice = newPrice;
            }
        } finally {
            locker.unlock();
        }
    }

    public String getWinner() {
        return "Name: " + this.name + " | Price: " + this.currentPrice;
    }
}
