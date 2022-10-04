/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Frontend.AddFriendScreen;
import Frontend.HomeScreen;
import Frontend.LoginMainScreen;
import java.awt.Color;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
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
    private JButton button;
    
    
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
    
    
    public Threads(String username,String whatList,JList jList,boolean onlyDisplayName){
        Username = username;
        list = jList;
        
        
        if(whatList.equals("Friends")){
            
            if(onlyDisplayName){
                
                purpose = "getFriendsOnlyDisplay";
                
            }
            else{
                
                purpose = "getFriendsWithDisplay";
                
            }
            
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
    
    public Threads(String from, String to, String Message1,String Message2,boolean friend){
        
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
    
    public Threads(JTextArea jTextArea,String from, String to,JToggleButton jToggleButton,JList jList){
        
        MessageFrom = from;
        MessageTo1 = to;
        textArea = jTextArea;
        toggleButton = jToggleButton;
        list = jList;
            
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
        groupMember1 = (String) jComboBox1.getSelectedItem();
        groupMember2 = (String) jComboBox2.getSelectedItem();
        groupMember3 = (String) jComboBox3.getSelectedItem();
        groupMember4 = (String) jComboBox4.getSelectedItem();
        groupMember5 = (String) jComboBox5.getSelectedItem();
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
    
    public Threads(String selectedGroupName,JList jList,String user){
        
        list = jList;
        userInput = selectedGroupName;
        purpose = "ShowMemberOfGroup";
        Username = user;
        
    }
    public Threads(String username,String to,boolean friend,boolean block,JButton jButton){
        
        Username = username;
        userInput = to;
        button = jButton;
        
        if(block){
            
            if(friend){
            
                purpose = "BlockFriend";
            
            }
           else{
            
                purpose = "BlockGroup";
            
            }
            
        }
        else{
            
             if(friend){
            
                purpose = "unblockFriend";
            
            }
           else{
            
                purpose = "unblockGroup";
            
            }
            
        }
        
    }
    
    public Threads(String username,String to,JButton jButton,boolean friend){
        
        Username = username;
        userInput = to;
        button = jButton;
        
        if(friend){
            
            purpose = "IsFriendBlock";
            
        }
        else{
            
            purpose = "IsGroupBlock";
            
        }
        
    }
    public Threads(JLabel jLabel,String displayName){
        
        label = jLabel;
        userInput = displayName;
        purpose = "isDisplayNameValid";
                
        
    }
    
    public Threads(String username, String addAccount){
        
        purpose = "AddConnectedAccount";
        Username = username;
        userInput = addAccount;
        
    }
    
    public Threads(String username, String groupName,boolean friend){
        //friend is there to keep it from error
        
        Username = username;
        userInput = groupName;
                    
        purpose = "deleteGroup";
        
    }

    public Threads() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        
        else if(purpose.equals("getFriendsOnlyDisplay")){
            
            try {
                
                DefaultListModel DefaultListModel = new DefaultListModel();
                        
                String[] listOfFriends = FriendManager.getFriends(Username);
                
                for(int i = 0; i < listOfFriends.length; i++){
                    
                    String displayName = UserManager.getDisplayName(listOfFriends[i]);
                    DefaultListModel.addElement(displayName);
                    
                }
                if(listOfFriends != null && listOfFriends.length > 0){
                    
                    list.setModel(DefaultListModel);
                    
                }
                else{
                    
                    DefaultListModel.clear();
                    list.setModel(DefaultListModel);
                    
                }
                    
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        
        else if(purpose.equals("getFriendsWithDisplay")){
            
            try {
                
                DefaultListModel DefaultListModel = new DefaultListModel();
                        
                String[] listOfFriends = FriendManager.getFriends(Username);
                
                for(int i = 0; i < listOfFriends.length; i++){
                    
                    String username = listOfFriends[i];
                    
                    String displayName = UserManager.getDisplayName(username);
                    
                    username = username + "(" + displayName + ")";
                    
                    DefaultListModel.addElement(username);
                    
                }
                if(listOfFriends != null && listOfFriends.length > 0){
                    
                    list.setModel(DefaultListModel);
                    
                }
                else{
                    
                    DefaultListModel.clear();
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
                
                
                DefaultListModel DefaultListModel = FriendManager.findPeople(userInput, Username);
     
                this.list.setModel(DefaultListModel);
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(purpose.equals("getReceivingFriendRequest")){
            
                
            try {
                
                DefaultListModel DefaultListModel = FriendManager.getFriendRequestList(Username);
                this.list.setModel(DefaultListModel);
                
            } catch (SQLException ex) {
                
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            
        }
        
        else if(purpose.equals("sendFriendMessage")){
            
                
                try {
                    
                    MessageManager.sendFriendMessage(MessageFrom, MessageTo1, sendMessage);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        
        else if(purpose.equals("getFriendMessages")){
            
            if(MessageTo1 != null){
                
            try {
                
                String result = MessageManager.getFriendMessages(MessageFrom, MessageTo1);
                textArea.setText(result);
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            while(new HomeScreen().isDisplayable()&& toggleButton.getText().equals("Friends")){
                                    
                    String display = textArea.getText();
                    try {
                        
                        String result = MessageManager.getFriendMessages(MessageFrom, MessageTo1);
                        
                        if(!(display.equals(result))){
                        
                        textArea.setText(result);
                        
                        }
                         
                         
                    } catch (SQLException ex) {
                        Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                   

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
            
           Runnable getGroupName = new Threads(Username,"Groups",list,false);
            
            Thread thread = new Thread(getGroupName);
        
            thread.start();
            
        }
        
        else if(purpose.equals("setToggleButtonToFriend")){
            
            toggleButton.setText("Friends");
            toggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/friend_icon.png")));
            toggleButton.setSelected(false);
            
            Runnable getFriendName = new Threads(Username,"Friends",list,true);
            
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
               
                boolean result = GroupManager.areMembersDifferent(groupMember1,groupMember2,groupMember3,groupMember4,groupMember5);
                
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
                
                comboBox1.setModel(DefaultComboBoxModel1);
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
            if(MessageTo1 != null){
                
            try {
                
                String result = MessageManager.getGroupMessages(MessageFrom, MessageTo1);
                textArea.setText(result);
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            

            while(new HomeScreen().isDisplayable() && list.getSelectedValue().toString().equals(MessageTo1) && toggleButton.getText().equals("Groups")){
                                    
                    String display = textArea.getText();
                    try {
                        
                        String result = MessageManager.getGroupMessages(MessageFrom, MessageTo1);
                        
                         if(!(display.equals(result))){
                        
                        textArea.setText(result);
                        
                        }
                         
                         
                    } catch (SQLException ex) {
                        Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                   

            }
            
            
        }
        }
        
        else if(purpose.equals("sendGroupMessage")){
            
            try {
                
                MessageManager.sendGroupMessage(MessageFrom, MessageTo1, sendMessage );
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        else if(purpose.equals("ShowMemberOfGroup")){
            
            try {
                
                DefaultListModel DefaultListModel = GroupManager.getGroupMember(userInput, Username);
                list.setModel(DefaultListModel);
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(purpose.equals("BlockFriend")){
            
            try {
                FriendManager.blockFriend(Username, userInput);
                button.setText("Unblock");
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(purpose.equals("BlockGroup")){
            
            try {
                GroupManager.blockGroup(Username, userInput);
                button.setText("Unblock");
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(purpose.equals("IsFriendBlock")){
            
            try {
                
                if(FriendManager.isBlocked(Username, userInput)){
                    
                    button.setText("Unblock");
                    
                }
                else{
                    
                    button.setText("Block");
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(purpose.equals("IsGroupBlock")){
            try {
                if(GroupManager.isBlocked(Username, userInput)){
                    
                    button.setText("Unblock");
                    
                }
                else{
                    
                    button.setText("Block");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(purpose.equals("unblockFriend")){
            
            try {
                
                FriendManager.unblockFriend(Username, userInput);
                button.setText("Block");
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        else if(purpose.equals("unblockGroup")){
            
            try {
                
                GroupManager.unblockGroup(Username, userInput);
                button.setText("Block");
                
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        else if(purpose.equals("isDisplayNameValid")){
            
            String result = UserManager.isDisplayNameValid(userInput);
            
            if(result.equals("Everything is alright")){
                
                label.setForeground(Color.green);
                label.setText(result);
                
            }
            else{
                
                label.setForeground(Color.red);
                label.setText(result);
                
            }
            
        }
        
        else if(purpose.equals("AddConnectedAccount")){
            
            try {
                UserManager.addConnectedAccount(Username, userInput);
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        else if(purpose.equals("deleteGroup")){
           
            try {
                GroupManager.exitGroup(Username, userInput);
            } catch (SQLException ex) {
                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }
}