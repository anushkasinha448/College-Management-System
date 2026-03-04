package ALLGUI;

import students_details.add_student;
import students_details.functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentGUI {

    private JFrame frame;
    private JTextArea displayArea;

    public StudentGUI() {
        frame = new JFrame("Student Management App");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top panel with buttons
        JPanel panel = new JPanel();
        JButton addBtn = new JButton("Add Student");
        JButton deleteBtn = new JButton("Delete Student");
        JButton displayBtn = new JButton("Display Students");

        panel.add(addBtn);
        panel.add(deleteBtn);
        panel.add(displayBtn);

        frame.add(panel, BorderLayout.NORTH);

        // Text area for displaying students
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Button actions
        addBtn.addActionListener(e -> addStudent());
        deleteBtn.addActionListener(e -> deleteStudent());
        displayBtn.addActionListener(e -> displayStudents());

        frame.setVisible(true);
    }

    private void addStudent() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Student ID:"));
            String name = JOptionPane.showInputDialog(frame, "Enter Student Name:");
            String father = JOptionPane.showInputDialog(frame, "Enter Father's Name:");
            String mother = JOptionPane.showInputDialog(frame, "Enter Mother's Name:");
            String course = JOptionPane.showInputDialog(frame, "Enter Course:");
            String branch = JOptionPane.showInputDialog(frame, "Enter Branch:");
            String year = JOptionPane.showInputDialog(frame, "Enter Year:");
            long phone = Long.parseLong(JOptionPane.showInputDialog(frame, "Enter Phone Number:"));
            // Call your database function here
            add_student st = new add_student(id, name, father, mother, phone, course, branch, year);
            boolean success = functions.insertStudentToDb(st);

            if (success) {
                JOptionPane.showMessageDialog(frame, "Student added successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Failed to add student!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input! Try again.");
        }
    }

    private void deleteStudent() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Student ID to Delete:"));
            boolean success = functions.deleteStudent(id);
            if (success) {
                JOptionPane.showMessageDialog(frame, "Student deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Student not found!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input! Try again.");
        }
    }

    private void displayStudents() {
        // Get student list from DB
        java.util.List<add_student> studentList = functions.getAllStudents();

        if (studentList.isEmpty()) {
            displayArea.setText("No students found.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (add_student s : studentList) {
            sb.append(s.toString()).append("\n\n");
        }

        // 🔥 Add total count at the end
        sb.append("====================================\n");
        sb.append("Total Students: ").append(studentList.size()).append("\n");
        sb.append("====================================");

        displayArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentGUI::new);
    }
}
