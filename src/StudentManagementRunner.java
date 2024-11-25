import java.util.Scanner;

public class StudentManagementRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        String filePath = "students.csv";
        manager.readCSV(filePath);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Display All Students");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manager.displayAllStudents();
                    break;

                case 2:
                    System.out.print("Enter Roll Number to search: ");
                    String rollNumber = scanner.nextLine();
                    Student student = manager.searchStudent(rollNumber);
                    if (student != null) {
                        System.out.println("Student found: " + student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to update: ");
                    rollNumber = scanner.nextLine();
                    System.out.print("Enter new marks: ");
                    int newMarks = scanner.nextInt();
                    if (manager.updateStudent(rollNumber, newMarks)) {
                        System.out.println("Marks updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    rollNumber = scanner.nextLine();
                    if (manager.deleteStudent(rollNumber)) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
