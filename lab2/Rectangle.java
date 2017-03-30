/*
 * File: Lab2_B.java
 * Author: Christopher Clinard 
 * Date: September 8, 2016
 * This program has syntax errors that need to be corrected
 * and rerranged.
 */
package lab2;
import java.util.*;

public class Rectangle {
    public static void main(String [] args){
    
    //Assign Variables and initiate new Scanner
    Scanner console = new Scanner (System.in);
    int width;
    int area;
    int perimeter;
    int length;
    
    //Command line prompts and arithmetic
    System.out.print("Enter the length: ");
    length = console.nextInt();
    System.out.print("Enter the width: ");
    width = console.nextInt();
    area = length * width;
    System.out.println("\nArea = "+ area);
    perimeter = 2 * (length * width);
    System.out.println("Perimeter = "+ perimeter);

    } 
}


