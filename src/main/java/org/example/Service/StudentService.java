package org.example.Service;

import org.example.Model.Student;

import java.sql.SQLException;

public interface StudentService {
    void insertStudent(Student student) throws SQLException;
}
