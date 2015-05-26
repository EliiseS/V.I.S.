
package final_project_2sem;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.prompt.BuddySupport;
import org.jdesktop.swingx.prompt.PromptSupport;

public class Inventory extends javax.swing.JFrame {   
    private static Inventory inv;
    private static Connection conn;
    private TableRowSorter<TableModel> rowSorter; 
    private TableRowSorter<TableModel> rowSorter2;
    private static HashMap<Integer, Customer> customersMap;
    private static HashMap<Integer, Item> itemsMap;
    private static DefaultTableModel receiptsTableModel;
    
    private Inventory() {
        initComponents();
        conn = DBConnector.getConnection();
        customersMap = new HashMap<>(); 
        itemsMap = new HashMap<>();
        updateItemsTable();   
        updateCustomersTable();
        updateReceiptsTable();
        rowSorter = new TableRowSorter<>(itemsTable.getModel());
        itemsTable.setRowSorter(rowSorter);
        rowSorter2 = new TableRowSorter<>(customersTable.getModel());
        customersTable.setRowSorter(rowSorter2);
        PromptSupport.init("Search", Color.GRAY, Color.WHITE,tfFindCust);
        BuddySupport.addLeft(searchImage2, tfFindCust);
        PromptSupport.init("Search", Color.GRAY, Color.WHITE,tfFindItem);
        BuddySupport.addLeft(searchImage1, tfFindItem);
    }
    
