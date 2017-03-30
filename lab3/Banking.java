/*
 * File: Banking.java
 * Author: Christopher Clinard
 * Date: 10/03/2016
 * This program calculates a bank balance after accrued interest or fees
 * depending on if the account is a savings or checking account.
 */
package lab3;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class Banking {
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
    String accountBalanceStr;
    String accountNumberStr;
    String accountTypeStr;
    String accountMinStr;
    String output = "";
        
    //Sets precision of doubles used in message dialog
    NumberFormat currency = NumberFormat.getCurrencyInstance();
        
    //Account Number Prompt
    accountNumberStr = JOptionPane.showInputDialog("Please Enter Your "+
        "Account Number.");
    accountNumber = Integer.parseInt(accountNumberStr);
        
    //Account Type Prompt
    accountTypeStr = JOptionPane.showInputDialog("What type of account is "+
        "this? C or c for Checking or S or s for Savings?");
    accountType = accountTypeStr.charAt(0);
    accountType = Character.toLowerCase(accountType);
    
    while((accountType != 'c') && (accountType != 's')){
         accountTypeStr = JOptionPane.showInputDialog("What type of account is "+
        "this? C or c for Checking or S or s for Savings?");
        accountType = accountTypeStr.charAt(0);
        accountType = Character.toLowerCase(accountType);
    }
            
    //Minmum Account Balance Prompt
    accountMinStr = JOptionPane.showInputDialog("What is the minimum"+
        " account balance for this account?");
    accountMin = Double.parseDouble(accountMinStr);
        
    //Account Balance Prompt
    accountBalanceStr = JOptionPane.showInputDialog("Please enter the"+
        " account balance for this account: ");
    accountBalance = Double.parseDouble(accountBalanceStr);
        
        
        
    //IF Statement to determine the account type
    if((accountType == 's')||(accountType == 'S')){
            
      //IF statment to determine if the savings account balance is 
      //greater than or equal to the minimum.
      if(accountBalance >= accountMin){
        JOptionPane.showMessageDialog(null, "The Account Number is "+
          accountNumber+ "\nThe Account Type is: "+ 
          accountType+ "\nThe balance is: "+ 
          currency.format(accountBalance)+ "\nThe new adjusted "+
          "balance is: "+ currency.format((accountBalance) 
          = accountBalance + (accountBalance * SAVINGS_INTEREST)));                                
      }
            
      //If savings balance is less than minimum then it will subtract 
      //the fee and give new balance.
      else{
        JOptionPane.showMessageDialog(null, "The Account Number is: "+ 
          accountNumber+ "\nThe Account Type is: "+ 
          accountType+ "\nThe current balance is: "+ 
          currency.format(accountBalance)+ "\nThe new adjusted balance is: "+ 
          currency.format((accountBalance = (accountBalance 
          - SAVINGS_SERVICE_CHARGE))));
      }
                        
    }
    
    //Checks to see if account is a checking account type.
    else if((accountType == 'c') || (accountType == 'C')){
      if(accountBalance >= accountMin){
        if(accountBalance+ 5000 > accountMin + 5000){
          JOptionPane.showMessageDialog(null, "The Account Number is: "+
            accountNumber+ "\nThe Account Type is: "+ 
            accountType+ "\nThe balance is: "+ currency.format(accountBalance)+ 
            "\nThe new adjusted balance is: "+ currency.format((accountBalance = 
            (accountBalance + (accountBalance * CHECKING5001)))));                                
        }
        else{
          JOptionPane.showMessageDialog(null, "The Account Number is: "+
            accountNumber+ "\nThe Account Type is: "+ 
            accountType+ "\nThe balance is: "+ currency.format(accountBalance)+ 
            "\nThe new adjusted balance is: "+ currency.format((accountBalance = 
            (accountBalance + (accountBalance * CHECKING5K)))));
        }
      }
      
      //IF checking balance is less than the account minimum
      else if(accountBalance < accountMin){
        JOptionPane.showMessageDialog(null, "The Account Number is "+
          accountNumber+ "\nThe Account Type is: "+ 
          accountType+ "\nThe balance is: "+ currency.format(accountBalance)+ 
          "\nThe new adjusted balance is: "+ currency.format((accountBalance = 
          (accountBalance - CHECKING_SERVICE_CHARGE))));
      }
    }
        else{
          JOptionPane.showMessageDialog(null, "This is not a "+
          "valid account type.");
        }
        
        
       
  }
    
}

