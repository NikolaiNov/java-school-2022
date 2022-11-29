package ru.croc.task13.entities.user;

import java.util.*;

public class UsersStorage {
    private final ArrayList<User> users;
    private int usersAmount;

    public UsersStorage(List<String> filmUsers) {
        this.users = new ArrayList<>();
        for (String filmUser : filmUsers) {
            this.users.add(new User(filmUser));
            this.usersAmount++;
        }
    }

    public int getUsersAmount() {
        return this.usersAmount;
    }

    public User getUserByNumber(int userNumber) {
        return this.users.get(userNumber);
    }

    public List<User> getUsersByCommonFilms(HashSet<Integer> filmsToSearch) {
        List<User> usersWithCommonFilms = new ArrayList<>();
        for (User user : this.users) {
            if (user.getCommonFilmsNumber(filmsToSearch) >= (user.getFilmsAmount() / 2)) {
                usersWithCommonFilms.add(user);
            }
        }
        return usersWithCommonFilms;
    }
}
