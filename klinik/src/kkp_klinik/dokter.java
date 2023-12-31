/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

//INI FORM PENAMBAHAN DOKTER
package kkp_klinik;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Xander001
 */
public class dokter extends javax.swing.JFrame {

    /**
     * Creates new form user_form
     */
    public Statement st;
    public ResultSet rs;
    Connection cn = DBMS.mysql_connector.open_con();
    
    public dokter() {
        initComponents();
        print_data();
    }
    private void print_data(){
        try{        
            String query_print = "SELECT * FROM dokter";
            st = cn.createStatement();
            rs = st.executeQuery(query_print);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nama Dokter");
            model.addColumn("Spesialis");
            model.addColumn("Alamat");
            model.addColumn("Telp");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
           
            while (rs.next()){
                Object [] data = {
                    rs.getString("id_dokter"),
                    rs.getString("nama_dokter"),
                    rs.getString("spesialis_dokter"),
                    rs.getString("alamat_dokter"),
                    rs.getString("telp_dokter"),
                };
                model.addRow(data);
                tabel_dok.setModel(model);
            }
        } catch (Exception e){
//            return null;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id_dokter = new javax.swing.JTextField();
        spesialis_dok = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat_dok = new javax.swing.JTextArea();
        telp_dok = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_dok = new javax.swing.JTable();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        nama_dok = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        baru = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("ID Dokter");

        jLabel2.setText("Spesialis");

        jLabel3.setText("Alamat");

        jLabel4.setText("No.Telepon");

        spesialis_dok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------", "Penyakit Dalam", "Umum" }));

        alamat_dok.setColumns(20);
        alamat_dok.setRows(5);
        jScrollPane1.setViewportView(alamat_dok);

        tabel_dok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Dokter", "Spesialis", "Alamat", "No Telp"
            }
        ));
        jScrollPane2.setViewportView(tabel_dok);

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        delete.setText("Delete");

        cancel.setText("Cancel");

        jLabel5.setText("Nama Dokter");

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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(telp_dok, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(id_dokter, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(spesialis_dok, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nama_dok)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(baru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(save)
                        .addGap(18, 18, 18)
                        .addComponent(delete)
                        .addGap(18, 18, 18)
                        .addComponent(cancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id_dokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nama_dok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spesialis_dok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(79, 79, 79)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(telp_dok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(delete)
                    .addComponent(cancel)
                    .addComponent(baru))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        try{
            st = cn.createStatement();
            
//            using auto increment 
            String id_dok = id_dokter.getText();
            
            String nam_dok = nama_dok.getText();
            String spes_dok = spesialis_dok.getSelectedItem().toString();
            String alm_dok = alamat_dok.getText();
            String no_dok = telp_dok.getText();

            String insert_data = String.format("INSERT INTO dokter Values ('%s','%s','%s','%s','%s')",id_dok,nam_dok,spes_dok,alm_dok,no_dok);
            st.execute(insert_data);
            print_data();
            JOptionPane.showMessageDialog(null,"success save data");
        }
        catch (Exception e){
            
        }
    }//GEN-LAST:event_saveActionPerformed

    private void baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baruActionPerformed
        // TODO add your handling code here:
        nama_dok.setEnabled(true);
        spesialis_dok.setEnabled(true);
        alamat_dok.setEnabled(true);
        telp_dok.setEnabled(true);
        
        save.setEnabled(true);
        delete.setEnabled(true);
        cancel.setEnabled(true);
        
        try {
            // set auto increment for id dokter using DTH-{}
            // maybe using lenght to calculate how many data rows in database to make auto increment
            
            st = cn.createStatement();
            String auto_id = "SELECT id_dokter from dokter ORDER BY id_dokter DESC LIMIT 1";
            rs = st.executeQuery(auto_id);
            if (rs.next()){
                String old_id = rs.getString("id_dokter").substring(4);
                System.out.print(old_id);
                int auto_inc = Integer.parseInt(old_id);
                auto_inc += 1;
                String s_auto_no = Integer.toString(auto_inc);
                id_dokter.setText(String.format("DTH-%s",s_auto_no));
            }
            
//        id_dokter.setText(String.format("DTH-%s",s_auto_no));
        } catch (SQLException ex) {
            Logger.getLogger(dokter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_baruActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        id_dokter.setEditable(false);
        nama_dok.setEnabled(false);
        spesialis_dok.setEnabled(false);
        alamat_dok.setEnabled(false);
        telp_dok.setEnabled(false);
        
        save.setEnabled(false);
        delete.setEnabled(false);
        cancel.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dokter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat_dok;
    private javax.swing.JButton baru;
    private javax.swing.JButton cancel;
    private javax.swing.JButton delete;
    private javax.swing.JTextField id_dokter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nama_dok;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> spesialis_dok;
    private javax.swing.JTable tabel_dok;
    private javax.swing.JTextField telp_dok;
    // End of variables declaration//GEN-END:variables
}
