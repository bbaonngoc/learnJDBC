package org.example;

import org.example.Model.Student;
import org.example.Service.StudentServiceImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection conn = DBConnection.getConnection();
        System.out.println("Connection to databaase successful: " + conn);

        // tao mot doi tuong chu khong phai in4face
        StudentServiceImp studentService = new StudentServiceImp();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n======= MENU =======");
            System.out.println("1. Add student");
            System.out.println("2. Display students list");
            System.out.println("3. Update student's information");
            System.out.println("4. Delete student");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
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
                    break;

                case 2:
                    System.out.println("List students");
                    System.out.println(studentService.displayStudents());
                    break;

                case 3:
                    update(updateMenu());
                    break;

                default:
                    System.out.println("You need to enter again!");
            }
        }
    }

    private static int updateMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n====== UPDATE MENU ======");
        System.out.println("1. Update Name");
        System.out.println("2. Update Email");
        System.out.println("3. Update Date Of Birth");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
        int updateChoice = scanner.nextInt();
        return updateChoice;
    }

    private static void update(int updateChoice) throws SQLException {
        StudentServiceImp studentService = new StudentServiceImp();
        Scanner scanner = new Scanner(System.in);
        switch (updateChoice) {
            case 1:
                System.out.println("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự (\n) còn sót lại trong bộ đệm
                System.out.println("Enter new name: ");
                String newName = scanner.nextLine();
                studentService.updateStudentName(id,newName);
                break;

            case 2:
                System.out.println("Enter ID: ");
                int idE = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự (\n) còn sót lại trong bộ đệm
                System.out.println("Enter new email: ");
                String newE = scanner.nextLine();
                studentService.updateStudentEmail(idE,newE);
                break;

            case 3: // update date of birth
                System.out.println("Enter ID: ");
                int idDate = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự (\n) còn sót lại trong bộ đệm
                System.out.println("Enter new date of birth (yyyy-MM-dd): ");
                String newDate = scanner.nextLine();
                studentService.updateStudentDob(idDate,newDate);
                break;

            case 0:
        }
    }

}