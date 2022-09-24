/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Frontend.HomeScreen;
import java.awt.Color;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author abban
 */
public class Threads implements Runnable{
    private String purpose = "";
    
    private String Username = "";
    private String Password = "";
    
    private JLabel label;
    
    
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

                String result = UserManager.isAutoLoginOn();
                
                if(result.isEmpty()){
                    
                }
                else{
                    
                }
            
        }
    }
    
}
