
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
    private TableRowSorter<TableModel> rowSorter3;
    private static HashMap<Integer, Item> itemsMap;
    private static HashMap<Integer, Customer> customersMap;
    private static DefaultTableModel itemsTableModel; 
    private static DefaultTableModel customersTableModel; 
    private static DefaultTableModel receiptsTableModel;    
    
    private Inventory() {
        initComponents();
        conn = DBConnector.getConnection();
        itemsMap = new HashMap<>();
        customersMap = new HashMap<>();
        
        updateItemsTable();   
        updateCustomersTable();
        updateReceiptsTable();
        
        rowSorter = new TableRowSorter<>(itemsTable.getModel());
        itemsTable.setRowSorter(rowSorter);
        rowSorter2 = new TableRowSorter<>(customersTable.getModel());
        customersTable.setRowSorter(rowSorter2);
        rowSorter3 = new TableRowSorter<>(receiptsTable.getModel());
        receiptsTable.setRowSorter(rowSorter3);
        
        PromptSupport.init("Search", Color.GRAY, Color.WHITE,tfFilterCust);
        BuddySupport.addLeft(searchIcon2, tfFilterCust);
        PromptSupport.init("Search", Color.GRAY, Color.WHITE,tfFilterItems);
        BuddySupport.addLeft(searchIcon1, tfFilterItems);
        PromptSupport.init("Search", Color.GRAY, Color.WHITE,tfFilterReceipts);
        BuddySupport.addLeft(searchIcon3, tfFilterReceipts);
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
        tfFilterItems = new javax.swing.JTextField();
        searchIcon2 = new javax.swing.JLabel();
        customersPanel = new javax.swing.JPanel();
        tfFilterCust = new javax.swing.JTextField();
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
        searchIcon1 = new javax.swing.JLabel();
        receiptsPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        receiptsTable = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        bDeleteReceipt = new javax.swing.JButton();
        tfFilterReceipts = new javax.swing.JTextField();
        searchIcon3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bChangePass = new javax.swing.JButton();
        bLogOut = new javax.swing.JButton();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Villa Watt Inventory");

        jTabbedPane1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        bEditItem.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bEditItem.setText("Edit");
        bEditItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditItemActionPerformed(evt);
            }
        });

        bDeleteItem.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bDeleteItem.setText("Delete");
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
        itemsTable.getTableHeader().setReorderingAllowed(false);
        itemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemsTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(itemsTable);

        tfFilterItems.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfFilterItems.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                filter(tfFilterItems.getText(),rowSorter);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filter(tfFilterItems.getText(),rowSorter);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        searchIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project_2sem/Search-icon.png"))); // NOI18N

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
                        .addComponent(searchIcon2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFilterItems, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        itemsPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bCreateItem, bDeleteItem, bEditItem});

        itemsPanelLayout.setVerticalGroup(
            itemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(itemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchIcon2)
                    .addComponent(tfFilterItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        tfFilterCust.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfFilterCust.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                filter(tfFilterCust.getText(),rowSorter2);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filter(tfFilterCust.getText(),rowSorter2);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        customersTable.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        customersTable.getTableHeader().setReorderingAllowed(false);
        customersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                customersTableMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(customersTable);

        bDeleteCust.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bDeleteCust.setText("Delete");
        bDeleteCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteCustActionPerformed(evt);
            }
        });

        bEditCust.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bEditCust.setText("Edit");
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
        bRental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRentalActionPerformed(evt);
            }
        });

        searchIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project_2sem/Search-icon.png"))); // NOI18N

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
                        .addComponent(searchIcon1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFilterCust, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(tfFilterCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchIcon1))
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
        receiptsTable.getTableHeader().setReorderingAllowed(false);
        receiptsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                receiptsTableMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(receiptsTable);

        bDeleteReceipt.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bDeleteReceipt.setText("Delete");
        bDeleteReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteReceiptActionPerformed(evt);
            }
        });

        tfFilterReceipts.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                filter(tfFilterReceipts.getText(),rowSorter3);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filter(tfFilterReceipts.getText(),rowSorter3);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        tfFilterReceipts.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        searchIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project_2sem/Search-icon.png"))); // NOI18N

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
                        .addGroup(receiptsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bDeleteReceipt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receiptsPanelLayout.createSequentialGroup()
                                .addComponent(searchIcon3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfFilterReceipts, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        receiptsPanelLayout.setVerticalGroup(
            receiptsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiptsPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(receiptsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFilterReceipts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchIcon3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(bDeleteReceipt)
                .addContainerGap())
        );

        jTabbedPane1.addTab("  Receipts Archive   ", receiptsPanel);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bChangePass.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bChangePass.setText("Change Password ");
        bChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChangePassActionPerformed(evt);
            }
        });

        bLogOut.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bLogOut.setText("Log out");
        bLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogOutActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project_2sem/VillaWatt-logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bChangePass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bLogOut)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bChangePass)
                    .addComponent(bLogOut))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void filter(String text, TableRowSorter<TableModel> sorter) {
        if (text.trim().length() == 0) {                                        //trim() returns a copy of the string, with leading and trailing whitespace omitted.
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text.trim()));
        }
    }
    
    public static void updateItemsTable() {                   
        try {
            String sql = "SELECT itemID,SerialNo,Type,Brand,Model,Price,Status,ReturnDate FROM villa_watt_inventory.items;";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            itemsTable.setModel(DbUtils.resultSetToTableModel(rs));
            itemsTableModel = (DefaultTableModel) itemsTable.getModel();
            
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
            for(int i = 0; i < row; i++) { 
                int id = itemsArray.get(i).getId();
                itemsMap.put(id, itemsArray.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateCustomersTable() {               
        try { 
            String sql = "SELECT CustomerID,FirstName,LastName,Address,PhoneNo,Email FROM villa_watt_inventory.customers;";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            customersTable.setModel(DbUtils.resultSetToTableModel(rs));
            customersTableModel = (DefaultTableModel) customersTable.getModel();
            
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
            for(int i = 0; i < row; i++) { 
                int id = customersArray.get(i).getId();
                customersMap.put(id, customersArray.get(i));
            }
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
        
        itemI.getSerialNo().setEditable(true);
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
        
        itemI.getItemKey().setText("");                                         //No key needed if new item
        
        itemI.setVisible(true);
    }//GEN-LAST:event_bCreateItemActionPerformed

    private void bEditItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditItemActionPerformed
        int row = itemsTable.getSelectedRow();
        if(row != -1) {
            ItemInfo itemI = ItemInfo.getItemI(); 
            getItemInfo(itemI);  
            itemI.getSerialNo().setEditable(true);
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

            itemI.getItemKey().setText(itemsTable.getValueAt(row, 0).toString());  //the key(row) to recognise the item in the new window
            itemI.getItemKey().setVisible(false);
            
            itemI.setVisible(true); 
        }
        else
            JOptionPane.showMessageDialog(this, "Please select an item to edit", "Message", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_bEditItemActionPerformed
    //Get item information to display
    private void getItemInfo(ItemInfo itemI) {
        itemI.getSerialNo().setText(String.valueOf(itemsTable.getValueAt(itemsTable.getSelectedRow(), 1)));
        itemI.getIType().setText(String.valueOf(itemsTable.getValueAt(itemsTable.getSelectedRow(), 2)));
        itemI.getBrand().setText(String.valueOf(itemsTable.getValueAt(itemsTable.getSelectedRow(), 3)));
        itemI.getModel().setText(String.valueOf(itemsTable.getValueAt(itemsTable.getSelectedRow(), 4)));
        itemI.getPrice().setText(String.valueOf(itemsTable.getValueAt(itemsTable.getSelectedRow(), 5)));
        
        String status = String.valueOf(itemsTable.getValueAt(itemsTable.getSelectedRow(), 6));
        if(status.equals("rented out")) {
            Item item = itemsMap.get(Integer.parseInt(itemsTable.getValueAt(itemsTable.getSelectedRow(), 0).toString()));
            Customer cust = customersMap.get(item.getFk());
            itemI.getLabelCust().setText(cust.getFirstName()+" "+cust.getLastName());
            itemI.getLabelCust().setVisible(true);
            itemI.getLabelRent().setVisible(true);
              
        }else {
            itemI.getLabelCust().setVisible(false);
            itemI.getLabelRent().setVisible(false);
        }
    }
    
    private void bDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteItemActionPerformed
        int row = itemsTable.getSelectedRow();
        if(row != -1) {
            String itemID = itemsTable.getValueAt(row, 0).toString();
            int choice;
            if(String.valueOf(itemsTable.getValueAt(row, 6)).equals("rented out")) 
                choice = JOptionPane.showConfirmDialog(this, "This item is rented out. Are you sure you want to delete it anyway?", "Delete item", JOptionPane.YES_NO_OPTION);
            else 
                choice = JOptionPane.showConfirmDialog(this, "Do you really want to delete this item?", "Delete item", JOptionPane.YES_NO_OPTION);
            
            if(choice == JOptionPane.YES_OPTION) {
                try { 
                    itemsMap.remove(Integer.parseInt(itemID));
                    //Update database
                    String sql = "DELETE FROM villa_watt_inventory.items WHERE ItemID = ?";

                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, itemID);
                    pstmt.execute();                     

                    //Update items Catalogue
                    itemsTableModel.removeRow(row);                                             
                    JOptionPane.showMessageDialog(this, "Item successfully deleted");

                } catch (SQLException ex) {
                    Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Please select an item to delete", "Message", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_bDeleteItemActionPerformed
 
    private void bCreateCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateCustActionPerformed
        CustomerInfo custI = CustomerInfo.getCustI();
        custI.setVisible(true);
        
        //Clean all fields
        custI.cleanCustFields();
        custI.getCustKey().setText("");
    }//GEN-LAST:event_bCreateCustActionPerformed

    private void bEditCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditCustActionPerformed
        int row = customersTable.getSelectedRow();
        if(row != -1) {
            CustomerInfo custI = CustomerInfo.getCustI();  
            String id = String.valueOf(customersTable.getValueAt(row, 0));
            Customer c = customersMap.get(Integer.parseInt(id));
            
            custI.getFirstName().setText(c.getFirstName());
            custI.getLastName().setText(c.getLastName());
            custI.getAddress().setText(c.getAddress());
            custI.getPhone().setText(c.getPhoneNo());
            custI.getEmail().setText(c.getEmail());

            custI.getCustKey().setText(id);
            custI.getCustKey().setVisible(false);

            custI.setVisible(true);    
        }
        else
            JOptionPane.showMessageDialog(this, "Please select a customer to edit", "Message", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_bEditCustActionPerformed

    private void bDeleteCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteCustActionPerformed
        int row = customersTable.getSelectedRow();
        if(row != -1) {
            String custID = customersTable.getValueAt(row, 0).toString();

            ArrayList<Integer> listRentedItems = checkRentedItems(custID);
            int choice;
            if(listRentedItems.isEmpty()) {                                     //No item is rented by this customer
                choice = JOptionPane.showConfirmDialog(this, "Do you really want to delete this customer?", "Delete customer", JOptionPane.YES_NO_OPTION);
                if(choice == JOptionPane.YES_OPTION)
                    deleteCustomer(row, custID);
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
                    deleteCustomer(row, custID);
                }
            }
            updateItemsTable();
        }
        else
            JOptionPane.showMessageDialog(this, "Please select a customer to delete", "Message", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_bDeleteCustActionPerformed
    
    private ArrayList<Integer> checkRentedItems(String custID) {
        ArrayList<Integer> listRentedItems = new ArrayList<>();
        for (int key : itemsMap.keySet()) {
            Item item = itemsMap.get(key);
            if(item.getFk() == Integer.parseInt(custID))
                listRentedItems.add(item.getId());
        }
        return listRentedItems;
    }
    
    private void deleteCustomer(int row, String id) {
        try {   
            customersMap.remove(Integer.parseInt(id));
            //Update database
            String sql = "DELETE FROM villa_watt_inventory.customers WHERE CustomerID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.execute();    

            //Update customer list
            customersTableModel.removeRow(row);                                             
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
            itemI.getSerialNo().setEditable(false);
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
            rent();
        }
        else
            JOptionPane.showMessageDialog(this, "Please select a customer first", "Message", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_bRentalActionPerformed

    private void receiptsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receiptsTableMousePressed
        if(evt.getClickCount() == 2) {
            ReceiptGenerator rg = ReceiptGenerator.getReceipt();
            String invoiceNo = receiptsTable.getValueAt(receiptsTable.getSelectedRow(), 0).toString();
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

    private void customersTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customersTableMousePressed
        if(evt.getClickCount() == 2)
            rent();        
    }//GEN-LAST:event_customersTableMousePressed
    
    private void rent() {
        int row = customersTable.getSelectedRow();
        String custID = customersTable.getValueAt(row, 0).toString();
        Customer c = customersMap.get(Integer.parseInt(custID));
        RentalProcess rent = RentalProcess.getRentalProcess();

        //Update tables in rent frame
        rent.updateAvailableItemsTable();
        rent.updateRentedItemsTable(custID);
        rent.enableSorting();

        //Display customer's name
        rent.getCustName().setText(c.getFirstName()+" "+c.getLastName());  

        //Put in the new frame the key(row) to retrieve the customer from HashMap
        rent.getCustKey().setText(custID);
        rent.getCustKey().setVisible(false);

        rent.setVisible(true); 
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
              /*      UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());*/
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel receiptsPanel;
    private static javax.swing.JTable receiptsTable;
    private javax.swing.JLabel searchIcon1;
    private javax.swing.JLabel searchIcon2;
    private javax.swing.JLabel searchIcon3;
    private javax.swing.JTextField tfFilterCust;
    private javax.swing.JTextField tfFilterItems;
    private javax.swing.JTextField tfFilterReceipts;
    // End of variables declaration//GEN-END:variables
}
