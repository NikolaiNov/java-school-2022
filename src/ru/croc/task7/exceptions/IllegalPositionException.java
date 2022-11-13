package ru.croc.task7.exceptions;

public class IllegalPositionException extends RuntimeException {
    public IllegalPositionException(char x, char y) {
        super("Invalid position of chess piece: " + x + y);
    }

    public IllegalPositionException(String string) {
        super("Invalid position of chess piece: " + string);
    }
}
