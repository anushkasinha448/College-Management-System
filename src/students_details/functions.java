package students_details;
import st_accounts.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class functions {
    //jdbc code
    static Connection C111 = connection.createC();

    public static boolean insertStudentToDb(add_student st) {
        boolean f = false;
        try {

            String query = "insert into STUDENTS_DETAIL values(?,?,?,?,?,?,?,?)";
            // Prepared statement
            PreparedStatement pstmt = C111.prepareStatement(query);
            //set the values
            pstmt.setInt(1, st.getStudentid());
            pstmt.setString(2, st.getStudentname());
            pstmt.setString(3, st.getF_name());
            pstmt.setString(4, st.getM_name());
            pstmt.setLong(5, st.getPhone());
            pstmt.setString(6, st.getCourse());
            pstmt.setString(7, st.getBranch());
            pstmt.setString(8, st.getYear());


//            private String studentname ,F_name,M_name;
//            private int  studentid, c_fee, net_paid,fine ,year,phone;

            //execute
            pstmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static boolean deleteStudent(int idd) {
        boolean f = false;
        try {
            String query = "DELETE FROM STUDENTS_DETAIL WHERE SID=?";
            // Prepared statement
            PreparedStatement pstmt = C111.prepareStatement(query);
            //set the values
            pstmt.setInt(1, idd);

            int rows=pstmt.executeUpdate();
            if (rows > 0) {
                f = true;
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("No student found with that ID.");
            }

            C111.commit();   // 🔥 VERY IMPORTANT FOR ORACLE

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static java.util.List<add_student> getAllStudents() {
        java.util.List<add_student> list = new java.util.ArrayList<>();
        try {

            Statement st = C111.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM STUDENTS_DETAIL"); // your table name
             int count =0;
            while (rs.next()) {
                int id = rs.getInt("SID");
                String name = rs.getString("S_NAME");
                String father = rs.getString("F_NAME");
                String mother = rs.getString("M_NAME");
                long phone = rs.getLong("PHONE_NO");
                String course = rs.getString("COURSE");
                String branch = rs.getString("BRANCH");
                String year = rs.getString("YEAR");


                add_student s = new add_student(id, name, father, mother, phone, course, branch, year);
                list.add(s);
            }

            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}



