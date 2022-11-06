package ru.croc.task4;

import ru.croc.task4.figures.Figure;
import ru.croc.task4.figures.Point;
import ru.croc.task4.figures.Circle;
import ru.croc.task4.figures.Rectangle;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Create a circle with center at (1;1) and radius 2:");
        Figure circle = new Circle(new Point(1, 1), 2);
        System.out.println(circle);
        System.out.println("Create a rectangle with vertices at (1, 2), (3,4):");
        Figure rectangle = new Rectangle(new Point(1, 2), new Point(3, 4));
        System.out.println(rectangle);

        System.out.println("Create an annotation for circle:");
        Annotation annotation1 = new Annotation(circle, "It is a circle");
        System.out.println(annotation1);
        System.out.println("Create an annotation for rectangle:");
        Annotation annotation2 = new Annotation(rectangle, "It is a rectangle");
        System.out.println(annotation2);

        // Create array of annotations
        Annotation[] annotations = {annotation1, annotation2};
        System.out.println("Create an annotated image:");
        AnnotatedImage annotatedImage = new AnnotatedImage("C:\\Users\\user\\Documents\\image.jpg", annotations);
        System.out.println(annotatedImage);
    }
}
