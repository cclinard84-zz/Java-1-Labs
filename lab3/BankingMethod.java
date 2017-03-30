/*
 * File: BankingMethod.java
 * Author: Christopher Clinard
 * Date: 10/19/2016
 * This program calculates a bank accout balance after accrued interest or fees
 * depending on if the account is a checking or savings account.
 * This program exclusively utilizes methods to perform important routines.
 */
package lab3;

import java.util.*;
import java.text.NumberFormat;

public class BankingMethod {
   
    //Static Constants for checking accounts used within methods
    public static final double CHECKING_SERVICE_CHARGE = 25.00;
    public static final double CHECKING5K = .03;
    public static final double CHECKING5001 = .05;
    public static final double CHECKING_5000 = 5000;
        
    //Static Constants for savings accounts used within methods
    public static final double SAVINGS_SERVICE_CHARGE = 10.00;
    public static final double SAVINGS_INTEREST = .04;
   
    public static void main(String[] args){
                
        //Assign variables and strings for use within main
        int accountNumber;
        char accountType;
        double accountMin;
        double accountBalance;
        
        //Scanner utilized for input data
        Scanner input = new Scanner(System.in);
        
        //Formatting for currency use and 2 decimal precision
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        accountNumber = accntNum(input);
        accountType = accntType(input);
        accountMin = accntMin(input);
        accountBalance = accntBalance(input);        
        if(accountType == 's'){
            accountSavings(accountNumber, accountType, 
                           accountMin, accountBalance, currency);  
        }
        else{
            accountChecking(accountNumber, accountType, 
                            accountMin, accountBalance, currency);  
        }
    }
    
    //This method gets the account number from the user with a bit of error
    //checking to make sure there are no symbols other than numbers.
    public static int accntNum(Scanner input){
        String acctNumStr;
        int accountNum;
        int length;
        
        System.out.println("Please enter the account number: ");
        acctNumStr = input.nextLine();
        length = acctNumStr.length();
        
        for(int i = 0; i<length; i++){
            char testChar = acctNumStr.charAt(i);
            
            if(Character.isDigit(testChar)){
            }
            else {
                i = 0;
                length = 0;
                System.out.print("You have entered an invalid"+
                        " account number. Please enter a valid account number: ");
                acctNumStr = input.nextLine();
                length = acctNumStr.length();
            }
        }
        accountNum = Integer.parseInt(acctNumStr);
        return accountNum;
    }
    
    //This method gets the account type from the user, C for checking, and
    //S for savings and returns it to main. This method also utilizes error
    //checking logic.
    public static char accntType(Scanner input){
        char aT;
 
        System.out.print("Please enter the account type. S for Savings or"+
                " C for checking: ");
        aT = input.next().charAt(0);
        aT = Character.toLowerCase(aT);
        
        while((aT != 'c') && (aT != 's')){
            System.out.print("That account type was not valid. Please enter a"+
                    " S for savings for C for checking.");
            aT = input.next().charAt(0);
            aT = Character.toLowerCase(aT);
        }
        return aT;
    }
    
    //This method asks the user the minimum account balance for the type of 
    //account and returns the value to main.
    public static double accntMin(Scanner input){
        double acctMin;
        System.out.print("Please enter the minimum balance for this account: ");
        acctMin = input.nextDouble();
        return acctMin; 
    }
    
    //This method asks the user the actual account balance and returns the value
    //to main.
    public static double accntBalance(Scanner input){
        double acctBal;
        System.out.print("Please enter the balance on this account: ");
        acctBal = input.nextDouble();
        return acctBal;
    }
    
    //This method prints the savings account information depending 
    //on certain criteria.
    public static void accountSavings(int num1, char char1,
                                      double min, double balance, 
                                      NumberFormat currency){
       
        double accountBalance;
        
        if(balance >= min){
          System.out.println("The account number is: "+ num1+ "\n"+
          "The account type is: "+ char1+ "\n"+
          "The account unadjusted balance is: "+ 
          currency.format(balance)+ "\n"+
          "The adjusted balance is: "+
          currency.format(accountBalance= 
          balance + (balance * SAVINGS_INTEREST)));
           
        }
        else{
          System.out.println("The account number is: "+ num1+ "\n"+
          "The account type is: "+ char1+ "\n"+
          "The account unadjusted balance is: "+ 
          currency.format(balance)+ "\n"+
          "The adjusted balance is: "+
          currency.format(accountBalance = (balance - SAVINGS_SERVICE_CHARGE)));
        }  
    }
    
    //This method prints checking account information depending on certain 
    //criteria
    public static void accountChecking(int num1, char char1, double min, 
                                       double balance, NumberFormat currency){
        
        double adjustedBalance;
        
        if(balance >= min){
          System.out.println("The account number is: "+ num1+ "\n"+
          "The account type is: "+ char1+ "\n"+
          "The account unadjusted balance is: "+ 
          currency.format(balance)+ "\n"+
          "The adjusted balance is: "+
          currency.format(adjustedBalance = (balance + (balance * CHECKING5K))));      
        }
        else if(balance + 5000 > min + 5000){
          System.out.println("The account number is: "+ num1+ "\n"+
          "The account type is: "+ char1+ "\n"+ 
          "The account unadjusted balance is: "+ 
          currency.format(balance)+ "\n"+
          "The adjusted balance is: "+
          currency.format(adjustedBalance = (balance + (balance * CHECKING5001))));
        }
        else{
          System.out.println("The account number is: "+ num1+ "\n"+
          "The account type is: "+ char1+ "\n"+
          "The account unadjusted balance is: "+ 
          currency.format(balance)+ "\n"+
          "The adjusted balance is: "+
          currency.format( adjustedBalance = balance - CHECKING_SERVICE_CHARGE));
        }
    }
    
    
    
}
