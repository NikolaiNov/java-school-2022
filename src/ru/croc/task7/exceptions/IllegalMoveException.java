package ru.croc.task7.exceptions;

import ru.croc.task7.entities.ChessPosition;

public class IllegalMoveException extends Exception {
    public IllegalMoveException(ChessPosition position1, ChessPosition position2) {
        super("Horse can't make this move: " + position1 + "->" + position2);
    }
}
