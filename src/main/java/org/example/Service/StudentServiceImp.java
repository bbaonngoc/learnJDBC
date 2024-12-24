package org.example.Service;

import org.example.DBConnection;
import org.example.Model.Student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.DBConnection.getConnection;

public class StudentServiceImp implements StudentService {

    // dependency injection
    private final Connection connection;

// Tiêm hàm getConnection vào class nì
    public StudentServiceImp () throws SQLException {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public void insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (name, email, dob) VALUES (?,?,?)";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, student.getName());
        ps.setString(2, student.getEmail());
        ps.setDate(3, Date.valueOf(student.getDob()));
        ps.executeUpdate();

        System.out.println("Insert successfully!");
    }



}
