package ru.croc.task4.graphicObjects;

public class Circle extends Figure {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        if (Double.compare(radius, 0.0) <= 0) {
            throw new IllegalArgumentException("Incorrect circle radius");
        }
        this.setCenter(center);
        this.setRadius(radius);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle (" + this.center.getX() + ", " + this.center.getY() + "), " + radius;
    }
}
