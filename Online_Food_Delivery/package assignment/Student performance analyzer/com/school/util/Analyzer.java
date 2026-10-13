package com.school.util;
import com.school.data.Student;

public class Analyzer {
    public double calculateAverage(Student s) {
        return (s.m1 + s.m2 + s.m3) / 3.0;
    }

    public String findGrade(double avg) {
        if (avg >= 75) return "A";
        else if (avg >= 60) return "B";
        else return "C";
    }
}
