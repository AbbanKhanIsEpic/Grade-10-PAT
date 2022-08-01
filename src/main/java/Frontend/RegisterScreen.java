/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.PasswordManager;


/**
 *
 * @author abban
 */
public class RegisterScreen extends javax.swing.JFrame {

    /**
     * Creates new form RegisterScreen
     */
    String typed_password = "";
    
    public RegisterScreen() {
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

        UsernameLabel = new javax.swing.JLabel();
        UsernameTextField = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        ConfirmPasswordLabel = new javax.swing.JLabel();
        RegisterButton = new javax.swing.JButton();
        ViewPasswordToggleButton = new javax.swing.JToggleButton();
        PasswordTextField = new javax.swing.JTextField();
        ConfirmPasswordTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UsernameLabel.setText("Username");

        PasswordLabel.setText("Password:");

        ConfirmPasswordLabel.setText("Confirm password:");

        RegisterButton.setText("Register");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        ViewPasswordToggleButton.setText("Hidden");
        ViewPasswordToggleButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ViewPasswordToggleButtonItemStateChanged(evt);
            }
        });

        PasswordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PasswordTextFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ConfirmPasswordTextField)
                    .addComponent(UsernameLabel)
                    .addComponent(UsernameTextField)
                    .addComponent(PasswordLabel)
                    .addComponent(ConfirmPasswordLabel)
                    .addComponent(RegisterButton, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(PasswordTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewPasswordToggleButton)
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 382, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(UsernameLabel)
                .addGap(18, 18, 18)
                .addComponent(UsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(PasswordLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewPasswordToggleButton)
                    .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ConfirmPasswordLabel)
                .addGap(18, 18, 18)
                .addComponent(ConfirmPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RegisterButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void ViewPasswordToggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ViewPasswordToggleButtonItemStateChanged
        // TODO add your handling code here:
        int choice = evt.getStateChange(); //This declared variable get the value of the jToggle button
        
        switch(choice){ //This is a switch case which check if the user agree or disagree and change the text so the user know if they agree or not
            case 1: 
                ViewPasswordToggleButton.setText("Visible"); 
                PasswordTextField.setText(typed_password);
                
                break;
            case 2:
                ViewPasswordToggleButton.setText("Hidden");
                break;
        }
    }//GEN-LAST:event_ViewPasswordToggleButtonItemStateChanged

    private void PasswordTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordTextFieldKeyReleased
        // TODO add your handling code here:
        String selectedToggleButton = ViewPasswordToggleButton.getText();
        String userPasswordInput = PasswordTextField.getText();
        
        if(selectedToggleButton.equals("Hidden")){
                typed_password = PasswordManager.getTypedText(userPasswordInput, typed_password, selectedToggleButton);
                PasswordTextField.setText(PasswordManager.getDisplayText(typed_password,selectedToggleButton));
        }
        else{
            typed_password = userPasswordInput;
            PasswordTextField.setText(typed_password);
        }

        System.out.println(typed_password);
    }//GEN-LAST:event_PasswordTextFieldKeyReleased

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
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ConfirmPasswordLabel;
    private javax.swing.JTextField ConfirmPasswordTextField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JTextField PasswordTextField;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JTextField UsernameTextField;
    private javax.swing.JToggleButton ViewPasswordToggleButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
