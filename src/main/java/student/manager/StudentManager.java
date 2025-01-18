package student.manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println();
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate + "\n");
        new StudentManager().run();
    }

    private static void printChoice() {
        System.out.println("""
                1.Add students
                2.Remove students
                3.List students
                4.Enter marks
                5.List marks
                6.List toppers
                7.Manage fees
                8.Exit
                """);
    }

    static void defaultPrint() {
        System.out.println("Enter a valid input");
    }

    public void run() {
        System.out.println("Welcome to the Student Manager");
        boolean running = true;
        while (running) {
            try {
                printChoice();
                int choice = Utilities.validateIntInput(sc, "Enter your choice : ", 1, 8);
                Student student = new Student(studentList);
                switch (choice) {
                    case 1:
                        ManageStudents.addStudent(student);
                        break;
                    case 2:
                        ManageStudents.removeStudent();
                        break;
                    case 3:
                        ManageStudents.listStudentNames();
                        break;
                    case 4:
                        ManageMarks.enterMarks();
                        break;
                    case 5:
                        ManageMarks.listMarks();
                        break;
                    case 6:
                        ManageMarks.listToppers();
                        break;
                    case 7:
                        ManageFees.run();
                        break;
                    case 8:
                        running = false;
                        break;
                    default:
                        defaultPrint();
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred : " + e.getMessage());
                sc.nextLine();
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                sc.nextLine();
            }
        }
    }

}