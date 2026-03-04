package st_accounts;
import java.sql.Connection;
import java.sql.DriverManager;

public class connection {

    static  Connection c11;
    public static Connection createC(){
        try {
            // load driver
            Class.forName("java.sql.Driver");
            // create the connection....
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "STUDENT_MANAGEMENT";
            String password = "ST_MANAGE11";
            c11= DriverManager.getConnection(url,user, password);
        } catch (Exception e){
            e.printStackTrace();
        }
        return c11;
    }
}




