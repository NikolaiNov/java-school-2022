package ru.croc.task3;

import java.util.Scanner;

public class Task3 {
    static class Point {
        double x;
        double y;

        public void Put(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double p = 0;
        double s = 0;

        double ab = 0;
        double bc = 0;
        double ac = 0;

        Point a = new Point();
        a.Put(scanner.nextDouble(), scanner.nextDouble());

        Point b = new Point();
        b.Put(scanner.nextDouble(), scanner.nextDouble());

        Point c = new Point();
        c.Put(scanner.nextDouble(), scanner.nextDouble());

        ab = Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
        bc = Math.sqrt(Math.pow((b.x - c.x), 2) + Math.pow((b.y - c.y), 2));
        ac = Math.sqrt(Math.pow((a.x - c.x), 2) + Math.pow((a.y - c.y), 2));
        p = (ab + bc + ac) / 2;
        s = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));

        System.out.print("Площадь треугольника: " + Math.round(s));
    }
}
