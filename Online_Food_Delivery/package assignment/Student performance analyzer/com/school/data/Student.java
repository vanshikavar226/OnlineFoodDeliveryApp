package com.school.data;

public class Student {
    public String name;
    public int m1, m2, m3;

    public Student(String name, int a, int b, int c) {
        this.name = name;
        m1 = a; m2 = b; m3 = c;
    }

    public String toString() {
        return name + " Marks: " + m1 + "," + m2 + "," + m3;
    }
}
