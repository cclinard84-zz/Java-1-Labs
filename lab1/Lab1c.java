/* 
* File: lab1c.java
* Author: Christopher Clinard
* Date: 8/26/2016
* This program prints out student grades.
*/
package Lab1;

public class Lab1c {
    public static void main(String[] args){
                        
        //Strings used to create headers and student info
        String topBorder = "////////////"+"\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\";
        String studentPoints = "== Student Points ==";
        String bottomBorder = "\\\\\\\\\\\\\\\\\\\\\\\\"+"/////////////////";
        String columnHeaders = "Name    Lab    Bonus    Total"+ "\n"+ 
                               "\n----    ---    -----    -----";
        
        //Student names and grades to be used within print statements
        String student1 = "Matt";
        String student2 = "Sam";
        String student3 = "Ryne";
        
        int mattLab = 100;
        int mattBonus = 0;
        int mattTotal = mattLab + mattBonus;
        int samLab = 75;
        int samBonus = 25;
        int samTotal = samLab + samBonus;
        int ryneLab = 50;
        int ryneBonus = 25;
        int ryneTotal = ryneLab + ryneBonus;
     
        //Print statements for Headers, Students Names, and Grades.
        System.out.println(topBorder+ "\n"+ studentPoints+ "\n"+ bottomBorder+
                           "\n"+ columnHeaders);
        
        //Prints Matt's info
        System.out.println("\n"+ student1+ "\t"+   mattLab+ "\t"+   mattBonus+ 
                           "\t"+  mattTotal);
        
        //Prints Sam's info
        System.out.println("\n"+ student2+ "\t"+ samLab+ "\t"+ samBonus+ 
                           "\t"+ samTotal);
        
        //Prints Ryne's info
        System.out.println("\n"+ student3+ "\t"+ ryneLab+ "\t"+ ryneBonus+ 
                           "\t"+ ryneTotal);        
        
    }
    
}
