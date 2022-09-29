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
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

/**
 *
 * @author abban
 */
public class Threads implements Runnable{
    
    private String purpose = "";
    private String Username = "";
    private String Password = "";
    private String userInput = "";
    private String MessageFrom = "";
    private String MessageTo1= "";
    private String sendMessage = "";
    private String previousMessage = "";
    private String groupMember1 = "";
    private String groupMember2 = "";
    private String groupMember3 = "";
    private String groupMember4 = "";
    private String groupMember5 = "";

    
    private JLabel label;
    private JList list;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JTextArea textArea;
    private JToggleButton toggleButton;
    
    
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
        
        else if(whatList.equals("Groups")){
            
            purpose = "getGroupNames";
        }
    }
    
    public Threads(String username, JComboBox jComboBox){
        Username = username;
        comboBox1 =  jComboBox;
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
    
    public Threads(JTextArea jTextArea, String from, String to, String Message1,String Message2,boolean friend){
        
        
        textArea = jTextArea;
        MessageFrom = from;
        MessageTo1 = to;
        sendMessage = Message1; 
        previousMessage = Message2;
        if(friend){
            purpose = "sendFriendMessage";
        }
        else{
            purpose = "sendGroupMessage";
        }
    }
    
    public Threads(JTextArea jTextArea, String from, String to,JToggleButton jToggleButton){
        
        MessageFrom = from;
        MessageTo1 = to;
        textArea = jTextArea;
        toggleButton = jToggleButton;
            
        if(toggleButton.getText().equals("Friends")){
            
            purpose = "getFriendMessages";
            
            
        }
        else{
            
            purpose = "getGroupMessages";
            
        }
        
    }
    
    public Threads(JToggleButton jToggleButton, String previousSelectedItem,JList jList,String username){
        
        toggleButton = jToggleButton;
        list = jList;
        Username = username;
        
        if(previousSelectedItem.equals("Friends")){
            
            purpose = "setToggleButtonToGroup";
            
        }
        else{
            
            purpose = "setToggleButtonToFriend";
            
        }
        
    }
    
    public Threads(String username, JComboBox jComboBox1,JComboBox jComboBox2,JComboBox jComboBox3,JComboBox jComboBox4,JComboBox jComboBox5,JList jList){
        
        purpose = "setAddGroupScreen";
        Username = username;
        comboBox1 = jComboBox1;
        comboBox2 = jComboBox2;
        comboBox3 = jComboBox3;
        comboBox4 = jComboBox4;
        comboBox5 = jComboBox5;
        list = jList;
        
    }
    
    public Threads(String username,String groupName,String member1,String member2,String member3,String member4,String member5,JLabel jLabel){
        
        purpose = "createGroup";
        Username = username;
        userInput = groupName;
        groupMember1 = member1;
        groupMember2 = member2;
        groupMember3 = member3;
        groupMember4 = member4;
        groupMember5 = member5;
        label = jLabel;
        
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
                        
                String[] listOfFriends = FriendManager.getFriends(Username);
                
                for(int i = 0; i < listOfFriends.length; i++){
                    
                    DefaultListModel.addElement(listOfFriends[i]);
                    list.setModel(DefaultListModel);
                    
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
                    this.comboBox1.setModel(DefaultComboBoxModel);
                            
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
            
            try {
                
                DefaultListModel DefaultListModel = FriendManager.getReceivingFriendRequest(Username);
                this.list.setModel(DefaultListModel);
                
            } catch (SQLException ex) {
                
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            }
        
        else if(purpose.equals("sendFriendMessage")){
            
                
                try {
                    
                    String result = MessageManager.sendFriendMessage(MessageFrom, MessageTo1, sendMessage,previousMessage);
                    
                    textArea.setText(result);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        
        else if(purpose.equals("getFriendMessages")){
            
            String result = "";
            try {
                
                result = MessageManager.getFriendMessages(MessageFrom, MessageTo1);
                textArea.setText(result);
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            while(new HomeScreen().isShowing() && toggleButton.getText().equals("Friends")){
                                    
                    String display = textArea.getText();
                    try {
                        
                        result = MessageManager.getFriendMessages(MessageFrom, MessageTo1);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(!(display.equals(result))){
                        
                        textArea.setText(result);
                        
                    }

            }
            
            
        }
        
        else if(purpose.equals("getGroupNames")){
            
            try {
                
                DefaultListModel DefaultListModel = GroupManager.getGroups(Username);

                list.setModel(DefaultListModel);
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        else if(purpose.equals("setToggleButtonToGroup")){
            
            toggleButton.setText("Groups");
            toggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/group_icon.png")));
            toggleButton.setSelected(false);
            
           Runnable getGroupName = new Threads(Username,"Groups",list);
            
            Thread thread = new Thread(getGroupName);
        
            thread.start();
            
        }
        
        else if(purpose.equals("setToggleButtonToFriend")){
            
            toggleButton.setText("Friends");
            toggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/friend_icon.png")));
            toggleButton.setSelected(false);
            
            Runnable getFriendName = new Threads(Username,"Friends",list);
            
            Thread thread = new Thread(getFriendName);
        
            thread.start();
            
            
            
        }
        
        else if(purpose.equals("createGroup")){
            
            int count = 0;
            
            if(groupMember2.equals("No-one")){
                
                count++;
                
            }
            if(groupMember3.equals("No-one")){
                
                count++;
                
            }
            if(groupMember4.equals("No-one")){
                
                count++;
                
            }
            if(groupMember5.equals("No-one")){
                
                count++;
                
            }
            
            if(count >= 3){
                
                label.setForeground(Color.red);
                label.setText("A group needs a min of 3 member");
                
            }
            else{
               
                boolean result = GroupManager.areMembersDifferent(groupMember2,groupMember3,groupMember4,groupMember5);
                
                if(result){
                    
                    try {

                        result = GroupManager.isGroupNameUnique(userInput, Username);
                        
                        if(result){
                            
                            if(userInput.isEmpty()){
                                
                             label.setForeground(Color.red);
                             label.setText("Group name can't be blank");
                                
                            }
                            else{
                                
                                if(userInput.length() > 200){
                                    
                                    label.setForeground(Color.red);
                                    label.setText("Group name too long");
                                    
                                }
                                else{
                                    
                                    label.setForeground(Color.GREEN);
                                    label.setText("Group created");
                                    GroupManager.createGroup(userInput,groupMember1,groupMember2,groupMember3,groupMember4,groupMember5);
                                   
                                    
                                }
                            
                            }
                            
                        }
                        else{
                            
                            label.setForeground(Color.red);
                            label.setText("This group name exits");
                            
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                
                }
                else{
                    
                    label.setForeground(Color.red);
                    label.setText("Group member has to be different");
                    
                }
                
            }
        }
        
        else if(purpose.equals("setAddGroupScreen")){
 
            try {
                DefaultComboBoxModel DefaultComboBoxModel1 = new DefaultComboBoxModel();
                DefaultComboBoxModel DefaultComboBoxModel2 = new DefaultComboBoxModel();
                DefaultComboBoxModel DefaultComboBoxModel3 = new DefaultComboBoxModel();
                DefaultComboBoxModel DefaultComboBoxModel4 = new DefaultComboBoxModel();
                DefaultComboBoxModel DefaultComboBoxModel5 = new DefaultComboBoxModel();
                
                DefaultComboBoxModel1.addElement(Username);
                
                comboBox1.setModel(DefaultComboBoxModel1);

                DefaultComboBoxModel2.addElement("No-one");
                DefaultComboBoxModel3.addElement("No-one");
                DefaultComboBoxModel4.addElement("No-one");
                DefaultComboBoxModel5.addElement("No-one");
                
                String[] listOfFriends = FriendManager.getFriends(Username);
                
                for(int i = 0; i < listOfFriends.length; i++){
                    
                    DefaultComboBoxModel2.addElement(listOfFriends[i]);
                    DefaultComboBoxModel3.addElement(listOfFriends[i]);
                    DefaultComboBoxModel4.addElement(listOfFriends[i]);
                    DefaultComboBoxModel5.addElement(listOfFriends[i]);

                } 
                
                comboBox2.setModel(DefaultComboBoxModel2);
                comboBox3.setModel(DefaultComboBoxModel3);
                comboBox4.setModel(DefaultComboBoxModel4);
                comboBox5.setModel(DefaultComboBoxModel5);
            
                DefaultListModel DefaultListModel = GroupManager.getGroups(Username);

                list.setModel(DefaultListModel);
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        else if(purpose.equals("getGroupMessages")){
            String result = "";
            try {
                
                result = MessageManager.getGroupMessages(MessageFrom, MessageTo1);
                textArea.setText(result);
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }

            while(new HomeScreen().isShowing() && toggleButton.getText().equals("Groups")){
                                    
                    String display = textArea.getText();
                    try {
                        
                        result = MessageManager.getGroupMessages(MessageFrom, MessageTo1);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(!(display.equals(result))){
                        
                        textArea.setText(result);
                        
                    }

            }
            
            
        }
        
        else if(purpose.equals("sendGroupMessage")){
            
            try {
                
                String text = MessageManager.sendGroupMessages(MessageFrom, MessageTo1, sendMessage,previousMessage);
                textArea.setText(text);
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
}