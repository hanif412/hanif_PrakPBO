/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class execute {

    static Scanner input = new Scanner(System.in);
    static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost:3306/pbo";
    static String USER = "root";
    static String PASS = null;

    static Connection connect;
    static Statement stmtt;
    static ResultSet rse;

    static void MEnuAdmin() {
        System.out.println("\n| ========= DAFTAR PILIHAN ========= |");
        System.out.println("1. Insert User");
        System.out.println("2. Show User");
        System.out.println("3. Edit User");
        System.out.println("4. Delete User");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN :  ");

        try {
            int pilihan = Integer.parseInt(input.nextLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    insertsistemlogin();
                    break;
                case 2:
                    showData();
                    break;
                case 3:
                    updatesistemlogin();
                    break;
                case 4:
                    deletesistemlogin();
                    break;
                default:
                    System.out.println("EROR tidak ada pilihan!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void MEnusuperuser() {
        System.out.println("\n| ========= DAFTAR PILIHAN ========= |");
        System.out.println("1. Insert User");
        System.out.println("2. Show User");
        System.out.println("3. Edit User");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN :  ");

        try {
            int pilihan = Integer.parseInt(input.nextLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    insertsistemlogin();
                    break;
                case 2:
                    showData();
                    break;
                case 3:
                    updatesistemlogin();
                    break;
                default:
                    System.out.println("EROR tidak ada pilihan!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void MEnuuser() {
        System.out.println("\n| ========= DAFTAR PILIHAN ========= |");
        System.out.println("1. Show User");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN :  ");

        try {
            int pilihan = Integer.parseInt(input.nextLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    showData();
                    break;
                default:
                    System.out.println("EROR tidak ada pilihan!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showData() {
        try {
            String sql = "SELECT * FROM login";
            rse = stmtt.executeQuery(sql);

            System.out.println("| --------- DATA PENGGUNA ---------");
            while (rse.next()) {
                System.out.println("| ID User\t : " + rse.getString("id"));
                System.out.println("| Nama User\t : " + rse.getString("username"));
                System.out.println("| Password\t : " + rse.getString("password"));
                System.out.println("||||||||||||||||||||||||||||||");
            }
            System.out.println("-------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void insertsistemlogin() {
        try {
            System.out.print("ID User\t : ");
            int id = Integer.parseInt(input.nextLine());
            System.out.print("Nama User\t : ");
            String username = input.nextLine();
            System.out.print("Password\t : ");
            String password = input.nextLine();
            System.out.print("Detail\t : ");
            String detail = input.nextLine();

            String sql = "INSERT INTO login (id,username,password) VALUE('%d', '%s','%s', '%s')";
            sql = String.format(sql, id, username, password, detail);

            stmtt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void updatesistemlogin() {

        try {
            System.out.print("ID User yang akan diedit : ");
            int id = Integer.parseInt(input.nextLine());
            System.out.print("Nama User\t : ");
            String username = input.nextLine();
            System.out.print("Password\t : ");
            int password = Integer.parseInt(input.nextLine());
            System.out.print("Detail\t : ");
            int detail = Integer.parseInt(input.nextLine());

            String sql = "UPDATE login SET username='%s', password='%s' WHERE id=%d";
            sql = String.format(sql, username, password, detail, id);

            stmtt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deletesistemlogin() {
        try {
            System.out.print("ID User yang mau dihapus: ");
            String id = input.nextLine();

            String sql = String.format("DELETE FROM login WHERE id=%s", id);

            stmtt.execute(sql);

            System.out.println("Hapus User Berhasil hapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
