/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author abban
 */
public class GroupMessageThread implements Runnable {
    
    //This is a thread that will get group  Messages
    
    private String username;
    private int groupIndex;
    private JTextArea messageTextArea;

    Thread t;

    private boolean running = true;
    

    public GroupMessageThread(String username, int groupIndex, JTextArea messageTextArea) {
        this.username = username;
        this.groupIndex = groupIndex;
        this.messageTextArea = messageTextArea;

        t = new Thread(this);
        t.start();

    }

    //Stop the tread
    public void stopRunning() {
        this.running = false;

    }

    @Override
    public void run()  {
        //Check if the thread stopped
        //Reason for this so the jTextArea will not look glitched 
        while (running) {
            try {
                 //Cooldown because do not want jTextArea to look weird
                Thread.sleep(50);

                //Get all group message
                String messages = MessageManager.getGroupMessages(username, groupIndex);
                
               //Set the JTextArea text to the message
                messageTextArea.setText(messages);

            } catch (InterruptedException | SQLException ex) {
                Logger.getLogger(FriendMessageThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
