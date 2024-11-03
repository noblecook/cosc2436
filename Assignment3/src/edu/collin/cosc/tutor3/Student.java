package edu.collin.cosc.tutor3;

import java.util.List;

public class Student implements Comparable <Student>{
    private String studentID;
    private String name;
    private int age;
    private String major;
    private List<Double> grades;

    public Student(String studentID, String name, int age, String major, List<Double> grades) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.major = major;
        this.grades = grades;
    }

    // Recursive method to calculate GPA
    public double calculateGPA() {
        return calculateSum(grades, grades.size()) / grades.size();
    }

    private double calculateSum(List<Double> grades, int size) {
        if (size == 1) return grades.get(0);
        return grades.get(size - 1) + calculateSum(grades, size - 1);
    }
    
    /**
	 * @return the studentID
	 */
    public String getStudentID() {
        return studentID;
    }
    
    /**
	 * @return the name
	 */
    public String getName() {
        return name;
    }

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * @return the grades
	 */
	public List<Double> getGrades() {
		return grades;
	}

	/**
	 * @param grades the grades to set
	 */
	public void setGrades(List<Double> grades) {
		this.grades = grades;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override	
	public String toString() {
        return "StudentID: " + studentID + 
               ", Name: " + name + 
               ", Age: " + age + 
               ", Major: " + major + 
               ", Grades: " + grades +
               ", GPA: " + calculateGPA();
    }

	@Override
	public int compareTo(Student o) {
		return this.studentID.compareTo(o.studentID);
	}
    
}

