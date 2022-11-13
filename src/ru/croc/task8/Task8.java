package ru.croc.task8;

import java.io.IOError;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.IllformedLocaleException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Locale locale = null;
        Scanner in = new Scanner(System.in);
        System.out.println("Entry country code (for example: ru)");
        String country = in.next();
        System.out.println("Entry language code (for example: RU)");
        String language = in.next();
        try {
            locale = new Locale.Builder().setRegion(country).setLanguage(language).build();

        } catch (IllformedLocaleException e) {
            System.out.println("Error while creating locale. Using locale by default (US).");
            locale = Locale.getDefault();
        }
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        System.out.println("Enter money amount:");
        try {
            BigDecimal money = new BigDecimal(in.nextDouble());
            System.out.println(format.format(money));

        } catch (InputMismatchException e) {
            System.out.println("Error while reading number");
        }
    }
}
