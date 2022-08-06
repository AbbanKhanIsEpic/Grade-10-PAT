/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.TextManager;
import java.awt.Font;


/**
 *
 * @author abban
 */
public class RegisterScreen extends javax.swing.JFrame {

    /**
     * Creates new form RegisterScreen
     */
    String typed_password = "";
    String confirm_typed_password = "";
    
    public RegisterScreen() {
        initComponents();
        RegisterLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
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
        ViewConfirmPasswordToggleButton = new javax.swing.JToggleButton();
        CheckingConfirmedPasswordLabel = new javax.swing.JLabel();
        CheckingPasswordLabel = new javax.swing.JLabel();
        CheckingUsernameLabel = new javax.swing.JLabel();
        RegisterLabel = new javax.swing.JLabel();
        ToContinueLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UsernameLabel.setText("Username:");

        UsernameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                UsernameTextFieldKeyReleased(evt);
            }
        });

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

        ConfirmPasswordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ConfirmPasswordTextFieldKeyReleased(evt);
            }
        });

        ViewConfirmPasswordToggleButton.setText("Hidden");
        ViewConfirmPasswordToggleButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ViewConfirmPasswordToggleButtonItemStateChanged(evt);
            }
        });

        RegisterLabel.setText("Register");

        ToContinueLabel.setText("to continue");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CheckingPasswordLabel)
                            .addComponent(CheckingUsernameLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CheckingConfirmedPasswordLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(RegisterButton, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                        .addComponent(ConfirmPasswordTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                        .addComponent(ConfirmPasswordLabel)
                                        .addComponent(PasswordLabel)
                                        .addComponent(ToContinueLabel)
                                        .addComponent(RegisterLabel)
                                        .addComponent(UsernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                        .addComponent(UsernameLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ViewConfirmPasswordToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ViewPasswordToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(230, 230, 230))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(RegisterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ToContinueLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UsernameLabel)
                .addGap(18, 18, 18)
                .addComponent(UsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckingUsernameLabel)
                .addGap(30, 30, 30)
                .addComponent(PasswordLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewPasswordToggleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckingPasswordLabel)
                .addGap(31, 31, 31)
                .addComponent(ConfirmPasswordLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewConfirmPasswordToggleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckingConfirmedPasswordLabel)
                .addGap(31, 31, 31)
                .addComponent(RegisterButton)
                .addGap(60, 60, 60))
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
                typed_password = TextManager.getTypedText(userPasswordInput, typed_password, selectedToggleButton);
                PasswordTextField.setText(TextManager.getDisplayText(typed_password,selectedToggleButton));
        }
        else{
            typed_password = userPasswordInput;
            PasswordTextField.setText(typed_password);
        }
        
        CheckingPasswordLabel.setText(TextManager.isLegal(typed_password));
        
    }//GEN-LAST:event_PasswordTextFieldKeyReleased

    private void ViewConfirmPasswordToggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ViewConfirmPasswordToggleButtonItemStateChanged
        // TODO add your handling code here:
        // TODO add your handling code here:
        int choice = evt.getStateChange(); //This declared variable get the value of the jToggle button
        
        switch(choice){ //This is a switch case which check if the user agree or disagree and change the text so the user know if they agree or not
            case 1: 
                ViewConfirmPasswordToggleButton.setText("Visible"); 
                ConfirmPasswordTextField.setText(confirm_typed_password);
                
                break;
            case 2:
                ViewConfirmPasswordToggleButton.setText("Hidden");
                break;
        }
    }//GEN-LAST:event_ViewConfirmPasswordToggleButtonItemStateChanged

    private void ConfirmPasswordTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConfirmPasswordTextFieldKeyReleased
        // TODO add your handling code here:
        String selectedToggleButton = ViewConfirmPasswordToggleButton.getText();
        String userConfirmPasswordInput = ConfirmPasswordTextField.getText();
        String userPasswordInput = PasswordTextField.getText();
        
        if(selectedToggleButton.equals("Hidden")){
                confirm_typed_password = TextManager.getTypedText(userConfirmPasswordInput, confirm_typed_password, selectedToggleButton);
                ConfirmPasswordTextField.setText(TextManager.getDisplayText(confirm_typed_password,selectedToggleButton));
        }
        else{
            confirm_typed_password = userConfirmPasswordInput;
            ConfirmPasswordTextField.setText(confirm_typed_password);
        }
        
        CheckingConfirmedPasswordLabel.setText(TextManager.isEqual(confirm_typed_password, typed_password));
    }//GEN-LAST:event_ConfirmPasswordTextFieldKeyReleased

    private void UsernameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsernameTextFieldKeyReleased
        // TODO add your handling code here:
        String entered_username = UsernameTextField.getText();
        int[] list = {58,59,60,61,62,63,64,91,92,93,94,95,96};
        boolean case_closed = TextManager.isLegal(entered_username, 48, 122,list);
        boolean range = TextManager.isBetweenLength(entered_username, 3, 50);
        CheckingUsernameLabel.setText(TextManager.getResultUsername(case_closed,range));
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
    private javax.swing.JLabel CheckingConfirmedPasswordLabel;
    private javax.swing.JLabel CheckingPasswordLabel;
    private javax.swing.JLabel CheckingUsernameLabel;
    private javax.swing.JLabel ConfirmPasswordLabel;
    private javax.swing.JTextField ConfirmPasswordTextField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JTextField PasswordTextField;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel RegisterLabel;
    private javax.swing.JLabel ToContinueLabel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JTextField UsernameTextField;
    private javax.swing.JToggleButton ViewConfirmPasswordToggleButton;
    private javax.swing.JToggleButton ViewPasswordToggleButton;
    // End of variables declaration//GEN-END:variables
}
