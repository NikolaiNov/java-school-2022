package ru.croc.task12;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BlackWordsRemover implements BlackListFilter {
    public void filterComments(List<String> comments, Set<String> blackList) {
        Iterator<String> commentsIterator = comments.iterator();
        Iterator<String> blackWordsIterator;
        
        String comment;
        int i = 0;

        while (commentsIterator.hasNext()) {
            blackWordsIterator = blackList.iterator();
            comment = commentsIterator.next();
            while (blackWordsIterator.hasNext()) {
                comment = comment.replaceAll("\\b(?i)" + blackWordsIterator.next() + "\\b", "***");
            }
            comments.set(i++, comment);
        }
    }
}
