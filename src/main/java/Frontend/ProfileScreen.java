/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.VisualManager;
import UISupport.ProfileBackground;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abban
 */
public class ProfileScreen extends javax.swing.JFrame {

    /**
     * Creates new form ProfileScreen
     */
    private String Username = "";
    
    public ProfileScreen() {
        initComponents();
        
    }
    
    public ProfileScreen(String username) {
        try {
            initComponents();
            Username = username;
            
            String colour1 = VisualManager.getFirstColourProfileBackground(username);
            
            String colour2 = VisualManager.getLastColourProfileBackground(username);
            
            ProfileBackground.changeColour(colour1, colour2);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfileScreen.class.getName()).log(Level.SEVERE, null, ex);
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

        profileBackground1 = new UISupport.ProfileBackground();
        jComboBox1 = new javax.swing.JComboBox<>();
        profileBackground2 = new UISupport.ProfileBackground();
        ProfileIconLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BioTextArea = new javax.swing.JTextArea();
        BioLabel = new javax.swing.JLabel();
        DisplayNameLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        JoinedLabel = new javax.swing.JLabel();
        GoBackButton = new javax.swing.JButton();

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ProfileIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/account_icon.png"))); // NOI18N

        BioTextArea.setEditable(false);
        BioTextArea.setColumns(20);
        BioTextArea.setRows(5);
        jScrollPane1.setViewportView(BioTextArea);

        BioLabel.setText("Bio:");

        DisplayNameLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        DisplayNameLabel.setText("KingKhanTheGreat");

        usernameLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        usernameLabel.setText("@AmongusFart");

        JoinedLabel.setText("Joined:");

        GoBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/left_arrow_icon.png"))); // NOI18N
        GoBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profileBackground2Layout = new javax.swing.GroupLayout(profileBackground2);
        profileBackground2.setLayout(profileBackground2Layout);
        profileBackground2Layout.setHorizontalGroup(
            profileBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileBackground2Layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addGroup(profileBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BioLabel))
                .addGap(121, 121, 121))
            .addGroup(profileBackground2Layout.createSequentialGroup()
                .addGroup(profileBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileBackground2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(GoBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198)
                        .addComponent(ProfileIconLabel))
                    .addGroup(profileBackground2Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(DisplayNameLabel)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(profileBackground2Layout.createSequentialGroup()
                .addGroup(profileBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileBackground2Layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(usernameLabel))
                    .addGroup(profileBackground2Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(JoinedLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        profileBackground2Layout.setVerticalGroup(
            profileBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileBackground2Layout.createSequentialGroup()
                .addGroup(profileBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileBackground2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(ProfileIconLabel))
                    .addGroup(profileBackground2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(GoBackButton)))
                .addGap(18, 18, 18)
                .addComponent(DisplayNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JoinedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(BioLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profileBackground2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profileBackground2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GoBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackButtonActionPerformed
        // TODO add your handling code here:
        new HomeScreen(Username).setVisible(true);
        dispose();
    }//GEN-LAST:event_GoBackButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ProfileScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfileScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BioLabel;
    private javax.swing.JTextArea BioTextArea;
    private javax.swing.JLabel DisplayNameLabel;
    private javax.swing.JButton GoBackButton;
    private javax.swing.JLabel JoinedLabel;
    private javax.swing.JLabel ProfileIconLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private UISupport.ProfileBackground profileBackground1;
    private UISupport.ProfileBackground profileBackground2;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
