import java.io.*;
import java.util.*;

public class StudentManager {
    private List<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    public void readCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                String rollNumber = data[1].trim();
                int marks = Integer.parseInt(data[2].trim());
                studentList.add(new Student(name, rollNumber, marks));
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public Student searchStudent(String rollNumber) {
        for (Student student : studentList) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    public boolean updateStudent(String rollNumber, int newMarks) {
        Student student = searchStudent(rollNumber);
        if (student != null) {
            student.setMarks(newMarks);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(String rollNumber) {
        Student student = searchStudent(rollNumber);
        if (student != null) {
            studentList.remove(student);
            return true;
        }
        return false;
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records available.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }
}
