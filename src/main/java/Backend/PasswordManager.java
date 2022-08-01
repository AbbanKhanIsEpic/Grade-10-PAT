/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author abban
 */
public class PasswordManager {
    public static String getTypedText(String userInput, String typed_password,String option){
        String processedText = typed_password;
            if(userInput.length() > typed_password.length()){
                String lastIndex = userInput.charAt(userInput.length() - 1) + "";
                typed_password = typed_password + lastIndex;
                processedText = typed_password;
            }
            else{
                typed_password = typed_password.substring(0, typed_password.length()-1);
                processedText = typed_password;
            }
            return processedText;
        }
    public static String getDisplayText(String typed_password,String option){
       String processedText = typed_password;
       if(option.equals("Hidden")){
           int i = 0;
           String star = "";
           while(i < typed_password.length()){
               star = star + "*";
               i++;
           }
           processedText = star;
       }
       else{
           processedText = typed_password;
       }
       return processedText;
    }
}
