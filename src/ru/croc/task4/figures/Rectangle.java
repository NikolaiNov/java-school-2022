package ru.croc.task4.figures;

public class Rectangle extends Figure {
    private Point a;
    private Point b;

    public Rectangle(Point a, Point b) {
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

    @Override
    public String toString() {
        return "Rectangle (" + this.getA().getX() + ", " + this.getA().getY() + "), (" + this.getB().getX() + ", " + this.getB().getY() + ")";
    }
}
