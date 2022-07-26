/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.FriendManager;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author abban
 */
public class AddFriendScreen extends javax.swing.JFrame {

    /**
     * Creates new form AddFriendScreen
     */
    private String username;

    public AddFriendScreen() {
        initComponents();

    }

    public AddFriendScreen(String username) {
        initComponents();

        this.username = username;
        
        try {
            
            //Get a string array of friend request
            String[] incomingFriendRequest = FriendManager.getFriendRequestList(username);

            //use DefaultListModel because you can easily change content of jList
            DefaultListModel defaultIncomingFriendRequestListModel = new DefaultListModel();

            for (String incomingFriendRequest1 : incomingFriendRequest) {
                
                //Add each element from string array to DefaultListModel
                defaultIncomingFriendRequestListModel.addElement(incomingFriendRequest1);

            }

            //Set model
            IncomingFriendRequestList.setModel(defaultIncomingFriendRequestListModel);

        } catch (SQLException ex) {
            Logger.getLogger(AddFriendScreen.class.getName()).log(Level.SEVERE, null, ex);
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

        settingBackground1 = new Backgrounds.SettingBackground();
        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SearchFriendTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        PeopleToSendFriendRequestList = new javax.swing.JList<>();
        SendFriendRequestButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        IncomingFriendRequestList = new javax.swing.JList<>();
        AcceptFriendRequestButton = new javax.swing.JButton();
        GoBackButton = new javax.swing.JButton();
        SendFriendRequestSucessLabel = new javax.swing.JLabel();
        RefreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Send Friend request");

        jLabel2.setText("Search");

        SearchFriendTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFriendTextFieldKeyReleased(evt);
            }
        });

        PeopleToSendFriendRequestList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(PeopleToSendFriendRequestList);

        SendFriendRequestButton.setText("Send");
        SendFriendRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendFriendRequestButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Accept Friend Request");

        IncomingFriendRequestList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(IncomingFriendRequestList);

        AcceptFriendRequestButton.setText("Accept");
        AcceptFriendRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptFriendRequestButtonActionPerformed(evt);
            }
        });

        GoBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/left_arrow_icon.png"))); // NOI18N
        GoBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackButtonActionPerformed(evt);
            }
        });

        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout settingBackground1Layout = new javax.swing.GroupLayout(settingBackground1);
        settingBackground1.setLayout(settingBackground1Layout);
        settingBackground1Layout.setHorizontalGroup(
            settingBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingBackground1Layout.createSequentialGroup()
                .addGroup(settingBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingBackground1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(GoBackButton))
                    .addGroup(settingBackground1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(settingBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(settingBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(SearchFriendTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(SendFriendRequestButton)
                            .addComponent(SendFriendRequestSucessLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(83, 83, 83)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(settingBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(settingBackground1Layout.createSequentialGroup()
                        .addComponent(AcceptFriendRequestButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RefreshButton))
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(74, 74, 74))
        );
        settingBackground1Layout.setVerticalGroup(
            settingBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
            .addGroup(settingBackground1Layout.createSequentialGroup()
                .addGroup(settingBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingBackground1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(GoBackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(SearchFriendTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SendFriendRequestButton)
                        .addGap(18, 18, 18)
                        .addComponent(SendFriendRequestSucessLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(settingBackground1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(settingBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AcceptFriendRequestButton)
                            .addComponent(RefreshButton))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settingBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settingBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GoBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackButtonActionPerformed
        // TODO add your handling code here:
        new HomeScreen(username).setVisible(true);
        dispose();
    }//GEN-LAST:event_GoBackButtonActionPerformed

    private void SearchFriendTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFriendTextFieldKeyReleased
        // TODO add your handling code here:
        String search = SearchFriendTextField.getText();
        try {

            //Get a string array of people
            String[] listOfPeople = FriendManager.findPeople(search, username);

            //use DefaultListModel because you can easily change content of jList
            DefaultListModel defaultSearchResultListModel = new DefaultListModel();

            for (String listOfPeople1 : listOfPeople) {

                //Add each element from string array to DefaultListModel
                defaultSearchResultListModel.addElement(listOfPeople1);

            }

            //Set model
            PeopleToSendFriendRequestList.setModel(defaultSearchResultListModel);

        } catch (SQLException ex) {
            Logger.getLogger(AddFriendScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SearchFriendTextFieldKeyReleased

    private void SendFriendRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendFriendRequestButtonActionPerformed
        // TODO add your handling code here:
        String to = PeopleToSendFriendRequestList.getSelectedValue();
        try {

            boolean friendRequestSucess = FriendManager.sendFriendRequest(username, to);

            if (friendRequestSucess) {

                SendFriendRequestSucessLabel.setForeground(Color.green);
                SendFriendRequestSucessLabel.setText("Friend request sent");

            } else {

                SendFriendRequestSucessLabel.setForeground(Color.red);
                SendFriendRequestSucessLabel.setText("Friend request failed");

            }

        } catch (SQLException ex) {
            Logger.getLogger(AddFriendScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_SendFriendRequestButtonActionPerformed

    private void AcceptFriendRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptFriendRequestButtonActionPerformed
        // TODO add your handling code here:
        String selectedFriendRequest = IncomingFriendRequestList.getSelectedValue();

        try {

            FriendManager.acceptFriendRequest(username, selectedFriendRequest);

            String[] newIncomingFriendRequest = FriendManager.getFriendRequestList(username);

            DefaultListModel defaultNewIncomingFriendRequestListModel = new DefaultListModel();

            for (String newIncomingFriendRequest1 : newIncomingFriendRequest) {

                defaultNewIncomingFriendRequestListModel.addElement(newIncomingFriendRequest1);

            }

            IncomingFriendRequestList.setModel(defaultNewIncomingFriendRequestListModel);

        } catch (SQLException ex) {
            Logger.getLogger(AddFriendScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AcceptFriendRequestButtonActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        try {
            // TODO add your handling code here:
            String[] incomingFriendRequest = FriendManager.getFriendRequestList(username);

            DefaultListModel defaultIncomingFriendRequestListModel = new DefaultListModel();

            for (String incomingFriendRequest1 : incomingFriendRequest) {

                defaultIncomingFriendRequestListModel.addElement(incomingFriendRequest1);

            }

            IncomingFriendRequestList.setModel(defaultIncomingFriendRequestListModel);
        } catch (SQLException ex) {
            Logger.getLogger(AddFriendScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RefreshButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddFriendScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFriendScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFriendScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFriendScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AddFriendScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptFriendRequestButton;
    private javax.swing.JButton GoBackButton;
    private javax.swing.JList<String> IncomingFriendRequestList;
    private javax.swing.JList<String> PeopleToSendFriendRequestList;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JTextField SearchFriendTextField;
    private javax.swing.JButton SendFriendRequestButton;
    private javax.swing.JLabel SendFriendRequestSucessLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private Backgrounds.SettingBackground settingBackground1;
    // End of variables declaration//GEN-END:variables
}
