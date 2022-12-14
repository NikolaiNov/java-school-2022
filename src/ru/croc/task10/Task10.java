package ru.croc.task10;

import ru.croc.task10.entities.Auction;
import ru.croc.task10.entities.AuctioneerThread;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        LocalDateTime auctionEnd = LocalDateTime.now().plus(10, ChronoUnit.SECONDS);
        Auction auction = new Auction(0, auctionEnd);
        Thread[] auctioneerThreads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            auctioneerThreads[i] = new Thread(new AuctioneerThread(auction, "Auctioneer " + i, 0, i));
        }
        for (int i = 0; i < 100; i++) {
            auctioneerThreads[i].start();
        }
        while (auctionEnd.isAfter(LocalDateTime.now())) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i < 100; i++) {
            auctioneerThreads[i].interrupt();
        }
        System.out.println(auction.getWinner());
    }
}
