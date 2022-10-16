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
public class FriendMessageThread implements Runnable {

    //This is a thread that will get friend Messages
    
    private String username;
    private String friend;
    private JTextArea messageTextArea;

    Thread friendMessageThread;

    private boolean running = true;

    public FriendMessageThread(String username, String friend, JTextArea messageTextArea) {
        this.username = username;
        this.friend = friend;
        this.messageTextArea = messageTextArea;

        friendMessageThread = new Thread(this);
        friendMessageThread.start();

    }

    //Stop the tread
    public void stopRunning() {
        this.running = false;

    }

    @Override
    public void run() {
        //Check if the thread stopped
        //Reason for this so the jTextArea will not look glitched 
        while (running) {
            try {
                //Cooldown because do not want jTextArea to look weird
                Thread.sleep(50);

                //Get all friend message 
                String friendMessages = MessageManager.getFriendMessages(username, friend);

                //Set the JTextArea text to the message
                messageTextArea.setText(friendMessages);
                
            } catch (InterruptedException | SQLException ex) {
                Logger.getLogger(FriendMessageThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
