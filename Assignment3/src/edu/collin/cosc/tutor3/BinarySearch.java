package edu.collin.cosc.tutor3;
import java.util.logging.Logger;
import java.util.List;

public class BinarySearch implements SearchAlgorithm {
    private static final Logger logger = Logger.getLogger(BinarySearch.class.getName());   	

    @Override
    public Student search(List<Student> students, String key) {
        logger.info("Starting binary search");

        int left = 0;
        int right = students.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            Student student = students.get(mid);
            logger.info("Checking student ID: " + student.getStudentID());
            
            int comparison = student.getStudentID().compareTo(key);
            if (comparison == 0) {
            	logger.info("Student found: " + student.getName());
            	return student;
            }
            if (comparison < 0) left = mid + 1;
            else right = mid - 1;
        }
        logger.warning("Student not found with ID: " + key);
        return null;
    }
}

