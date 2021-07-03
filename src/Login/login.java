/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

/**
 *
 * @author ASUS
 */
public class login {

    private String Data, username, password, chek;

    public login(String data) {
        this.Data = data;
    }

    public login() {
    }

    public String cheklogin(String username, String password) {
        if (this.getUsername().equalsIgnoreCase(username) && this.getPassword().equalsIgnoreCase(password)) {
            this.chek = "LOGIN BERHASIL";
        } else {
            this.chek = "LOGIN GAGAL";
        }
        return this.chek;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChek() {
        return chek;
    }

    public void setChek(String chek) {
        this.chek = chek;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

}
