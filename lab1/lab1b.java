/* 
* File: lab1b.java
* Author: Christopher Clinard
* Date: 8/26/2016
* This program displays large block JAVA and my name, address, and major.
*/
package Lab1;

public class lab1b {
    
    public static void main(String[] args){
        
        //Assign Types and variables
        String name = "Christopher Clinard";
        String address = "9918 Old Rutledge Pk Mascot, TN 37806";
        String major = "Computer Science";
        
        //Prints out "JAVA" in block letters.
        System.out.println ("     J     A     V     V     A"+ 
                            "\n     J    A A     V   V     A A"+
                            "\n J   J   AAAAA     V V     AAAAA"+
                            "\n  J J   A     A     V     A     A");
        
        //Prints Name, address, and major on seperate lines
        System.out.println ("\nName: "+ name+ "\nAddress: "+ address+ 
            "\nMajor: "+ major);
        
    }
    
}
