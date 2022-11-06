package ru.croc.task5.graphicObjects;

import ru.croc.task5.interfaces.Moveable;

public class Point implements Moveable {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void move(double deltaX, double deltaY) {
        this.setX(this.getX() + deltaX);
        this.setY(this.getY() + deltaY);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Point point = (Point) object;
        return Double.compare(point.getX(), this.getX()) == 0 &&
                Double.compare(point.getY(), this.getY()) == 0;
    }

    @Override
    public String toString() {
        return "Point (" + this.getX() + ", " + this.getY() + ")";
    }
}
