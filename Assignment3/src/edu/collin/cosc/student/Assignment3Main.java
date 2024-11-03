package edu.collin.cosc.student;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Assignment3Main {

    // Generic Bubble Sort to sort any Comparable objects
    public static <T extends Comparable<T>> void bubbleSort(ArrayList<T> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // Generic Binary Search for student by ID
    public static <T extends Comparable<T>> T binarySearch(ArrayList<T> list, 
            T key) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            T midElement = list.get(mid);

            if (midElement.compareTo(key) == 0) {
                return midElement;
            }
            if (midElement.compareTo(key) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Student not found
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        String fileName = "C:\\Users\\patri\\eclipse-workspace\\cosc-2436-assignments\\JunitTest\\src\\\\data\\\\students_data.txt"; 
        
        try (Scanner input = new Scanner(new File(fileName))) {
            input.useDelimiter(",|;");
            while (input.hasNext()) {
                String id = input.next();
                String name = input.next();
                int age = input.nextInt();
                String major = input.next();
                Student stu = new Student(id, name, major, age);
                while (input.hasNextDouble()) {
                    stu.addGrade(input.nextDouble());
                }
                students.add(stu);
                input.nextLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        // Sort students by GPA
        bubbleSort(students);

        // Print sorted students
        for (Student student : students) {
            System.out.println(student.getName() + " GPA: " 
                    + student.calculateGPA());
        }

        try (// Search for a student by ID
		        // Search for a student by ID
        	Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter student ID to search: ");
			String searchID = scanner.nextLine();
			Student searchKey = new Student(searchID, "", "", 0); 
			Student foundStudent = binarySearch(students, searchKey);

			if (foundStudent != null) {
			    System.out.println("Student found: " + foundStudent);
			} else {
			    System.out.println("Student not found.");
			}
		}
    }

}