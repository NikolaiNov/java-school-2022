package ru.croc.task13;

import ru.croc.task13.entities.film.FilmsStorage;
import ru.croc.task13.entities.user.User;
import ru.croc.task13.entities.user.UsersStorage;
import ru.croc.task13.entities.ViewCounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("C:\\Users\\user\\IdeaProjects\\first\\src\\ru\\croc\\task13\\history.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        ViewCounter viewCounter = new ViewCounter(lines);
        UsersStorage usersStorage = new UsersStorage(lines);

        try {
            lines = Files.readAllLines(Paths.get("C:\\Users\\user\\IdeaProjects\\first\\src\\ru\\croc\\task13\\films.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        FilmsStorage filmsStorage = new FilmsStorage(lines);

        String line = in.nextLine();
        User mainUser = new User(line);

        TreeSet<Integer> recommendedFilms = mainUser.getRecommendedFilms(usersStorage, viewCounter);
        if (!recommendedFilms.isEmpty()) {
            try {
                System.out.println(filmsStorage.getFilmNameByNumber(recommendedFilms.first()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("[!] Check that you have given the number of an existing movie in the input data");
            }
        } else {
            System.out.println("Nothing to recommend");
        }
    }
}
