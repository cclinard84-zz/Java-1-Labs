/*
 * File: UtilityMethods.java
 * Author: Christopher Matthew Clinard
 * Date: 11/10/16
 * This class is the beginning of a library of methods that
 * I have created and I use on a regular basis. 
 */
package lab5;
import java.util.*;

public class UtilityMethods {
  
  //This method verifies if the input is an integer.
  public static int verifyInt(Scanner input, String str){
    int length, age;
    length = str.length();
    
      for(int i = 0; i<length; i++){
            char testChar = str.charAt(i);
            
            if(Character.isDigit(testChar)){
            }
            else{
                i = 0;
                length = 0;
                System.out.print("This is not a valid integer.\nEnter a valid integer: ");             
                str = input.next();
                length = str.length();
            }
      }
      age = Integer.parseInt(str);
      return age;
  }
  
  //This method is used for verification of yes or no inputs.
  public static char askIfYesOrNo(Scanner input, char optionChar){
      String option;
      
        while(optionChar != 'y' && optionChar != 'n'){
            System.out.print("Enter a 'y' or 'n': ");
            option = input.next();
            optionChar = option.charAt(0);
        }
        return optionChar;
  }
  
  public static String verifyString(Scanner input, String str){
      int length = str.length();
      char c;
      
      for(int i = 0; i < length; i++){
          if(!(Character.isLetter(str.charAt(i)))){
              while(!(Character.isLetter(str.charAt(i)))){
                  System.out.println("Enter a word with no numbers: ");
                  str = input.next();
                  i = 0;
              }
          }
      }
      return str; 
  }
}
  

