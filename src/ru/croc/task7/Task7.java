package ru.croc.task7;

import ru.croc.task7.entities.ChessPosition;
import ru.croc.task7.entities.Horse;
import ru.croc.task7.exceptions.IllegalMoveException;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isPossible = true;
        Horse a = new Horse();

        System.out.println("Set waypoints (for example: \"g8\", \"e7\", \"e6\")");
        String[] waypoints = in.nextLine().split(", ");

        for (int i = 0; i < waypoints.length; i++) {
            waypoints[i] = String.valueOf(waypoints[i].charAt(1)) + waypoints[i].charAt(2);
            if (!ChessPosition.isCorrectPosition(waypoints[i])) {
                System.out.println("Incorrect waypoint");
                break;
            }
            try {
                a.MoveTo(waypoints[i]);
            } catch (IllegalMoveException e) {
                System.out.println(e.getMessage());
                isPossible = false;
                break;
            }
        }
        if (isPossible) {
            System.out.println("Possible to finish the way");
        } else {
            System.out.println("Not possible to finish the way");
        }
    }
}
