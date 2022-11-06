package ru.croc.task5.entities;

import ru.croc.task5.graphicObjects.Point;

public class AnnotatedImage {
    private final String imagePath;
    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    public Annotation findByPoint(Point point) {
        for (Annotation annotation : this.annotations) {
            if (annotation.findPoint(point)) {
                return annotation;
            }
        }
        return null;
    }

    public Annotation findByLabel(String label) {
        for (Annotation annotation : this.annotations) {
            if (annotation.findLabel(label)) {
                return annotation;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "AnnotatedImage, imagePath: " + this.imagePath + ", number of annotations: " + this.annotations.length;
    }
}
