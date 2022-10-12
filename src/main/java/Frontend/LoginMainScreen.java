/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.UserManager;
import Backend.BackgroundManager;
import Backend.DB;
import Backgrounds.SideMenuBackground;
import Backgrounds.TextingBackground;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abban
 */
public class LoginMainScreen extends javax.swing.JFrame {

    /**
     * Creates new form LoginMainScreeb
     */
    private int usage = 0;

    private String username = "";

    public LoginMainScreen() {

        initComponents();

        try {

            DB.createConnection();

        } catch (SQLException ex) {
            Logger.getLogger(LoginMainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public LoginMainScreen(int usage, String username) {
        initComponents();

        this.usage = usage;
        this.username = username;

        try {

            DB.createConnection();

        } catch (SQLException ex) {
            Logger.getLogger(LoginMainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //if int usage = 0; means that the user is logining to the home screen
    //if int usage = 1; means that the user is adding an account

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginBackground1 = new Backgrounds.LoginBackground();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        UsernameTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        FinalErrorCheckerLabel = new javax.swing.JLabel();
        PasswordVisibleToggleButton = new javax.swing.JToggleButton();
        passwordPasswordField = new javax.swing.JPasswordField();
        signUpScreen1 = new Backgrounds.SignUpBackground();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        SignUpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome ");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("back");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username:");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password:");

        LoginButton.setText("Login");
        LoginButton.setBorder(new javax.swing.border.MatteBorder(null));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        FinalErrorCheckerLabel.setBackground(new java.awt.Color(255, 0, 0));
        FinalErrorCheckerLabel.setForeground(new java.awt.Color(255, 0, 0));

        PasswordVisibleToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close_eye_icon.png"))); // NOI18N
        PasswordVisibleToggleButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PasswordVisibleToggleButtonItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout loginBackground1Layout = new javax.swing.GroupLayout(loginBackground1);
        loginBackground1.setLayout(loginBackground1Layout);
        loginBackground1Layout.setHorizontalGroup(
            loginBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginBackground1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(loginBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FinalErrorCheckerLabel)
                    .addGroup(loginBackground1Layout.createSequentialGroup()
                        .addGroup(loginBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(UsernameTextField)
                            .addComponent(LoginButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(passwordPasswordField))
                        .addGap(18, 18, 18)
                        .addComponent(PasswordVisibleToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        loginBackground1Layout.setVerticalGroup(
            loginBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginBackground1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(54, 54, 54)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(UsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(loginBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(loginBackground1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PasswordVisibleToggleButton))
                .addGap(42, 42, 42)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FinalErrorCheckerLabel)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("New here?");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("That is not a problem.");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Click the 'Sign Up' button");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("and sign up and start chatting");

        SignUpButton.setText("Sign Up");
        SignUpButton.setBorder(new javax.swing.border.MatteBorder(null));
        SignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout signUpScreen1Layout = new javax.swing.GroupLayout(signUpScreen1);
        signUpScreen1.setLayout(signUpScreen1Layout);
        signUpScreen1Layout.setHorizontalGroup(
            signUpScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signUpScreen1Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(signUpScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(SignUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );
        signUpScreen1Layout.setVerticalGroup(
            signUpScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signUpScreen1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(34, 34, 34)
                .addComponent(SignUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loginBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signUpScreen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(signUpScreen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButtonActionPerformed
        // TODO add your handling code here:
        new SignUpMainScreen().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_SignUpButtonActionPerformed

    private void PasswordVisibleToggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PasswordVisibleToggleButtonItemStateChanged
        // This code change the visuial of the toggle button
        if (evt.getStateChange() == 1) {

            PasswordVisibleToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/open_eye.png")));
            passwordPasswordField.setEchoChar((char) 0);

        } else {

            PasswordVisibleToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close_eye_icon.png")));
            passwordPasswordField.setEchoChar('*');

        }

    }//GEN-LAST:event_PasswordVisibleToggleButtonItemStateChanged

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        String inputUsername = UsernameTextField.getText();
        String password = passwordPasswordField.getText();

        try {

            boolean result = UserManager.isLoginValid(inputUsername, password);

            if (result && usage == 0) {

                String colour1 = BackgroundManager.getFirstColourSideMenuBackground(inputUsername);

                String colour2 = BackgroundManager.getLastColourSideMenuBackground(inputUsername);

                SideMenuBackground.setSideMenuBackground(colour1, colour2);

                colour1 = BackgroundManager.getFirstColourTextingBackground(inputUsername);

                colour2 = BackgroundManager.getLastColourTextingBackground(inputUsername);

                TextingBackground.setTextingScreenBackground(colour1, colour2);

                new HomeScreen(inputUsername).setVisible(true);

                dispose();

            } else if (result && usage == 1 && !(UserManager.isAccountConnected(username, inputUsername))) {

                UserManager.addConnectedAccount(username, inputUsername);

                new SettingScreen(username, "Account added successful").setVisible(true);

                dispose();

            } else if (usage == 1) {

                new SettingScreen(username, "Account added failed").setVisible(true);

                dispose();

            } else {

                FinalErrorCheckerLabel.setText("Username or password is incorrect");

            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginMainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginMainScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FinalErrorCheckerLabel;
    private javax.swing.JButton LoginButton;
    private javax.swing.JToggleButton PasswordVisibleToggleButton;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JTextField UsernameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private Backgrounds.LoginBackground loginBackground1;
    private javax.swing.JPasswordField passwordPasswordField;
    private Backgrounds.SignUpBackground signUpScreen1;
    // End of variables declaration//GEN-END:variables
}
