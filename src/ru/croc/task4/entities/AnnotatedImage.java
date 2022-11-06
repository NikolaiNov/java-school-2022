package ru.croc.task4.entities;

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

    @Override
    public String toString() {
        return "AnnotatedImage, imagePath: " + this.imagePath + ", number of annotations: " + this.annotations.length;
    }
}
