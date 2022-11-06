package ru.croc.task5.entities;

import ru.croc.task5.graphicObjects.Figure;
import ru.croc.task5.graphicObjects.Point;

public class Annotation {
    private Figure figure;
    private String description;

    public Annotation(Figure figure, String description) {
        this.setFigure(figure);
        this.setDescription(description);
    }

    public boolean findPoint(Point point) {
        return this.getFigure().findPoint(point);
    }

    public boolean findLabel(String label) {
        return this.getDescription().contains(label);
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
