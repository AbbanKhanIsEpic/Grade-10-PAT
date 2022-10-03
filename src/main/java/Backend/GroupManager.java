/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author abban
 */
public class GroupManager {
    
    public static  String[] getGroups(String username) throws SQLException{
        
        ArrayList<String> groupArrayList = new ArrayList<>();
        
        String table = username + "_gm";
            
        ResultSet result = DB.query("SELECT GroupName FROM abbankDB."+table+";");
            
        while(result.next()){
                
            String individualGroupNames = result.getString(1);
            
            groupArrayList.add(individualGroupNames);
                
        }
        
        String[] groupList = groupArrayList.toArray(String[]::new);
        
        return groupList;
        
    }
    
    public static boolean isGroupNameUnique(String groupName,String username) throws SQLException{
        
        String table = username + "_gm";
        
        ResultSet result = DB.query("Select count(*) from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        result.next();
        
        return result.getInt(1) == 0;
    }
    
    public static void createGroup(String groupName, String[] groupMembers) throws SQLException{
        
        if(groupMembers[0].equals("No-one")){
            groupMembers[0] = null;
        }
        if(groupMembers[1].equals("No-one")){
            groupMembers[1] = null;
        }
        if(groupMembers[2].equals("No-one")){
            groupMembers[2] = null;
        }
        if(groupMembers[3].equals("No-one")){
            groupMembers[3] = null;
        }
        if(groupMembers[4].equals("No-one")){
            groupMembers[4] = null;
        }
        
        String table = groupMembers[0] + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + groupMembers[0] + "' , '" + groupMembers[1] + "' , '" + groupMembers[2] + "' , '" + groupMembers[3] + "' , '" + groupMembers[4] + "', 0 , '')"); 
        
        table = groupMembers[1] + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + groupMembers[0] + "' , '" + groupMembers[1] + "' , '" + groupMembers[2] + "' , '" + groupMembers[3] + "' , '" + groupMembers[4] + "', 0 , '')");
        
