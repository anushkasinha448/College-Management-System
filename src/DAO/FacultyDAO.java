package DAO;
import st_accounts.connection;
import java.sql.*;
import java.util.ArrayList;

public class FacultyDAO {
    static Connection C111=connection.createC();
    public   ArrayList<Object[]> getAllFaculty() {

        ArrayList<Object[]> list = new ArrayList<>();

        try {

            Statement stmt = C111.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM FACULTY");

            while (rs.next()) {
                Object[] row = {
                        rs.getLong("FAC_ID"),
                        rs.getString("FAC_NAME"),
                        rs.getString("GENDER"),
                        rs.getString("DESIGNATION"),
                        rs.getLong("SALARY"),
                        rs.getLong("PHONE"),
                        rs.getString("EMAIL"),
                        rs.getLong("B_ID")

                };
                list.add(row);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}