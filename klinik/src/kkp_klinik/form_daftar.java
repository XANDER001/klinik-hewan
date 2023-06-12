/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
//INI FORM DAFTAR


package kkp_klinik;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

//disable text field
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author Xander001
 */
//Connection cn = RDMBS.mysql_connection.open_con();
public class form_daftar extends javax.swing.JFrame {

    /**
     * Creates new form pasien_logic
     */
    public Statement st;
    public ResultSet rs;
    Connection cn = DBMS.mysql_connector.open_con();
    public form_daftar() {
        initComponents();
        print_data();
    }
    private void clean(){
        check_pasien.setText("");
        nama_pemilik.setText("");
        alamat_pemilik.setText("");
        telp_pemilik.setText("");
        usia_pasien.setText("");
        kota_pemilik.setSelectedIndex(0);
        kelamin_pasien.setSelectedIndex(0);
    }
    private void print_data(){
        try{        
            String query_print = "SELECT * FROM pasien";
            st = cn.createStatement();
            rs = st.executeQuery(query_print);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No.id");
            model.addColumn("Nama Pemilik");
            model.addColumn("Alamat");
            model.addColumn("Kota");
            model.addColumn("Telp");
            model.addColumn("Nama Hewan");
            model.addColumn("Jenis");
            model.addColumn("Ras");
            model.addColumn("Warna");
            model.addColumn("Kelamin");
            model.addColumn("Usia");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
           
            while (rs.next()){
                Object [] data = {
                    rs.getString("id_pasien"),
                    rs.getString("nama_pemilik"),
                    rs.getString("alamat_pemilik"),
                    rs.getString("kota_pemilik"),
                    rs.getString("telp_pemilik"),
                    rs.getString("nama_hewan"),
                    rs.getString("jenis_hewan"),
                    rs.getString("ras_hewan"),
                    rs.getString("warna_hewan"),
                    rs.getString("kelamin_hewan"),
                    rs.getString("usia_hewan"),
                };
                model.addRow(data);
                cust_tabel.setModel(model);
            }
        } catch (Exception e){
//            return null;
        }
    }
    
