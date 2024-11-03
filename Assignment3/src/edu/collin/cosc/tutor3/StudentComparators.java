package edu.collin.cosc.tutor3;

import java.util.Comparator;

public class StudentComparators {

    public static Comparator<Student> byID() {
        return Comparator.comparing(Student::getStudentID);
    }

    public static Comparator<Student> byName() {
        return Comparator.comparing(Student::getName);
    }

    public static Comparator<Student> byAge() {
        return Comparator.comparingInt(Student::getAge);
    }

    public static Comparator<Student> byGPA() {
        return Comparator.comparingDouble(Student::calculateGPA);
    }
}

