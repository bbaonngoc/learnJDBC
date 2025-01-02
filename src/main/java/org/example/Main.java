package org.example;

import org.example.Views.StudentView;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection conn = DBConnection.getConnection();
        System.out.println("Connection to databaase successful: " + conn);

        StudentView studentView = new StudentView();
        studentView.mainView();
    }





}