    public static synchronized Inventory getInventory() {
        if(inv == null)
            inv = new Inventory();
        return inv;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        itemsPanel = new javax.swing.JPanel();
        bEditItem = new javax.swing.JButton();
        bDeleteItem = new javax.swing.JButton();
        bCreateItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        tfFindItem = new javax.swing.JTextField();
        searchImage2 = new javax.swing.JLabel();
        customersPanel = new javax.swing.JPanel();
        tfFindCust = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        customersTable = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        bDeleteCust = new javax.swing.JButton();
        bEditCust = new javax.swing.JButton();
        bCreateCust = new javax.swing.JButton();
        bRental = new javax.swing.JButton();
        searchImage1 = new javax.swing.JLabel();
        receiptsPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        receiptsTable = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        bDeleteReceipt = new javax.swing.JButton();
        bLogOut = new javax.swing.JButton();
        bChangePass = new javax.swing.JButton();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Villa Watt Inventory");

        jTabbedPane1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        bEditItem.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bEditItem.setText("Edit");
        bEditItem.setEnabled(false);
        bEditItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditItemActionPerformed(evt);
            }
        });

        bDeleteItem.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bDeleteItem.setText("Delete");
        bDeleteItem.setEnabled(false);
        bDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteItemActionPerformed(evt);
            }
        });

        bCreateItem.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bCreateItem.setText("Create");
        bCreateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreateItemActionPerformed(evt);
            }
        });

        itemsTable.setAutoCreateRowSorter(true);
        itemsTable.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        itemsTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                itemsTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                itemsTableFocusLost(evt);
            }
        });
        itemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemsTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(itemsTable);

        tfFindItem.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfFindItem.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        searchImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project_2sem/Search-icon.png"))); // NOI18N

        javax.swing.GroupLayout itemsPanelLayout = new javax.swing.GroupLayout(itemsPanel);
        itemsPanel.setLayout(itemsPanelLayout);
        itemsPanelLayout.setHorizontalGroup(
            itemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addGroup(itemsPanelLayout.createSequentialGroup()
                        .addComponent(bCreateItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bEditItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bDeleteItem)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchImage2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFindItem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        itemsPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bCreateItem, bDeleteItem, bEditItem});

        itemsPanelLayout.setVerticalGroup(
            itemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(itemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchImage2)
                    .addComponent(tfFindItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCreateItem)
                    .addComponent(bEditItem)
                    .addComponent(bDeleteItem))
                .addContainerGap())
        );

        jTabbedPane1.addTab("  Items Catalogue  ", itemsPanel);

        tfFindCust.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfFindItem.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        customersTable.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        customersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        customersTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                customersTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                customersTableFocusLost(evt);
            }
        });
        jScrollPane4.setViewportView(customersTable);

        bDeleteCust.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bDeleteCust.setText("Delete");
        bDeleteCust.setEnabled(false);
        bDeleteCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteCustActionPerformed(evt);
            }
        });

        bEditCust.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bEditCust.setText("Edit");
        bEditCust.setEnabled(false);
        bEditCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditCustActionPerformed(evt);
            }
        });

        bCreateCust.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bCreateCust.setText("Create");
        bCreateCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreateCustActionPerformed(evt);
            }
        });

        bRental.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bRental.setText("Rentals");
        bRental.setEnabled(false);
        bRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRentalActionPerformed(evt);
            }
        });

        searchImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project_2sem/Search-icon.png"))); // NOI18N

        javax.swing.GroupLayout customersPanelLayout = new javax.swing.GroupLayout(customersPanel);
        customersPanel.setLayout(customersPanelLayout);
        customersPanelLayout.setHorizontalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addGroup(customersPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchImage1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFindCust, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(customersPanelLayout.createSequentialGroup()
                        .addComponent(bCreateCust)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bEditCust)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bDeleteCust)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bRental)))
                .addContainerGap())
        );

        customersPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bCreateCust, bDeleteCust, bEditCust});

        customersPanelLayout.setVerticalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFindCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchImage1))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCreateCust)
                    .addComponent(bEditCust)
                    .addComponent(bRental)
                    .addComponent(bDeleteCust))
                .addContainerGap())
        );

        jTabbedPane1.addTab("  Customers List  ", customersPanel);

        receiptsTable.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        receiptsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        receiptsTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                receiptsTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                receiptsTableFocusLost(evt);
            }
        });
        receiptsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                receiptsTableMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(receiptsTable);

        bDeleteReceipt.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bDeleteReceipt.setText("Delete");
        bDeleteReceipt.setEnabled(false);
        bDeleteReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteReceiptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receiptsPanelLayout = new javax.swing.GroupLayout(receiptsPanel);
        receiptsPanel.setLayout(receiptsPanelLayout);
        receiptsPanelLayout.setHorizontalGroup(
            receiptsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiptsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receiptsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receiptsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bDeleteReceipt)))
                .addContainerGap())
        );
        receiptsPanelLayout.setVerticalGroup(
            receiptsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiptsPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(bDeleteReceipt)
                .addContainerGap())
        );

        jTabbedPane1.addTab("  Receipts Archive   ", receiptsPanel);

        bLogOut.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bLogOut.setText("Log out");
        bLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogOutActionPerformed(evt);
            }
        });

        bChangePass.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bChangePass.setText("Change Password ");
        bChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChangePassActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project_2sem/VillaWatt-logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bChangePass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bLogOut)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bLogOut)
                            .addComponent(bChangePass))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void filter() {
        String text = tfFindItem.getText();
        if (text.trim().length() == 0) { //trim() returns a copy of the string, with leading and trailing whitespace omitted.
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text.trim()));
        }
    }
    
    public static void updateItemsTable() {                   
        try {
            String sql = "SELECT SerialNo,Type,Brand,Model,Price,Status,ReturnDate FROM villa_watt_inventory.items;";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            itemsTable.setModel(DbUtils.resultSetToTableModel(rs));
            getItems();
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }             
    }
    
    private static void getItems() {
        try {   
            ArrayList<Item> itemsArray = new ArrayList<>();
            String sql = "SELECT ItemID,SerialNo,Type,Brand,Model,Price,fk_custID FROM villa_watt_inventory.items;"; //date??
            
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
                itemsArray.add(item);
            }
            int row = itemsTable.getRowCount();
            for(int i = 0; i < row; i++)                 
                itemsMap.put(i, itemsArray.get(i));
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateCustomersTable() {               
        try {
            String sql = "SELECT FirstName,LastName,Address,PhoneNo,Email FROM villa_watt_inventory.customers;";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();            
                      
            customersTable.setModel(DbUtils.resultSetToTableModel(rs)); 
            getCustomers();
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }             
    }
    
    private static void getCustomers() {
        try {   
            ArrayList<Customer> customersArray = new ArrayList<>();
            String sql = "SELECT CustomerID,FirstName,LastName,Address,PhoneNo,Email FROM villa_watt_inventory.customers;";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(); 
            while(rs.next()) {
                int id         = rs.getInt("CustomerID");
                String fName   = rs.getString("FirstName");
                String lName   = rs.getString("LastName");
                String address = rs.getString("Address");
                String phone   = rs.getString("PhoneNo");
                String email   = rs.getString("Email");
                
                Customer c = new Customer(id,fName,lName,address,phone,email);
                customersArray.add(c);
            }
            int row = customersTable.getRowCount();
            for(int i = 0; i < row; i++)                 
                customersMap.put(i, customersArray.get(i));
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateReceiptsTable() {                   
        try {
            String sql = "SELECT InvoiceNo,Date,CustName FROM villa_watt_inventory.receipts;";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            receiptsTable.setModel(DbUtils.resultSetToTableModel(rs));
            receiptsTableModel = (DefaultTableModel) receiptsTable.getModel();
            
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }             
    }
    
    private void bCreateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateItemActionPerformed
        ItemInfo itemI = ItemInfo.getItemI();
        
        //Clean all fields
        itemI.cleanItemFields();
        itemI.getLabelCust().setVisible(false);
        itemI.getLabelRent().setVisible(false);
        
        itemI.getID().setEditable(true);
        itemI.getIType().setEditable(true);
        itemI.getBrand().setEditable(true);
        itemI.getModel().setEditable(true);
        itemI.getPrice().setEditable(true);
        itemI.getbSaveItem().setVisible(true);
        itemI.getbCancelItemInfo().setVisible(true);
        itemI.getbOK().setVisible(false);
        
        //Error messages invisible
        itemI.getErrType().setVisible(false);
        itemI.getErrBrand().setVisible(false);
        itemI.getErrModel().setVisible(false);
        itemI.getErrPrice().setVisible(false);
        
        itemI.getItemKey().setText("");     //No key needed if new item
        
        itemI.setVisible(true);
    }//GEN-LAST:event_bCreateItemActionPerformed

    private void bEditItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditItemActionPerformed
        if(itemsTable.getSelectedRow() != -1) {
            ItemInfo itemI = ItemInfo.getItemI(); 
            getItemInfo(itemI);  
            itemI.getID().setEditable(true);
            itemI.getIType().setEditable(true);
            itemI.getBrand().setEditable(true);
            itemI.getModel().setEditable(true);
            itemI.getPrice().setEditable(true);
            itemI.getbSaveItem().setVisible(true);
            itemI.getbCancelItemInfo().setVisible(true);
            itemI.getbOK().setVisible(false);
            itemI.setVisible(true); 
            
            //Error messages invisible
            itemI.getErrType().setVisible(false);
            itemI.getErrBrand().setVisible(false);
            itemI.getErrModel().setVisible(false);
            itemI.getErrPrice().setVisible(false);

            itemI.getItemKey().setText(Integer.toString(itemsTable.getSelectedRow()));  //the key(row) to recognise the item in the new window
            itemI.getItemKey().setVisible(false);
        }
        else
            JOptionPane.showMessageDialog(this, "Please select an item to edit", "Message", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_bEditItemActionPerformed
    //Get item information to display
    private void getItemInfo(ItemInfo itemI) {
        itemI.getID().setText(String.valueOf(itemsTable.getValueAt(itemsTable.getSelectedRow(), 0)));
        itemI.getIType().setText(String.valueOf(itemsTable.getValueAt(itemsTable.getSelectedRow(), 1)));
        itemI.getBrand().setText(String.valueOf(itemsTable.getValueAt(itemsTable.getSelectedRow(), 2)));
        itemI.getModel().setText(String.valueOf(itemsTable.getValueAt(itemsTable.getSelectedRow(), 3)));
        itemI.getPrice().setText(String.valueOf(itemsTable.getValueAt(itemsTable.getSelectedRow(), 4)));
        
        String status = String.valueOf(itemsTable.getValueAt(itemsTable.getSelectedRow(), 5));
        if(status.equals("rented out")) {
            Item item = itemsMap.get(itemsTable.getSelectedRow());
            try {
                String sql = "SELECT FirstName,LastName FROM villa_watt_inventory.customers WHERE CustomerID = ?;";
            
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, item.getFk());
                
                ResultSet rs = pstmt.executeQuery(); 
                String fName = " ";
                String lName = " ";
                
                while(rs.next()) {
                    fName = rs.getString("FirstName");
                    lName = rs.getString("LastName");
                }
                itemI.getLabelCust().setText(fName+" "+lName);
                itemI.getLabelCust().setVisible(true);
                itemI.getLabelRent().setVisible(true);
                
            } catch(SQLException ex) {
                Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
            }     
        }else {
            itemI.getLabelCust().setVisible(false);
            itemI.getLabelRent().setVisible(false);
        }
    }
    
    private void bDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteItemActionPerformed
        int row = itemsTable.getSelectedRow();
        if(row != -1) {
            Item item = itemsMap.get(row);
            int itemID = item.getId();
            int choice;
            if(isItemRented(itemID)) 
                choice = JOptionPane.showConfirmDialog(this, "This item is rented out. Are you sure you want to delete it anyway?", "Delete item", JOptionPane.YES_NO_OPTION);
            else 
                choice = JOptionPane.showConfirmDialog(this, "Do you really want to delete this item?", "Delete item", JOptionPane.YES_NO_OPTION);
            
            if(choice == JOptionPane.YES_OPTION) {
                try {                    
                    //Update database

                    String sql = "DELETE FROM villa_watt_inventory.items WHERE ItemID = ?";

                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, itemID);
                    pstmt.execute();                     

                    //Update items Catalogue
                    updateItemsTable();
                    JOptionPane.showMessageDialog(this, "Item successfully deleted");

                } catch (SQLException ex) {
                    Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Please select an item to delete", "Message", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_bDeleteItemActionPerformed

    private boolean isItemRented(int itemID) {
        try {
            String sql = "SELECT Status FROM villa_watt_inventory.items WHERE ItemID = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, itemID);
            ResultSet rs = pstmt.executeQuery(); 
            String status = "";
            while(rs.next())
                status = rs.getString("Status");
            if(status.equals("rented out"))
                return true;
        }catch(SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private void bCreateCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateCustActionPerformed
        CustomerInfo custI = CustomerInfo.getCustI();
        custI.setVisible(true);
        
        //Clean all fields
        custI.cleanCustFields();
        custI.getCustKey().setText("");
    }//GEN-LAST:event_bCreateCustActionPerformed

    private void bEditCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditCustActionPerformed
        if(customersTable.getSelectedRow() != -1) {
            CustomerInfo custI = CustomerInfo.getCustI();        

            custI.getFirstName().setText(String.valueOf(customersTable.getValueAt(customersTable.getSelectedRow(), 0)));
            custI.getLastName().setText(String.valueOf(customersTable.getValueAt(customersTable.getSelectedRow(), 1)));
            custI.getAddress().setText(String.valueOf(customersTable.getValueAt(customersTable.getSelectedRow(), 2)));
            custI.getPhone().setText(String.valueOf(customersTable.getValueAt(customersTable.getSelectedRow(), 3)));
            custI.getEmail().setText(String.valueOf(customersTable.getValueAt(customersTable.getSelectedRow(), 4)));

            custI.getCustKey().setText(Integer.toString(customersTable.getSelectedRow()));
            custI.getCustKey().setVisible(false);

            custI.setVisible(true);    
        }
        else
            JOptionPane.showMessageDialog(this, "Please select a customer to edit", "Message", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_bEditCustActionPerformed

    private void bDeleteCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteCustActionPerformed
        if(customersTable.getSelectedRow() != -1) {
            int key = customersTable.getSelectedRow();
            Customer c = customersMap.get(key);
            int custID = c.getId();

            ArrayList<Integer> listRentedItems = checkRentedItems(custID);
            int choice;
            if(listRentedItems.isEmpty()) {//No item is rented by this customer
                choice = JOptionPane.showConfirmDialog(this, "Do you really want to delete this customer?", "Delete customer", JOptionPane.YES_NO_OPTION);
                if(choice == JOptionPane.YES_OPTION)
                    deleteCustomer(custID);
            }
            else {
                choice = JOptionPane.showConfirmDialog(this, "This customer has items rented out. Are you sure you want to delete it anyway?", "Delete customer", JOptionPane.YES_NO_OPTION);
                if(choice == JOptionPane.YES_OPTION) {
                    try { 
                        for (Integer listRentedItem : listRentedItems) {
                            String sql = "UPDATE villa_watt_inventory.items SET Status = 'available',fk_custID = NULL,ReturnDate = NULL WHERE ItemID = ?;";
                            PreparedStatement pstmt = conn.prepareStatement(sql);
                            pstmt.setInt(1, listRentedItem);
                            pstmt.execute();
                        }     
                    } catch (SQLException ex) {                
                        Logger.getLogger(CustomerInfo.class.getName()).log(Level.SEVERE, null, ex);
                    }                
                    deleteCustomer(custID);
                }
            }
            updateItemsTable();
        }
        else
            JOptionPane.showMessageDialog(this, "Please select a customer to delete", "Message", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_bDeleteCustActionPerformed
    
    private ArrayList<Integer> checkRentedItems(int custID) {
        ArrayList<Integer> listRentedItems = new ArrayList<>();
        try {
            String sql = "SELECT ItemID FROM villa_watt_inventory.items WHERE fk_custID = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, custID);
            ResultSet rs = pstmt.executeQuery(); 
            
            while(rs.next()) {
                listRentedItems.add(rs.getInt("ItemID"));
            }
            
        }catch(SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRentedItems;
    }
    
    private void deleteCustomer(int id) {
        try {                    
            //Update database
            String sql = "DELETE FROM villa_watt_inventory.customers WHERE CustomerID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.execute();    

            //Update customer list
            updateCustomersTable(); 
            JOptionPane.showMessageDialog(this, "Customer successfully deleted");

        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void itemsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsTableMousePressed
        if(evt.getClickCount() == 2) {
            ItemInfo itemI = ItemInfo.getItemI();
            getItemInfo(itemI);
            
            //Not editable fields
            itemI.getID().setEditable(false);
            itemI.getIType().setEditable(false);
            itemI.getBrand().setEditable(false);
            itemI.getModel().setEditable(false);
            itemI.getPrice().setEditable(false);
            
            //Show right buttons
            itemI.getbSaveItem().setVisible(false);
            itemI.getbCancelItemInfo().setVisible(false);
            itemI.getbOK().setVisible(true);
            
            //Hide error messages and stars
            itemI.getErrType().setVisible(false);
            itemI.getErrBrand().setVisible(false);
            itemI.getErrModel().setVisible(false);
            itemI.getErrPrice().setVisible(false);
            itemI.getStar1().setVisible(false);
            itemI.getStar2().setVisible(false);
            itemI.getStar3().setVisible(false);
            itemI.getStar4().setVisible(false);
            
            itemI.setVisible(true); 
        }
    }//GEN-LAST:event_itemsTableMousePressed

    private void bRentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRentalActionPerformed
        if(customersTable.getSelectedRow() != -1) {
            int row = customersTable.getSelectedRow();
            Customer c = customersMap.get(row);
            RentalProcess rent = RentalProcess.getRentalProcess();

            //Update tables in rent frame
            rent.updateAvailableItemsTable();
            rent.updateRentedItemsTable(c);
            rent.getAvailableItems();
            rent.getRentedItems(c);

            //Display customer's name
            rent.getCustName().setText(c.getFirstName()+" "+c.getLastName());  

            //Put in the new frame the key(row) to retrieve the customer from HashMap
            rent.getCustKey().setText(Integer.toString(row));
            rent.getCustKey().setVisible(false);
            
            rent.setVisible(true); 
            rent.getbAdd().setEnabled(false);
            rent.getbRemove().setEnabled(false);
            rent.getjXDatePicker1().setEnabled(false);
        }
        else
            JOptionPane.showMessageDialog(this, "Please select a customer first", "Message", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_bRentalActionPerformed

    private void receiptsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receiptsTableMousePressed
        if(evt.getClickCount() == 2) {
            ReceiptGenerator rg = ReceiptGenerator.getReceipt();
            String invoiceNo = receiptsTableModel.getValueAt(receiptsTable.getSelectedRow(), 0).toString();
            try {
                String sql = "SELECT Date,ItemsInfo,CustName FROM villa_watt_inventory.receipts WHERE InvoiceNo = ?;";
            
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, invoiceNo);
                
                ResultSet rs = pstmt.executeQuery(); 
                
                while(rs.next()) {
                    String date = rs.getString("Date");
                    String itemsInfo = rs.getString("ItemsInfo");
                    String custName = rs.getString("CustName");
                    
                    rg.getLabelInvoiceNo().setText(invoiceNo);
                    rg.getLabelDate().setText(date);
                    rg.getAreaItems().setText(itemsInfo);
                    rg.getLabelCust().setText(custName);
                }
                rg.setVisible(true);
                
            } catch(SQLException ex) {
                Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_receiptsTableMousePressed

    private void bLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLogOutActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bLogOutActionPerformed

    private void bDeleteReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteReceiptActionPerformed
        int row = receiptsTable.getSelectedRow();
        if(row != -1) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you really want to delete this receipt?", "Delete receipt", JOptionPane.YES_NO_OPTION);

            if(choice == JOptionPane.YES_OPTION) {
                try {                    
                    //Update database
                    String selected = receiptsTableModel.getValueAt(row,0).toString();

                    String sql = "DELETE FROM villa_watt_inventory.receipts WHERE InvoiceNo = ?";

                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, selected);
                    pstmt.execute();                     

                    //Update table
                    receiptsTableModel.removeRow(row);
                    JOptionPane.showMessageDialog(this, "Receipt successfully deleted");

                } catch (SQLException ex) {
                    Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Please select an item to delete", "Message", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_bDeleteReceiptActionPerformed

    private void bChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChangePassActionPerformed
        Password pass = Password.getPassword();
        
        // Empty fields
        pass.getTfOldPass().setText("");
        pass.getTfNewPass().setText("");
        pass.getTfConfirm().setText("");        
        
        // No visible error message
        pass.getErrOldPass().setVisible(false);
        pass.getErrNewPass().setVisible(false);
        pass.getPassCheck().setVisible(false);
        
        pass.setVisible(true);
    }//GEN-LAST:event_bChangePassActionPerformed

    private void itemsTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemsTableFocusGained
        bDeleteItem.setEnabled(true);
        bEditItem.setEnabled(true);
    }//GEN-LAST:event_itemsTableFocusGained

    private void itemsTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemsTableFocusLost
        bDeleteItem.setEnabled(false);
        bEditItem.setEnabled(false);
        itemsTable.getSelectionModel().clearSelection();
    }//GEN-LAST:event_itemsTableFocusLost

    private void customersTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customersTableFocusGained
        bDeleteCust.setEnabled(true);
        bEditCust.setEnabled(true);
        bRental.setEnabled(true);
    }//GEN-LAST:event_customersTableFocusGained

    private void customersTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customersTableFocusLost
        bDeleteCust.setEnabled(false);
        bEditCust.setEnabled(false);
        bRental.setEnabled(false);
        customersTable.getSelectionModel().clearSelection();
    }//GEN-LAST:event_customersTableFocusLost

    private void receiptsTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receiptsTableFocusGained
        bDeleteReceipt.setEnabled(true);
    }//GEN-LAST:event_receiptsTableFocusGained

    private void receiptsTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receiptsTableFocusLost
        bDeleteReceipt.setEnabled(false);
        receiptsTable.getSelectionModel().clearSelection();
    }//GEN-LAST:event_receiptsTableFocusLost
         
    public static HashMap<Integer, Customer> getCustomerMap() {
        return customersMap;
    }

    public static HashMap<Integer, Item> getItemsMap() {
        return itemsMap;
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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bChangePass;
    private javax.swing.JButton bCreateCust;
    private javax.swing.JButton bCreateItem;
    private javax.swing.JButton bDeleteCust;
    private javax.swing.JButton bDeleteItem;
    private javax.swing.JButton bDeleteReceipt;
    private javax.swing.JButton bEditCust;
    private javax.swing.JButton bEditItem;
    private javax.swing.JButton bLogOut;
    private javax.swing.JButton bRental;
    private javax.swing.JPanel customersPanel;
    private static javax.swing.JTable customersTable;
    private javax.swing.JPanel itemsPanel;
    private static javax.swing.JTable itemsTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel receiptsPanel;
    private static javax.swing.JTable receiptsTable;
    private javax.swing.JLabel searchImage1;
    private javax.swing.JLabel searchImage2;
    private javax.swing.JTextField tfFindCust;
    private javax.swing.JTextField tfFindItem;
    // End of variables declaration//GEN-END:variables
}
