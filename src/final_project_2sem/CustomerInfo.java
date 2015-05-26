/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_2sem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CustomerInfo extends javax.swing.JFrame {
    private static CustomerInfo c;
    private Connection conn;
    
    private CustomerInfo() {
        initComponents();
        conn = DBConnector.getConnection();
    }
    
    public static synchronized CustomerInfo getCustI() {
        if(c == null)
            c = new CustomerInfo();
        return c;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfFirstName = new javax.swing.JTextField();
        tfAddress = new javax.swing.JTextField();
        tfPhone = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        bSaveCust = new javax.swing.JButton();
        bCancelCustInfo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfLastName = new javax.swing.JTextField();
        custKey = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer Info");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("First name");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Phone No");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Address");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Email");

        tfFirstName.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tfAddress.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tfPhone.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tfEmail.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        bSaveCust.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bSaveCust.setText("Save");
        bSaveCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveCustActionPerformed(evt);
            }
        });

        bCancelCustInfo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bCancelCustInfo.setText("Cancel");
        bCancelCustInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelCustInfoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("Last name");

        tfLastName.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bSaveCust)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelCustInfo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(custKey, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfAddress, tfEmail, tfFirstName, tfLastName, tfPhone});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bCancelCustInfo, bSaveCust});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(custKey, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSaveCust)
                    .addComponent(bCancelCustInfo))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelCustInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelCustInfoActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelCustInfoActionPerformed

    private void bSaveCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveCustActionPerformed
        String fName = tfFirstName.getText();
        String lName = tfLastName.getText();
        String address = tfAddress.getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();
        
        if(checkEmptyField(tfFirstName) || checkEmptyField(tfLastName) || checkEmptyField(tfAddress) || checkEmptyField(tfPhone) || checkEmptyField(tfEmail)) {
            JOptionPane.showMessageDialog(this, "All fields must be filled in", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if(checkPhone()) {
            if(custKey.getText().equals("")) {
                try {
                    String sql = "INSERT INTO villa_watt_inventory.customers (FirstName,LastName,Address,PhoneNo,Email) VALUES(?,?,?,?,?);";

                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, fName);
                    pstmt.setString(2, lName);
                    pstmt.setString(3, address);
                    pstmt.setString(4, phone);
                    pstmt.setString(5, email);
                    pstmt.execute();

                    //Clean all fields
                    cleanCustFields();
                    //Update items Catalogue
                    Inventory.updateCustomersTable();
                    JOptionPane.showMessageDialog(this, "Customer created");

                    this.dispose();
                } catch (SQLException ex1) {
                    Logger.getLogger(CustomerInfo.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            else {
                try { 
                    int key = Integer.parseInt(custKey.getText());
                    Customer cust = Inventory.getCustomerMap().get(key);

                    String sql = "UPDATE villa_watt_inventory.customers SET FirstName = ?,LastName = ?,Address = ?,PhoneNo = ?,Email = ? WHERE CustomerID = ?;";

                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, fName);
                    pstmt.setString(2, lName);
                    pstmt.setString(3, address);
                    pstmt.setString(4, phone);
                    pstmt.setString(5, email);
                    pstmt.setInt(6, cust.getId());
                    pstmt.execute();

                    
                    //Update items Catalogue
                    Inventory.updateCustomersTable();
                    JOptionPane.showMessageDialog(this, "Customer's information saved");

                    this.dispose();            

                } catch (SQLException ex) {                
                    Logger.getLogger(CustomerInfo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_bSaveCustActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        rootPane.setDefaultButton(bSaveCust);
    }//GEN-LAST:event_formWindowGainedFocus
    
    private boolean checkEmptyField(JTextField f) {
        return f.getText().equals("");
    }
    
    public void cleanCustFields() {
        tfFirstName.setText("");
        tfLastName.setText("");
        tfAddress.setText("");
        tfPhone.setText("");
        tfEmail.setText("");
    }
    
    private boolean checkPhone() {
        try {
            int i = Integer.parseInt(tfPhone.getText());
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid phone nr.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public JTextField getFirstName() {
        return tfFirstName;
    }
    
    public JTextField getLastName() {
        return tfLastName;
    }
    
    public JTextField getAddress() {
        return tfAddress;
    }
    
    public JTextField getPhone() {
        return tfPhone;
    }
    
    public JTextField getEmail() {
        return tfEmail;
    }

    public JLabel getCustKey() {
        return custKey;
    }
    
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
            java.util.logging.Logger.getLogger(CustomerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelCustInfo;
    private javax.swing.JButton bSaveCust;
    private javax.swing.JLabel custKey;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JTextField tfPhone;
    // End of variables declaration//GEN-END:variables
}
