package fr.doranco.jpasimple.utils;

import java.util.Scanner;

public final class ScannerUtils {

    private final Scanner sc;

    public ScannerUtils(Scanner sc) {
        this.sc = sc;
    }

    public int getInt(String prompt, int minValue, int maxValue) {
        int result = 0;
        boolean done = false;
        do {
            System.out.print(prompt);
            try {
                int input = sc.nextInt();
                if (input >= minValue && input <= maxValue) {
                    result = input;
                    done = true;
                }
            } catch (Exception ignored) {

            } finally {
                sc.nextLine();
            }
        } while (!done);

        return result;
    }

    public long getLong(String prompt, long minValue, long maxValue) {
        long result = 0;
        boolean done = false;
        do {
            System.out.print(prompt);
            try {
                long input = sc.nextLong();
                if (input >= minValue && input <= maxValue) {
                    result = input;
                    done = true;
                }
            } catch (Exception ignored) {

            } finally {
                sc.nextLine();
            }
        } while (!done);

        return result;
    }

    public String getString(String prompt, boolean onlyNumeric) {
        String result = null;

        do {
            System.out.print(prompt);
            try {
                if (onlyNumeric) {
                    int input = sc.nextInt();
                    sc.nextLine();
                    result = String.valueOf(input);
                } else {
                    String input = sc.nextLine();
                    result = input;
                }
            } catch (Exception ignored) {

            } finally {
                if (onlyNumeric) {
                    sc.nextLine();
                }
            }
        } while (result == null);

        return result;
    }
}
