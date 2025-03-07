package az.edu.turing.lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadeAndWrite {
    public static void main(String[] args) {

        String userInput = inputFile();
        int result = computSequence(userInput);
        System.out.println("Computed result: " + result);
    }

    public static String inputFile() {
        Scanner scanner = null;
        String input = "";

        try {
            File file = new File("file.txt");
            scanner = new Scanner(file);
            input = scanner.nextLine();
            System.out.println("Reade from file: " + input);
        } catch (FileNotFoundException e) {
            System.out.println("File not found exeption. Please entered input manually: ");
            scanner = new Scanner(System.in);
            input = scanner.nextLine();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        input = input.replaceAll("\\s+","");
        return input;

    }

    public static int computSequence(String str) {
        int sum = 0;
        int lastDigit = 1;

        if (str.length() <= 2) {
            throw new IllegalArgumentException("String lenght must be at last 2.");
        }

        for (int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                throw new ArithmeticException("String contains non - digit character");
            }
            sum += Character.getNumericValue(str.charAt(i));
        }

        char lastChar = str.charAt(str.length() - 1);
        if (Character.isDigit(lastChar)) {
            lastDigit = Character.getNumericValue(lastChar);
        } else {
            throw new ArithmeticException("Last charcter must be digit");
        }
        return sum / lastDigit;

    }
}
