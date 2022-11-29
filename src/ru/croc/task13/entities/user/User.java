package ru.croc.task13.entities.user;

import ru.croc.task13.entities.ViewCounter;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class User {
    private final HashSet<Integer> watchedFilms;
    private int filmsAmount;

    public User(String filmUser) {
        this.watchedFilms = new HashSet<>();
        for (String film : filmUser.split(",")) {
            try {
                this.watchedFilms.add(Integer.parseInt(film));
            } catch (NumberFormatException e) {
                System.out.println("[!] Incorrect input data format: \"" + film + "\". Ignore it.");
            }
        }
        this.filmsAmount = this.watchedFilms.size();
    }

    public HashSet<Integer> getWatchedFilms() {
        return this.watchedFilms;
    }

    public int getCommonFilmsNumber(HashSet<Integer> watchedFilms) {
        HashSet<Integer> intersection = new HashSet<>(watchedFilms);
        intersection.retainAll(this.watchedFilms);
        return intersection.size();
    }

    public int getFilmsAmount() {
        return this.filmsAmount;
    }

    @Override
    public String toString() {
        return watchedFilms.toString();
    }

    public TreeSet<Integer> getRecommendedFilms(UsersStorage usersStorage, ViewCounter viewCounter) {
        List<User> usersWithCommonFilms = usersStorage.getUsersByCommonFilms(this.watchedFilms);
        TreeSet<Integer> recomendedFilms = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer film1, Integer film2) {
                return -Integer.compare(viewCounter.getViewsByFilmNumber(film1), viewCounter.getViewsByFilmNumber(film2));
            }
        });
        for (User user : usersWithCommonFilms) {
            recomendedFilms.addAll(user.getWatchedFilms());
        }
        recomendedFilms.removeAll(this.watchedFilms);
        return recomendedFilms;
    }
}
