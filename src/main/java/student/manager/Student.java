package student.manager;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    protected static Scanner sc = new Scanner(System.in);

    protected static ArrayList<Student> studentList;
    protected static double totalFees;
    protected static int outOfMarks;
    protected String name;
    protected int grade;
    protected char division;
    protected int age;
    protected int rollNumber;
    protected int englishMarks;
    protected int mathMarks;
    protected int physicsMarks;
    protected int chemistryMarks;
    protected int biologyMarks;
    protected int historyMarks;
    protected int geographyMarks;
    protected int totalMarks;
    protected double average;
    protected double percentage;
    protected double feesPaid;
    protected double feesPending;
    protected boolean feesIsPending;

    Student(ArrayList<Student> studentList) {
        Student.studentList = studentList;
        englishMarks = -1;
        mathMarks = -1;
        physicsMarks = -1;
        chemistryMarks = -1;
        biologyMarks = -1;
        historyMarks = -1;
        geographyMarks = -1;
        totalMarks = -1;
        average = -1;
        percentage = -1;
        grade = -1;
        division = '*';
        outOfMarks = 0;
        feesPaid = 0;
        feesPending = 0;
    }

    protected static double getTotalFees() {
        return totalFees;
    }

    protected static void noStudentFound() {
        System.out.println("No students found.");
    }

    protected static String printStudentName(Student student) {
        return (student.getName() + " , " + student.getGrade() + "-" + student.getDivision() + " , "
                + student.getRollNumber());
    }

    protected int getGrade() {
        return grade;
    }

    protected char getDivision() {
        return division;
    }

    protected String getName() {
        return name;
    }

    protected int getAge() {
        return age;
    }

    protected int getRollNumber() {
        return rollNumber;
    }

    protected int getEnglishMarks() {
        return englishMarks;
    }

    protected int getMathMarks() {
        return mathMarks;
    }

    protected int getPhysicsMarks() {
        return physicsMarks;
    }

    protected int getBiologyMarks() {
        return biologyMarks;
    }

    protected int getChemistryMarks() {
        return chemistryMarks;
    }

    protected int getHistoryMarks() {
        return historyMarks;
    }

    protected int getGeographyMarks() {
        return geographyMarks;
    }

    protected double getAverage() {
        return average;
    }

    protected double getPercentage() {
        return percentage;
    }

    protected int getOutOfMarks() {
        return outOfMarks;
    }

    protected int getTotalMarks() {
        return totalMarks;
    }

    protected boolean isFeesPending() {
        return feesIsPending;
    }

    protected double getFeesPending() {
        return feesPending;
    }
}