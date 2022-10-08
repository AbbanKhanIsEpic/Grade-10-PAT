/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author abban
 */
public class GroupManager {
    
    public static  String[] getGroupNames(String username) throws SQLException{
        
        int userID = UserManager.getUserID(username);
        
        ArrayList<String> groupArrayList = new ArrayList<>();
        
        ResultSet resultGroupID = DB.query("Select groupID from abbankDB.GroupMembers Where UserID = " + userID + "");
            
        while(resultGroupID.next()){
                
            int groupID = resultGroupID.getInt(1);
            
            ResultSet resultGroupName = DB.query("Select groupName from abbankDB.Groups Where groupID = " + groupID + "");
            
            resultGroupName.next();
            
            String individualGroupNames = resultGroupName.getString(1);
            
            groupArrayList.add(individualGroupNames);
                
        }
        
        String[] groupList = groupArrayList.toArray(String[]::new);
        
        return groupList;
        
    }
    
    public static void createGroup(String groupName, String[] groupMembers) throws SQLException{
        
        DB.update("Insert into abbankDB.Groups(groupName) Values('" + groupName + "')");
        
        ResultSet result = DB.query("Select groupID from abbankDB.Groups Where groupName = '" + groupName + "' Order by groupID desc");
        
        result.next();
        
        int groupID = result.getInt(1);
        
        addUsersToGroup(groupID,groupMembers);
        
    }
    
    public static void addUsersToGroup(int groupID,String[] users) throws SQLException{
        
        for (String user : users) {
            
            int userID = UserManager.getUserID(user);
            
            DB.update("Insert into abbankDB.GroupMembers Values(" + groupID + " , '" + userID + "')");
            
        }
        
    }
    
    public static String[] getGroupMembers(String username,int index) throws SQLException{

        ArrayList<String> groupMembersArrayList = new ArrayList<>();
        
        int groupID = GroupManager.getGroupID(username, index);
        
        ResultSet result = DB.query("Select distinct Username from abbankDB.Users,GroupMembers Where (abbankDB.Users.UserID = abbankDB.GroupMembers.userID) And abbankDB.GroupMembers.groupID = " + groupID + "");
        
        while(result.next()){
            
            String individualGroupMember = result.getString(1);
            
            groupMembersArrayList.add(individualGroupMember);
            
        }
        
        String[] groupMembers = groupMembersArrayList.toArray(String[]::new);
        
        return groupMembers;
    }
    
    public static void blockGroup(String username,int index) throws SQLException{

        int groupID = GroupManager.getGroupID(username, index);
        
        int userID = UserManager.getUserID(username);
        
        DB.update("Insert into abbankDB.BlockedGroups Values(" + userID + " , " + groupID + " , now())");
        
        
    }
    
    public static void unblockGroup(String username,int index) throws SQLException{
        
        int groupID = GroupManager.getGroupID(username, index);
        
        int userID = UserManager.getUserID(username);
        
        DB.update("Delete from abbankDB.BlockedGroups Where userID = " + userID + " And groupID = " + groupID + "");
        
    }
    
    public static boolean isBlocked(String username,int index) throws SQLException{
        
        int groupID = GroupManager.getGroupID(username, index);
        
        int userID = UserManager.getUserID(username);
        
        ResultSet result = DB.query("Select count(*) from abbankDB.BlockedGroups Where userID = " + userID + " And groupID = " + groupID + "");
        
        result.next();
        
        int count = result.getInt(1);
        
        return count == 1;

    }
    
    public static Timestamp getWhenBlocked(String username,int index) throws SQLException{
        
        int groupID = GroupManager.getGroupID(username, index);
        
        int userID = UserManager.getUserID(username);
        
        ResultSet result = DB.query("Select time from abbankDB.BlockedGroups Where userID = " + userID + " And groupID = " + groupID + "");
        
        result.next();
        
        Timestamp time = result.getTimestamp(1);
        
        return time;
        
    }
    
    public static void exitGroup(String username,int index) throws SQLException{
        
        int groupID = GroupManager.getGroupID(username, index);
        
        int userID = UserManager.getUserID(username);
        
        DB.update("Delete from abbankDB.GroupMembers Where groupID = " + groupID + " And userID = " + userID + "");
        
    }
    
    public static int getGroupID(String username,int index) throws SQLException{
        
        int userID = UserManager.getUserID(username);
        
        ResultSet result = DB.query("SELECT groupID FROM abbankDB.GroupMembers Where userID = " + userID + "");
        
        for(int i = 0; i <= index;i++){
            
            result.next();
            
        }
        
        int groupID = result.getInt(1);
        
        return groupID;
    }
    
    public static boolean isMessageDelete(String username,int index) throws SQLException{
        
        int groupID = GroupManager.getGroupID(username, index);
        
        int userID = UserManager.getUserID(username);    
        
        ResultSet result = DB.query("Select count(*) from abbankDB.deleteGroupMessage Where groupID = " + groupID + " And UserID = " + userID + "");
        
        result.next();
        
        int count = result.getInt(1);
        
        return count == 1;
        
    }
    
    public static Timestamp getWhenMessageDelete(String username,int index) throws SQLException{
        
        int groupID = GroupManager.getGroupID(username, index);
        
        int userID = UserManager.getUserID(username);
        
        ResultSet result = DB.query("Select time from abbankDB.deleteGroupMessage Where groupID = " + groupID + " And UserID = " + userID + "");
        
        result.next();
        
        Timestamp time = result.getTimestamp(1);
        
        return time;
        
    }
    
    public static void deleteMessage(String username,int index) throws SQLException{
        
        int userID = UserManager.getUserID(username);
        
        int groupID = GroupManager.getGroupID(username, index);
        
        if(isMessageDelete(username,index)){
            
            DB.update("Update abbankDB.deleteGroupMessage set time = now() Where groupID = " + groupID + " And UserID = " + userID + "");
            
        }
        else{

            DB.update("Insert into abbankDB.deleteGroupMessage Values(" + groupID + " , " + userID + " , now() )");
            
        }
    }
    
    
   
}
    

