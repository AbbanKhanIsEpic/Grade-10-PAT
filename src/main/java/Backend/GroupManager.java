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

    //Method gets the user's group names
    //Input is the user's username
    //Output is a string array of group names
    public static String[] getGroupNames(String username) throws SQLException {
        
        //Get userID of user
        int userID = UserManager.getUserID(username);
        
        //Using array list because we don't know how many groups the user is in
        ArrayList<String> groupArrayList = new ArrayList<>();
        
        //Query to get the group names from mySQL
        ResultSet mySQGroupIDResult = DB.query("Select groupID from abbankDB.GroupMembers Where UserID = " + userID + "");
        
        //While loop because we don't know how many elemenst the array list contains and we want to get get individual Group Names
        while (mySQGroupIDResult.next()) {

            //Get groupID
            int groupID = mySQGroupIDResult.getInt(1);

            //Query to get the group name from groupID
            ResultSet mysqlGroupNameResult = DB.query("Select groupName from abbankDB.Groups Where groupID = " + groupID + "");

            mysqlGroupNameResult.next();
            
            //Get group name
            String individualGroupNames = mysqlGroupNameResult.getString(1);
            
            //Add group name to array list
            groupArrayList.add(individualGroupNames);

        }
        
        //Covert array list to string array
        String[] groupList = groupArrayList.toArray(String[]::new);

        //return array
        return groupList;

    }

    //Method create group
   //Method inputs are group name and string array of group members
    public static void createGroup(String groupName, String[] groupMembers) throws SQLException {

        //Create group
        DB.update("Insert into abbankDB.Groups(groupName) Values('" + groupName + "')");

        //Query to get the groupID of the group name (order in dec because we want the latest one)
        ResultSet mySQLGetGroupIDResult = DB.query("Select groupID from abbankDB.Groups Where groupName = '" + groupName + "' Order by groupID desc");

        mySQLGetGroupIDResult.next();

        //Get groupID
        int groupID = mySQLGetGroupIDResult.getInt(1);
        
        //Add users to the group
        addUsersToGroup(groupID, groupMembers);

    }

    //Method add users to the group
    //Method inputs are the groupID and string array of users
    public static void addUsersToGroup(int groupID, String[] users) throws SQLException {

        //For-each loop to get add each user to the group
        for (String user : users) {

            //Get userID of the user
            int userID = UserManager.getUserID(user);

            //Add the user to the group
            DB.update("Insert into abbankDB.GroupMembers Values(" + groupID + " , '" + userID + "')");

        }

    }

    //Method returns group memebers
    //Method inputs are username and the index of group name of the jList
    public static String[] getGroupMembers(String username, int index) throws SQLException {

        //Array list becase we don't know how many group memebers there are in a group
        ArrayList<String> groupMembersArrayList = new ArrayList<>();

        //Get groupID
        int groupID = GroupManager.getGroupID(username, index);

        //Query to get group member of a group
        ResultSet mySQLGetGroupMemberResult = DB.query("Select distinct Username from abbankDB.Users,GroupMembers Where (abbankDB.Users.UserID = abbankDB.GroupMembers.userID) And abbankDB.GroupMembers.groupID = " + groupID + "");

        //While loop because we don't know how many group members there are and we want to add each group member to the array list
        while (mySQLGetGroupMemberResult.next()) {

            //Get individual Group Member
            String individualGroupMember = mySQLGetGroupMemberResult.getString(1);

            //Add Group Member to array list
            groupMembersArrayList.add(individualGroupMember);

        }

        //Convert the array list to string array
        String[] groupMembers = groupMembersArrayList.toArray(String[]::new);

        //Return string array
        return groupMembers;
    }

    //Method blocks the group
    //Method inputs are the user's username and the index of the jList
    public static void blockGroup(String username, int index) throws SQLException {

        //Get groupID
        int groupID = GroupManager.getGroupID(username, index);

        //Get the userID
        int userID = UserManager.getUserID(username);

        //Block group
        DB.update("Insert into abbankDB.BlockedGroups Values(" + userID + " , " + groupID + " , now())");

    }

    //Method unblock group
    //Method inputs are the user's username and the index of the jList
    public static void unblockGroup(String username, int index) throws SQLException {

        //Get groupID
        int groupID = GroupManager.getGroupID(username, index);

        //Get userID
        int userID = UserManager.getUserID(username);

        //Remove block
        DB.update("Delete from abbankDB.BlockedGroups Where userID = " + userID + " And groupID = " + groupID + "");

    }

    //Method checks if the user blocked the group
    //Method inputs are username and the index of the jList
    public static boolean isBlocked(String username, int index) throws SQLException {

        //Get groupID
        int groupID = GroupManager.getGroupID(username, index);

        //Get userID
        int userID = UserManager.getUserID(username);

        //Query to check if the user blocked the group ( count query because it is much easier )
        ResultSet mySQLIsGroupBlockedResult = DB.query("Select count(*) from abbankDB.BlockedGroups Where userID = " + userID + " And groupID = " + groupID + "");

        mySQLIsGroupBlockedResult.next();

        //Get result as int
        int count = mySQLIsGroupBlockedResult.getInt(1);

        //return count
        // 1 is true
        // 0 is false
        return count == 1;

    }

    //Method returns when the user blocked the group
    //Method inputs are username and the index of the jList
    public static Timestamp getWhenBlocked(String username, int index) throws SQLException {
        
        //Get groupID
        int groupID = GroupManager.getGroupID(username, index);

        //Get userID
        int userID = UserManager.getUserID(username);
        
        //Query to get when the uer blocked the group
        ResultSet mySQLWhenGroupBlockedResult = DB.query("Select time from abbankDB.BlockedGroups Where userID = " + userID + " And groupID = " + groupID + "");

        mySQLWhenGroupBlockedResult.next();

        //Get when as timestamp
        Timestamp whenGroupBlockedTimestamp = mySQLWhenGroupBlockedResult.getTimestamp(1);

        //Return timestamp
        return whenGroupBlockedTimestamp;

    }

    //Method remove user from the group
    //Method inputs are username and the index of the jList
    public static void exitGroup(String username, int index) throws SQLException {

        //Get groupID
        int groupID = GroupManager.getGroupID(username, index);

        //Get userID
        int userID = UserManager.getUserID(username);

        //Remove user from group
        DB.update("Delete from abbankDB.GroupMembers Where groupID = " + groupID + " And userID = " + userID + "");

    }

    //Method gets and returns the groupID from username and the index of the jList
    public static int getGroupID(String username, int index) throws SQLException {

        //Get userID
        int userID = UserManager.getUserID(username);

        //Query to get groupID
        ResultSet mySQLGetGroupIDResult = DB.query("SELECT groupID FROM abbankDB.GroupMembers Where userID = " + userID + "");

        //For loop because we want to get the groupID of the selected group
        for (int i = 0; i <= index; i++) {

            mySQLGetGroupIDResult.next();

        }

        //Save groupID as int
        int groupID = mySQLGetGroupIDResult.getInt(1);

        //return int
        return groupID;
    }

    //Method checks if the user has deleted the group message
    //Method inputs are username and the index of the jList
    //Method return true if the user has
    public static boolean isMessageDelete(String username, int index) throws SQLException {

        //Get groupID
        int groupID = GroupManager.getGroupID(username, index);

        //Get userID
        int userID = UserManager.getUserID(username);

        //Query to check if the user has delete groyo message ( count query because it is easy and simple )
        ResultSet mySQLIsGroupMessageDeleteResult = DB.query("Select count(*) from abbankDB.DeleteGroupMessage Where groupID = " + groupID + " And UserID = " + userID + "");

        mySQLIsGroupMessageDeleteResult.next();

        //Save result as int
        int count = mySQLIsGroupMessageDeleteResult.getInt(1);

        //Return int
        // 1 is true
        // 0 is false
        return count == 1;

    }

    //Method returns when the user delete group message
    //Method inputs are username and the index of the jList
    public static Timestamp getWhenMessageDelete(String username, int index) throws SQLException {

        //Get groupID
        int groupID = GroupManager.getGroupID(username, index);

        //Get userID
        int userID = UserManager.getUserID(username);

        //Query to get when the user delete group message
        ResultSet mySQLGetWhenGroupMessageDeleteResult = DB.query("Select time from abbankDB.DeleteGroupMessage Where groupID = " + groupID + " And UserID = " + userID + "");

        mySQLGetWhenGroupMessageDeleteResult.next();

        //Save the result as timestamp
        Timestamp whenGroupMessageDeleteTimestamp = mySQLGetWhenGroupMessageDeleteResult.getTimestamp(1);

        //Return timestamp
        return whenGroupMessageDeleteTimestamp;

    }

    //Method delete group messahe
    //Method inputs are username and the index of the jList
    public static void deleteMessage(String username, int index) throws SQLException {

        //Get userID
        int userID = UserManager.getUserID(username);

        //Get groupID
        int groupID = GroupManager.getGroupID(username, index);

        //Checks if the user has already delete group message 
        if (isMessageDelete(username, index)) {

            //True, update the time
            DB.update("Update abbankDB.DeleteGroupMessage set time = now() Where groupID = " + groupID + " And UserID = " + userID + "");

        } else {

            //False, insert a new delete group message
            DB.update("Insert into abbankDB.DeleteGroupMessage Values(" + groupID + " , " + userID + " , now() )");

        }
    }

}
