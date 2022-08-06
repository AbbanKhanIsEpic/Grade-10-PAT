/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author abban
 */
public class TextManager {
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
    public static boolean isLegal(String string,int lowestASCII, int higestASCII, int[] excludeASCII){
        boolean fate = true;
        int i = 0;
        
        while(i < string.length()){
            int result = getASCII(string.charAt(i));
            
            if(result <= higestASCII && result >= lowestASCII){
                fate = true;
                
                for(int j = 0; j < excludeASCII.length; j++){
                    String char1 = result + "";
                    String char2 = excludeASCII[j] + "";
                    
                    boolean equal = char1.equals(char2);
                    String equalString = equal + "";
                    
                    if(equalString.equals("false")){
                        fate = true;
                    }
                    else{
                        fate = false;
                        return fate;
                    }
                }
            }
            else{
                fate = false;
                break;
            }
            i++;
        }
        return fate;
    }
    private static int getASCII(char character){
        String stringify = character + "";
        int result = stringify.compareTo("!") + 33;
        return result;
    }
    public static String getResultUsername(boolean fate,boolean length){
        String display = "";
        String stringify = fate + ""; 
        String stringify2 = length + ""; 
        
        if(stringify.equals("true")&&stringify2.equals("true")){
            display = "Everything looks correct";
        }
        else if(stringify2.equals("true")){
            display = "Sorry...Only numbers and letters";
        }
        else{
            display = "Sorry...Length range is 3 - 50";
        }
        return display;
    }
    public static boolean isBetweenLength(String string,int min, int max){
        boolean fate = false;
        if(string.length()>=min && string.length() <= max){
            fate = true;
        }
        else{
           
        }
        return fate;
    }
    public static String isEqual(String confirmedpassword, String password){
        String decision = "";
        if(confirmedpassword.equals(password)){
            decision = "Everything looks alright";
        }
        else{
            decision = "The passwords are not the same";
        }
        return decision;
    }
    public static String isLegal(String password){
        String fate = "";
        if(password.length() > 100){
            fate = "The password can not be longer than 100 characters";
        }
        else{
            fate = "Everything looks alright";
        }
        return fate;
    }
}
