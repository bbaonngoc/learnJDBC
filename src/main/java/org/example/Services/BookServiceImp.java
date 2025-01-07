package org.example.Services;

import org.example.DBConnection;
import org.example.Model.Book;
import org.example.Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImp implements BookService {

    Connection conn = DBConnection.getConnection();

    // Tiêm hàm getConnection vào class nì
    public BookServiceImp() throws SQLException {
        this.conn = DBConnection.getConnection();
    }

    @Override
    public void insertBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (title, author, published_date) VALUES (?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setDate(3, Date.valueOf(book.getPublishedDate()));
        ps.executeUpdate();

        System.out.println("Insert successfully!");
    }

    @Override
    public List<Book> getAllBooksSorted() throws SQLException {
        String sql = "SELECT * FROM books ORDER BY published_date DESC";
        List<Book> books = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            books.add(mapRowToBook(resultSet));
        }
        return books;
    }

    @Override
    public void updateBookTitle(int id, String newTitle) throws SQLException {
        String sql = "UPDATE books SET title = ? WHERE id = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,newTitle);
        ps.setInt(2,id);
        ps.executeUpdate();
        System.out.println("Update successfully!");
    }

    @Override
    public void updateAuthor(int idA, String newAuthor) throws SQLException {
        String sql = "UPDATE books SET author = ? WHERE id = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,newAuthor);
        ps.setInt(2,idA);
        ps.executeUpdate();
        System.out.println("Update successfully!");
    }

    private Book mapRowToBook(ResultSet resultSet) throws SQLException {
        return new Book (
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("author"),
                resultSet.getDate("published_date").toLocalDate()
        );
    }

}
