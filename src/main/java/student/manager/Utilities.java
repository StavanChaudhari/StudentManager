package student.manager;

import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {
    public static String validateStringInput(Scanner sc, String prompt, int maxLength) {
        String input;
        do {
            System.out.println(prompt);
            input = sc.nextLine().trim();
            if (input.isEmpty() || input.length() > maxLength) {
                System.out.println("Input must be between 1 and " + maxLength + " characters.");
            }
        } while (input.isEmpty() || input.length() > maxLength);
        return input;
    }

    public static int validateIntInput(Scanner sc, String prompt, int min, int max) {
        int input;
        do {
            System.out.println(prompt);
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.next();
            }
            input = sc.nextInt();
            sc.nextLine();
            if (!(min <= input && max >= input)) {
                System.out.println("Input must be between " + min + " and " + max + ".");
            }
        } while (!(min <= input && max >= input));
        return input;
    }

    public static double validateDoubleInput(Scanner sc, String prompt, double min, double max) {
        double input;
        do {
            System.out.println(prompt);
            while (!sc.hasNextDouble()) {
                System.out.println("Please enter a valid number.");
                sc.next();
            }
            input = sc.nextDouble();
            sc.nextLine();
            if (!(min <= input && max >= input)) {
                System.out.println("Input must be between " + min + " and " + max + ".");
            }
        } while (!(min <= input && max >= input));
        return input;
    }

    public static char validateDivisionInput(Scanner sc, String prompt) {
        char input;
        do {
            System.out.println(prompt);
            input = sc.nextLine().trim().toUpperCase().charAt(0);
            if ("ABCDE".indexOf(input) == -1) {
                System.out.println("Please enter a valid division (A-E).");
            }
        } while ("ABCDE".indexOf(input) == -1);
        return input;
    }

    public static int validateRollNumberInput(Scanner sc, ArrayList<Student> studentList, Student student) {
        boolean isInvalid = false;
        int input;
        do {
            System.out.println("Enter roll number :");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer roll number.");
                sc.nextLine();
            }
            input = sc.nextInt();
            sc.nextLine();
            if (input < 0) {
                StudentManager.defaultPrint();
                isInvalid = true;
                continue;
            }
            if (!studentList.isEmpty()) {
                for (Student student2 : studentList) {
                    if (student2.getRollNumber() == input &&
                            student2.getGrade() == student.getGrade() &&
                            student2.getDivision() == student.getDivision()) {
                        System.out.println("Roll number already exists for student: " + student2.getName());
                        isInvalid = true;
                        break;
                    }
                }
            }
        } while (isInvalid);
        return input;
    }
}
