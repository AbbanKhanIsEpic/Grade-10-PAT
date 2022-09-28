/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

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
        
        String table = member1 + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + member1 + "' , '" + member2 + "' , '" + member3 + "' , '" + member4 + "' , '" + member5 + "')"); 
        
        table = member2 + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + member1 + "' , '" + member2 + "' , '" + member3 + "' , '" + member4 + "' , '" + member5 + "')");
        
        table = member3 + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + member1 + "' , '" + member2 + "' , '" + member3 + "' , '" + member4 + "' , '" + member5 + "')");
        
        table = member4 + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + member1 + "' , '" + member2 + "' , '" + member3 + "' , '" + member4 + "' , '" + member5 + "')");
        
        table = member5 + "_gm";
        DB.update("Insert into abbankDB." + table + " Values('" + groupName + "' , '" + member1 + "' , '" + member2 + "' , '" + member3 + "' , '" + member4 + "' , '" + member5 + "')");
        
    }
    
    public static boolean areMembersDifferent(String selectedMember1,String selectedMember2,String selectedMember3,String selectedMember4,String selectedMember5){
        
        if(selectedMember1.equals(selectedMember2)|| selectedMember1.equals(selectedMember3) || selectedMember1.equals(selectedMember4) || selectedMember1.equals(selectedMember5)){
            
            return false;
            
        }
        else if(selectedMember2.equals(selectedMember3) || selectedMember2.equals(selectedMember4) || selectedMember2.equals(selectedMember5)){
            
            return false;
            
        }
        else if(selectedMember3.equals(selectedMember4) || selectedMember3.equals(selectedMember5)){
            
            return false;
            
        }
        else if(selectedMember4.equals(selectedMember5)){
            
            return false;
            
        }
        
        return true;
    }
}
    

