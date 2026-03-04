package DAO;

import students_details.add_student;
import students_details.functions;

import java.io.IOException;
import java.util.Scanner;

public class details {
    public static void main(String[] args)  throws IOException {
        try {
            System.out.println("Welcome to Student Management App");
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Press 1 to Add Student");
                System.out.println("Press 2 to Delete student");
                System.out.println("Press 3 to display student");
                System.out.println("Press 4 to exit app");

                int c = sc.nextInt();
                sc.nextLine();
                if (c == 1) {
                    //Add
                    System.out.println("Enter the  student id  ");
                    int sid = sc.nextInt();
                    System.out.println("Enter the student name ");
                    String na = sc.nextLine();
                    System.out.println("Enter the father's  name ");
                    String fa = sc.nextLine();
                    System.out.println("Enter the mother's  name ");
                    String ma = sc.nextLine();
                    System.out.println("Enter the student phone number ");
                    int phonea = sc.nextInt();
                    System.out.println("Enter the Course  ");
                    String course = sc.nextLine();
                    System.out.println("Enter the paid fee fee ");
                    String branch = sc.nextLine();
                    System.out.println("Enter the year  ");
                    String year = sc.nextLine();
                    ;

                    //create student object to store student
                    // int studentid, String studentname, String F_name ,String M_name,String Course, String Branch,  String year,int phone
                    add_student st = new add_student(sid, na, fa, ma,phonea, course, branch, year);
                    boolean ans = functions.insertStudentToDb(st);
                    if (ans) {
                        System.out.println("student is added...");
                    } else {
                        System.out.println("Something went wrong... try again later!!");
                    }
                    System.out.println(st);
                } else if (c == 2) {
                    //delete ele
                    System.out.println("Enter the id to delete : ");
                    int iid = sc.nextInt();
                    boolean y = functions.deleteStudent(iid);

                    if (y) {
                        System.out.println("deleted...");
                    } else {
                        System.out.println("Something went wrong... try again later!!");
                    }
                } else if (c == 3) {
                    // display
                    functions.getAllStudents();
                } else if (c == 4) {
                    break;
                } else {

                }
            }
            System.out.println("Thank you for using my aaplication !!");
            System.out.println("See you soon ... bey bey");
        } catch (Exception e) {
            System.out.println("Something went wrong !!");
            ;
        }
    }
}

