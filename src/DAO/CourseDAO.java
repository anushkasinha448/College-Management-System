package DAO;

import st_accounts.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CourseDAO {
    static Connection C111= connection.createC();
    public ArrayList<Object[]> getAllCourses() {

        ArrayList<Object[]> list = new ArrayList<>();

        try {

            Statement stmt = C111.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COURSES");

            while (rs.next()) {
                Object[] row = {
                        rs.getLong("C_ID"),
                        rs.getString("C_NAME"),
                        rs.getLong("C_YEAR"),
                        rs.getLong("C_FEE"),

                };
                list.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
