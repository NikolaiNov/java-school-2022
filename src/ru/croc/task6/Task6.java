package ru.croc.task6;

import java.io.IOException;
import java.util.Scanner;

import ru.croc.task6.utils.CommentsRemover;

public class Task6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the path to the file to be processed:");
        String filePath = in.nextLine();
        try {
            System.out.println("Contents of processed file:\n" + CommentsRemover.removeFromFile(filePath));
        } catch (IOException e) {
            System.out.println("Error while reading file at " + e.getMessage());
        }

        String str = "/*\n" +
                " * My first ever program in Java!\n" +
                " */\n" +
                "class Hello { // class body starts here\n" +
                "\n" +
                "  /* main method */\n" +
                "  public static void main(String[] args/* we put command line arguments here*/) {\n" +
                "    // this line prints my first greeting to the screen\n" +
                "    System.out.println(\"Hi!\"); // :)\n" +
                "  }\n" +
                "} // the end\n" +
                "// to be continued...\n";
        System.out.println("Contents of processed string:\n" + CommentsRemover.removeFromString(str));
    }
}
