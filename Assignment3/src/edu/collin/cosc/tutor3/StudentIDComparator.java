package edu.collin.cosc.tutor3;

import java.util.Comparator;

public class StudentIDComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getStudentID().compareTo(s2.getStudentID());
    }
}

