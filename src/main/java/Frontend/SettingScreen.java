/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.ProfileManager;
import Backend.UserManager;
import Backend.VisualManager;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author abban
 */
public class SettingScreen extends javax.swing.JFrame {

    /**
     * Creates new form SettingScreen
     */
    private String Username = "";
    
    DefaultListModel AccountDefaultList = new DefaultListModel();
    String[] connectedAccount;
    
    //Code to get currently available font is from https://alvinalexander.com/blog/post/jfc-swing/swing-faq-list-fonts-current-platform/ 
    String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    
    DefaultComboBoxModel FontProfileDefaultList1 = new DefaultComboBoxModel();
    DefaultComboBoxModel FontProfileDefaultList2 = new DefaultComboBoxModel();
    
    
    
    public SettingScreen() {
        initComponents();
    }
    
    public SettingScreen(String username) {
        try {
            
            initComponents();
            Username = username;
            try {
                
                connectedAccount = UserManager.getConnectedAccount(Username);
                
                for(int i = 0; i < connectedAccount.length; i++ ){
                    
                    AccountDefaultList.addElement(connectedAccount[i]);
                    
                }
                
                this.AccountList.setModel(AccountDefaultList);
                
            } catch (SQLException ex) {
                Logger.getLogger(SettingScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i = 0; i < fonts.length; i++){
                FontProfileDefaultList1.addElement(fonts[i]);
                FontProfileDefaultList2.addElement(fonts[i]);
                this.fontBioComboBox.setModel(FontProfileDefaultList1);
                this.fontMessageComboBox.setModel(FontProfileDefaultList2);
            }
            
            FirstColourSideMenuTextField.setText(VisualManager.getFirstColourSideMenuBackground(username));
            
            LastColourSideMenuTextField.setText(VisualManager.getLastColourSideMenuBackground(username));
            
            FirstColourTextingScreenTextField.setText(VisualManager.getFirstColourTextingBackground(username));
            
            LastColourTextingScreenTextField.setText(VisualManager.getLastColourTextingBackground(username));
            
            FirstcColourProfileScreenTextField.setText(VisualManager.getFirstColourProfileBackground(username));
            
            LastColourProfileScreenTextField.setText(VisualManager.getLastColourProfileBackground(username));
            
        } catch (SQLException ex) {
            Logger.getLogger(SettingScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    public SettingScreen(String username,String result) {
        try {
            
            initComponents();
            Username = username;
            for(int i = 0; i < fonts.length; i++){
                FontProfileDefaultList1.addElement(fonts[i]);
                FontProfileDefaultList2.addElement(fonts[i]);
                this.fontBioComboBox.setModel(FontProfileDefaultList1);
                this.fontMessageComboBox.setModel(FontProfileDefaultList2);
            }
            if(result.equals("Account added successful")){
                
                ErrorAccountLabel.setForeground(Color.green);
                
            }
            else{
                
                ErrorAccountLabel.setForeground(Color.red);
                
            }
            try {
                
                connectedAccount = UserManager.getConnectedAccount(Username);
                
                for(int i = 0; i < connectedAccount.length; i++ ){
                    
                    AccountDefaultList.addElement(connectedAccount[i]);
                    
                }
                
                this.AccountList.setModel(AccountDefaultList);
                
            } catch (SQLException ex) {
                Logger.getLogger(SettingScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            FirstColourSideMenuTextField.setText(VisualManager.getFirstColourSideMenuBackground(username));
            LastColourSideMenuTextField.setText(VisualManager.getLastColourSideMenuBackground(username));
            FirstColourTextingScreenTextField.setText(VisualManager.getFirstColourTextingBackground(username));
            LastColourTextingScreenTextField.setText(VisualManager.getLastColourTextingBackground(username));
            FirstcColourProfileScreenTextField.setText(VisualManager.getFirstColourProfileBackground(username));
            LastColourProfileScreenTextField.setText(VisualManager.getLastColourProfileBackground(username));
            ErrorAccountLabel.setText(result);
            
        } catch (SQLException ex) {
            Logger.getLogger(SettingScreen.class.getName()).log(Level.SEVERE, null, ex);
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
        settingPanel1 = new UISupport.SettingBackground();
        SettingLabel = new javax.swing.JLabel();
        ReturnButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        DisplayLayerPane = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        FirstColourSideMenuTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        LastColourSideMenuTextField = new javax.swing.JTextField();
        UpdateSideMenuButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        FirstColourTextingScreenTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        LastColourTextingScreenTextField = new javax.swing.JTextField();
        UpdateTextingScreenButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        FirstcColourProfileScreenTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        LastColourProfileScreenTextField = new javax.swing.JTextField();
        profileBackground1 = new UISupport.ProfileBackground();
        UpdateProfileScreen = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        fontBioComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        fontMessageComboBox = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        SideMenuColourError = new javax.swing.JLabel();
        UpdateMessageButton = new javax.swing.JButton();
        sizeBioSpinner = new javax.swing.JSpinner();
        sizeMessageSpinner = new javax.swing.JSpinner();
        UpdateBioDisplayButton = new javax.swing.JButton();
        TextingAreaErrorLabel = new javax.swing.JLabel();
        ProfileBackgroundErrorLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sideMenuBackground1 = new UISupport.SideMenuBackground();
        textingBackground1 = new UISupport.TextingBackground();
        jLabel6 = new javax.swing.JLabel();
        ProfileLayeredPane = new javax.swing.JLayeredPane();
        DisplayNameLabel = new javax.swing.JLabel();
        DisplayNameTextField = new javax.swing.JTextField();
        UpdateDisplayNameButton = new javax.swing.JButton();
        IconLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        UpdateIconButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        UpdateBioButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        AddAccountButton = new javax.swing.JButton();
        RemoveAccountButton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        AccountList = new javax.swing.JList<>();
        ErrorAccountLabel = new javax.swing.JLabel();
        BioTextField = new javax.swing.JTextArea();
        ErrorBioLabel = new javax.swing.JLabel();
        ErrrorDisplayNameLabel = new javax.swing.JLabel();
        IconComboBox = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        ProfileIconLabel = new javax.swing.JLabel();
        ConfirmUpdateIconLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SettingLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        SettingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/setting_large_icon.png"))); // NOI18N
        SettingLabel.setText("Setting");

        ReturnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/left_arrow_icon.png"))); // NOI18N
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/account_small_icon.png"))); // NOI18N
        jLabel1.setText("Profile:");

        jLabel7.setText("Change background of side menu");

        jLabel8.setText("First colour:");

        FirstColourSideMenuTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FirstColourSideMenuTextFieldKeyReleased(evt);
            }
        });

        jLabel9.setText("Last colour:");

        LastColourSideMenuTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                LastColourSideMenuTextFieldKeyReleased(evt);
            }
        });

        UpdateSideMenuButton.setText("Update");
        UpdateSideMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateSideMenuButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Change background of texting screen");

        jLabel11.setText("First colour:");

        FirstColourTextingScreenTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FirstColourTextingScreenTextFieldKeyReleased(evt);
            }
        });

        jLabel12.setText("Last colour:");

        LastColourTextingScreenTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                LastColourTextingScreenTextFieldKeyReleased(evt);
            }
        });

        UpdateTextingScreenButton.setText("Update");
        UpdateTextingScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTextingScreenButtonActionPerformed(evt);
            }
        });

        jLabel13.setText("Change background of profile screen");

        jLabel14.setText("First colour:");

        FirstcColourProfileScreenTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FirstcColourProfileScreenTextFieldKeyReleased(evt);
            }
        });

        jLabel15.setText("Last colour:");

        LastColourProfileScreenTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                LastColourProfileScreenTextFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout profileBackground1Layout = new javax.swing.GroupLayout(profileBackground1);
        profileBackground1.setLayout(profileBackground1Layout);
        profileBackground1Layout.setHorizontalGroup(
            profileBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        profileBackground1Layout.setVerticalGroup(
            profileBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        UpdateProfileScreen.setText("Update");
        UpdateProfileScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateProfileScreenActionPerformed(evt);
            }
        });

        jLabel17.setText("Change text font of bio:");

        jLabel18.setText("Change text size of bio:");

        jLabel20.setText("Change text font of messages:");

        jLabel21.setText("Change text size of messages:");

        fontBioComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("This is how it looks like:");

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel24.setText("words");

        fontMessageComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel25.setText("This is how it looks like: ");

        jLabel26.setText("words");

        SideMenuColourError.setText(" ");

        UpdateMessageButton.setText("Update");

        UpdateBioDisplayButton.setText("Update");

        TextingAreaErrorLabel.setText(" ");

        jLabel2.setText("You may need to restart the program for the change to happen");

        javax.swing.GroupLayout sideMenuBackground1Layout = new javax.swing.GroupLayout(sideMenuBackground1);
        sideMenuBackground1.setLayout(sideMenuBackground1Layout);
        sideMenuBackground1Layout.setHorizontalGroup(
            sideMenuBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        sideMenuBackground1Layout.setVerticalGroup(
            sideMenuBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout textingBackground1Layout = new javax.swing.GroupLayout(textingBackground1);
        textingBackground1.setLayout(textingBackground1Layout);
        textingBackground1Layout.setHorizontalGroup(
            textingBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        textingBackground1Layout.setVerticalGroup(
            textingBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        DisplayLayerPane.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(FirstColourSideMenuTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(LastColourSideMenuTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(UpdateSideMenuButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(FirstColourTextingScreenTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(LastColourTextingScreenTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(UpdateTextingScreenButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(FirstcColourProfileScreenTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(LastColourProfileScreenTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(profileBackground1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(UpdateProfileScreen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(fontBioComboBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel24, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(fontMessageComboBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel25, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel26, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(SideMenuColourError, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(UpdateMessageButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(sizeBioSpinner, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(sizeMessageSpinner, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(UpdateBioDisplayButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(TextingAreaErrorLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(ProfileBackgroundErrorLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(sideMenuBackground1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DisplayLayerPane.setLayer(textingBackground1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DisplayLayerPaneLayout = new javax.swing.GroupLayout(DisplayLayerPane);
        DisplayLayerPane.setLayout(DisplayLayerPaneLayout);
        DisplayLayerPaneLayout.setHorizontalGroup(
            DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DisplayLayerPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DisplayLayerPaneLayout.createSequentialGroup()
                        .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sizeBioSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addGap(224, 224, 224))
                    .addGroup(DisplayLayerPaneLayout.createSequentialGroup()
                        .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sizeMessageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jLabel26)
                        .addGap(220, 220, 220))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DisplayLayerPaneLayout.createSequentialGroup()
                        .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DisplayLayerPaneLayout.createSequentialGroup()
                                .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(LastColourProfileScreenTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(FirstcColourProfileScreenTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(profileBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DisplayLayerPaneLayout.createSequentialGroup()
                                .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11)
                                    .addComponent(FirstColourTextingScreenTextField)
                                    .addComponent(jLabel12)
                                    .addComponent(LastColourTextingScreenTextField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textingBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DisplayLayerPaneLayout.createSequentialGroup()
                        .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(FirstColourSideMenuTextField)
                                .addComponent(LastColourSideMenuTextField))
                            .addComponent(UpdateBioDisplayButton)
                            .addComponent(fontBioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(UpdateTextingScreenButton)
                            .addComponent(jLabel14)
                            .addComponent(UpdateProfileScreen)
                            .addComponent(fontMessageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sideMenuBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))
                    .addGroup(DisplayLayerPaneLayout.createSequentialGroup()
                        .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UpdateMessageButton)
                            .addComponent(jLabel20)
                            .addComponent(TextingAreaErrorLabel)
                            .addComponent(ProfileBackgroundErrorLabel)
                            .addComponent(jLabel2)
                            .addComponent(UpdateSideMenuButton)
                            .addComponent(SideMenuColourError, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        DisplayLayerPaneLayout.setVerticalGroup(
            DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DisplayLayerPaneLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(26, 26, 26)
                .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DisplayLayerPaneLayout.createSequentialGroup()
                        .addComponent(FirstColourSideMenuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(21, 21, 21)
                        .addComponent(LastColourSideMenuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sideMenuBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(UpdateSideMenuButton)
                .addGap(4, 4, 4)
                .addComponent(SideMenuColourError)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DisplayLayerPaneLayout.createSequentialGroup()
                        .addComponent(FirstColourTextingScreenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(LastColourTextingScreenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textingBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DisplayLayerPaneLayout.createSequentialGroup()
                        .addComponent(UpdateTextingScreenButton)
                        .addGap(8, 8, 8)
                        .addComponent(TextingAreaErrorLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(FirstcColourProfileScreenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(LastColourProfileScreenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(profileBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(UpdateProfileScreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProfileBackgroundErrorLabel)
                .addGap(16, 16, 16)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fontBioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sizeBioSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addComponent(UpdateBioDisplayButton)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fontMessageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sizeMessageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DisplayLayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addComponent(UpdateMessageButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/display_icon.png"))); // NOI18N
        jLabel6.setText("Display");

        DisplayNameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Displayname_icon.png"))); // NOI18N
        DisplayNameLabel.setText("Display name:");

        DisplayNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DisplayNameTextFieldKeyReleased(evt);
            }
        });

        UpdateDisplayNameButton.setText("Update");
        UpdateDisplayNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateDisplayNameButtonActionPerformed(evt);
            }
        });

        IconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/account_really_small_icon.png"))); // NOI18N
        IconLabel.setText("Icon:");

        UpdateIconButton.setText("Update");
        UpdateIconButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateIconButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Bio:");

        UpdateBioButton.setText("Update");
        UpdateBioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBioButtonActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/change_account_icon.png"))); // NOI18N
        jLabel4.setText("Add account:");

        AddAccountButton.setText("Add");
        AddAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAccountButtonActionPerformed(evt);
            }
        });

        RemoveAccountButton.setText("Remove");
        RemoveAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveAccountButtonActionPerformed(evt);
            }
        });

        AccountList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        ErrorAccountLabel.setForeground(new java.awt.Color(255, 0, 0));

        BioTextField.setColumns(20);
        BioTextField.setRows(5);
        BioTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BioTextFieldKeyReleased(evt);
            }
        });

        ErrorBioLabel.setForeground(new java.awt.Color(255, 0, 0));

        ErrrorDisplayNameLabel.setForeground(new java.awt.Color(255, 0, 0));

        IconComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default", "Sir Croc", "Charli sqaud", "Real Charli sqaud", "Los Pollos Hermanos", "Old wizard", "Capybara", "Doofenshmirtz evil incorporated", "True fat man" }));
        IconComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                IconComboBoxItemStateChanged(evt);
            }
        });

        jLabel27.setText("This is how it looks like:");

        ProfileIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/account_icon.png"))); // NOI18N

        ProfileLayeredPane.setLayer(DisplayNameLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(DisplayNameTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(UpdateDisplayNameButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(IconLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(UpdateIconButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(UpdateBioButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(jSeparator3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(AddAccountButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(RemoveAccountButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(jSeparator4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(AccountList, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(ErrorAccountLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(BioTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(ErrorBioLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(ErrrorDisplayNameLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(IconComboBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(jLabel27, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(ProfileIconLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ProfileLayeredPane.setLayer(ConfirmUpdateIconLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout ProfileLayeredPaneLayout = new javax.swing.GroupLayout(ProfileLayeredPane);
        ProfileLayeredPane.setLayout(ProfileLayeredPaneLayout);
        ProfileLayeredPaneLayout.setHorizontalGroup(
            ProfileLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileLayeredPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProfileLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addGroup(ProfileLayeredPaneLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(ProfileLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(ProfileLayeredPaneLayout.createSequentialGroup()
                        .addComponent(AccountList, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(ProfileLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4)
                            .addComponent(AddAccountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RemoveAccountButton, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                        .addGap(116, 116, 116))
                    .addGroup(ProfileLayeredPaneLayout.createSequentialGroup()
                        .addGroup(ProfileLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UpdateDisplayNameButton)
                            .addGroup(ProfileLayeredPaneLayout.createSequentialGroup()
                                .addComponent(DisplayNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DisplayNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(ProfileLayeredPaneLayout.createSequentialGroup()
                        .addGroup(ProfileLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ErrorAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ErrrorDisplayNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(ProfileLayeredPaneLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(ProfileLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UpdateBioButton)
                                    .addComponent(ErrorBioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ProfileLayeredPaneLayout.createSequentialGroup()
                        .addComponent(IconLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProfileLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IconComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ProfileLayeredPaneLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ProfileLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UpdateIconButton)
                            .addComponent(ConfirmUpdateIconLabel))
                        .addGap(29, 29, 29))))
            .addGroup(ProfileLayeredPaneLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(ProfileIconLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProfileLayeredPaneLayout.setVerticalGroup(
            ProfileLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileLayeredPaneLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(ProfileLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DisplayNameLabel)
                    .addComponent(DisplayNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ErrrorDisplayNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(UpdateDisplayNameButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ProfileLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IconLabel)
                    .addComponent(IconComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateIconButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ProfileLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(ConfirmUpdateIconLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ProfileIconLabel)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(BioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UpdateBioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ErrorBioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(ProfileLayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileLayeredPaneLayout.createSequentialGroup()
                        .addComponent(AddAccountButton)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RemoveAccountButton)
                        .addGap(33, 33, 33))
                    .addComponent(AccountList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ErrorAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout settingPanel1Layout = new javax.swing.GroupLayout(settingPanel1);
        settingPanel1.setLayout(settingPanel1Layout);
        settingPanel1Layout.setHorizontalGroup(
            settingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ReturnButton)
                .addGap(141, 141, 141)
                .addGroup(settingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addComponent(SettingLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingPanel1Layout.createSequentialGroup()
                .addContainerGap(265, Short.MAX_VALUE)
                .addGroup(settingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(ProfileLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DisplayLayerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
        );
        settingPanel1Layout.setVerticalGroup(
            settingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingPanel1Layout.createSequentialGroup()
                .addGroup(settingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ReturnButton))
                    .addGroup(settingPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(SettingLabel)))
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProfileLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(24, 24, 24)
                .addComponent(DisplayLayerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(settingPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 2352, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RemoveAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveAccountButtonActionPerformed
        // TODO add your handling code here:
        if(AccountDefaultList.elementAt(AccountList.getSelectedIndex()).equals(Username)){
            
            ErrorAccountLabel.setForeground(Color.red);
            ErrorAccountLabel.setText("Can't remove this account");
            
        }else{
            
            try {
                UserManager.removeConnectedAccount(Username, AccountList.getSelectedValue(), AccountList.getSelectedIndex());
                AccountDefaultList.removeElementAt(AccountList.getSelectedIndex());
                ErrorAccountLabel.setForeground(Color.GREEN);
                ErrorAccountLabel.setText("Remove account successful");
            } catch (SQLException ex) {
                Logger.getLogger(SettingScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_RemoveAccountButtonActionPerformed

    private void AddAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAccountButtonActionPerformed
        // TODO add your handling code here:
        int numberOfAccount = AccountList.getMaxSelectionIndex();
        
        if(numberOfAccount == 3){
            
            ErrorAccountLabel.setForeground(Color.red);
            ErrorAccountLabel.setText("Can't add more account");
            
        }
        else{
            
            new LoginMainScreen(1,Username).setVisible(true);
            dispose();
            
        }
    }//GEN-LAST:event_AddAccountButtonActionPerformed

    private void FirstColourSideMenuTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FirstColourSideMenuTextFieldKeyReleased
        // TODO add your handling code here:
        try{
            Color.decode(FirstColourSideMenuTextField.getText());
            
            SideMenuColourError.setForeground(Color.green);
            SideMenuColourError.setText("This is real colour");
            
        }
        catch(IllegalArgumentException ex){
            
            SideMenuColourError.setForeground(Color.red);
            SideMenuColourError.setText("This is not a real colour");
            
        }
        
    }//GEN-LAST:event_FirstColourSideMenuTextFieldKeyReleased

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        // TODO add your handling code here:
        new HomeScreen(Username).setVisible(true);
        dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private void LastColourSideMenuTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LastColourSideMenuTextFieldKeyReleased
        // TODO add your handling code here:
        try{
            
            Color.decode(LastColourSideMenuTextField.getText());
            
            SideMenuColourError.setForeground(Color.green);
            SideMenuColourError.setText("This is real colour");
            
        }
        catch(IllegalArgumentException ex){
            
            SideMenuColourError.setForeground(Color.red);
            SideMenuColourError.setText("This is not a real colour");
            
        }
    }//GEN-LAST:event_LastColourSideMenuTextFieldKeyReleased

    private void FirstColourTextingScreenTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FirstColourTextingScreenTextFieldKeyReleased
        // TODO add your handling code here:
        try{
            Color.decode(FirstColourTextingScreenTextField.getText());
        }
        catch(IllegalArgumentException ex){
            
           TextingAreaErrorLabel.setForeground(Color.red);
            TextingAreaErrorLabel.setText("This is not a real colour");
            
        }
    }//GEN-LAST:event_FirstColourTextingScreenTextFieldKeyReleased

    private void LastColourTextingScreenTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LastColourTextingScreenTextFieldKeyReleased
        // TODO add your handling code here:
        try{
            
            Color.decode(LastColourTextingScreenTextField.getText());
            
            TextingAreaErrorLabel.setForeground(Color.green);
            TextingAreaErrorLabel.setText("This is a real colour");
            
        }
        catch(IllegalArgumentException ex){
            
            TextingAreaErrorLabel.setForeground(Color.red);
            TextingAreaErrorLabel.setText("This is not a real colour");
            
        }
    }//GEN-LAST:event_LastColourTextingScreenTextFieldKeyReleased

    private void FirstcColourProfileScreenTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FirstcColourProfileScreenTextFieldKeyReleased
        // TODO add your handling code here:
        try{
            
            Color.decode(FirstcColourProfileScreenTextField.getText());
            
            ProfileBackgroundErrorLabel.setForeground(Color.green);
            ProfileBackgroundErrorLabel.setText("This is a real colour");
            
        }
        catch(IllegalArgumentException ex){
            
            ProfileBackgroundErrorLabel.setForeground(Color.red);
            ProfileBackgroundErrorLabel.setText("This is not a real colour");
            
        }
    }//GEN-LAST:event_FirstcColourProfileScreenTextFieldKeyReleased

    private void LastColourProfileScreenTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LastColourProfileScreenTextFieldKeyReleased
        // TODO add your handling code here:
        try{
            Color.decode(LastColourProfileScreenTextField.getText());
            
            ProfileBackgroundErrorLabel.setForeground(Color.green);
            ProfileBackgroundErrorLabel.setText("This is a real colour");
            
        }
        catch(IllegalArgumentException ex){
            
            ProfileBackgroundErrorLabel.setForeground(Color.red);
            ProfileBackgroundErrorLabel.setText("This is not a real colour");
            
        }
    }//GEN-LAST:event_LastColourProfileScreenTextFieldKeyReleased

    private void IconComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_IconComboBoxItemStateChanged
        // TODO add your handling code here:
        if(IconComboBox.getSelectedItem().toString().equals("Default")){
            
            ProfileIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/account_icon.png")));
            
        }
        else if(IconComboBox.getSelectedItem().toString().equals("Sir Croc")){
            
            ProfileIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fancy_croc_profile_icon.png")));
            
        }
        else if(IconComboBox.getSelectedItem().toString().equals("Charli sqaud")){
            
            ProfileIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/charli_sqaud_profile_icon.png")));
            
        }
        else if(IconComboBox.getSelectedItem().toString().equals("Real Charli sqaud")){
            
            ProfileIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/real_charli_squad_profile_icon.png")));
            
        }
        else if(IconComboBox.getSelectedItem().toString().equals("Los Pollos Hermanos")){
            
            ProfileIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/los_pollos_hermandoes_profile_icon.png")));
        }
        else if(IconComboBox.getSelectedItem().toString().equals("Old wizard")){
            
            ProfileIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/old_man_with_stick_profile_icon.png"))); 
            
        }
        else if(IconComboBox.getSelectedItem().toString().equals("Capybara")){
            
            ProfileIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/capybara_profile_icon.png"))); 
            
        }
        else if(IconComboBox.getSelectedItem().toString().equals("Doofenshmirtz evil incorporated")){
            
            ProfileIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/doofenshmirtz_evil_incorporated_profile_icon.png")));
            
        }
        else{
            
            ProfileIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/true_fat_man_profile_icon.png")));
            
        }
    }//GEN-LAST:event_IconComboBoxItemStateChanged

    private void DisplayNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DisplayNameTextFieldKeyReleased
        // TODO add your handling code here:
        String result = UserManager.isDisplayNameValid(DisplayNameTextField.getText());
        
        if(result.equals("Everything is alright")){
            
            ErrrorDisplayNameLabel.setForeground(Color.green);
            
        }
        else{
            
            ErrrorDisplayNameLabel.setForeground(Color.red);
        }
        
        ErrrorDisplayNameLabel.setText(result);
    }//GEN-LAST:event_DisplayNameTextFieldKeyReleased

    private void UpdateDisplayNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateDisplayNameButtonActionPerformed
        try {
            // TODO add your handling code here:
            UserManager.updateDisplayName(Username, DisplayNameTextField.getText());
            ErrrorDisplayNameLabel.setForeground(Color.green);
            ErrrorDisplayNameLabel.setText("Display name updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(SettingScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateDisplayNameButtonActionPerformed

    private void UpdateIconButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateIconButtonActionPerformed
        // TODO add your handling code here:
        int profileIconNumber = IconComboBox.getSelectedIndex() + 1;
        
        try {
            
            ProfileManager.updateProfileIcon(Username, profileIconNumber);
            
            ConfirmUpdateIconLabel.setForeground(Color.green);
            
            ConfirmUpdateIconLabel.setText("Profile Updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(SettingScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateIconButtonActionPerformed

    private void BioTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BioTextFieldKeyReleased
        // TODO add your handling code here:
       if(BioTextField.getText().length() > 255){
           
           ErrorBioLabel.setForeground(Color.red);
           ErrorBioLabel.setText("Too long");
           
       }
       else{
           
           ErrorBioLabel.setForeground(Color.green);
           ErrorBioLabel.setText("Everything is alright");
           
       }
    }//GEN-LAST:event_BioTextFieldKeyReleased

    private void UpdateBioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBioButtonActionPerformed
        try {
            // TODO add your handling code here:
            String bio = BioTextField.getText();
            
            ProfileManager.updateBio(Username, bio);
            
            ErrorBioLabel.setForeground(Color.green);
            
            ErrorBioLabel.setText("Bio updated");
        } catch (SQLException ex) {
            Logger.getLogger(SettingScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_UpdateBioButtonActionPerformed

    private void UpdateSideMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateSideMenuButtonActionPerformed
        try {
            // TODO add your handling code here:
            VisualManager.updateSideMenuBackground(Username, FirstColourSideMenuTextField.getText(), LastColourSideMenuTextField.getText());
        } catch (SQLException ex) {
            Logger.getLogger(SettingScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateSideMenuButtonActionPerformed

    private void UpdateTextingScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTextingScreenButtonActionPerformed
        try {
            // TODO add your handling code here:
            VisualManager.updateTextingBackground(Username, FirstColourTextingScreenTextField.getText(), LastColourTextingScreenTextField.getText());
        } catch (SQLException ex) {
            Logger.getLogger(SettingScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateTextingScreenButtonActionPerformed

    private void UpdateProfileScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateProfileScreenActionPerformed
        try {
            // TODO add your handling code here:
            VisualManager.updateProfileBackground(Username, FirstcColourProfileScreenTextField.getText(), LastColourProfileScreenTextField.getText());
        } catch (SQLException ex) {
            Logger.getLogger(SettingScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateProfileScreenActionPerformed

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
            java.util.logging.Logger.getLogger(SettingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SettingScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> AccountList;
    private javax.swing.JButton AddAccountButton;
    private javax.swing.JTextArea BioTextField;
    private javax.swing.JLabel ConfirmUpdateIconLabel;
    private javax.swing.JLayeredPane DisplayLayerPane;
    private javax.swing.JLabel DisplayNameLabel;
    private javax.swing.JTextField DisplayNameTextField;
    private javax.swing.JLabel ErrorAccountLabel;
    private javax.swing.JLabel ErrorBioLabel;
    private javax.swing.JLabel ErrrorDisplayNameLabel;
    private javax.swing.JTextField FirstColourSideMenuTextField;
    private javax.swing.JTextField FirstColourTextingScreenTextField;
    private javax.swing.JTextField FirstcColourProfileScreenTextField;
    private javax.swing.JComboBox<String> IconComboBox;
    private javax.swing.JLabel IconLabel;
    private javax.swing.JTextField LastColourProfileScreenTextField;
    private javax.swing.JTextField LastColourSideMenuTextField;
    private javax.swing.JTextField LastColourTextingScreenTextField;
    private javax.swing.JLabel ProfileBackgroundErrorLabel;
    private javax.swing.JLabel ProfileIconLabel;
    private javax.swing.JLayeredPane ProfileLayeredPane;
    private javax.swing.JButton RemoveAccountButton;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JLabel SettingLabel;
    private javax.swing.JLabel SideMenuColourError;
    private javax.swing.JLabel TextingAreaErrorLabel;
    private javax.swing.JButton UpdateBioButton;
    private javax.swing.JButton UpdateBioDisplayButton;
    private javax.swing.JButton UpdateDisplayNameButton;
    private javax.swing.JButton UpdateIconButton;
    private javax.swing.JButton UpdateMessageButton;
    private javax.swing.JButton UpdateProfileScreen;
    private javax.swing.JButton UpdateSideMenuButton;
    private javax.swing.JButton UpdateTextingScreenButton;
    private javax.swing.JComboBox<String> fontBioComboBox;
    private javax.swing.JComboBox<String> fontMessageComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private UISupport.ProfileBackground profileBackground1;
    private UISupport.SettingBackground settingPanel1;
    private UISupport.SideMenuBackground sideMenuBackground1;
    private javax.swing.JSpinner sizeBioSpinner;
    private javax.swing.JSpinner sizeMessageSpinner;
    private UISupport.TextingBackground textingBackground1;
    // End of variables declaration//GEN-END:variables
}
