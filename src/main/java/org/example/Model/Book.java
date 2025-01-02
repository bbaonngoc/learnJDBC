package org.example.Model;

import java.time.LocalDate;
import java.util.Locale;

public class Book {
    private int id;
    private String title;
    private String author;
    private LocalDate pulishedDate;

    public Book(){}
    public Book(int id, String title, String author, LocalDate pulishedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pulishedDate = pulishedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPulishedDate() {
        return pulishedDate;
    }

    public void setPulishedDate(LocalDate pulishedDate) {
        this.pulishedDate = pulishedDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pulishedDate=" + pulishedDate +
                '}';
    }
}
