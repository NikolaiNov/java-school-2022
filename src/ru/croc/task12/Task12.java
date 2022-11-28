package ru.croc.task12;

import java.util.*;

public class Task12 {
    public static void main(String[] args) {
        BlackWordsRemover blackWordsRemover = new BlackWordsRemover();

        List<String> comments = new ArrayList<>();
        Iterator<String> commentsIterator;
        comments.add("I - like, to eat ;ice cream!");
        comments.add("Today I will go to the 'ice' arena");
        comments.add("I know, ;that it! \"will\" be the best day today!");

        Set<String> blackWords = new HashSet<>();
        blackWords.add("ice");
        blackWords.add("cream");
        blackWords.add("i");
        blackWords.add("will");

        blackWordsRemover.filterComments(comments, blackWords);

        commentsIterator = comments.iterator();
        while (commentsIterator.hasNext()) {
            System.out.println(commentsIterator.next());
        }
    }
}
