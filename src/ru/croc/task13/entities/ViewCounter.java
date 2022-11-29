package ru.croc.task13.entities;

import java.util.HashMap;
import java.util.List;

public class ViewCounter {
    private final HashMap<Integer, Integer> filmViews;

    public ViewCounter(List<String> filmUsers) {
        int filmNumber;
        this.filmViews = new HashMap<>();
        for (String filmUser : filmUsers) {
            for (String film : filmUser.split(",")) {
                try {
                    filmNumber = Integer.parseInt(film);
                    if (!this.filmViews.containsKey(filmNumber)) {
                        this.filmViews.put(filmNumber, 0);
                    }
                    this.filmViews.put(filmNumber, this.filmViews.get(filmNumber) + 1);
                } catch (NumberFormatException e) {
                    System.out.println("[!] Incorrect input data format: \"" + film + "\". Ignore it.");
                }
            }
        }
    }

    public int getViewsByFilmNumber(int filmNumber) {
        if (!this.filmViews.containsKey(filmNumber)) {
            throw new IllegalArgumentException("Incorrect film number");
        }
        return this.filmViews.get(filmNumber);
    }
}
