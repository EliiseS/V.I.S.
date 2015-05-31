
package final_project_2sem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ItemInfo extends javax.swing.JFrame {
    private static ItemInfo i;
    private Connection conn;


    
    private ItemInfo() {
        initComponents(); 
        conn = DBConnector.getConnection();
    }
    
    public static synchronized ItemInfo getItemI() {
        if(i == null)
            i = new ItemInfo();
        return i;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfSerialNo = new javax.swing.JTextField();
        tfType = new javax.swing.JTextField();
        tfBrand = new javax.swing.JTextField();
        tfModel = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();
        bSaveItem = new javax.swing.JButton();
        bCancelItemInfo = new javax.swing.JButton();
        labelRent = new javax.swing.JLabel();
        labelCust = new javax.swing.JLabel();
        bOK = new javax.swing.JButton();
        itemKey = new javax.swing.JLabel();
        star1 = new javax.swing.JLabel();
        star2 = new javax.swing.JLabel();
        star3 = new javax.swing.JLabel();
        star4 = new javax.swing.JLabel();
        errType = new javax.swing.JLabel();
        errBrand = new javax.swing.JLabel();
        errModel = new javax.swing.JLabel();
        errPrice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Item Info");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Serial nr");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Type");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Price");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Brand");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("Model");

        tfSerialNo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tfType.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tfBrand.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tfModel.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tfPrice.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        bSaveItem.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bSaveItem.setText("Save");
        bSaveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveItemActionPerformed(evt);
            }
        });

        bCancelItemInfo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bCancelItemInfo.setText("Cancel");
        bCancelItemInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelItemInfoActionPerformed(evt);
            }
        });

        labelRent.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        labelRent.setText("Rented by");

        labelCust.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelCust.setText("Laura Gadola");

        bOK.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bOK.setText("OK");
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOKActionPerformed(evt);
            }
        });

        star1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        star1.setForeground(new java.awt.Color(255, 0, 0));
        star1.setText("*");

        star2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        star2.setForeground(new java.awt.Color(255, 0, 0));
        star2.setText("*");

        star3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        star3.setForeground(new java.awt.Color(255, 0, 0));
        star3.setText("*");

        star4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        star4.setForeground(new java.awt.Color(255, 0, 0));
        star4.setText("*");

        errType.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        errType.setForeground(new java.awt.Color(255, 0, 0));
        errType.setText("This field is required");

        errBrand.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        errBrand.setForeground(new java.awt.Color(255, 0, 0));
        errBrand.setText("This field is required");

        errModel.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        errModel.setForeground(new java.awt.Color(255, 0, 0));
        errModel.setText("This field is required");

        errPrice.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        errPrice.setForeground(new java.awt.Color(255, 0, 0));
        errPrice.setText("This field is required");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(itemKey, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(star4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(star1)
                                            .addComponent(star2)
                                            .addComponent(star3))
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(errType, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfType)
                                            .addComponent(tfBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(errBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfModel)
                                            .addComponent(errModel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(errPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bSaveItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bCancelItemInfo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bOK, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(labelRent))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCust, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSerialNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfBrand, tfModel, tfPrice, tfSerialNo, tfType});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bCancelItemInfo, bSaveItem});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemKey, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errType)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errBrand)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errModel)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errPrice)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSerialNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCust)
                    .addComponent(labelRent))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bSaveItem)
                    .addComponent(bCancelItemInfo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bOK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelItemInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelItemInfoActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelItemInfoActionPerformed

    private void bSaveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveItemActionPerformed
        String serialNo = tfSerialNo.getText();
        String type     = tfType.getText();
        String brand    = tfBrand.getText();
        String model    = tfModel.getText();
        String price    = tfPrice.getText();
        
        //Error messages invisible
        errType.setVisible(false);
        errBrand.setVisible(false);
        errModel.setVisible(false);
        errPrice.setVisible(false);
        
        if(checkEmptyField(tfType))
            errType.setVisible(true);
        if(checkEmptyField(tfBrand))
            errBrand.setVisible(true);
        if(checkEmptyField(tfModel))
            errModel.setVisible(true);
        if(checkEmptyField(tfPrice))
            errPrice.setVisible(true);
        
        if(!checkEmptyField(tfType) && !checkEmptyField(tfBrand) && !checkEmptyField(tfModel) && !checkEmptyField(tfPrice)){
            if(checkForNumbers(serialNo, price)) {                                
                if(itemKey.getText().equals("")) {
                    try {
                        String sql = "INSERT INTO villa_watt_inventory.items (SerialNo,Type,Brand,Model,Price) VALUES(?,?,?,?,?);";

                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, serialNo);
                        pstmt.setString(2, type);
                        pstmt.setString(3, brand);
                        pstmt.setString(4, model);
                        pstmt.setString(5, price);
                        pstmt.execute();

                        //Update items Catalogue
                        Inventory.updateItemsTable();
                        JOptionPane.showMessageDialog(this, "Item created");

                        this.dispose();

                    } catch (SQLException ex) {
                        Logger.getLogger(ItemInfo.class.getName()).log(Level.SEVERE, null, ex);
                    }            
                }else {
                    /*int key = Integer.parseInt(itemKey.getText());
                    Item item = Inventory.getItemsMap().get(key);*/
                    
                    try { 
                        String sql = "UPDATE villa_watt_inventory.items SET Type = ?,Brand = ?,Model = ?,Price = ? WHERE ItemID = ?;";

                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, type);
                        pstmt.setString(2, brand);
                        pstmt.setString(3, model);
                        pstmt.setString(4, price);
                        pstmt.setString(5, itemKey.getText());
                        pstmt.execute();

                        //Update items Catalogue
                        Inventory.updateItemsTable();
                        JOptionPane.showMessageDialog(this, "Item's information saved");

                        this.dispose();            

                    } catch (SQLException ex) {                
                        Logger.getLogger(ItemInfo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_bSaveItemActionPerformed

    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_bOKActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(bOK.isVisible())
            rootPane.setDefaultButton(bOK);
        else
            rootPane.setDefaultButton(bSaveItem);
    }//GEN-LAST:event_formWindowGainedFocus
    
    private boolean checkEmptyField(JTextField f) {
        return f.getText().equals("");
    }
    
    public void cleanItemFields() {
        tfSerialNo.setText("");
        tfType.setText("");
        tfBrand.setText("");
        tfModel.setText("");
        tfPrice.setText("");
    }
    
    private boolean checkForNumbers(String id, String price) {
        if(!id.equals(""))
            try{
                Integer.parseInt(id);            
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid Serial nr.", "Error", JOptionPane.ERROR_MESSAGE);
                tfSerialNo.setText("");
                return false;
            }        
        try{
            Double.parseDouble(price);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid price", "Error", JOptionPane.ERROR_MESSAGE); 
            tfPrice.setText("");
            return false;
        }
        return true;
    }
    
    public JTextField getSerialNo() {
        return tfSerialNo;
    }
    
    public JTextField getIType() {
        return tfType;
    }
    
    public JTextField getBrand() {
        return tfBrand;
    }
    
    public JTextField getModel() {
        return tfModel;
    }
    
    public JTextField getPrice() {
        return tfPrice;
    }

    public JLabel getLabelCust() {
        return labelCust;
    }

    public JLabel getLabelRent() {
        return labelRent;
    }

    public JButton getbCancelItemInfo() {
        return bCancelItemInfo;
    }

    public JButton getbSaveItem() {
        return bSaveItem;
    }

    public JButton getbOK() {
        return bOK;
    }

    public JLabel getItemKey() {
        return itemKey;
    }

    public JLabel getErrBrand() {
        return errBrand;
    }

    public JLabel getErrModel() {
        return errModel;
    }

    public JLabel getErrPrice() {
        return errPrice;
    }

    public JLabel getErrType() {
        return errType;
    }

    public JLabel getStar1() {
        return star1;
    }

    public JLabel getStar2() {
        return star2;
    }

    public JLabel getStar3() {
        return star3;
    }

    public JLabel getStar4() {
        return star4;
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
            java.util.logging.Logger.getLogger(ItemInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemInfo().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelItemInfo;
    private javax.swing.JButton bOK;
    private javax.swing.JButton bSaveItem;
    private javax.swing.JLabel errBrand;
    private javax.swing.JLabel errModel;
    private javax.swing.JLabel errPrice;
    private javax.swing.JLabel errType;
    private javax.swing.JLabel itemKey;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelCust;
    private javax.swing.JLabel labelRent;
    private javax.swing.JLabel star1;
    private javax.swing.JLabel star2;
    private javax.swing.JLabel star3;
    private javax.swing.JLabel star4;
    private javax.swing.JTextField tfBrand;
    private javax.swing.JTextField tfModel;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfSerialNo;
    private javax.swing.JTextField tfType;
    // End of variables declaration//GEN-END:variables
}
