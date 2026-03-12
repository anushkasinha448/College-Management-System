package Cour_Bran_Dep;
import javax.swing.*;
import java.awt.*;
public class TRYDASH extends JFrame{


    public TRYDASH(String studentName) {
        setTitle("Student Dashboard");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Use a GridLayout: 1 column, multiple rows, vertical space between components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 10, 20)); // 7 rows, 1 col, hgap=10, vgap=20

        // 1️⃣ Welcome label at the top
        JLabel welcomeLabel = new JLabel("Welcome, " + studentName + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(welcomeLabel);

        // 2️⃣ Buttons for different actions
        JButton btnProfile = new JButton("View Profile");
        JButton btnCourses = new JButton("My Courses");
        JButton btnGrades = new JButton("Grades");
        JButton btnSettings = new JButton("Settings");
        JButton btnLogout = new JButton("Logout");
        JButton btnHelp = new JButton("Help");

        panel.add(btnProfile);
        panel.add(btnCourses);
        panel.add(btnGrades);
        panel.add(btnSettings);
        panel.add(btnLogout);
        panel.add(btnHelp);

        // Add panel to frame
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TRYDASH("John Doe"));
    }
}