    private void cari_pasien(){
        try{
        st = cn.createStatement();

        String id = check_pasien.getText();

        String check_idpasien = String.format("select * from pasien where id_pasien='%s'",id);
        
        rs = st.executeQuery(check_idpasien);
        if(rs.next()){
            JOptionPane.showMessageDialog(null,"Pasien Sudah Terdaftar","Pasien",JOptionPane.INFORMATION_MESSAGE);
//            pemilik
            id_pasien.setText(rs.getString("id_pasien"));
            nama_pemilik.setText(rs.getString("nama_pemilik"));
            alamat_pemilik.setText(rs.getString("alamat_pemilik"));
            telp_pemilik.setText(rs.getString("telp_pemilik"));
            kota_pemilik.setSelectedItem(rs.getString("kota_pemilik"));
//          hewan peliharaan                       
            nama_hewan.setText(rs.getString("nama_hewan"));
            jenis_hewan.setSelectedItem(rs.getString("jenis_hewan"));
            ras_hewan.setText(rs.getString("ras_hewan"));
            warna_hewan.setText(rs.getString("warna_hewan"));
            usia_pasien.setText(rs.getString("usia_hewan"));
            kelamin_pasien.setSelectedItem(rs.getString("kel_hewan"));
//            button
            edit.setEnabled(true);
            id_pasien.setEnabled(true);
            nama_pemilik.setEnabled(true);
            alamat_pemilik.setEnabled(true);
            telp_pemilik.setEnabled(true);
            usia_pasien.setEnabled(true);
            kota_pemilik.setEnabled(true);
            kelamin_pasien.setEnabled(true);
            nama_hewan.setEnabled(true);
            jenis_hewan.setEnabled(true);
            ras_hewan.setEnabled(true);
            warna_hewan.setEnabled(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"Pasien Belum Terdaftar","Pasien",JOptionPane.INFORMATION_MESSAGE);
            id_pasien.setEnabled(true);
            nama_pemilik.setEnabled(true);
            alamat_pemilik.setEnabled(true);
            telp_pemilik.setEnabled(true);
            usia_pasien.setEnabled(true);
            kota_pemilik.setEnabled(true);
            kelamin_pasien.setEnabled(true);
            nama_hewan.setEnabled(true);
            jenis_hewan.setEnabled(true);
            ras_hewan.setEnabled(true);
            warna_hewan.setEnabled(true);
            save.setEnabled(true);
            edit.setEnabled(true);
            
//            clear input section if input was already write
            id_pasien.setText("");
            nama_pemilik.setText("");
            alamat_pemilik.setText("");
            telp_pemilik.setText("");
            kota_pemilik.setSelectedIndex(0);
            nama_hewan.setText("");
            jenis_hewan.setSelectedIndex(0);
            ras_hewan.setText("");
            warna_hewan.setText("");
            usia_pasien.setText("");
            kelamin_pasien.setSelectedIndex(0);
        }
    }
    catch (Exception e){
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        panel_form = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nama_pemilik = new javax.swing.JTextField();
        alamat_pemilik = new javax.swing.JTextField();
        telp_pemilik = new javax.swing.JTextField();
        usia_pasien = new javax.swing.JTextField();
        kota_pemilik = new javax.swing.JComboBox<>();
        kelamin_pasien = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nama_hewan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jenis_hewan = new javax.swing.JComboBox<>();
        ras_hewan = new javax.swing.JTextField();
        warna_hewan = new javax.swing.JTextField();
        id_pasien = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cust_tabel = new javax.swing.JTable();
        save = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        pembersihan = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        check_pasien = new javax.swing.JTextField();
        check = new javax.swing.JButton();
        baru = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        panel_form.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nama");

        jLabel3.setText("Alamat");

        jLabel4.setText("Kota");

        jLabel5.setText("Telp");

        jLabel6.setText("Kelamin");

        jLabel7.setText("Usia");

        nama_pemilik.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                nama_pemilikComponentShown(evt);
            }
        });
        nama_pemilik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_pemilikActionPerformed(evt);
            }
        });

        usia_pasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usia_pasienActionPerformed(evt);
            }
        });

        kota_pemilik.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------", "Jakarta", "Bogor", "Depok", "Tangerang", "Bekasi" }));
        kota_pemilik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kota_pemilikActionPerformed(evt);
            }
        });

        kelamin_pasien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------", "Laki-Laki", "Perempuan" }));

        jLabel8.setText("Pemilik");

        jLabel9.setText("Hewan Peliharaan");

        nama_hewan.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                nama_hewanComponentShown(evt);
            }
        });
        nama_hewan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_hewanActionPerformed(evt);
            }
        });

        jLabel10.setText("Nama");

        jLabel11.setText("Jenis");

        jLabel12.setText("Ras");

        jLabel13.setText("Warna");

        jenis_hewan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------", "Anjing", "Kucing" }));

        warna_hewan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warna_hewanActionPerformed(evt);
            }
        });

        id_pasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_pasienActionPerformed(evt);
            }
        });

        jLabel14.setText("No.Reg");

        javax.swing.GroupLayout panel_formLayout = new javax.swing.GroupLayout(panel_form);
        panel_form.setLayout(panel_formLayout);
        panel_formLayout.setHorizontalGroup(
            panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_formLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_formLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nama_pemilik, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_formLayout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(telp_pemilik, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_formLayout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(alamat_pemilik, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_formLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kota_pemilik, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_formLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(id_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
                .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_formLayout.createSequentialGroup()
                                .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usia_pasien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kelamin_pasien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_formLayout.createSequentialGroup()
                            .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)))
                            .addGap(18, 18, 18)
                            .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nama_hewan, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(warna_hewan)
                                .addComponent(ras_hewan)
                                .addComponent(jenis_hewan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel12))
                .addContainerGap())
        );
        panel_formLayout.setVerticalGroup(
            panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_formLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(nama_hewan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(id_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_formLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jenis_hewan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(ras_hewan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(warna_hewan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(kelamin_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_formLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nama_pemilik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(alamat_pemilik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(kota_pemilik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(telp_pemilik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(usia_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        cust_tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.Reg", "Nama Pemilik", "Alamat", "Kota", "Telp", "Nama Hewan", "Jenis", "Ras", "Warna", "Kelamin", "Usia"
            }
        ));
        cust_tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cust_tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cust_tabel);

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        pembersihan.setText("Bersih");
        pembersihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pembersihanActionPerformed(evt);
            }
        });

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        jLabel1.setText("Cari");

        check_pasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_pasienActionPerformed(evt);
            }
        });

        check.setText("Check");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        baru.setText("Baru");
        baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(baru))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(check_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(check))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pembersihan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(check_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(pembersihan)
                    .addComponent(keluar)
                    .addComponent(edit)
                    .addComponent(hapus)
                    .addComponent(baru))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {
            // TODO add your handling code here:
            st = cn.createStatement();
//          pemilik
            String id = id_pasien.getText();
            String nama = nama_pemilik.getText();
            String alamat = alamat_pemilik.getText();
            String telp = telp_pemilik.getText();
            String kota = kota_pemilik.getSelectedItem().toString();
//          hewan peliharaan
            String namhew = nama_hewan.getText();
            String jenhew = jenis_hewan.getSelectedItem().toString();
            String rashew = ras_hewan.getText();
            String warhew = warna_hewan.getText();
            String kelamin = kelamin_pasien.getSelectedItem().toString();
            String usia = usia_pasien.getText();
            
            String insert_data = String.format("INSERT INTO pasien Values ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',%s)",id,nama,alamat,kota,telp,namhew,jenhew,rashew,warhew,kelamin,usia);
            st.execute(insert_data);
            JOptionPane.showMessageDialog(null,"success save data");
            print_data();
            clean();
        } catch (SQLException ex) {
            Logger.getLogger(form_daftar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void check_pasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_pasienActionPerformed
        // TODO add your handling code here:
        cari_pasien();
    }//GEN-LAST:event_check_pasienActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
    cari_pasien();
    
       
    }//GEN-LAST:event_checkActionPerformed

    private void nama_pemilikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_pemilikActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nama_pemilikActionPerformed

    private void nama_pemilikComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_nama_pemilikComponentShown
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nama_pemilikComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        id_pasien.setEnabled(false);
        nama_pemilik.setEnabled(false);
        alamat_pemilik.setEnabled(false);
        telp_pemilik.setEnabled(false);
        usia_pasien.setEnabled(false);
        kota_pemilik.setEnabled(false);
        kelamin_pasien.setEnabled(false);
        nama_hewan.setEnabled(false);
        jenis_hewan.setEnabled(false);
        ras_hewan.setEnabled(false);
        warna_hewan.setEnabled(false);
        save.setEnabled(false);
        edit.setEnabled(false);
