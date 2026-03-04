package st_accounts;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextArea;

public class link {

    // Original console version
    public static void showStu(int idd){
        try {
            Connection C111 = connection.createC();
            String query = "SELECT ACC_ID, C_TOTAL, C_NET, FINE FROM ACCOUNTS WHERE SID = ?";
            PreparedStatement stm = C111.prepareStatement(query);
            stm.setInt(1, idd);
            ResultSet set = stm.executeQuery();

            if(set.next()){
                int ACC_id = set.getInt(1);
                int Total_C_pay = set.getInt(2);
                int Net_Payed = set.getInt(3);
                int Fine = set.getInt(4);

                int Net_due = (Total_C_pay + Fine) - Net_Payed;

                System.out.println("Total due : "+Net_due );
                System.out.println("Total Course fee : "+Total_C_pay );
                System.out.println("Total Paid : "+Net_Payed );
                System.out.println("Fine : "+Fine );
                System.out.println("------------------------");
            }
            else{
                System.out.println("No record found !!!");
            }

            C111.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // New GUI version
    public static void showStuGUI(int idd, JTextArea outputArea){
        try {
            Connection C111 = connection.createC();
            String query = "SELECT ACC_ID, C_TOTAL, C_NET, FINE FROM ACCOUNTS WHERE SID = ?";
            PreparedStatement stm = C111.prepareStatement(query);
            stm.setInt(1, idd);
            ResultSet set = stm.executeQuery();

            if(set.next()){
                int ACC_id = set.getInt(1);
                int Total_C_pay = set.getInt(2);
                int Net_Payed = set.getInt(3);
                int Fine = set.getInt(4);

                int Net_due = (Total_C_pay + Fine) - Net_Payed;

                outputArea.setText(""); // Clear previous output
                outputArea.append("Account ID : " + ACC_id + "\n");
                outputArea.append("Total Course Fee : " + Total_C_pay + "\n");
                outputArea.append("Total Paid : " + Net_Payed + "\n");
                outputArea.append("Fine : " + Fine + "\n");
                outputArea.append("Net Due : " + Net_due + "\n");
                outputArea.append("------------------------\n");
            } else {
                outputArea.setText("No record found for SID: " + idd + "\n");
            }

            C111.close();
        } catch (Exception e) {
            e.printStackTrace();
            outputArea.setText("Error: " + e.getMessage());
        }
    }
}