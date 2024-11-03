package edu.collin.cosc.tutor3;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements SortAlgorithm {
    @Override
    public void sortByGPA(List<Student> students) {
        if (students.size() < 2) return;
        int mid = students.size() / 2;
        List<Student> left = new ArrayList<>(students.subList(0, mid));
        List<Student> right = new ArrayList<>(students.subList(mid, students.size()));
        sortByGPA(left);
        sortByGPA(right);
        mergeByGPA(students, left, right);
    }
    

    private void mergeByGPA(List<Student> students, List<Student> left, List<Student> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).calculateGPA() <= right.get(j).calculateGPA()) {
                students.set(k++, left.get(i++));
            } else {
                students.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) students.set(k++, left.get(i++));
        while (j < right.size()) students.set(k++, right.get(j++));
    }
    
        
    // Sort by Student ID
    public void sortByID(List<Student> students) {
        if (students.size() > 1) {
            List<Student> leftHalf = students.subList(0, students.size() / 2);
            List<Student> rightHalf = students.subList(students.size() / 2, students.size());

            sortByID(leftHalf);
            sortByID(rightHalf);

            mergeByID(students, leftHalf, rightHalf);
        }
    }

    // Merge by Student ID
    private void mergeByID(List<Student> students, List<Student> leftHalf, List<Student> rightHalf) {
        int i = 0, j = 0, k = 0;

        while (i < leftHalf.size() && j < rightHalf.size()) {
            if (leftHalf.get(i).getStudentID().compareTo(rightHalf.get(j).getStudentID()) <= 0) {
                students.set(k++, leftHalf.get(i++));
            } else {
                students.set(k++, rightHalf.get(j++));
            }
        }

        while (i < leftHalf.size()) {
            students.set(k++, leftHalf.get(i++));
        }

        while (j < rightHalf.size()) {
            students.set(k++, rightHalf.get(j++));
        }
    }
}

