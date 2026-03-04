package DAO;

import st_accounts.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BranchDAO {

    static Connection C111= connection.createC();
    public ArrayList<Object[]> getAllBranches() {

        ArrayList<Object[]> list = new ArrayList<>();

        try {

            Statement stmt = C111.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BRANCHES");

            while (rs.next()) {
                Object[] row = {
                        rs.getLong("B_ID"),
                        rs.getString("B_NAME"),
                        rs.getLong("C_ID"),


                };
                list.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}

