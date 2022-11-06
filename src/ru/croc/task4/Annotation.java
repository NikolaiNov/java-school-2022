package ru.croc.task4;

import ru.croc.task4.figures.Figure;

public class Annotation {
    private Figure figure;
    private String description;

    public Annotation(Figure figure, String description) {
        this.setFigure(figure);
        this.setDescription(description);
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return figure.toString() + ": " + this.getDescription();
    }
}
