package org.example.Controllers;

import org.example.Model.Student;
import org.example.Services.StudentService;
import org.example.Services.StudentServiceImp;
import org.example.Views.StudentView;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StudentController {

    public StudentController() {}
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void displayMenu (int choice) throws SQLException {
        switch (choice) {
            case 1:
                insert();
                break;

            case 2:
                for ( Student student : studentService.displayStudents()) {
                    System.out.println(student);
                }
                break;

            case 3:
                update(updateMenu());
                break;

            case 4:
                deleteStudent();
                break;

            case 0:
                return;

            default:
                System.out.println("Invalid choice");
        }
    }

    private static void insert() throws SQLException {
        StudentServiceImp studentService = new StudentServiceImp();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter date of birth: ");
        String dateString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(dateString, formatter);
        Student student = new Student(name, email, dob);
        studentService.insertStudent(student);
    }

    private static int updateMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n====== UPDATE MENU ======");
        System.out.println("1. Update Name");
        System.out.println("2. Update Email");
        System.out.println("3. Update Date Of Birth");
        System.out.println("0. Exit");
        System.out.println("--------------------------");
        System.out.print("Choose option: ");
        return scanner.nextInt();
    }

    private static void update(int updateChoice) throws SQLException {
        StudentServiceImp studentService = new StudentServiceImp();
        Scanner scanner = new Scanner(System.in);
        switch (updateChoice) {
            case 1:
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự (\n) còn sót lại trong bộ đệm
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                studentService.updateStudentName(id,newName);
                break;

            case 2:
                System.out.print("Enter ID: ");
                int idE = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự (\n) còn sót lại trong bộ đệm
                System.out.print("Enter new email: ");
                String newE = scanner.nextLine();
                studentService.updateStudentEmail(idE,newE);
                break;

            case 3: // update date of birth
                System.out.print("Enter ID: ");
                int idDate = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự (\n) còn sót lại trong bộ đệm
                System.out.print("Enter new date of birth (yyyy-MM-dd): ");
                String newDate = scanner.nextLine();
                studentService.updateStudentDob(idDate,newDate);
                break;

            case 0:
                break;
        }
    }

    private void deleteStudent() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID student need to remove: ");
        int deleteId = scanner.nextInt();
        System.out.println("Are u sure delete with student id = " + deleteId + " ? (Y/N)");
        scanner.nextLine(); // Consume newline
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Y"))
            studentService.deleteStudent(deleteId);
        else
            System.out.println("Do not delete any students.");
    }

}
