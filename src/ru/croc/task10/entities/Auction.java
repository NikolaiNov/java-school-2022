package ru.croc.task10.entities;

import java.time.LocalDateTime;

public class Auction {
    private long currentPrice;
    private String name;
    private final LocalDateTime endTime;

    public Auction(int beginPrice, LocalDateTime endTime) {
        this.currentPrice = beginPrice;
        this.name = "-";
        this.endTime = endTime;
    }

    public void makeBet(String name, long newPrice) {
        if (this.currentPrice < newPrice && endTime.isBefore(LocalDateTime.now())) {
            this.name = name;
            this.currentPrice = newPrice;
        }
    }

    public String getWinner() {
        return "Name: " + this.name + " | Price: " + this.currentPrice;
    }
}
