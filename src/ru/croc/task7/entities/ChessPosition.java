package ru.croc.task7.entities;

import ru.croc.task7.exceptions.IllegalPositionException;

public class ChessPosition {
    private byte x;
    private byte y;

    public ChessPosition(char x, char y) throws IllegalPositionException {
        if (!(x >= 'a' && x <= 'h') || !(y >= '1' && y <= '8')) {
            throw new IllegalPositionException(x, y);
        }
        this.x = (byte) (x - 97);
        this.y = (byte) (y - 49);
    }

    public static boolean isCorrectPosition(String position) {
        char x = position.charAt(0);
        char y = position.charAt(1);
        if ((x >= 'a' && x <= 'h') && (y >= '1' && y <= '8')) {
            return true;
        }
        return false;
    }

    public static ChessPosition parse(String position) throws IllegalPositionException {
        if (position.length() != 2) {
            throw new IllegalPositionException(position);
        }
        return new ChessPosition(position.charAt(0), position.charAt(1));
    }

    public static int deltaX(ChessPosition position1, ChessPosition position2) {
        return position2.x - position1.x;
    }

    public static int deltaY(ChessPosition position1, ChessPosition position2) {
        return position2.y - position1.y;
    }

    @Override
    public String toString() {
        return String.valueOf((char) (x + 97)) + (char) (y + 49);
    }
}
