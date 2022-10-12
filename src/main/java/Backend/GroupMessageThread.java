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

    private String username;
    private int groupIndex;
    private JTextArea messageTextArea;

    Thread t;

    private boolean running = true;
    //Messages

    public GroupMessageThread(String username, int groupIndex, JTextArea messageTextArea) {
        this.username = username;
        this.groupIndex = groupIndex;
        this.messageTextArea = messageTextArea;

        t = new Thread(this);
        t.start();

    }

    public void stopRunning() {
        this.running = false;

    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(50);

                String messages = MessageManager.getGroupMessages(username, groupIndex);

                messageTextArea.setText(messages);

            } catch (InterruptedException | SQLException ex) {
                Logger.getLogger(FriendMessageThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
