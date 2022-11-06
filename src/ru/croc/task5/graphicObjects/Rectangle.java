package ru.croc.task5.graphicObjects;

public class Rectangle extends Figure {
    private Point a;
    private Point b;

    public Rectangle(Point a, Point b) {
        if (a.equals(b) ||
                Double.compare(a.getX(), b.getX()) > 0 ||
                Double.compare(a.getY(), b.getY()) > 0) {
            throw new IllegalArgumentException("Incorrect positions of rectangle vertices.");
        }
        this.setA(a);
        this.setB(b);
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public void move(double deltaX, double deltaY) {
        this.getA().move(deltaX, deltaY);
        this.getB().move(deltaX, deltaY);
    }

    @Override
    public boolean findPoint(Point point) {
        return Double.compare(point.getX(), this.getA().getX()) >= 0 &&
                Double.compare(point.getX(), this.getB().getX()) <= 0 &&
                Double.compare(point.getY(), this.getA().getY()) >= 0 &&
                Double.compare(point.getY(), this.getB().getY()) <= 0;
    }

    @Override
    public String toString() {
        return "Rectangle (" + this.getA().getX() + ", " + this.getA().getY() + "), (" + this.getB().getX() + ", " + this.getB().getY() + ")";
    }
}
