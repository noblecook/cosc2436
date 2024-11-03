package edu.collin.cosc.tutor3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerformAnalysis {
	
	// Define sizes to test
    int[] testSizes = {500, 1000, 2000, 4000};
    
    public static void setupTestData(int[] sizes){
    	for (int size : sizes) {
            // Generate a list of the specified size with randomized data
            List<Student> students = generateTestData(size);

            // Shuffle to simulate an unsorted list
            Collections.shuffle(students);
            
            // Measure time for Bubble Sort
            BubbleSort bubbleSort = new BubbleSort();
            long startTime = System.nanoTime();
            bubbleSort.sortByID(students);
            long endTime = System.nanoTime();

            // Calculate duration in milliseconds
            long duration = (endTime - startTime) / 1_000_000;
            System.out.println("Bubble Sort for " + size + " elements took " + duration + " ms.");
         }
    }

    // Chapter 16 Algorithm Analysis & Time Complexity
	// Measure and analyze the execution time of sorting
    public static String analyzeSort(SortAlgorithm algorithm, List<Student> students) {
        long startTime = System.nanoTime(); // Start time
        algorithm.sortByID(students); // Perform the sort
        long endTime = System.nanoTime(); // End time
        
        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        String complexity = "Unknown time complexity.";
        
        if (algorithm instanceof BubbleSort) {
            complexity = "Bubble Sort: O(n^2) time complexity for average and worst cases.";
        } else if (algorithm instanceof MergeSort) {
            complexity = "Merge Sort: O(n log n) time complexity for average and worst cases.";
        }
        
        return complexity + " Execution time: " + duration + " ms.";
    }

    // Measure and analyze the execution time of searching
    public static String analyzeSearch(SearchAlgorithm algorithm, List<Student> students, String studentID) {
        long startTime = System.nanoTime(); // Start time
        Student result = algorithm.search(students, studentID); // Perform the search
        long endTime = System.nanoTime(); // End time
        
        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        String complexity = "Unknown time complexity.";
        
        if (algorithm instanceof BinarySearch) {
            complexity = "Binary Search: O(log n) time complexity.";
        }
        
        String found = (result != null) ? "Student found." : "Student not found.";
        
        return complexity + " Execution time: " + duration + " ms. " + found;
    }
    

    
    // Generate test data of given size
    private static List<Student> generateTestData(int size) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            students.add(new Student("S" + i, "Student " + i, 20 + (i % 10), "Major", generateRandomGrades()));
        }
        return students;
    }

    // Generate random grades for GPA calculation
    private static List<Double> generateRandomGrades() {
        List<Double> grades = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            grades.add(2.0 + Math.random() * 2.0); // Random GPA between 2.0 and 4.0
        }
        return grades;
    }
    
    
    
    
}



