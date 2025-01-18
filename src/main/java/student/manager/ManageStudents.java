package student.manager;

import java.util.ArrayList;

public class ManageStudents extends Student {

    ManageStudents(ArrayList<Student> studentList) {
        super(studentList);
    }

    public static void addStudent(Student student) {
        student.name = Utilities.validateStringInput(sc, "Enter name : ", 30);
        student.grade = Utilities.validateIntInput(sc, "Enter grade : ", 1, 10);
        student.division = Utilities.validateDivisionInput(sc, "Enter division (A-E) : ");
        student.rollNumber = Utilities.validateRollNumberInput(sc, studentList, student);
        student.age = Utilities.validateIntInput(sc, "Enter age : ", 1, 100);
        studentList.add(student);
        System.out.println(student.getName() + " added successfully.");
    }

    public static void listStudentNames() {
        if (studentList.isEmpty()) {
            noStudentFound();
        } else {
            int i = 1;
            for (Student student : studentList) {
                System.out.println(i + ". Name : " + student.getName());
                System.out.println("   Class : " + student.getGrade() + "-" + student.getDivision());
                System.out.println("   Roll number : " + student.getRollNumber());
                System.out.println("   Age : " + student.getAge());
                i++;
            }
        }
    }

    public static void removeStudent() {
        if (studentList.isEmpty()) {
            noStudentFound();
        } else {
            System.out.println("Which one do you want to remove");
            listStudentNames();
            int choice = Utilities.validateIntInput(sc, "", 1, studentList.size()) - 1;
            System.out.println(studentList.get(choice).getName() + " removed successfully.");
            studentList.remove(choice);
        }
    }
}
