package ALLGUI;


import st_accounts.link;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountantPanelFrame extends JFrame {

    private JTextField nameField;
    private JTextField regField;
    private JTextArea resultArea;

    public AccountantPanelFrame() {
        setTitle("Student Account Viewer");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Full Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Registration No:"));
        regField = new JTextField();
        inputPanel.add(regField);

        JButton searchButton = new JButton("Show Account");
        inputPanel.add(searchButton);

        JButton clearButton = new JButton("Clear");
        inputPanel.add(clearButton);

        add(inputPanel, BorderLayout.NORTH);

        // Result area
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // Button actions
        searchButton.addActionListener(e -> showAccount());

        clearButton.addActionListener(e -> {
            nameField.setText("");
            regField.setText("");
            resultArea.setText("");
        });
        setVisible(true);
    }

    private void showAccount() {
        String name = nameField.getText().trim();
        String regStr = regField.getText().trim();

        if (name.isEmpty() || regStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both Name and Registration No.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int regNo;
        try {
            regNo = Integer.parseInt(regStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Registration number must be a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Clear previous result
        resultArea.setText("");

        // Call your DAO method
        link.showStuGUI(regNo, resultArea);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AccountantPanelFrame frame = new AccountantPanelFrame();
            frame.setVisible(true);
        });
    }
}
