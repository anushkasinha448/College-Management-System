package ALLGUI;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;


public class Dashboard extends JFrame {

        public Dashboard() {
            setTitle("College Management Dashboard");
            setSize(800, 500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());

           // setLayout(new GridLayout(7, 1, 20, 20)); // 2 rows, 3 columns, 20px gap

            // 1️⃣ Welcome label at the top
            JLabel welcomeLabel = new JLabel("Welcome !", SwingConstants.CENTER);
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 22));
            welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
            add(welcomeLabel, BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 80, 10, 80)); // left-right spacing

            // Create buttons
            JButton btnStudents = new JButton("Students");
            JButton btnAccounts = new JButton("Accounts");
            JButton btnCourses = new JButton("Courses");
            JButton btnBranches = new JButton("Branches");
            JButton btnFaculty = new JButton("Faculty");
            JButton btnDepartments = new JButton("Departments");

            JButton[] buttons = {
                    btnStudents, btnAccounts, btnCourses,
                    btnBranches, btnFaculty, btnDepartments
            };

            Dimension buttonSize = new Dimension(200, 40);

            for (JButton btn : buttons) {
                btn.setMaximumSize(buttonSize);
                btn.setAlignmentX(Component.CENTER_ALIGNMENT);
                buttonPanel.add(btn);
                buttonPanel.add(Box.createRigidArea(new Dimension(0, 15))); // spacing
            }

            // Add action listeners
            btnStudents.addActionListener((ActionEvent e) -> new StudentGUI());
            btnAccounts.addActionListener((ActionEvent e) -> new AccountantPanelFrame());
            btnCourses.addActionListener((ActionEvent e) -> new CoursePanelFrame());
            btnBranches.addActionListener((ActionEvent e) -> new BranchPanelFrame());
            btnFaculty.addActionListener((ActionEvent e) -> new FacultyGUI());
            btnDepartments.addActionListener((ActionEvent e) -> new DepartmentPanelFrame());

            // Add buttons to the frame
            add(buttonPanel, BorderLayout.CENTER);
            setVisible(true);
        }

        public static void main(String[] args) {
            new Dashboard();
        }

}

