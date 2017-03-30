/*
 * File: Errors.java
 * Author: Christopher Clinard & James Paterick
 * Date: September 13, 2016
 * This program has multiple errors that need to be corrected.
 */
package lab2;

import java.util.Scanner; 

public class Errors {

    public static void main (String[] args){ 
      String name; // Name of the user 
      int number; 
      int numSq; 
      Scanner scan = new Scanner(System.in); 

        System.out.print("Enter your first/last name, please: "); 
        name = scan.nextLine(); 

        System.out.print("What is your favorite number? "); 
        number = scan.nextInt(); 

        numSq = number * number; 

        System.out.println (name+ ", the square of your number is "+ numSq); 

    } 

}