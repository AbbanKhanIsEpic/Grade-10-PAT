/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;

/**
 *
 * @author abban
 */
public class SendFriendManager implements Runnable{
    private String friend = "";
    private JList list;

    public SendFriendManager(JList jList, String search){
        list = jList;
        friend = search;
    }
   
    public void run() {

        
        
    
    }
    
}
