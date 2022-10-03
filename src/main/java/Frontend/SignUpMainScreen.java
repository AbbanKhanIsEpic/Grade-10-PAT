/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.UserManager;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abban
 */
public class SignUpMainScreen extends javax.swing.JFrame {

    /**
     * Creates new form SignUpMainScreen
     */
    public SignUpMainScreen() {
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

        signUpBackground1 = new UISupport.SignUpBackground();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UsernameTextField = new javax.swing.JTextField();
        UsernameErrorCheckerLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PasswordErrorCheckerLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ConfirmedPasswordErrorCheckerLabel = new javax.swing.JLabel();
        SignUpButton = new javax.swing.JButton();
        PasswordVisibleToggleButton = new javax.swing.JToggleButton();
        ConfirmPasswordVisibleToggleButton = new javax.swing.JToggleButton();
        FinalErrorCheckerLabel = new javax.swing.JLabel();
        passwordPasswordField = new javax.swing.JPasswordField();
        confirmPasswordPasswordField = new javax.swing.JPasswordField();
        loginBackground1 = new UISupport.LoginBackground();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Account");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username:");

        UsernameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                UsernameTextFieldKeyReleased(evt);
            }
        });

        UsernameErrorCheckerLabel.setBackground(new java.awt.Color(255, 0, 0));
        UsernameErrorCheckerLabel.setForeground(new java.awt.Color(255, 0, 0));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Password:");

        PasswordErrorCheckerLabel.setBackground(new java.awt.Color(255, 0, 0));
        PasswordErrorCheckerLabel.setForeground(new java.awt.Color(255, 0, 0));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Confirm password:");

        ConfirmedPasswordErrorCheckerLabel.setBackground(new java.awt.Color(255, 0, 0));
        ConfirmedPasswordErrorCheckerLabel.setForeground(new java.awt.Color(255, 0, 0));

        SignUpButton.setText("Sign Up");
        SignUpButton.setBorder(new javax.swing.border.MatteBorder(null));
        SignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonActionPerformed(evt);
            }
        });

        PasswordVisibleToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close_eye_icon.png"))); // NOI18N
        PasswordVisibleToggleButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PasswordVisibleToggleButtonItemStateChanged(evt);
            }
        });

        ConfirmPasswordVisibleToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close_eye_icon.png"))); // NOI18N
        ConfirmPasswordVisibleToggleButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ConfirmPasswordVisibleToggleButtonItemStateChanged(evt);
            }
        });

        FinalErrorCheckerLabel.setForeground(new java.awt.Color(255, 0, 0));

        passwordPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordPasswordFieldKeyReleased(evt);
            }
        });

        confirmPasswordPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                confirmPasswordPasswordFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout signUpBackground1Layout = new javax.swing.GroupLayout(signUpBackground1);
        signUpBackground1.setLayout(signUpBackground1Layout);
        signUpBackground1Layout.setHorizontalGroup(
            signUpBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signUpBackground1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(signUpBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FinalErrorCheckerLabel)
                    .addGroup(signUpBackground1Layout.createSequentialGroup()
                        .addGroup(signUpBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ConfirmedPasswordErrorCheckerLabel)
                            .addComponent(jLabel11)
                            .addComponent(PasswordErrorCheckerLabel)
                            .addComponent(jLabel9)
                            .addComponent(UsernameErrorCheckerLabel)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UsernameTextField)
                            .addComponent(SignUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordPasswordField)
                            .addComponent(confirmPasswordPasswordField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(signUpBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ConfirmPasswordVisibleToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordVisibleToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        signUpBackground1Layout.setVerticalGroup(
            signUpBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signUpBackground1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(UsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UsernameErrorCheckerLabel)
                .addGap(35, 35, 35)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(signUpBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PasswordVisibleToggleButton)
                    .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(PasswordErrorCheckerLabel)
                .addGap(29, 29, 29)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(signUpBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConfirmPasswordVisibleToggleButton)
                    .addComponent(confirmPasswordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(ConfirmedPasswordErrorCheckerLabel)
                .addGap(23, 23, 23)
                .addComponent(SignUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FinalErrorCheckerLabel)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Have an account?");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("That is not a problem. ");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Click the 'Login' button to login and continue chatting!");

        LoginButton.setText("Login");
        LoginButton.setBorder(new javax.swing.border.MatteBorder(null));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginBackground1Layout = new javax.swing.GroupLayout(loginBackground1);
        loginBackground1.setLayout(loginBackground1Layout);
        loginBackground1Layout.setHorizontalGroup(
            loginBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginBackground1Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addGroup(loginBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LoginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(62, 62, 62))
        );
        loginBackground1Layout.setVerticalGroup(
            loginBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginBackground1Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(37, 37, 37)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(signUpBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signUpBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(loginBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButtonActionPerformed
        // TODO add your handling code here:
        String usernameLabelColour = UsernameErrorCheckerLabel.getForeground().toString();
        String passwordLabelColour = PasswordErrorCheckerLabel.getForeground().toString();
        String confirmedPasswordLabelColour = ConfirmedPasswordErrorCheckerLabel.getForeground().toString();
        
        String username = UsernameTextField.getText();
        String password = passwordPasswordField.getText();
        
        if(usernameLabelColour.equals("java.awt.Color[r=64,g=64,b=64]")&&passwordLabelColour.equals("java.awt.Color[r=64,g=64,b=64]")&&confirmedPasswordLabelColour.equals("java.awt.Color[r=64,g=64,b=64]")){
            try {
                UserManager.createAccount(username, password);
            } catch (SQLException ex) {
                Logger.getLogger(SignUpMainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            new HomeScreen(username).setVisible(true);
            dispose();
        }
        else{
            FinalErrorCheckerLabel.setText("There is an error");
        }
        
    }//GEN-LAST:event_SignUpButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        new LoginMainScreen().setVisible(true);
        dispose();
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void PasswordVisibleToggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PasswordVisibleToggleButtonItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == 1){
            PasswordVisibleToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/open_eye.png")));
            passwordPasswordField.setEchoChar((char)0);
        }
        else{
            PasswordVisibleToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close_eye_icon.png")));
            passwordPasswordField.setEchoChar('*');
        }
        
        
    }//GEN-LAST:event_PasswordVisibleToggleButtonItemStateChanged

    private void ConfirmPasswordVisibleToggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ConfirmPasswordVisibleToggleButtonItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == 1){
            ConfirmPasswordVisibleToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/open_eye.png")));
            confirmPasswordPasswordField.setEchoChar((char)0);
        }
        else{
            ConfirmPasswordVisibleToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close_eye_icon.png")));
            confirmPasswordPasswordField.setEchoChar('*');
            
            
        }
    }//GEN-LAST:event_ConfirmPasswordVisibleToggleButtonItemStateChanged

    private void confirmPasswordPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmPasswordPasswordFieldKeyReleased
        // TODO add your handling code here:
        if(confirmPasswordPasswordField.getText().equals(passwordPasswordField.getText())){
            ConfirmedPasswordErrorCheckerLabel.setForeground(Color.darkGray);
            ConfirmedPasswordErrorCheckerLabel.setText("Everything looks alright");
        }
        else{
            ConfirmedPasswordErrorCheckerLabel.setForeground(Color.red);
            ConfirmedPasswordErrorCheckerLabel.setText("Passwords must be the same");

        }
    }//GEN-LAST:event_confirmPasswordPasswordFieldKeyReleased

    private void passwordPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordPasswordFieldKeyReleased
        // TODO add your handling code here:
        String result = UserManager.isPasswordSafe(passwordPasswordField.getText(), UsernameTextField.getText());
        
        if(result.equals("Everything looks alright")){
                PasswordErrorCheckerLabel.setForeground(Color.darkGray);
            } 
            else{
                PasswordErrorCheckerLabel.setForeground(Color.red);
            }
            PasswordErrorCheckerLabel.setText(result);
    }//GEN-LAST:event_passwordPasswordFieldKeyReleased

    private void UsernameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsernameTextFieldKeyReleased
        // TODO add your handling code here:
        String result = UserManager.isUsernameValid(UsernameTextField.getText());
        
         if(result.equals("Everything looks alright")){
                UsernameErrorCheckerLabel.setForeground(Color.darkGray);
            } 
            else{
                UsernameErrorCheckerLabel.setForeground(Color.red);
            }
            UsernameErrorCheckerLabel.setText(result);
    }//GEN-LAST:event_UsernameTextFieldKeyReleased

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
            java.util.logging.Logger.getLogger(SignUpMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpMainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ConfirmPasswordVisibleToggleButton;
    private javax.swing.JLabel ConfirmedPasswordErrorCheckerLabel;
    private javax.swing.JLabel FinalErrorCheckerLabel;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel PasswordErrorCheckerLabel;
    private javax.swing.JToggleButton PasswordVisibleToggleButton;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JLabel UsernameErrorCheckerLabel;
    private javax.swing.JTextField UsernameTextField;
    private javax.swing.JPasswordField confirmPasswordPasswordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private UISupport.LoginBackground loginBackground1;
    private javax.swing.JPasswordField passwordPasswordField;
    private UISupport.SignUpBackground signUpBackground1;
    // End of variables declaration//GEN-END:variables
}
