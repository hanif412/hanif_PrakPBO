package LatihanPBO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class koneksi {

    private static Connection conn;

    public static Connection getKoneksi() {
        String host = "Jdbc:mysql://localhost:3306/pbo",
                user = "root",
                pass = null;
        try {
            conn = (Connection) DriverManager.getConnection(host, user, pass);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return conn;
    }
}
