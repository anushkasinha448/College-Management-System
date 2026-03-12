package DAO;

import st_accounts.connection;
import java.sql.*;
import java.util.ArrayList;

public class DepartmentDAO {
    static Connection C111= connection.createC();
    public ArrayList<Object[]> getAllDepartments() {

        ArrayList<Object[]> list = new ArrayList<>();

        try {

            Statement stmt = C111.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DEPARTMENTS");

            while (rs.next()) {
                Object[] row = {
                        rs.getLong("D_ID"),
                        rs.getString("D_NAME"),
                        rs.getLong("HOD_ID"),
                        rs.getString("D_LOCATION"),
                        rs.getString("D_EMAIL"),

                };
                list.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
