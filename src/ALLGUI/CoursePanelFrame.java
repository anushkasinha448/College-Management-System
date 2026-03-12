package ALLGUI;


import DAO.CourseDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CoursePanelFrame extends JFrame {

    private JTable table;
    DefaultTableModel model;

    public CoursePanelFrame() {
        setTitle("Course Panel");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("Course_ID");
        model.addColumn("COURSE_NAME");
        model.addColumn("YEAR");
        model.addColumn("FEE");

        add(new JScrollPane(table), BorderLayout.CENTER);
        loadData();
        setVisible(true);
    }

    private void loadData() {

        CourseDAO dao = new CourseDAO();
        ArrayList<Object[]> list = dao.getAllCourses();

        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    public static void main(String[] args) {
        new CoursePanelFrame();
    }
}


