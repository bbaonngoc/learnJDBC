package org.example.Controllers;

import org.example.Model.Book;
import org.example.Services.BookService;
import org.example.Services.BookServiceImp;
import org.example.Services.StudentServiceImp;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BookController {

    private BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void displayBookMenu(int choice) throws SQLException {
        switch (choice) {
            case 1:
                insert();
                break;

            case 2:
                for (Book book : bookService.getAllBooksSorted()) {
                    System.out.println(book);
                }
                break;

            case 3:
                updateBookById(updateMenu());
                break;

            case 4:
//                deleteBook();
                break;

            case 0:
                return;

            default:
                System.out.println("Invalid choice");
        }
    }

    private void insert () throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publish date: ");
        String dateString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate publishedDate = LocalDate.parse(dateString, formatter);
        Book book = new Book(title, author, publishedDate);
        bookService.insertBook(book);
    }

    private static int updateMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n====== UPDATE MENU ======");
        System.out.println("1. Update Title");
        System.out.println("2. Update Author");
        System.out.println("0. Exit");
        System.out.println("--------------------------");
        System.out.print("Choose option: ");
        return scanner.nextInt();
    }

    private static void updateBookById(int updateChoice) throws SQLException {
        BookServiceImp b = new BookServiceImp();
        Scanner scanner = new Scanner(System.in);
        switch (updateChoice) {
            case 1:
                System.out.print("Enter Book ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự (\n) còn sót lại trong bộ đệm
                System.out.print("Enter new title: ");
                String newTitle = scanner.nextLine();
                b.updateBookTitle(id,newTitle);
                break;

            case 2:
                System.out.print("Enter Book ID: ");
                int idA = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự (\n) còn sót lại trong bộ đệm
                System.out.print("Enter new author: ");
                String newAuthor = scanner.nextLine();
                b.updateAuthor(idA,newAuthor);
                break;


            case 0:
                break;
            default:
                System.out.println("Invalid choice");
        }
    }


}
