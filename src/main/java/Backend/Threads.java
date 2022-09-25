/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Frontend.HomeScreen;
import java.awt.Color;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author abban
 */
public class Threads implements Runnable{
    private String purpose = "";
    
    private String Username = "";
    private String Password = "";
    private String userInput = "";
    
    private JLabel label;
    private JList list;
    private JComboBox comboBox;
    
    
    public Threads(String username,JLabel jLabel){
        purpose = "isUsernameValid";
        Username = username;
        label = jLabel;
    }
    
    public Threads(String password,String username,JLabel jLabel){
        purpose = "isPasswordSafe";
        Password = password;
        Username = username;
        label = jLabel;
    }
    
    public Threads(){
        purpose = "isAutoLoginOn";
    }
    
    public Threads(String username,String whatList,JList jList){
        Username = username;
        list = jList;
        
        if(whatList.equals("Friends")){
            
            purpose = "getFriends";
            
        }
        else{
            
            purpose = "getGroupNames";
        }
    }
    
    public Threads(String username, JComboBox jComboBox){
        Username = username;
        comboBox =  jComboBox;
        purpose = "getConnectedAccount";
    }

    public Threads(JList jList, String input, String username){
        
        purpose = "findingToSendFriendRequest";
        Username = username;
        userInput = input;
        list = jList;
        
    }
    
    public Threads(JList jList, String username){
        
        purpose = "getReceivingFriendRequest";
        Username = username;
        list = jList;
        
    }
    
    @Override
    public void run() {
        if(purpose.equals("isUsernameValid")){
            
            String result = UserManager.isUsernameValid(Username);
            
            if(result.equals("Everything looks alright")){
                label.setForeground(Color.darkGray);
            } 
            else{
                label.setForeground(Color.red);
            }
            label.setText(result);
        }
        else if(purpose.equals("isPasswordSafe")){
            
            String result = UserManager.isPasswordSafe(Password, Username);
            
            if(result.equals("Everything looks alright")){
                label.setForeground(Color.darkGray);
            } 
            else{
                label.setForeground(Color.red);
            }
            label.setText(result);
            
        }
        
        else if(purpose.equals("isAutoLoginOn")){

            try {
                
                String result = UserManager.isAutoLoginOn();
                
                if(result.isEmpty()){
                    
                }
                else{
                    new HomeScreen(result).setVisible(true);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        else if(purpose.equals("getFriends")){
            
            try {
                
                DefaultListModel DefaultListModel = new DefaultListModel();
                
                String[] result = FriendManager.getFriends(Username);
                
                for(int i = 0; i < result.length;i++){
                    
                    DefaultListModel.addElement(result[i]);
                    this.list.setModel(DefaultListModel);
                            
                }
                    
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        else if(purpose.equals("getConnectedAccount")){
            try {
                
                DefaultComboBoxModel DefaultComboBoxModel = new DefaultComboBoxModel();
                
                String[] result = UserManager.getConnectedAccount(Username);
                
                for(int i = 0; i < result.length;i++){
                    
                    DefaultComboBoxModel.addElement(result[i]);
                    this.comboBox.setModel(DefaultComboBoxModel);
                            
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(purpose.equals("findingToSendFriendRequest")){
            
            try {
                
                
                DefaultListModel DefaultListModel = FriendManager.findingToSendFriendRequest(userInput, Username);
     
                this.list.setModel(DefaultListModel);
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(purpose.equals("getReceivingFriendRequest")){
            
            while(!(list.hasFocus())){
                
            try {
                
                DefaultListModel DefaultListModel = FriendManager.getReceivingFriendRequest(Username);
                this.list.setModel(DefaultListModel);
                
            } catch (SQLException ex) {
                
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            }
        }
    }
    
}
