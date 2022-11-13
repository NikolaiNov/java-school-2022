package ru.croc.task6.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentsRemover {
    public static String removeFromString(String source) {
        StringBuilder withoutComments = new StringBuilder();
        Pattern pattern = Pattern.compile("//.*|(?s:/\\*.*?\\*/)");
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            matcher.appendReplacement(withoutComments, "");
        }
        matcher.appendTail(withoutComments);
        return withoutComments.toString();
    }

    public static String removeFromFile(String filePath) throws IOException {
        String source = null;
        source = Files.readString(Paths.get(filePath));
        return removeFromString(source);
    }
}
