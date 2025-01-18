package student.manager;

import java.util.ArrayList;

public class ManageMarks extends Student {
    private static boolean outOfMarksThere;

    ManageMarks(ArrayList<Student> studentList) {
        super(studentList);
        outOfMarksThere = false;
    }

    public static void enterMarks() {
        if (studentList.isEmpty()) {
            noStudentFound();
        } else {
            System.out.println("Which student's marks you want to enter : ");
            ManageStudents.listStudentNames();
            int choice1 = Utilities.validateIntInput(sc, "", 1, studentList.size()) - 1;
            if (!(outOfMarksThere)) {
                outOfMarks = Utilities.validateIntInput(sc, "Enter the out-of marks : ", 0, 1000);
                outOfMarksThere = true;
            } else {
                System.out.println("Out of Marks : " + outOfMarks);
                int choice2 = Utilities.validateIntInput(sc, "Enter '1' to change and '2' to continue", 1, 2);
                if (choice2 == 1) {
                    outOfMarks = Utilities.validateIntInput(sc, "Enter the out-of marks : ", 0, 1000);
                }
            }
            Student student = studentList.get(choice1);
            student.englishMarks = Utilities.validateIntInput(sc, "Enter marks in english : ", 0, outOfMarks);
            student.mathMarks = Utilities.validateIntInput(sc, "Enter marks in maths : ", 0, outOfMarks);
            student.physicsMarks = Utilities.validateIntInput(sc, "Enter marks in physics : ", 0, outOfMarks);
            student.chemistryMarks = Utilities.validateIntInput(sc, "Enter marks in chemistry  : ", 0, outOfMarks);
            student.biologyMarks = Utilities.validateIntInput(sc, "Enter marks in biology : ", 0, outOfMarks);
            student.historyMarks = Utilities.validateIntInput(sc, "Enter marks in history : ", 0, outOfMarks);
            student.geographyMarks = Utilities.validateIntInput(sc, "Enter marks in geography : ", 0, outOfMarks);
            student.totalMarks = student.getEnglishMarks() + student.getMathMarks() + student.getPhysicsMarks()
                    + student.getChemistryMarks() + student.getBiologyMarks() + student.getHistoryMarks()
                    + student.getGeographyMarks();
            student.average = (student.getTotalMarks()) / 7.0;
            student.percentage = student.getTotalMarks()
                    / (student.getOutOfMarks() * 7.0) * 100.0;

        }
    }

    public static void listMarks() {
        if (studentList.isEmpty()) {
            noStudentFound();
        } else {
            int i = 1;
            for (Student student : studentList) {
                if (student.getEnglishMarks() != -1) {
                    System.out.print(i + ". ");
                    System.out.println(printStudentName(student));
                    System.out.println("   English : " + student.getEnglishMarks());
                    System.out.println("   Maths : " + student.getMathMarks());
                    System.out.println("   Physics : " + student.getPhysicsMarks());
                    System.out.println("   Chemistry : " + student.getChemistryMarks());
                    System.out.println("   Biology : " + student.getBiologyMarks());
                    System.out.println("   History : " + student.getHistoryMarks());
                    System.out.println("   Geography : " + student.getGeographyMarks());
                    System.out.println("   Average : " + student.getAverage());
                    System.out.println("   Percentage : " + student.getPercentage());
                    i++;
                } else {
                    System.out.print("Marks for ");
                    System.out.print(printStudentName(student));
                    System.out.println(" have not been entered yet.");
                }
            }
        }
    }

    public static void listToppers() {
        if (studentList.isEmpty()) {
            noStudentFound();
        } else {
            for (int i1 = 1; i1 <= 10; i1++) {
                for (int i2 = 65; i2 <= 69; i2++) {
                    int maxTotalMarks = 0;
                    double maxAverage = 0;
                    double maxPercentage = 0;
                    String maxStudentName = "";
                    boolean maxRan = false;
                    for (Student student2 : studentList) {
                        if (student2.getGrade() == i1 && student2.getDivision() == (char) (i2)) {
                            if (student2.getTotalMarks() >= maxTotalMarks) {
                                maxTotalMarks = student2.getTotalMarks();
                                maxAverage = student2.getAverage();
                                maxPercentage = student2.getPercentage();
                                maxStudentName = student2.getName();
                                maxRan = true;
                            }
                        }
                    }
                    if (maxRan) {
                        System.out.println("Topper for " + i1 + "-" + (char) (i2) + " is " + maxStudentName
                                + " with :");
                        System.out.println("Total Marks : " + maxTotalMarks);
                        System.out.println("Average marks : " + maxAverage);
                        System.out.println("Percentage : " + maxPercentage);
                    } else {
                        System.out.println(
                                "None of student's data in  " + i1 + "-" + (char) (i2) + " has been entered yet.");
                    }
                }
            }
        }
    }
}
