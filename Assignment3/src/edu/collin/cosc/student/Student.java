package edu.collin.cosc.student;

import java.util.ArrayList;

public class Student implements Comparable<Student>{
    private String studentID;
    private String name;
    private String major;
    private int age;
    private final ArrayList<Double> grades = new ArrayList<>();
    
    public Student(String id, String stuName, String stuMajor, int stuAge)
    {
        studentID = id;
        name = stuName;
        major = stuMajor;
        age = stuAge;
    }

     // Recursive GPA calculation method
    public double calculateGPA() {
        return calculateGPAHelper(0, 0);
    }

    // Helper method for recursion
    private double calculateGPAHelper(int index, double totalGradePoints) {
        if (index >= grades.size()) {
            //If all courses are processed, calculate and return GPA
            return grades.isEmpty() ? 0.0 : totalGradePoints / grades.size();
        }

        // Recursive call to process the next course
        double CalcGPAAverage= calculateGPAHelper(index + 1, totalGradePoints + 
                grades.get(index));
        return CalcGPAAverage;
    }
    
    public void setStudentID(String id)
    {
        studentID = id;
    }
    
    
    public void setName(String newName)
    {
        name = newName;
    }
    

    public void setMajor(String stuMajor)
    {
        major = stuMajor;
    }
    
    public void setAge(int stuAge)
    {
        age = stuAge;
    }
    
 
    public String getName()
    {
        return name;
    }
    
   
    public String getID()
    {
        return studentID;
    }
    
 
    public String getMajor()
    {
        return major;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void addGrade(double newGrade)
    {
        grades.add(newGrade);
    }
    
    public ArrayList<Double> viewGrades()
    {
        return grades;
    }
        

    @Override
    public String toString()
    {
        return "Name: "+ name + "\nID: " + studentID+ "\nAge: " + age
                + "\nGPA: " +  calculateGPA();
    }
    @Override
    public int compareTo(Student other) {
        // Compare by student ID (Case insensitive)
        return this.studentID.compareToIgnoreCase(other.studentID);
    }

   /* public int compareTo(Student other) {
        if(this.calculateGPA()> other.calculateGPA()){
            return 1;
        }        
        else if(this.calculateGPA()> other.calculateGPA()){
            return -1;
        }
        return 0;
    }*/

}