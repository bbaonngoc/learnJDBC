package org.example.Views;

import org.example.Controllers.BookController;
import org.example.Services.BookService;
import org.example.Services.BookServiceImp;

import java.sql.SQLException;
import java.util.Scanner;

public class BookView {

    public void bookMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("======= MENU =======");
            System.out.println("1. Add Book");
            System.out.println("2. Sort Books By Release Date");
            System.out.println("3. Update By ID");
            System.out.println("4. Delete By Name");
            System.out.println("0. Exit");
            System.out.println("-------------------------");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            BookService bookService = new BookServiceImp();
            BookController b = new BookController(bookService);
            b.displayBookMenu(choice);
        }
    }
}
