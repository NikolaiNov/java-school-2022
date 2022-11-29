package ru.croc.task13.entities.film;

import java.util.*;

public class FilmsStorage {
    private final HashMap<Integer, String> films;

    public FilmsStorage(List<String> dataFilms) {
        this.films = new HashMap<>();

        int filmNumber;
        String filmName;
        String[] parsedFilmData;

        for (String dataFilm : dataFilms) {
            try {
                parsedFilmData = dataFilm.split(",");
                filmNumber = Integer.parseInt(parsedFilmData[0]);
                filmName = parsedFilmData[1];
                this.films.put(filmNumber, filmName);
            } catch (NumberFormatException e) {
                System.out.println("[!] Incorrect input data format: \"" + dataFilm + "\". Ignore it.");
            }
        }
    }

    public String getFilmNameByNumber(int filmNumber) throws IllegalArgumentException {
        if (!this.films.containsKey(filmNumber)) {
            throw new IllegalArgumentException("Incorrect film number");
        }
        return this.films.get(filmNumber);
    }
}
