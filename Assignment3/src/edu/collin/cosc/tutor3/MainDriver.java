package edu.collin.cosc.tutor3;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Collections;
import java.util.List;

public class MainDriver {
    public static void main(String[] args) {
        final Logger logger = Logger.getLogger(MainDriver.class.getName());
    	String fileName = "src\\data\\students_data.txt"; 
        LoggerConfig.getFileHandler();
    	
    	// Load the student files
        logger.info("Starting to load student data from file: " + fileName);
        StudentInformationSystem studentInfoSystem = new StudentInformationSystem();
        studentInfoSystem.loadStudentsFromFile(fileName);
        logger.info("Loaded student data succesfully.\n");
        
        // Verify students loaded and are in order - print first x elements
        int x = 10; 
        System.out.println("First x elements BEFORE shuffling");
        printFirstXElements(studentInfoSystem.getStudents(), x);
        
                
        // Now that the data file is loaded into the Student Info System, let's scramble the data
        Collections.shuffle(studentInfoSystem.getStudents());
        
        // Verify students are shuffled - print first x elements
        System.out.println("First x elements AFTER shuffling");
        printFirstXElements(studentInfoSystem.getStudents(), x); 
        

        // <><><> SORTING <><><> Example of using BubbleSort
        logger.info("Starting BubbleSort by studentID.");
        IGenericSortAlgorithm <Student> bubbleSort = new BubbleSortGenericImpl<>();
        
        bubbleSort.sort(studentInfoSystem.getStudents(), StudentComparators.byID());
        
        logger.info("Sorting by ID completed.");
        
        System.out.println("Evaluate the data AFTER peforming Bubble Sort by f(x)");
        printFirstXElements(studentInfoSystem.getStudents(), x); 
        
        // <><><> SEARCHING  <><><> Example of using Binary Search
        // Now that we are sorted by student ID, we can perform Binary Search        
        logger.info("Starting binary search");
        IGenericSearchAlgorithm<Student> binarySearch = new BinarySearchGenericImpl<>();
        Student searchKey = new Student("S983", null, 0, null, null);
        Student foundStudent = binarySearch.search(studentInfoSystem.getStudents(), searchKey);
        
        if (foundStudent != null) {
            System.out.println("Found student: " + foundStudent.toString());  
            logger.info("Found student: " + foundStudent.toString());
        } else {
            System.out.println("Student not found.\n");
            logger.log(Level.WARNING, "Student not found.\n");

        }
        logger.info("Binary search complete.\n");
        
        
        
        
        // Shuffle again before performing the analysis
        Collections.shuffle(studentInfoSystem.getStudents());
        
        // Verify students are shuffled - print first x elements
        System.out.println("Printing elements BEFORE conducting a -- PERFORMANCE ANALYSIS -- analysis");
        printFirstXElements(studentInfoSystem.getStudents(), x); 
        
        
        // Performing Analysis
        logger.info("-------------------------------------------------------------------.");
        logger.info("Performing analysis on the sorting algorithm.");
        //System.out.println(PerformAnalysis.analyzeSort(bubbleSort, studentInfoSystem.getStudents()));
        logger.info("-------------------------------------------------------------------.");
        logger.info("Performing analysis complete.\n");
     

        
    }
    
    public static void loadStudentFiles(List<Student> students, int x) {
        System.out.println("First " + x + " elements:");
        for (int i = 0; i < Math.min(x, students.size()); i++) {
            System.out.println(students.get(i));
        }
    }
    
    public static void calculateGPARecursive(List<Student> students, int x) {
        System.out.println("First " + x + " elements:");
        for (int i = 0; i < Math.min(x, students.size()); i++) {
            System.out.println(students.get(i));
        }
    }
    
    public static void sortStudentsWithBubbleSort(List<Student> students, int x) {
        System.out.println("First " + x + " elements:");
        for (int i = 0; i < Math.min(x, students.size()); i++) {
            System.out.println(students.get(i));
        }
    }
    
    public static void searchStudentsByID(List<Student> students, int x) {
        System.out.println("First " + x + " elements:");
        for (int i = 0; i < Math.min(x, students.size()); i++) {
            System.out.println(students.get(i));
        }
    }
    
    public static void analyzeSortPerformance(List<Student> students, int x) {
        System.out.println("First " + x + " elements:");
        for (int i = 0; i < Math.min(x, students.size()); i++) {
            System.out.println(students.get(i));
        }
    }
    
    public static void analyzeSearchPerformance(List<Student> students, int x) {
        System.out.println("First " + x + " elements:");
        for (int i = 0; i < Math.min(x, students.size()); i++) {
            System.out.println(students.get(i));
        }
    }
    
    public static void printFirstXElements(List<Student> students, int x) {
        System.out.println("First " + x + " elements:");
        for (int i = 0; i < Math.min(x, students.size()); i++) {
            System.out.println(students.get(i));
        }
        System.out.println("\n");

    }

}
