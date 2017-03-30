/*
 * File: BankingScanner.java
 * Author: Christopher Clinard
 * Date: 10/14/2016
 * This program calculates a bank balance after accrued interest or fees
 * depending on if the account is a savings or checking account.
 */
package lab3;

import java.util.*;
import java.text.NumberFormat;

public class BankingScanner {
    
  public static void main(String[] args){
        
   //Constants for checking accounts
   final double CHECKING_SERVICE_CHARGE = 25.00;
   final double CHECKING5K = .03;
   final double CHECKING5001 = .05;
   final double CHECKING_5000 = 5000;
        
   //Constants for savings accounts
   final double SAVINGS_SERVICE_CHARGE = 10.00;
   final double SAVINGS_INTEREST = .04;
        
   //Assign variables and strings for use within the program
   int accountNumber;
   char accountType;
   double accountMin;
   double accountBalance;
   String output = "";
   Scanner input = new Scanner(System.in);
    
   //Number format for setting precision and Dollar sign.
   NumberFormat currency = NumberFormat.getCurrencyInstance();
    
   //Asks for account number
   System.out.print("Enter the account number: ");
   accountNumber = input.nextInt();
    
   //Asks for account type C for checking or S for savings
   System.out.print("Enter the account type. C for checking" + 
            " and S for savings: ");
   accountType = input.next(".").charAt(0);
    
   //Lower cases accountType to evaluate as a lower case only
   accountType = Character.toLowerCase(accountType);
    
   //If an incorrect accountType is given this loop makes sure the user
   //inputs a correct accountType.
   while((accountType != 'c') && (accountType != 's')){
       
     System.out.println("That is not a valid account type.");
     System.out.print("Enter the account type: ");
     accountType = input.next(".").charAt(0);
     accountType = Character.toLowerCase(accountType);
   }
    
   //Asks for the minimum balance this account can have.
   System.out.print("What is the minimum balance for this account: ");
   accountMin = input.nextDouble();
    
   //Asks for the balance available in the account.
   System.out.print("What is the balance in this account: ");
   accountBalance = input.nextDouble();
   
   //If statement to determine account type.
   if(accountType == 's'){
     
     //If and else statement to determine if the balance is greater than, 
     //equal to, or less than the account minimum.
     if(accountBalance >= accountMin){
       System.out.println("The account number is: "+ accountNumber+ "\n"+
          "The account type is: "+ accountType+ "\n"+
          "The account unadjusted balance is: "+ 
          currency.format(accountBalance)+ "\n"+
          "The adjusted balance is: "+
          currency.format(accountBalance = 
          accountBalance + (accountBalance * SAVINGS_INTEREST)));      
     }
     
     //
     else{
       
       System.out.println("The account number is: "+ accountNumber+ "\n"+
          "The account type is: "+ accountType+ "\n"+
          "The account unadjusted balance is: "+ 
          currency.format(accountBalance)+ "\n"+
          "The adjusted balance is: "+
          currency.format(accountBalance = 
          accountBalance - SAVINGS_SERVICE_CHARGE));
     }
   }
   
   //else if statement to determine account type
   else if(accountType == 'c'){
       
     //If statement to determine if accountBalance is greater than or equal to 
     //accountMin
     if(accountBalance >= accountMin){
         
         //If and else statements to determine if accountBalance is greater than
         //5000 or less than or equal to 5000.
         if(accountBalance + 5000 > accountMin + 5000){
             
          System.out.println("The account number is: "+ accountNumber+ "\n"+
          "The account type is: "+ accountType+ "\n"+
          "The account unadjusted balance is: "+ 
          currency.format(accountBalance)+ "\n"+
          "The adjusted balance is: "+
          currency.format(accountBalance = 
          accountBalance + (accountBalance * CHECKING5001)));
     
         }
         else{
             
          System.out.println("The account number is: "+ accountNumber+ "\n"+
          "The account type is: "+ accountType+ "\n"+
          "The account unadjusted balance is: "+ 
          currency.format(accountBalance)+ "\n"+
          "The adjusted balance is: "+
          currency.format(accountBalance = 
          accountBalance + (accountBalance * CHECKING5K)));
         
             
         }
     }
     
     //If accountBalance is less than accountMin go here.
     else if(accountBalance < accountMin){
         
         System.out.println("The account number is: "+ accountNumber+ "\n"+
          "The account type is: "+ accountType+ "\n"+
          "The account unadjusted balance is: "+ 
          currency.format(accountBalance)+ "\n"+
          "The adjusted balance is: "+
          currency.format(accountBalance = 
          accountBalance - CHECKING_SERVICE_CHARGE));
         
       ;    
     }    
   }
  }
 }