        table = groupMembers[2] + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + groupMembers[0] + "' , '" + groupMembers[1] + "' , '" + groupMembers[2] + "' , '" + groupMembers[3] + "' , '" + groupMembers[4] + "' , 0, '')");
        
        table = groupMembers[3] + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + groupMembers[0] + "' , '" + groupMembers[1] + "' , '" + groupMembers[2] + "' , '" + groupMembers[3] + "' , '" + groupMembers[4] + "' , 0 , '')");
        
        table = groupMembers[4] + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + groupMembers[0] + "' , '" + groupMembers[1] + "' , '" + groupMembers[2] + "' , '" + groupMembers[3] + "' , '" + groupMembers[4] + "' , 0 , '')");
        
    }
    
    public static boolean areMembersDifferent(String[] selectedGroupMember){
        if(!(selectedGroupMember[0].equals("No-one"))){
            if((selectedGroupMember[0].equals(selectedGroupMember[1]) && !(selectedGroupMember[1].equals("No-one"))) || (selectedGroupMember[0].equals(selectedGroupMember[2]) && !(selectedGroupMember[2].equals("No-one"))) || ((selectedGroupMember[3].equals(selectedGroupMember[3]) && !(selectedGroupMember[3].equals("No-one")))) || (selectedGroupMember[0].equals(selectedGroupMember[4]) && !(selectedGroupMember[4].equals("No-one")))){
                return false;
            }
            
        }
        if(!(selectedGroupMember[1].equals("No-one"))){
            if(selectedGroupMember[1].equals(selectedGroupMember[2]) && !(selectedGroupMember[2].equals("No-one")) || selectedGroupMember[1].equals(selectedGroupMember[3]) && !(selectedGroupMember[3].equals("No-one")) || selectedGroupMember[1].equals(selectedGroupMember[4]) && !(selectedGroupMember[4].equals("No-one"))){
                return false;
            }
            
        }
        if(!(selectedGroupMember[2].equals("No-one"))){
            if(selectedGroupMember[2].equals(selectedGroupMember[3]) && !(selectedGroupMember[3].equals("No-one")) || selectedGroupMember[2].equals(selectedGroupMember[4]) && !(selectedGroupMember[4].equals("No-one"))){
                return false;
            }
        }
        if(!(selectedGroupMember[3].equals("No-one"))){
            if(selectedGroupMember[3].equals(selectedGroupMember[4]) && !(selectedGroupMember[4].equals("No-one"))){
                return false;
            }
        }
        
        return true;
    }
    public static String[] getGroupMember(String groupName,String username) throws SQLException{
        
        String table = username + "_gm";
        
        ArrayList<String> groupMemberArrayList = new ArrayList<>();
        
        ResultSet result = DB.query("Select GroupMemember1,GroupMemember2,GroupMemember3,GroupMemember4,GroupMemember5 from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        
        while(result.next()){
            
            String individualGroupMember = result.getString(1);
            
            if(!(individualGroupMember.equals("null"))){
                
                groupMemberArrayList.add(individualGroupMember);
                
            }
            
        }
        
        String[] listOfGroupMember = groupMemberArrayList.toArray(String[]::new);
        
        return listOfGroupMember;
    }
    
    public static void blockGroup(String username,String groupName) throws SQLException{
        
        String table = username + "_gm";
        
        DB.update("Update abbankDB." + table + " Set GroupBlockOrNot = 1 Where GroupName = '" + groupName + "'");
        
    }
    
    public static void unblockGroup(String username,String groupName) throws SQLException{
        
        String table = username + "_gm";
        
        DB.update("Update abbankDB." + table + " Set GroupBlockOrNot = 0 Where GroupName = '" + groupName + "'");
        
    }
    
    public static boolean isBlocked(String username,String groupName) throws SQLException{
        
        String table = username + "_gm";
        
        ResultSet result = DB.query("Select GroupBlockOrNot from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        
        result.next();
        
        int block = result.getInt(1);
        
        return block == 1;
    }
    
    public static void removeGroup(String username,String groupName) throws SQLException{
        
        String table = username + "_gm";
        
        ResultSet result = DB.query("select GroupMemember1,GroupMemember2,GroupMemember3,GroupMemember4,GroupMemember5 from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        
        result.next();
        
        String member1 = result.getString(1);
        String member2 = result.getString(2);
        String member3 = result.getString(3);
        String member4 = result.getString(4);
        String member5 = result.getString(5);
        
        DB.update("Delete from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        
        if(member1.equals(username)){
            
            if(!(member2.equals("null"))){
                
                table = member2 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember1 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member3.equals("null"))){
                
                table = member3 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember1 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member4.equals("null"))){
                
                table = member4 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember1 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member5.equals("null"))){
                
                table = member5 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember1 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            
        }
        else if(member2.equals(username)){
            
            if(!(member1.equals("null"))){
                
                table = member1 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember2 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member3.equals("null"))){
                
                table = member3 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember2 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member4.equals("null"))){
                
                table = member4 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember2 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member5.equals("null"))){
                
                table = member5 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember2 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            
        }
        else if(member3.equals(username)){
            
            if(!(member1.equals("null"))){
                
                table = member1 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember3 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member2.equals("null"))){
                
                table = member2 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember3 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member4.equals("null"))){
                
                table = member4 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember3 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member5.equals("null"))){
                
                table = member5 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember3 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            
        }
        else if(member4.equals(username)){
            
            if(!(member1.equals("null"))){
                
                table = member1 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember4 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member2.equals("null"))){
                
                table = member2 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember4 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member3.equals("null"))){
                
                table = member3 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember4 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member5.equals("null"))){
                
                table = member5 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember4 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            
        }
        else if(member5.equals(username)){
            
            if(!(member1.equals("null"))){
                
                table = member1 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember5 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member2.equals("null"))){
                
                table = member2 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember5 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member3.equals("null"))){
                
                table = member3 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember5 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            if(!(member4.equals("null"))){
                
                table = member4 + "_gm";
                
                DB.update("Update abbankDB." + table + " Set GroupMemember5 = 'null' Where GroupName = '" + groupName + "'");
                
            }
            
        }
        
    }
   
}
    

