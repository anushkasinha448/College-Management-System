package DAO;

import st_accounts.link;

import java.util.Scanner;

public class front {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your full name ");
        String Name = sc.nextLine();
        System.out.println("rEnter your redgestration no : ");
        int id=sc.nextInt();
        System.out.println("sid : "+id);

        link.showStu(id);
    }
}
