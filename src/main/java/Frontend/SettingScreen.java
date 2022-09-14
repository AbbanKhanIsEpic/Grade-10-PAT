/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

/**
 *
 * @author abban
 */
public class SettingScreen extends javax.swing.JFrame {

    /**
     * Creates new form SettingScreen
     */
    public SettingScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settingPanel1 = new UISupport.SettingBackground();
        returnButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SettingLabel = new javax.swing.JLabel();
        HelpLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        openAccountButton = new javax.swing.JButton();
        openDisplayButton = new javax.swing.JButton();
        openHelpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        returnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/left_arrow_icon.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/account_small_icon.png"))); // NOI18N
        jLabel1.setText("Account:");

        SettingLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        SettingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Setting_icon.png"))); // NOI18N
        SettingLabel.setText("Setting");

        HelpLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        HelpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/House_icon.png"))); // NOI18N
        HelpLabel.setText("      Help:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/open_eye.png"))); // NOI18N
        jLabel2.setText("Display:");

        openAccountButton.setText(">");
        openAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAccountButtonActionPerformed(evt);
            }
        });

        openDisplayButton.setText(">");
        openDisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDisplayButtonActionPerformed(evt);
            }
        });

        openHelpButton.setText(">");

        javax.swing.GroupLayout settingPanel1Layout = new javax.swing.GroupLayout(settingPanel1);
        settingPanel1.setLayout(settingPanel1Layout);
        settingPanel1Layout.setHorizontalGroup(
            settingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingPanel1Layout.createSequentialGroup()
                .addGroup(settingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(settingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(settingPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(HelpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(137, 137, 137)
                        .addGroup(settingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(openHelpButton)
                            .addComponent(openAccountButton)
                            .addComponent(openDisplayButton)))
                    .addGroup(settingPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197)
                        .addComponent(SettingLabel)))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        settingPanel1Layout.setVerticalGroup(
            settingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(returnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SettingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addGroup(settingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(openAccountButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(settingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(openDisplayButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(settingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HelpLabel)
                    .addComponent(openHelpButton))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(settingPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settingPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAccountButtonActionPerformed
        // TODO add your handling code here:
        new ProfileScreen(false).setVisible(true);
    }//GEN-LAST:event_openAccountButtonActionPerformed

    private void openDisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openDisplayButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openDisplayButtonActionPerformed

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
    private javax.swing.JLabel HelpLabel;
    private javax.swing.JLabel SettingLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton openAccountButton;
    private javax.swing.JButton openDisplayButton;
    private javax.swing.JButton openHelpButton;
    private javax.swing.JButton returnButton;
    private UISupport.SettingBackground settingPanel1;
    // End of variables declaration//GEN-END:variables
}
