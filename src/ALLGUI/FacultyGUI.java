package ALLGUI;
import DAO.FacultyDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class FacultyGUI extends JFrame {

    DefaultTableModel model;

    public FacultyGUI() {

        setTitle("Faculty Details");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("FACUTY_ID");
        model.addColumn("FACUTY_NAME");
        model.addColumn("GENDER");
        model.addColumn("DESIGNATION");
        model.addColumn("SALARY");
        model.addColumn("PHONE");
        model.addColumn("Email");
        model.addColumn("BRANCH");

        add(new JScrollPane(table), BorderLayout.CENTER);

        loadData();

        setVisible(true);
    }

    private void loadData() {

        FacultyDAO dao = new FacultyDAO();
        ArrayList<Object[]> list = dao.getAllFaculty();

        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    public static void main(String[] args) {
        new FacultyGUI();
    }
}
