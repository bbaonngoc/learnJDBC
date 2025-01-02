package org.example.Services;
import org.example.Model.Student;
import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    void insertStudent(Student student) throws SQLException;

    List<Student> displayStudents() throws SQLException;

    public Student getStudentById(int id) throws SQLException;

    public void updateStudentName(int id, String name) throws SQLException;

    void updateStudentEmail(int idE, String newE) throws SQLException;

    void updateStudentDob(int idDate, String newDate) throws SQLException;

    void deleteStudent(int deleteId) throws SQLException;
}
