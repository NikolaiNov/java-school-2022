package ru.croc.task5;

import ru.croc.task5.entities.*;
import ru.croc.task5.graphicObjects.*;

public class Task5 {
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

        System.out.println("\nLet's find the annotation, which contains point (1;2), and try to move it.");
        Annotation foundAnnotationPoint = annotatedImage.findByPoint(new Point(1, 2));
        if (foundAnnotationPoint != null) {
            System.out.println("The annotation, which contains point (1;2), has found successfully!");

            System.out.println("Let's move the figure of this annotation a distance (-9, 6)");
            System.out.println("Previous state of figure: " + foundAnnotationPoint);
            foundAnnotationPoint.getFigure().move(-9, 6);
            System.out.println("New state of figure: " + foundAnnotationPoint);
        } else {
            System.out.println("Failed to find the annotation, which contains point (1;2).");
        }

        System.out.println("\nLet's find the annotation by label \"It is a rectangle\" and try to move it.");
        Annotation foundAnnotationLabel = annotatedImage.findByLabel("It is a rectangle");
        if (foundAnnotationLabel != null) {
            System.out.println("The annotation with label \"It is a rectangle\" has found successfully!");

            System.out.println("Let's move the figure of this annotation a distance (12, -21)");
            System.out.println("Previous state of figure: " + foundAnnotationLabel);
            foundAnnotationLabel.getFigure().move(12, -21);
            System.out.println("New state of figure: " + foundAnnotationLabel);
        } else {
            System.out.println("Failed to find the annotation with label \"It is a rectangle\".");
        }
    }
}
