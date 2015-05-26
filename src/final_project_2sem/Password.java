/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_2sem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Password extends javax.swing.JFrame {
    private static Password p;
    private Connection conn;
    
    private Password() {
        initComponents();
        conn = DBConnector.getConnection();
    }
    
    public static synchronized Password getPassword() {
        if(p == null)
            p = new Password();
        return p;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfConfirm = new javax.swing.JPasswordField();
        tfNewPass = new javax.swing.JPasswordField();
        tfOldPass = new javax.swing.JPasswordField();
        bCancel = new javax.swing.JButton();
        bChangePass = new javax.swing.JButton();
        errNewPass = new javax.swing.JLabel();
        errOldPass = new javax.swing.JLabel();
        passCheck = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change your password");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Old password:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("New password:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Confirm password:");

        tfConfirm.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tfNewPass.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tfOldPass.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        bCancel.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        bChangePass.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bChangePass.setText("Change Password");
        bChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChangePassActionPerformed(evt);
            }
        });

        errNewPass.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        errNewPass.setForeground(new java.awt.Color(255, 0, 0));
        errNewPass.setText("Type the password again");

        errOldPass.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        errOldPass.setForeground(new java.awt.Color(255, 0, 0));
        errOldPass.setText("Incorrect password");

        passCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project_2sem/Check-icon.png"))); // NOI18N
        passCheck.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bChangePass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errNewPass)
                            .addComponent(errOldPass))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfConfirm, tfNewPass, tfOldPass});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errOldPass)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errNewPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancel)
                    .addComponent(bChangePass))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    private void bChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChangePassActionPerformed
        errNewPass.setVisible(false);
        errOldPass.setVisible(false);        
        
        String oldPass = new String(tfOldPass.getPassword());
        String newPass = new String(tfNewPass.getPassword());
        String confirm = new String(tfConfirm.getPassword());
        if(oldPass.equals("") || newPass.equals("") || confirm.equals(""))
                JOptionPane.showMessageDialog(this, "All fields must be filled in", "Warning", JOptionPane.WARNING_MESSAGE);
        
        else if(checkPass() == -1) 
            errOldPass.setVisible(true);            
        
        else {
            passCheck.setVisible(true);
            if(newPass.equals(confirm)) {
                try {
                    String sql = "UPDATE villa_watt_inventory.users SET Password = ? WHERE UserID = 1;";    //Change if more than 1 account!
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, newPass);
                    pstmt.execute();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Your password was changed successfully!");
                this.dispose();
            }
            else {
                errNewPass.setVisible(true);
                tfNewPass.setText("");
                tfConfirm.setText("");
            }
        }
    }//GEN-LAST:event_bChangePassActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        rootPane.setDefaultButton(bChangePass);
    }//GEN-LAST:event_formWindowGainedFocus
    
    private int checkPass() {
        String pass = new String(tfOldPass.getPassword());
        int id = -1;
        try {    
            String sql = "SELECT UserID FROM villa_watt_inventory.users WHERE Password = '"+pass+"';";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();             
            while(rs.next()) {
                id = rs.getInt("UserID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public JLabel getErrNewPass() {
        return errNewPass;
    }

    public JLabel getErrOldPass() {
        return errOldPass;
    }

    public JLabel getPassCheck() {
        return passCheck;
    }

    public JPasswordField getTfConfirm() {
        return tfConfirm;
    }

    public JPasswordField getTfNewPass() {
        return tfNewPass;
    }

    public JPasswordField getTfOldPass() {
        return tfOldPass;
    }
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
            java.util.logging.Logger.getLogger(Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bChangePass;
    private javax.swing.JLabel errNewPass;
    private javax.swing.JLabel errOldPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel passCheck;
    private javax.swing.JPasswordField tfConfirm;
    private javax.swing.JPasswordField tfNewPass;
    private javax.swing.JPasswordField tfOldPass;
    // End of variables declaration//GEN-END:variables
}
