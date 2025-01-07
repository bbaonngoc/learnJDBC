package org.example.Services;

import org.example.Model.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Queue;

public interface BookService {
    public void insertBook (Book book) throws SQLException;

    public List<Book> getAllBooksSorted() throws SQLException;

    public void updateBookTitle(int id, String newTitle) throws SQLException;

    public void updateAuthor(int idA, String newAuthor) throws SQLException;

}
