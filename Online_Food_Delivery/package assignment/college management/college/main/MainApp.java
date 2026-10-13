package college.main;

import college.student.Student;
import college.faculty.Faculty;
import college.department.Department;

public class MainApp {
    public static void main(String[] args) {

        Student s = new Student(101, "Rahul Sharma");
        Faculty f = new Faculty("Dr. Mehta", "Java Programming");
        Department d = new Department("Computer Science");

        System.out.println("---- COLLEGE MANAGEMENT SYSTEM ----\n");

        s.displayStudent();
        System.out.println();

        f.displayFaculty();
        System.out.println();

        d.displayDepartment();
    }
}
