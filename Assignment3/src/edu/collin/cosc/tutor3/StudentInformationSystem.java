package edu.collin.cosc.tutor3;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class StudentInformationSystem {
    private static final Logger logger = Logger.getLogger(StudentInformationSystem.class.getName());   	
    private List<Student> students = new ArrayList<>();

    // Load students from file
    // Example line := S001,Student 1,30,Biology,3.0;2.5;3.5;3.5;4.0
    public void loadStudentsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	
                String[] parts = line.split(",");
                
                // Check if the line has at least 5 parts (studentID, name, age, major, grades)
                if (parts.length < 5) {
                    logger.warning("Skipping invalid line (not enough fields): " + line);
                    continue; // Skip this line and move to the next
                }
                
                String studentID = parts[0];
                String name = parts[1];
   
                int age;
                try {
                    age = Integer.parseInt(parts[2]);
                } catch (NumberFormatException e) {
                    logger.warning("Invalid age format for line: " + line);
                    continue; // Skip lines with invalid age format
                }
                               
                String major = parts[3];
                List<Double> grades = new ArrayList<>();
                try {
                    for (String grade : parts[4].split(";")) {
                        grades.add(Double.parseDouble(grade));
                    }
                } catch (NumberFormatException e) {
                    logger.warning("Invalid grade format for line: " + line);
                    continue; // Skip lines with invalid grade format
                }
                
                students.add(new Student(studentID, name, age, major, grades));
                logger.fine("Added student: " + name + " (ID: " + studentID + ")");                
            }
                        
        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "Error reading file: " + fileName, e);

        }
    }

    // Recursive GPA calculation
    public double calculateGPA(Student student) {
        return student.calculateGPA();
    }

    // Sorting students by GPA using chosen sorting algorithm
    public void sortStudentsByGPA(SortAlgorithm algorithm) {
        algorithm.sortByGPA(students);
    }
    
 // Sorting students by GPA using chosen sorting algorithm
    public void sortStudentsByID(SortAlgorithm algorithm) {
        algorithm.sortByID(students);
    }

    // Search student by ID
    public Student getStudentById(String studentID, SearchAlgorithm searchAlgorithm) {
        return searchAlgorithm.search(students, studentID);
    }

    // Search student by name
    public Student getStudentByName(String name, SearchAlgorithm searchAlgorithm) {
        return searchAlgorithm.search(students, name);
    }

	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}
}

