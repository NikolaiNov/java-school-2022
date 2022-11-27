package ru.croc.task10.entities;

public class AuctioneerThread implements Runnable {
    private final Auction auction;
    private final String name;
    private long currentPrice;
    private final int deltaPrice;

    public AuctioneerThread(Auction auction, String name, int firstPrice, int deltaPrice) {
        this.auction = auction;
        this.name = name;
        this.currentPrice = firstPrice;
        this.deltaPrice = deltaPrice;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            currentPrice += deltaPrice;
            auction.makeBet(this.name, currentPrice);
        }
    }
}
