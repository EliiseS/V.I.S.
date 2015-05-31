
package final_project_2sem;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.prompt.BuddySupport;
import org.jdesktop.swingx.prompt.PromptSupport;

public class RentalProcess extends javax.swing.JFrame {
    private static RentalProcess l;    
    private static Connection conn;
    private DefaultTableModel modelRented;
    private DefaultTableModel modelItems; 
    private String date;
    private SimpleDateFormat df;
    private SimpleDateFormat df2;
    private TableRowSorter<TableModel> rowSorter;
    
    
    private RentalProcess() {
        initComponents();
        conn = DBConnector.getConnection();   
        df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");   
        df2 = new SimpleDateFormat("dd-MM-yyyy");
        
        PromptSupport.init("Search", Color.GRAY, Color.WHITE,tfFilterAvItems);
        BuddySupport.addLeft(searchIcon, tfFilterAvItems);
    }
    
    public static synchronized RentalProcess getRentalProcess() {
        if(l == null)
            l = new RentalProcess();
        return l;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AvItemsTable = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jScrollPane3 = new javax.swing.JScrollPane();
        rentedItemsTable = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        bRemove = new javax.swing.JButton();
        bAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        custName = new javax.swing.JLabel();
        bOK = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        custKey = new javax.swing.JLabel();
        bCancel = new javax.swing.JButton();
        tfFilterAvItems = new javax.swing.JTextField();
        searchIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rentals Overview");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("ITEMS RENTED");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("ITEMS AVAILABLE");

        jXDatePicker1.setFormats(new String[] {"dd-MM-yyyy"});
        jXDatePicker1.setToolTipText("Select the item first");
        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Expected return date");

        AvItemsTable.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        AvItemsTable.getTableHeader().setReorderingAllowed(false);
        AvItemsTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AvItemsTableFocusGained(evt);
            }
        });
        AvItemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AvItemsTableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(AvItemsTable);

        rentedItemsTable.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        rentedItemsTable.getTableHeader().setReorderingAllowed(false);
        rentedItemsTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rentedItemsTableFocusGained(evt);
            }
        });
        rentedItemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rentedItemsTableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(rentedItemsTable);

        bRemove.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bRemove.setText("Remove");
        bRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoveActionPerformed(evt);
            }
        });

        bAdd.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bAdd.setText("Add");
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Customer: ");

        custName.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        custName.setPreferredSize(new java.awt.Dimension(10, 2));

        bOK.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bOK.setText("OK");
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOKActionPerformed(evt);
            }
        });

        bCancel.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        tfFilterAvItems.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterAvItems();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterAvItems();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        tfFilterAvItems.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        searchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project_2sem/Search-icon.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancel))
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(custName, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(custKey, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFilterAvItems, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bAdd, bRemove});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(custKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(custName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfFilterAvItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchIcon)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bRemove)
                    .addComponent(bAdd)
                    .addComponent(jLabel3)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOK)
                    .addComponent(bCancel))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("jFrameLoan");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void enableSorting() {
        rowSorter = new TableRowSorter<>(AvItemsTable.getModel());
        AvItemsTable.setRowSorter(rowSorter);
    }
    
    private void filterAvItems() {
        String text = tfFilterAvItems.getText();
        if (text.trim().length() == 0) {                                        //trim() returns a copy of the string, with leading and trailing whitespace omitted.
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text.trim()));
        }
    }
    
    private void AvItemsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AvItemsTableMousePressed
        if(evt.getClickCount() == 2)
            add();
    }//GEN-LAST:event_AvItemsTableMousePressed

    private void rentedItemsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rentedItemsTableMousePressed
        if(evt.getClickCount() == 2)
            remove();
    }//GEN-LAST:event_rentedItemsTableMousePressed

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        if(AvItemsTable.getSelectedRow() != -1)
            add();
        else
            JOptionPane.showMessageDialog(this, "Please select an item to rent out");
    }//GEN-LAST:event_bAddActionPerformed
    
    private void add() {
        int row = AvItemsTable.getSelectedRow();
        
        //Move row       
        modelRented.addRow(new Object[] {AvItemsTable.getValueAt(row, 0),AvItemsTable.getValueAt(row, 1),AvItemsTable.getValueAt(row, 2),AvItemsTable.getValueAt(row, 3),AvItemsTable.getValueAt(row, 4),AvItemsTable.getValueAt(row, 5)});
        modelItems.removeRow(row);       
    }
    
    private void bRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoveActionPerformed
        if(rentedItemsTable.getSelectedRow() != -1)
            remove();
        else
            JOptionPane.showMessageDialog(this, "Please select an item to return");
    }//GEN-LAST:event_bRemoveActionPerformed
    
    private void remove() {
        int row = rentedItemsTable.getSelectedRow();
        
        //Move row   
        modelItems.addRow(new Object[] {rentedItemsTable.getValueAt(row, 0),rentedItemsTable.getValueAt(row, 1),rentedItemsTable.getValueAt(row, 2),rentedItemsTable.getValueAt(row, 3),rentedItemsTable.getValueAt(row, 4),rentedItemsTable.getValueAt(row, 5)});
        modelRented.removeRow(row);        
    }
    
    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        if(rentedItemsTable.getSelectedRow() != -1) {
            String chosenDate = jXDatePicker1.getEditor().getText();
            String d = df2.format(new Date());
            try {    
                Date chosen = df2.parse(chosenDate);
                Date today = df2.parse(d);

                if (chosen.compareTo(today) <= 0) {
                    jXDatePicker1.setDate(null);
                    JOptionPane.showMessageDialog(this, "Invalid date", "Error", JOptionPane.ERROR_MESSAGE);
                }

                else {           
                    int[] rows = rentedItemsTable.getSelectedRows();
                    for(int eachRow : rows)
                        modelRented.setValueAt(chosenDate, eachRow, 6);
                }
            } catch (ParseException ex) {
                Logger.getLogger(RentalProcess.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        else {
            jXDatePicker1.setDate(null);
            JOptionPane.showMessageDialog(this, "Please select an item");
        }
    }//GEN-LAST:event_jXDatePicker1ActionPerformed
    
    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        String custID = custKey.getText();
                
        if(!hasReturnDate())                                                            //Check date field 
            JOptionPane.showMessageDialog(this, "Please select a return date for each item"); 
        else {
            //ADD PROCESS
            int rows = modelRented.getRowCount();
            ArrayList<Item> addedItems = new ArrayList<>();
            addProcess(rows, custID, addedItems);
            
            //REMOVE PROCESS
            removeProcess();
            
            //Update items catalogue
            Inventory.updateItemsTable();
            
            //Update database for receipts
            Date d = new Date();
            date = df.format(d);
            String itemsInfo = printItems(addedItems);
            String customerName = custName.getText();
            
            if(rows > 0) {                                                              //Check if something is rented otherwise no new receipt
                int invoiceNo = getInvoiceNo(itemsInfo, custID);                        //Check if a receipt for this customer with these addedItems already exists
                if(invoiceNo == -1) {                                                   //No such receipt exists                    
                    createReceipt(itemsInfo, custID, customerName);                     //Create new receipt and add it to database
                    invoiceNo = getInvoiceNo(itemsInfo, custID);                        //Get invoiceNo and date from database to display on the receipt

                    //Generate receipt
                    ReceiptGenerator receipt = ReceiptGenerator.getReceipt();
                    receipt.getLabelCust().setText(customerName);
                    receipt.getAreaItems().setText(itemsInfo);
                    receipt.getLabelDate().setText(date);
                    receipt.getLabelInvoiceNo().setText(Integer.toString(invoiceNo));
                    receipt.setVisible(true);
                    
                    Inventory.updateReceiptsTable();                                    
                }
                else {}                                                                 //If receipt already exists do nothing 
            }
            else {}  
            
            this.dispose();
        }
    }//GEN-LAST:event_bOKActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    private void AvItemsTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AvItemsTableFocusGained
        rentedItemsTable.getSelectionModel().clearSelection();        
    }//GEN-LAST:event_AvItemsTableFocusGained

    private void rentedItemsTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rentedItemsTableFocusGained
        AvItemsTable.getSelectionModel().clearSelection();
    }//GEN-LAST:event_rentedItemsTableFocusGained
    
    private void createReceipt(String itemsInfo, String custID, String customerName) {
        try {
            String sql = "INSERT INTO villa_watt_inventory.receipts (Date,ItemsInfo,CustID,CustName) VALUES(?,?,?,?);";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, date);
            pstmt.setString(2, itemsInfo);
            pstmt.setString(3, custID);
            pstmt.setString(4, customerName);
            pstmt.execute();

        } catch (SQLException ex) { 
            Logger.getLogger(ReceiptGenerator.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    
    private int getInvoiceNo(String itemsInfo, String custID) {
        int invoiceNo = -1;
        try {
            String sql2 = "SELECT InvoiceNo FROM villa_watt_inventory.receipts WHERE ItemsInfo = ? AND CustID = ?;";

            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, itemsInfo);
            pstmt2.setString(2, custID);
            ResultSet rs = pstmt2.executeQuery(); 

            while(rs.next()) {
                invoiceNo = rs.getInt("InvoiceNo");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RentalProcess.class.getName()).log(Level.SEVERE, null, ex);  
        }
        return invoiceNo;
    }
    
    private void addProcess(int rows, String custID, ArrayList<Item> items) {
        Item item;
        for(int i = 0; i < rows; i++) {
            //link custID to each item selected - foreign key in database   
            try {
                String itemID = rentedItemsTable.getValueAt(i, 0).toString();
                
                String returnDate = rentedItemsTable.getValueAt(i, 6).toString();

                String sql = "UPDATE villa_watt_inventory.items SET Status = 'rented out',fk_custID = ?, ReturnDate = ? WHERE ItemID = ?;";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, custID);
                pstmt.setString(2, returnDate);
                pstmt.setString(3, itemID); 
                pstmt.execute(); 
                
                //Info for receipt
                String type = rentedItemsTable.getValueAt(i, 1).toString();
                String brand = rentedItemsTable.getValueAt(i, 2).toString();
                String model = rentedItemsTable.getValueAt(i, 3).toString();
                String price = rentedItemsTable.getValueAt(i, 4).toString();
                
                item = new Item(itemID,type,brand,model,price,returnDate);
                items.add(item);                                                        //To keep in memory which item(s) to display on the receipt

            } catch (SQLException ex) {
                Logger.getLogger(RentalProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void removeProcess() {
        int rows = modelItems.getRowCount();
        for(int j = 0; j < rows; j++) {
            try {
                //Change item status and break fk with customer
                String itemID = AvItemsTable.getValueAt(j, 0).toString();

                String sql = "UPDATE villa_watt_inventory.items SET Status = 'available',fk_custID = NULL,ReturnDate = NULL WHERE ItemID = ?;";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, itemID);
                pstmt.execute();                         

            } catch (SQLException ex) {
                Logger.getLogger(RentalProcess.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }
    }
    
    public String printItems(ArrayList<Item> items) {
        String s = "";
        for(int i = 0; i < items.size(); i++) {
            Item it = items.get(i);
            s += "<html>ITEM Nr."+(i+1)+": "+it.getType()+" "+it.getBrand()+" "+it.getModel()+" "+it.getSerialNo()+"<br>Price: "+it.getPrice()+"<br>Return date: "+it.getDate()+"<br><br>";
        }
        return s;
    }
    
    private boolean hasReturnDate() {
        int rows = rentedItemsTable.getRowCount();
        for(int i = 0; i < rows; i++)
            if(rentedItemsTable.getValueAt(i, 6) == null)
                return false;
        return true;                
    }
        
    public void updateAvailableItemsTable() {        
        try {
            String sql = "SELECT itemID,SerialNo,Type,Brand,Model,Price FROM villa_watt_inventory.items WHERE Status = 'available';";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            AvItemsTable.setModel(DbUtils.resultSetToTableModel(rs));
            modelItems = (DefaultTableModel)AvItemsTable.getModel();
         
        } catch (SQLException ex) {
            Logger.getLogger(RentalProcess.class.getName()).log(Level.SEVERE, null, ex);
        }             
    }
    
    public void updateRentedItemsTable(String custID) { 
        try {
            String sql = "SELECT itemID,SerialNo,Type,Brand,Model,Price,ReturnDate FROM villa_watt_inventory.items WHERE fk_custID = '"+custID+"';";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            rentedItemsTable.setModel(DbUtils.resultSetToTableModel(rs));
            modelRented = (DefaultTableModel)rentedItemsTable.getModel();
        } catch (SQLException ex) {
            Logger.getLogger(RentalProcess.class.getName()).log(Level.SEVERE, null, ex);
        }             
    } 
    
    public JLabel getCustName() {
        return custName;
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
            java.util.logging.Logger.getLogger(RentalProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentalProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentalProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentalProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AvItemsTable;
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bOK;
    private javax.swing.JButton bRemove;
    private javax.swing.JLabel custKey;
    private javax.swing.JLabel custName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JTable rentedItemsTable;
    private javax.swing.JLabel searchIcon;
    private javax.swing.JTextField tfFilterAvItems;
    // End of variables declaration//GEN-END:variables
}
