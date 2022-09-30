/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import static java.lang.ProcessBuilder.Redirect.to;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

/**
 *
 * @author abban
 */
public class GroupManager {
    
    public static  DefaultListModel getGroups(String username) throws SQLException{

        String table = username + "_gm";
            
        DefaultListModel defaultListModel = new DefaultListModel();
            
        ResultSet result = DB.query("SELECT GroupName FROM abbankDB."+table+";");
            
        while(result.next()){
                
            defaultListModel.addElement(result.getString(1));
                
        }

        return defaultListModel;
        
    }
    
    public static boolean isGroupNameUnique(String groupName,String username) throws SQLException{
        
        String table = username + "_gm";
        ResultSet result = DB.query("Select count(*) from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        result.next();
        
        return result.getInt(1) == 0;
    }
    
    public static void createGroup(String groupName, String member1,String member2,String member3,String member4, String member5) throws SQLException{
        
        if(member2.equals("No-one")){
            member2 = null;
        }
        if(member3.equals("No-one")){
            member3 = null;
        }
        if(member4.equals("No-one")){
            member4 = null;
        }
        if(member5.equals("No-one")){
            member5 = null;
        }
        
        String table = member1 + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + member1 + "' , '" + member2 + "' , '" + member3 + "' , '" + member4 + "' , '" + member5 + "', 0 , '')"); 
        
        table = member2 + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + member1 + "' , '" + member2 + "' , '" + member3 + "' , '" + member4 + "' , '" + member5 + "', 0 , '')");
        
        table = member3 + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + member1 + "' , '" + member2 + "' , '" + member3 + "' , '" + member4 + "' , '" + member5 + "' , 0, '')");
        
        table = member4 + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + member1 + "' , '" + member2 + "' , '" + member3 + "' , '" + member4 + "' , '" + member5 + "' , 0 , '')");
        
        table = member5 + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + member1 + "' , '" + member2 + "' , '" + member3 + "' , '" + member4 + "' , '" + member5 + "' , 0 , '')");
        
    }
    
    public static boolean areMembersDifferent(String selectedMember1,String selectedMember2,String selectedMember3,String selectedMember4,String selectedMember5){
        if(!(selectedMember1.equals("No-one"))){
            if((selectedMember1.equals(selectedMember2) && !(selectedMember2.equals("No-one"))) || (selectedMember1.equals(selectedMember3) && !(selectedMember3.equals("No-one"))) || ((selectedMember1.equals(selectedMember4) && !(selectedMember4.equals("No-one")))) || (selectedMember1.equals(selectedMember5) && !(selectedMember5.equals("No-one")))){
                return false;
            }
            
        }
        if(!(selectedMember2.equals("No-one"))){
            if(selectedMember2.equals(selectedMember3) && !(selectedMember3.equals("No-one")) || selectedMember2.equals(selectedMember4) && !(selectedMember4.equals("No-one")) || selectedMember2.equals(selectedMember5) && !(selectedMember5.equals("No-one"))){
                return false;
            }
            
        }
        if(!(selectedMember3.equals("No-one"))){
            if(selectedMember3.equals(selectedMember4) && !(selectedMember4.equals("No-one")) || selectedMember3.equals(selectedMember5) && !(selectedMember5.equals("No-one"))){
                return false;
            }
        }
        if(!(selectedMember4.equals("No-one"))){
            if(selectedMember4.equals(selectedMember5) && !(selectedMember5.equals("No-one"))){
                return false;
            }
        }
        
        return true;
    }
    public static DefaultListModel getGroupMember(String groupName,String username) throws SQLException{
        
        String table = username + "_gm";
        
        DefaultListModel DefaultListModel = new DefaultListModel();
        
        ResultSet result = DB.query("Select GroupMemember1 from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        
        result.next();
        
        String member = result.getString(1);
        
        if(!(member.equals("null"))){
            
            DefaultListModel.addElement(result.getString(1));
            
        }
        
        
        
        result = DB.query("Select GroupMemember2 from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        
        result.next();
        
        member = result.getString(1);
        
        if(!(member.equals("null"))){
            
            DefaultListModel.addElement(result.getString(1));
            
        }
        
        result = DB.query("Select GroupMemember3 from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        
        result.next();
        
        member = result.getString(1);
        
        if(!(member.equals("null"))){
            
            DefaultListModel.addElement(result.getString(1));
            
        }
        
        result = DB.query("Select GroupMemember4 from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        
        result.next();
        
        member = result.getString(1);
        
        if(!(member.equals("null"))){
            
            DefaultListModel.addElement(result.getString(1));
            
        }
        
        result = DB.query("Select GroupMemember5 from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        
        result.next();
        
        member = result.getString(1);
        
        if(!(member.equals("null"))){
            
            DefaultListModel.addElement(result.getString(1));
            
        }
        
        return DefaultListModel;
    }
    
    public static void blockGroup(String username,String groupName) throws SQLException{
        
        String table = username + "_gm";
        
        DB.update("Update abbankDB." + table + " Set GroupBlockOrNot = 1 Where GroupName = '" + groupName + "'");
        
    }
    
    public static void unblockGroup(String username,String groupName) throws SQLException{
        
        String table = username + "_gm";
        
        DB.update("Update abbankDB." + table + " Set GroupBlockOrNot = 0 Where GroupName = '" + groupName + "'");
        
    }
    
    public static boolean isGroupBlock(String username,String groupName) throws SQLException{
        
        String table = username + "_gm";
        
        ResultSet result = DB.query("Select GroupBlockOrNot from abbankDB." + table + " Where GroupName = '" + groupName + "'");
        
        result.next();
        
        int block = result.getInt(1);
        
        return block == 1;
    }
    
   
}
    

