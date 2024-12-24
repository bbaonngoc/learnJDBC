package org.example;

import org.example.Model.Student;
import org.example.Service.StudentService;
import org.example.Service.StudentServiceImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection conn = DBConnection.getConnection();
        System.out.println("Connection to databaase successful: " + conn);

        // tao mot doi tuong chu khong phai in4face
        StudentServiceImp studentService = new StudentServiceImp();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== QUẢN LÝ HỌC VIÊN ===");
            System.out.println("1. Thêm học viên");
            System.out.println("2. Hiển thị danh sách học viên");
            System.out.println("3. Cập nhật email học viên");
            System.out.println("4. Xóa học viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
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
                default:
                    System.out.println("ngu");
            }
        }
    }
}