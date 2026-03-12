package ALLGUI;

import DAO.BranchDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class BranchPanelFrame extends JFrame {

    private DefaultTableModel model;

    public BranchPanelFrame() {
        setTitle("Branch Panel");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("BRANCH ID");
        model.addColumn("BRANCH NAME");
        model.addColumn("COURSR ID");
        add(new JScrollPane(table), BorderLayout.CENTER);

        loadData();

        setVisible(true);
    }

    private void loadData() {

        BranchDAO dao = new BranchDAO();
        ArrayList<Object[]> list = dao.getAllBranches();

        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    public static void main(String[] args) {
        new BranchPanelFrame();
    }



}