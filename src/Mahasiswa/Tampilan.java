package Mahasiswa;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Tampilan extends javax.swing.JFrame {
    
    int length;
    Mahasiswa DaftarMhs[] = new Mahasiswa[10];
    int lenght = 0;
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    

    String dbUrl = "Jdbc:mysql://localhost:3306/pbo";
    String login = "root";
    String pwd = null;
    String sql = "Select nama,nim,kelas,prodi from mahasiswa";

    private DefaultTableModel Mahasiswa;

    public Tampilan() {
        initComponents();
        Mahasiswa = new DefaultTableModel();
        tabelMhs.setModel(Mahasiswa);
        Mahasiswa.addColumn("Nama Mahasiswa");
        Mahasiswa.addColumn("NIM");
        Mahasiswa.addColumn("Kelas");
        Mahasiswa.addColumn("Prodi");

        TableColumn column;
        tabelMhs.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabelMhs.getColumnModel().getColumn(0);
        column.setPreferredWidth(200);
        column = tabelMhs.getColumnModel().getColumn(1);
        column.setPreferredWidth(75);
        column = tabelMhs.getColumnModel().getColumn(2);
        column.setPreferredWidth(50);
        column = tabelMhs.getColumnModel().getColumn(3);
        column.setPreferredWidth(200);
        
        database();
    }
    
    public void database() {
        //menghapus isi table tblGaji
        Mahasiswa.getDataVector().removeAllElements();
        Mahasiswa.fireTableDataChanged();

        try {
           
            Statement stat = (Statement) Config.getKoneksi().createStatement();
            String sql = "Select * from mahasiswa";
            
            ResultSet res = stat.executeQuery(sql);
            
            
            //penelusuran baris pada tabel tblGaji dari database
            for (int i = 0; i < DaftarMhs.length; i++) {
                DaftarMhs[i] = new Mahasiswa();
            }

            int y = 0;
            
            while (res.next()) {
                DaftarMhs[y].setNama(res.getString("nama"));
                DaftarMhs[y].setNim(res.getString("nim"));
                DaftarMhs[y].setKelas(res.getString("kelas"));
                DaftarMhs[y].setProdi(res.getString("prodi"));
                lenght++;
                Object[] tes = new Object[4];
                tes[0] = DaftarMhs[y].getNama();
                tes[1] = DaftarMhs[y].getNim();
                tes[2] = DaftarMhs[y].getKelas();
                tes[3] = DaftarMhs[y].getProdi();

                Mahasiswa.addRow(tes);
                y++;
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMhs = new javax.swing.JTable();
        Cari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextCari = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelMhs.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelMhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tabelMhs);

        Cari.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Cari.setText("Cari Data Mahasiswa");
        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });

        TextCari.setColumns(20);
        TextCari.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TextCari.setRows(5);
        jScrollPane2.setViewportView(TextCari);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel1.setText("DATA MAHASISWA");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Tambah Data Mahasiswa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Cari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(70, 70, 70))))
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cari)
                    .addComponent(jButton1))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
        String search = JOptionPane.showInputDialog("Masukkan Data Mahasiswa (Nama/Nim/Kelas/Prodi)");
        TextCari.setText("");
        
        int j=0;
        for (int i = 0; i < DaftarMhs.length; i++) {
            if (DaftarMhs[i].getNama().equalsIgnoreCase(search) ||
                DaftarMhs[i].getNim().equalsIgnoreCase(search) || 
                DaftarMhs[i].getKelas().equalsIgnoreCase(search) ||
                DaftarMhs[i].getProdi().equalsIgnoreCase(search)){
                TextCari.append("Nama Mahasiswa\t : " + DaftarMhs[i].getNama() + "\n");
                TextCari.append("Nim\t\t : " + DaftarMhs[i].getNim() + "\n");
                TextCari.append("Kelas\t\t : " + DaftarMhs[i].getKelas() + "\n");
                TextCari.append("Prodi\t\t : " + DaftarMhs[i].getProdi() + "\n\n");
                
                j=2;
            } 
        }
        if (j==0) {
                TextCari.setText("Data Mahasiswa Tidak Ada");
            }

    }//GEN-LAST:event_CariActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String nama = JOptionPane.showInputDialog("Masukkan Nama Mahasiswa : ");
       String nim = JOptionPane.showInputDialog("Masukkan NIM Mahasiswa : ");
       String kelas = JOptionPane.showInputDialog("Masukkan Kelas Mahasiswa : ");
       String prodi = JOptionPane.showInputDialog("Masukkan Prodi Mahasiswa : ");
       
       
       try {
            String tambah = "INSERT INTO mahasiswa (nama,nim,kelas,prodi) VALUES ('"+nama+"','"+nim+"','"+kelas+"','"+prodi+"')";
            con = DriverManager.getConnection(dbUrl, login, pwd);
            java.sql.PreparedStatement pstm = con.prepareStatement (tambah);
            pstm.execute();
            JOptionPane.showMessageDialog(null,"Data Mahasiswa Berhasil Ditambahkan");
            database();
           
               
        }catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }   
        
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tampilan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cari;
    private javax.swing.JTextArea TextCari;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelMhs;
    // End of variables declaration//GEN-END:variables
}
