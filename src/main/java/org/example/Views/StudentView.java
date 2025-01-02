package org.example.Views;

import org.example.Controllers.StudentController;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentView {

    public void mainView() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("======= MENU =======");
            System.out.println("1. Add student");
            System.out.println("2. Display students list");
            System.out.println("3. Update student's information");
            System.out.println("4. Delete student");
            System.out.println("0. Exit");
            System.out.println("-------------------------");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            StudentController s = new StudentController();
            s.displayMenu(choice);
        }
    }

}
