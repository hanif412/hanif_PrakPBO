/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Testlogin extends execute {

    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String dbUrl = "Jdbc:mysql://localhost:3306/pbo";
        String login = "root";
        String pwd = null;
        String sql = "Select id,username,password from login";

        String username, password;
        Scanner input = new Scanner(System.in);
        login cheklogin  = new login();
        login login_as[] = new login[3];

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, login, pwd);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            int no = 0;
            while (rs.next()) {
                login_as[no] = new login();
                login_as[no].setUsername(rs.getString("username"));
                login_as[no].setPassword(rs.getString("password"));
                no++;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        while (true) {

            System.out.println("LOGIN SEBAGAI : ");
            System.out.print("Username\t : ");
            username = input.nextLine();
            System.out.print("Passwrod\t : ");
            password = input.nextLine();

            for (int i = 0; i < 3; i++) {
                if ("LOGIN BERHASIL".equalsIgnoreCase(login_as[i].cheklogin(username, password))) {
                    System.out.println("| ========== BERHASIL LOGIN =========== |");
                    try {
                        Class.forName(JDBC_DRIVER);
                        connect = DriverManager.getConnection(DB_URL, USER, PASS);
                        stmtt = connect.createStatement();
                        if (login_as[i].getUsername().equalsIgnoreCase("admin")) {
                            while (!connect.isClosed()) {
                                MEnuAdmin();
                            }
                        } else if (login_as[i].getUsername().equalsIgnoreCase("superuser")) {
                            while (!connect.isClosed()) {
                                MEnusuperuser();
                            }
                        } else if (login_as[i].getUsername().equalsIgnoreCase("user")) {
                            while (!connect.isClosed()) {
                                MEnuuser();
                            }
                        }

                        stmtt.close();
                        connect.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}

