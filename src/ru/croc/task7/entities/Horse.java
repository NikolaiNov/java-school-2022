package ru.croc.task7.entities;

import ru.croc.task7.exceptions.IllegalMoveException;
import ru.croc.task7.exceptions.IllegalPositionException;

public class Horse {
    ChessPosition position;

    public Horse() {
    }

    public Horse(String position) throws IllegalArgumentException, IllegalPositionException {
        this.position = ChessPosition.parse(position);
    }

    public void MoveTo(String endPosition) throws IllegalMoveException, IllegalPositionException {
        if (this.position != null) {    // если задана начальная позиция
            ChessPosition position2 = ChessPosition.parse(endPosition);
            int deltaX = ChessPosition.deltaX(this.position, position2);
            int deltaY = ChessPosition.deltaY(this.position, position2);
            if ((Math.abs(deltaX) == 1 && Math.abs(deltaY) == 2) || (Math.abs(deltaX) == 2 && Math.abs(deltaY) == 1)) {
                this.position = position2;
            } else {
                throw new IllegalMoveException(this.position, position2);
            }
        } else {    // если начальная позиция еще не задана, то переставляем фигуру в указанную позицию
            this.position = ChessPosition.parse(endPosition);
        }
    }
}
