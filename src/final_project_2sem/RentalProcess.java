
package final_project_2sem;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.JXDatePicker;

public class RentalProcess extends javax.swing.JFrame {
    private static RentalProcess l;    
    private static Customer c;
    private static Connection conn;
    private DefaultTableModel modelRented;
    private DefaultTableModel modelItems; 
    private String date;
    private SimpleDateFormat df;
    private SimpleDateFormat df2;
    private HashMap<Integer,Item> availableItemsMap; //??
    private HashMap<Integer,Item> rentedItemsMap;
    private ArrayList<Item> availableItemsArray;
    private ArrayList<Item> rentedItemsArray;
    //private TableRowSorter<TableModel> rowSorter;
    
    
    private RentalProcess() {
        initComponents();
        conn = DBConnector.getConnection();   
        df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        df2 = new SimpleDateFormat("dd-MM-yyyy");
        jXDatePicker1.setFormats(df2);
        availableItemsMap = new HashMap<>();
        rentedItemsMap = new HashMap<>();
        availableItemsArray = new ArrayList<>();
        rentedItemsArray = new ArrayList<>();
        
        //rowSorter = new TableRowSorter<>(tblItems.getModel());
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
        tblItems = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRented = new javax.swing.JTable(){
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rentals Overview");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("ITEMS RENTED");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("ITEMS AVAILABLE");

        jXDatePicker1.setFormats(new String[] {"yyyy-MM-dd"});
        jXDatePicker1.setToolTipText("Select the item first");
        jXDatePicker1.setEnabled(false);
        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Expected return date");

        tblItems.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblItems.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblItemsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblItemsFocusLost(evt);
            }
        });
        tblItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblItemsMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblItems);

        tblRented.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblRented.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SerialNo", "Type", "Brand", "Model", "Return Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRented.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblRentedFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblRentedFocusLost(evt);
            }
        });
        tblRented.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblRentedMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblRented);

        bRemove.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bRemove.setText("Remove");
        bRemove.setEnabled(false);
        bRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoveActionPerformed(evt);
            }
        });

        bAdd.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bAdd.setText("Add");
        bAdd.setEnabled(false);
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
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
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

    private void tblItemsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemsMousePressed
        if(evt.getClickCount() == 2)
            add();
    }//GEN-LAST:event_tblItemsMousePressed

    private void tblRentedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRentedMousePressed
        if(evt.getClickCount() == 2)
            remove();
    }//GEN-LAST:event_tblRentedMousePressed

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        add();
    }//GEN-LAST:event_bAddActionPerformed
    
    private void add() {
        int row = tblItems.getSelectedRow();
        
        //Edit Arrays
        Item item = availableItemsArray.remove(row);        
        rentedItemsArray.add(item);
        
        //Move row       
        modelRented.addRow(new Object[] {tblItems.getValueAt(row, 0),tblItems.getValueAt(row, 1),tblItems.getValueAt(row, 2),tblItems.getValueAt(row, 3),tblItems.getValueAt(row, 4)});
        modelItems.removeRow(row);        
                
        System.out.println("Item Added");
    }
    
    private void bRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoveActionPerformed
        remove();
    }//GEN-LAST:event_bRemoveActionPerformed
    
    private void remove() {
        int row = tblRented.getSelectedRow();
        //Edit Arrays
        Item item = rentedItemsArray.remove(row);  
        availableItemsArray.add(item);

        //Move row   
        modelItems.addRow(new Object[] {tblRented.getValueAt(row, 0),tblRented.getValueAt(row, 1),tblRented.getValueAt(row, 2),tblRented.getValueAt(row, 3),tblRented.getValueAt(row, 4)});
        modelRented.removeRow(row);        
                             
        System.out.println("Item Removed");
    }
    
    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        String chosenDate = jXDatePicker1.getEditor().getText();
        String d = df2.format(new Date());
        try {    
            Date chosen = df2.parse(chosenDate);
            Date today = df2.parse(d);
            
            if (chosen.compareTo(today) <= 0)
                JOptionPane.showMessageDialog(this, "Invalid date", "Error", JOptionPane.ERROR_MESSAGE);
            
            else {           
                int[] rows = tblRented.getSelectedRows();
                for(int eachRow : rows)
                    modelRented.setValueAt(chosenDate, eachRow, 5);
            }
        } catch (ParseException ex) {
            Logger.getLogger(RentalProcess.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_jXDatePicker1ActionPerformed
    
    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        int key = Integer.parseInt(custKey.getText());
        c = Inventory.getCustomerMap().get(key);
        int custID = c.getId();
        
        int row = tblItems.getRowCount();                                           //HashMap to get the available items knowing the row(key)
        if(row > 0) {
            for(int i = 0; i < row; i++)                 
                availableItemsMap.put(i, availableItemsArray.get(i));
        }
        
        int row2 = tblRented.getRowCount();                                         //HashMap to get the rented items knowing the row(key)
        if(row2 > 0) {
            for(int i = 0; i < row2; i++)  
                rentedItemsMap.put(i, rentedItemsArray.get(i));
        }
        
        if(!hasReturnDate())                                                            //Check date field 
            JOptionPane.showMessageDialog(this, "Please select a return date for each item"); 
        else {
            //ADD PROCESS
            int rows = modelRented.getRowCount();
            ArrayList<Item> addedItems = new ArrayList<>();
            addProcess(rows, custID, addedItems);
            
            //REMOVE PROCESS
            removeProcess();
            
            //Update database for receipts
            Date d = new Date();
            date = df.format(d);
            String itemsInfo = printItems(addedItems);
            String customerName = c.getFirstName()+" "+c.getLastName();
            
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
                }
                else {}                                                                 //If receipt already exists do nothing 
            }
            else {}                                                                     //If nothing is rented do nothing
            
            //Update tables
            Inventory.updateItemsTable();
            updateAvailableItemsTable();
            updateRentedItemsTable(c);
            Inventory.updateReceiptsTable(); 
            
            this.dispose();
        }
    }//GEN-LAST:event_bOKActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    private void tblItemsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblItemsFocusGained
        bAdd.setEnabled(true);
        bRemove.setEnabled(false);
        jXDatePicker1.setEnabled(false);
        tblRented.getSelectionModel().clearSelection();
    }//GEN-LAST:event_tblItemsFocusGained

    private void tblRentedFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblRentedFocusGained
        bAdd.setEnabled(false);
        bRemove.setEnabled(true);
        jXDatePicker1.setEnabled(true);
        tblItems.getSelectionModel().clearSelection();
    }//GEN-LAST:event_tblRentedFocusGained

    private void tblItemsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblItemsFocusLost
        bAdd.setEnabled(false);
        bAdd.setFocusPainted(false);
    }//GEN-LAST:event_tblItemsFocusLost

    private void tblRentedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblRentedFocusLost
        bRemove.setEnabled(false);
        bRemove.setFocusPainted(false);
        jXDatePicker1.setEnabled(false);
    }//GEN-LAST:event_tblRentedFocusLost
    
    private void createReceipt(String itemsInfo, int custID, String customerName) {
        try {
            String sql = "INSERT INTO villa_watt_inventory.receipts (Date,ItemsInfo,CustID,CustName) VALUES(?,?,?,?);";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, date);
            pstmt.setString(2, itemsInfo);
            pstmt.setInt(3, custID);
            pstmt.setString(4, customerName);
            pstmt.execute();

        } catch (SQLException ex) { 
            Logger.getLogger(ReceiptGenerator.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    
    private int getInvoiceNo(String itemsInfo, int custID) {
        int invoiceNo = -1;
        try {
            String sql2 = "SELECT InvoiceNo FROM villa_watt_inventory.receipts WHERE ItemsInfo = ? AND CustID = ?;";

            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, itemsInfo);
            pstmt2.setInt(2, custID);
            ResultSet rs = pstmt2.executeQuery(); 

            while(rs.next()) {
                invoiceNo = rs.getInt("InvoiceNo");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RentalProcess.class.getName()).log(Level.SEVERE, null, ex);  
        }
        return invoiceNo;
    }
    
    private void addProcess(int rows, int custID, ArrayList<Item> items) {
        Item item;
        for(int i = 0; i < rows; i++) {
            //link custID to each item selected - foreign key in database   
            try {

                item = rentedItemsMap.get(i);
                int itemID = item.getId();
                
                String returnDate = tblRented.getValueAt(i, 5).toString();

                String sql = "UPDATE villa_watt_inventory.items SET Status = 'rented out',fk_custID = ?, ReturnDate = ? WHERE ItemID = ?;";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, custID);
                pstmt.setString(2, returnDate);
                pstmt.setInt(3, itemID); 
                pstmt.execute(); 
                
                //Info for receipt
                item = new Item(item.getSerialNo(),item.getType(),item.getBrand(),item.getModel(),item.getPrice(),returnDate);
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
                Item item = availableItemsMap.get(j);
                int itemID = item.getId();                   

                String sql = "UPDATE villa_watt_inventory.items SET Status = 'available',fk_custID = NULL,ReturnDate = NULL WHERE ItemID = ?;";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, itemID);
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
        int rows = tblRented.getRowCount();
        for(int i = 0; i < rows; i++)
            if(tblRented.getValueAt(i, 5) == null)
                return false;
        return true;                
    }
        
    public void updateAvailableItemsTable() {        
        try {
            String sql = "SELECT SerialNo,Type,Brand,Model,Price FROM villa_watt_inventory.items WHERE Status = 'available';";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            tblItems.setModel(DbUtils.resultSetToTableModel(rs));
            modelItems = (DefaultTableModel)tblItems.getModel();
         
        } catch (SQLException ex) {
            Logger.getLogger(RentalProcess.class.getName()).log(Level.SEVERE, null, ex);
        }             
    }
    
    public void getAvailableItems() {
        try {   
            
            String sql = "SELECT ItemID,SerialNo,Type,Brand,Model,Price,fk_custID FROM villa_watt_inventory.items WHERE Status = 'available';"; //add custID
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(); 
            while(rs.next()) {
                int id          = rs.getInt("ItemID");
                String serialNo = rs.getString("SerialNo");
                String type     = rs.getString("Type");
                String brand    = rs.getString("Brand");
                String model    = rs.getString("Model");
                String price    = rs.getString("Price");
                int fk          = rs.getInt("fk_custID");
                
                Item item = new Item(id,serialNo,type,brand,model,price,fk);
                availableItemsArray.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RentalProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateRentedItemsTable(Customer c) {           
        int custID = c.getId();
        try {
            String sql = "SELECT SerialNo,Type,Brand,Model,Price,ReturnDate FROM villa_watt_inventory.items WHERE fk_custID = '"+custID+"';";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            tblRented.setModel(DbUtils.resultSetToTableModel(rs));
            modelRented = (DefaultTableModel)tblRented.getModel();
        } catch (SQLException ex) {
            Logger.getLogger(RentalProcess.class.getName()).log(Level.SEVERE, null, ex);
        }             
    } 
    
    public void getRentedItems(Customer c) {
        try {   
            int custID = c.getId();
            String sql = "SELECT ItemID,SerialNo,Type,Brand,Model,Price FROM villa_watt_inventory.items WHERE fk_custID= '"+custID+"';"; 
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(); 
            while(rs.next()) {
                int id          = rs.getInt("ItemID");
                String serialNo = rs.getString("SerialNo");
                String type     = rs.getString("Type");
                String brand    = rs.getString("Brand");
                String model    = rs.getString("Model");
                String price    = rs.getString("Price");
                
                Item item = new Item(id,serialNo,type,brand,model,price,custID);
                rentedItemsArray.add(item);
            }
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

    public JButton getbAdd() {
        return bAdd;
    }

    public JButton getbRemove() {
        return bRemove;
    }

    public JXDatePicker getjXDatePicker1() {
        return jXDatePicker1;
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
    private javax.swing.JTable tblItems;
    private javax.swing.JTable tblRented;
    // End of variables declaration//GEN-END:variables
}
