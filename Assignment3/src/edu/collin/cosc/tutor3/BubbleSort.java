package edu.collin.cosc.tutor3;

import java.util.Collections;
import java.util.List;

public class BubbleSort implements SortAlgorithm {
    @Override
    // Sort by Student GPA
    public void sortByGPA (List<Student> students) {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).calculateGPA() > students.get(j + 1).calculateGPA()) {
                    Collections.swap(students, j, j + 1);
                }
            }
        }
    }
    
    // Sort by Student ID
    public void sortByID(List<Student> students) {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getStudentID().compareTo(students.get(j + 1).getStudentID()) > 0) {
                    // Swap students[j] and students[j + 1]
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }
}

