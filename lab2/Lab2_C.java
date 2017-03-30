/*
 * File: Lab2_C.java
 * Author: Christopher Clinard 
 * Date: September 8, 2016
 * This program calculates the total pay, taxes, and expenditures after 
 * gathering information such as pay rate and hours worked.
 */
package lab2;
import javax.swing.JOptionPane;
import java.text.NumberFormat;
 
public class Lab2_C{
    
    public static void main(String[] args){
        
        //Constants for these identifiers since they will not change
        final double TAXRATE = .14;
        final double SCHOOLCLOTHES = .1;
        final double SCHOOLSUPPLIES = .01;
        final double SAVINGSBONDS = .25;
        final double PARENTSAVINGSBONDS = .5;
        
        //Declaration of double, int, and string identifiers
        double payRate, hours, grossPay, netPay;
        double schoolClothesMoney, schoolSuppliesMoney, savingsBondsMoney;
        double parentsSavingsBondsMoney;
        int savingsBondsInteger;
        String payRateStr, hoursStr;
        
        //Prompts for pay rate and hours worked
        payRateStr = JOptionPane.showInputDialog("Enter your pay rate.");
        payRate = Double.parseDouble(payRateStr);
        hoursStr = JOptionPane.showInputDialog("How many hours did you work?");
        hours = Double.parseDouble(hoursStr);
        
        //Arithmetic for variable categories
        grossPay = payRate * hours;
        netPay = grossPay - (payRate * hours) * TAXRATE;
        schoolClothesMoney = netPay * SCHOOLCLOTHES;
        schoolSuppliesMoney = netPay * SCHOOLSUPPLIES;
        savingsBondsMoney = netPay * SAVINGSBONDS;
        
        //Casts savingsBondsMoney to an integer to correctly calculate
        //parentsSavingsBondsMoney
        savingsBondsInteger =(int)savingsBondsMoney;
        parentsSavingsBondsMoney = savingsBondsInteger * PARENTSAVINGSBONDS;
        
        //Sets precision of doubles used in message dialog
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        //Message dialog for gross/net income, money spent, 
        //and parents savings bonds.
        JOptionPane.showMessageDialog(null, "Your pay before taxes is "+
        currency.format(grossPay)+ "."+ "\nYour pay after taxes is "+ 
        currency.format(netPay)+ "."+ "\nYou spent "+ 
        currency.format(schoolClothesMoney)+ 
        " on clothes and accessories."+ "\nYou spent "+ 
        currency.format(schoolSuppliesMoney)+ " on school supplies."+ 
        "\nYou spent "+ currency.format(savingsBondsMoney)+ 
        " on savings bonds."+ "\nYour parents spent "+ 
        currency.format(parentsSavingsBondsMoney)+ 
        " on additional savings bonds.");
        
    }
}
