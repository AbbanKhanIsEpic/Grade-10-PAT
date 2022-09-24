/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import javax.swing.JTextArea;

/**
 *
 * @author abban
 */
public class RecieveMessageManager implements Runnable {
    private JTextArea textArea;
    private String output = "";
    private String talkingToWho = "";
    private String talkingFromWho = "";
    private boolean isFriendMessage = false;

    public RecieveMessageManager(JTextArea jTextArea, String whoTo, String whoFrom,boolean friend){
        textArea = jTextArea;
        talkingToWho = whoTo;   
        isFriendMessage = friend; 
        talkingFromWho = whoTo;
    }
    
    public void run() {

        
    }
    


    
}
