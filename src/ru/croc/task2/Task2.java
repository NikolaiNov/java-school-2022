package ru.croc.task2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double initialElement = scanner.nextDouble();
        double delta = scanner.nextDouble();
        int amount = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < amount; i++) {
            total += (initialElement + delta * i);
        }
        System.out.println("Sum: " + total);
    }
}
