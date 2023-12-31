/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
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
public class gudang_obat extends javax.swing.JFrame {

    /**
     * Creates new form gudang_obat
     */
    public Statement st;
    public ResultSet rs;
    Connection cn = DBMS.mysql_connector.open_con();
    public gudang_obat() {
        initComponents();
        print_data();
    }
    private void print_data(){
        try{        
            String query_print = "SELECT * FROM gudang_obat";
            st = cn.createStatement();
            rs = st.executeQuery(query_print);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Obat");
            model.addColumn("Nama Obat");
            model.addColumn("Harga Obat");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
           
            while (rs.next()){
                Object [] data = {
                    rs.getString("kode_obat"),
                    rs.getString("nama_obat"),
                    rs.getString("harga_obat"),
                };
                model.addRow(data);
                tabel_obat.setModel(model);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_obat = new javax.swing.JTable();
        baru = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        id_obat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        nambat = new javax.swing.JTextField();
        harbat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabel_obat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id obat", "nama obat", "harga obat"
            }
        ));
        jScrollPane1.setViewportView(tabel_obat);

        baru.setText("Baru");
        baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baruActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Obat");

        id_obat.setMinimumSize(new java.awt.Dimension(100, 22));
        id_obat.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel2.setText("Nama Obat");

        jLabel3.setText("Harga Obat");

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        nambat.setMinimumSize(new java.awt.Dimension(100, 22));
        nambat.setPreferredSize(new java.awt.Dimension(100, 22));

        harbat.setMinimumSize(new java.awt.Dimension(100, 22));
        harbat.setPreferredSize(new java.awt.Dimension(100, 22));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(baru)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(harbat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nambat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_obat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id_obat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nambat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(harbat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(baru)
                    .addComponent(save))
                .addGap(85, 85, 85)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baruActionPerformed
        try {
            // TODO add your handling code here:
            st = cn.createStatement();
            String get_rows = String.format("select count(kode_obat) from gudang_obat");
            rs = st.executeQuery(get_rows);
            if (rs.next()){
                int auto_no = rs.getInt(1);
                auto_no += 1;
                String s_auto_no = Integer.toString(auto_no);
                id_obat.setText(String.format("KO-%s",s_auto_no));
                
                nambat.setText("");
                harbat.setText("");
            }
            else{
                System.out.print("return False from query");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(gudang_obat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_baruActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {
            st = cn.createStatement();
            
            String nobat = id_obat.getText();
            String nama = nambat.getText();
            String harbot = harbat.getText();
            
            String insert_data = String.format("INSERT INTO gudang_obat VALUES('%s','%s','%s')",nobat,nama,harbot);
            st.execute(insert_data);
            print_data();
            JOptionPane.showMessageDialog(null,"success save data");
        } catch (SQLException ex) {
            Logger.getLogger(gudang_obat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveActionPerformed

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
            java.util.logging.Logger.getLogger(gudang_obat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gudang_obat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gudang_obat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gudang_obat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gudang_obat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baru;
    private javax.swing.JTextField harbat;
    private javax.swing.JTextField id_obat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nambat;
    private javax.swing.JButton save;
    private javax.swing.JTable tabel_obat;
    // End of variables declaration//GEN-END:variables
}
