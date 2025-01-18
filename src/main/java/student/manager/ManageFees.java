package student.manager;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageFees extends Student {
    private static final Scanner sc = new Scanner(System.in);

    private static boolean totalFeesThere;
    private static boolean feesAdded;

    ManageFees(ArrayList<Student> studentList) {
        super(studentList);
        totalFeesThere = false;
        feesAdded = false;
    }

    private static void addFees() {
        if (studentList.isEmpty()) {
            noStudentFound();
        } else {
            System.out.println("Which student's fees you want to enter : ");
            ManageStudents.listStudentNames();
            int choice = Utilities.validateIntInput(sc, "", 1, studentList.size()) - 1;
            Student student = studentList.get(choice);
            double tempFeesPaid = Utilities.validateDoubleInput(sc, "Enter the amount of fees that the student paid : ",
                    0, 10000000);
            student.feesPaid += tempFeesPaid;
            student.feesPending = Student.getTotalFees() - student.feesPaid;
            if (student.feesPending > 0) {
                student.feesIsPending = true;
                System.out.println(tempFeesPaid + " has been paid in the name of : " + printStudentName(student));
                System.out.println("Now pending fees : " + student.getFeesPending());
            } else if (student.feesPending < 0) {
                student.feesIsPending = false;
                System.out.print(student.getName() + " paid more than the total fees by : ");
                System.out.println(Math.abs(student.getFeesPending()));
            } else {
                student.feesIsPending = false;
                System.out.println("Fees have been paid in full by : " + printStudentName(student));
            }
            feesAdded = true;
        }
    }

    private static void listAllStudentWithPendingFees() {
        if (studentList.isEmpty()) {
            noStudentFound();
        } else {
            if (feesAdded) {
                for (Student student : studentList) {
                    if (student.isFeesPending()) {
                        System.out.print(printStudentName(student));
                        System.out.println(" has their fees pending by : " + student.getFeesPending());
                    }
                }
            } else {
                System.out.println("Please enter the fees first.");
            }
        }
    }

    public static void run() {
        if (studentList.isEmpty()) {
            noStudentFound();
        } else {
            if (!(totalFeesThere)) {
                totalFees = Utilities.validateDoubleInput(sc, "Enter total fees : ", 1, 10000000);
                totalFeesThere = true;
            } else {
                System.out.println("Total Fees : " + totalFees);
                int choice1 = Utilities.validateIntInput(sc, "Enter '1' to change and '2' to continue", 1, 2);
                if (choice1 == 1) {
                    totalFees = Utilities.validateDoubleInput(sc, "Enter total fees : ", 1, 10000000);
                }
            }
            System.out.println("1.Enter paid fees of a student");
            System.out.println("2.List all students with fees pending");
            int choice2 = Utilities.validateIntInput(sc, "", 1, 2);
            switch (choice2) {
                case 1:
                    addFees();
                    break;
                case 2:
                    listAllStudentWithPendingFees();
                    break;
                default:
                    StudentManager.defaultPrint();
                    break;
            }
        }
    }
}