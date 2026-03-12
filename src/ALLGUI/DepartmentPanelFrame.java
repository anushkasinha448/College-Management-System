
package ALLGUI;



import DAO.DepartmentDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class DepartmentPanelFrame extends JFrame {


    private DefaultTableModel model;

    public DepartmentPanelFrame() {
        setTitle("Department Panel");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("Department ID");
        model.addColumn("Department_NAME");
        model.addColumn("HOD ID");
        model.addColumn("LOCATION");
        model.addColumn("Email");


        add(new JScrollPane(table), BorderLayout.CENTER);

        loadData();

        setVisible(true);
    }

    private void loadData() {

        DepartmentDAO dao = new DepartmentDAO();
        ArrayList<Object[]> list = dao.getAllDepartments();

        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    public static void main(String[] args) {
        new DepartmentPanelFrame();


    }
}