package ru.croc.task5.graphicObjects;

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

    public void move(double deltaX, double deltaY) {
        this.getCenter().move(deltaX, deltaY);
    }

    @Override
    public boolean findPoint(Point point) {
        return Double.compare(Math.pow(point.getX() - this.getCenter().getX(), 2) + Math.pow(point.getY() - this.getCenter().getY(), 2), Math.pow(this.getRadius(), 2)) <= 0;
    }

    @Override
    public String toString() {
        return "Circle (" + this.getCenter().getX() + ", " + this.getCenter().getY() + "), " + radius;
    }
}
