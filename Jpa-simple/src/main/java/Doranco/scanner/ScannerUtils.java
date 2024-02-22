package Doranco.scanner;

import java.util.Scanner;

public final class ScannerUtils {

    private final Scanner inputScanner;

    public ScannerUtils(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public int getInt(String prompt, int minValue, int maxValue) {
        int result = 0;
        boolean done = false;
        do {
            System.out.print(prompt);
            try {
                int input = inputScanner.nextInt();
                if (input >= minValue && input <= maxValue) {
                    result = input;
                    done = true;
                }
            } catch (Exception ignored) {
            } finally {
                inputScanner.nextLine();
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
                long input = inputScanner.nextLong();
                if (input >= minValue && input <= maxValue) {
                    result = input;
                    done = true;
                }
            } catch (Exception ignored) {
            } finally {
                inputScanner.nextLine();
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
                    int input = inputScanner.nextInt();
                    inputScanner.nextLine();
                    result = String.valueOf(input);
                } else {
                    result = inputScanner.nextLine();
                }
            } catch (Exception ignored) {
            }
        } while (result == null);

        return result;
    }
}