//        set color to recognize textfield was disable
//        nama_pemilik.setBackground(Color.red);
//        alamat_pemilik.setBackground(Color.red);
//        telp_pemilik.setBackground(Color.red);
//        usia_pasien.setBackground(Color.red);
        
    }//GEN-LAST:event_formComponentShown

    private void kota_pemilikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kota_pemilikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kota_pemilikActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        if (check_pasien.getText().equals("")){
            JOptionPane.showMessageDialog(this, "choice data");
        }
        else{
            int confrim = JOptionPane.showConfirmDialog(null, "are you sure ?", "Danger", JOptionPane.YES_NO_OPTION);
            if (confrim == 0){
                try {
                    st = cn.createStatement();
                    
                    String query_delete = String.format("DELETE FROM pasien WHERE id_reg=%s",check_pasien.getText());
                    st.executeUpdate(query_delete);
                    JOptionPane.showMessageDialog(null, "Berhasil di hapus");
                    print_data();
                    clean();
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_keluarActionPerformed

    private void pembersihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pembersihanActionPerformed
        // TODO add your handling code here:
        clean();
    }//GEN-LAST:event_pembersihanActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        try{
            st = cn.createStatement();
            //pemilik
            String id = check_pasien.getText();
            String nama = nama_pemilik.getText();
            String alamat = alamat_pemilik.getText();
            String telp = telp_pemilik.getText();
            String kota = kota_pemilik.getSelectedItem().toString();
//          hewan peliharaan
            String namhew = nama_hewan.getText();
            String jenhew = jenis_hewan.getSelectedItem().toString();
            String rashew = ras_hewan.getText();
            String warhew = warna_hewan.getText();
            String kelamin = kelamin_pasien.getSelectedItem().toString();
            String usia = usia_pasien.getText();

            String update_data = String.format("update pasien set id_pas=%s,nama_pem='%s',alamat_pem='%s',kota_pem='%s',telp_pem='%s',nama_bin='%s',jenis_bin='%s',ras_bin='%s',warna_bin='%s',kel_bin='%s',usia_bin='%s' where id_pas=%s",id,nama,alamat,kota,telp,namhew,jenhew,rashew,warhew,kelamin,usia,id);
            st.executeUpdate(update_data);
            print_data();
            clean();
            JOptionPane.showMessageDialog(null,"success edit data");
        }
        catch(Exception e){
            System.out.print(e);
        }
    }//GEN-LAST:event_editActionPerformed

    private void cust_tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cust_tabelMouseClicked
        // TODO add your handling code here:
        int row_table = cust_tabel.getSelectedRow();
        check_pasien.setText(cust_tabel.getValueAt(row_table,0).toString());
        
    }//GEN-LAST:event_cust_tabelMouseClicked

    private void usia_pasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usia_pasienActionPerformed
        // TODO add your thandling code here:
    }//GEN-LAST:event_usia_pasienActionPerformed

    private void nama_hewanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_hewanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_hewanActionPerformed

    private void nama_hewanComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_nama_hewanComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_hewanComponentShown

    private void warna_hewanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warna_hewanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_warna_hewanActionPerformed

    private void id_pasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_pasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_pasienActionPerformed

    private void baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baruActionPerformed
        // TODO add your handling code here:
        try{
            st = cn.createStatement();
//            count how many rows in patient table
            String auto_id = "SELECT id_pasien from pasien ORDER BY id_pasien DESC LIMIT 1";
            rs = st.executeQuery(auto_id);
            if (rs.next()){
                String old_id = rs.getString("id_pasien").substring(3);
                System.out.print(old_id);
                int auto_inc = Integer.parseInt(old_id);
                auto_inc += 1;
                String s_auto_no = Integer.toString(auto_inc);
                id_pasien.setText(String.format("PS-%s",s_auto_no));
            }
            
            
        }
        catch (Exception e){
            
        }
    }//GEN-LAST:event_baruActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form_daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_daftar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat_pemilik;
    private javax.swing.JButton baru;
    private javax.swing.JButton check;
    private javax.swing.JTextField check_pasien;
    private javax.swing.JTable cust_tabel;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField id_pasien;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenis_hewan;
    private javax.swing.JComboBox<String> kelamin_pasien;
    private javax.swing.JButton keluar;
    private javax.swing.JComboBox<String> kota_pemilik;
    private javax.swing.JTextField nama_hewan;
    private javax.swing.JTextField nama_pemilik;
    private javax.swing.JPanel panel_form;
    private javax.swing.JButton pembersihan;
    private javax.swing.JTextField ras_hewan;
    private javax.swing.JButton save;
    private javax.swing.JTextField telp_pemilik;
    private javax.swing.JTextField usia_pasien;
    private javax.swing.JTextField warna_hewan;
    // End of variables declaration//GEN-END:variables
}
