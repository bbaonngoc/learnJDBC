package org.example.Service;

import org.example.DBConnection;
import org.example.Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImp implements StudentService {

    // dependency injection
    private final Connection connection;

    // Tiêm hàm getConnection vào class nì
    public StudentServiceImp() throws SQLException {
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

    @Override
    public List<Student> displayStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            students.add(mapRowToStudent(resultSet));
        }
        return students;
    }

    @Override
    public Student getStudentById(int id) throws SQLException {
        Student student = null;
        String sql = "SELECT * FROM students WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            student = mapRowToStudent(resultSet);
        }
        return student;
    }

    @Override
    public void updateStudentName(int id, String newName) throws SQLException {
        String sql = "UPDATE students SET name = ? WHERE id = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,newName);
        ps.setInt(2,id);
        ps.executeUpdate();
        System.out.println("Update successfully!");
    }

    @Override
    public void updateStudentEmail(int idE, String newE) throws SQLException {
        String sql = "UPDATE students SET email = ? WHERE id = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,newE);
        ps.setInt(2,idE);
        ps.executeUpdate();
        System.out.println("Update successfully!");
    }

    @Override
    public void updateStudentDob(int idDate, String newDate) throws SQLException {
        String sql = "UPDATE students SET dob = ? WHERE id = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,newDate);
        ps.setInt(2,idDate);
        ps.executeUpdate();
        System.out.println("Update successfully!");
    }

    private Student mapRowToStudent(ResultSet resultSet) throws SQLException {
        return new Student(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getDate("dob").toLocalDate()
        );
    }
}
