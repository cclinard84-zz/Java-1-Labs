/*
 * File: RPSLizardSpock.java
 * Author: Christopher Clinard 
 * Date: 10/28/2016
 * This program is similar to the rock, paper, scissors game everyone knows but adds two more choices
 * which makes the game a little harder to predict and provides a fun twist! The program welcomes you 
 * to the game and gives you instructions on how to play. It will then ask you if you want to play
 * right now, if so, it will continue to play the game until you decide you want to stop at the correct prompt.
 */
package lab4;
import javax.swing.JOptionPane;
import java.util.*;

public class RPSLizardSpock {
    public static void main(String[] args){
        int cChoice;
        int winner, play, ties = 0, playerWins = 0, computerWins = 0;
        char pChoice;
    
        //Random number generator used in the computers choice
        Random generator = new Random();
        
        
        play = welcomeUser();
        
        //If the player selects 'NO' the game will end with no further menus. 
        //Otherwise the game will repeat as long as the player selects yes.
        if(play == JOptionPane.NO_OPTION)
          System.exit(0);
        while(play == JOptionPane.YES_OPTION){
            pChoice = playerChoice();
            cChoice = computerChoice(generator);
            winner = determineWinner(pChoice, cChoice);
            switch (winner) {
              case 0:
                ties++;
                break;
              case 1:
                playerWins++;
                break;
              default:
                computerWins++;
                break;
          } 
            play = JOptionPane.showConfirmDialog(null, "Do you want to play again?",null, JOptionPane.YES_NO_OPTION); 
        }
        farewell(ties, playerWins, computerWins);
        System.exit(0);
    }
    
    //This method welcomes the user, gives them a brief description, and explains the rules of the game. 
    //It also asks to make absolutely sure they are ready to play the game and returns their choice to 
    //main.
    public static int welcomeUser(){
     
        int answer;
        JOptionPane.showMessageDialog(null, "Welcome to Rock, Paper, Scissors, Lizard, Spock!");
        JOptionPane.showMessageDialog(null, "In this twist of the popular Rock, Paper, Scissors game a"+
                                      "\nlizard and Captain Spock join in the epic battle of decision making.");
        JOptionPane.showMessageDialog(null, "The rules are as follows: \nRock beats Scissors. \nScissors beats Paper."+
                                      "\nPaper beats Rock. \nLizard poisons Spock. \nSpock vaporizes Rock. "+
                                      "\nScissors decapitates Lizard. \nLizard eats Paper. \nRock smashes Lizard"+
                                      "\nSpock smashes Scissors.\nPaper disproves Spock.");
        JOptionPane.showMessageDialog(null, "Enter a R for rock,"+"\nEnter a P for paper,"+ 
                                     "\nEnter an S for scissors"+ "\nEnter an L for Lizard,"+
                                     "\nEnter an X for Capt. Spock.");
        
        answer = JOptionPane.showConfirmDialog(null,"\n Would you like to play now?", null, JOptionPane.YES_NO_OPTION);
        return answer;
    }
    
    //This method asks the player for their choice, validates the input for correctness, and then
    //returns the choice to main.
    public static char playerChoice(){
       String str1; //temp string to hold players choice.
       char choice; //return value of players choice after parsing.
       
       str1 = JOptionPane.showInputDialog("Choose one of the following: (R)Rock, (P)Paper, (S)Scissors,"+
                                     "\n(L)Lizard, (X)Spock");
       while(str1.length() == 0){
           str1 = JOptionPane.showInputDialog("Choose one of the following: (R)Rock, (P)Paper, (S)Scissors,"+
                                     "\n(L)Lizard, (X)Spock");
       }
       
       choice = str1.charAt(0);
       choice = Character.toLowerCase(choice);
       while( choice != 'r' && choice != 'p' && choice != 's' && choice != 'l' && choice != 'x'){
            str1 = JOptionPane.showInputDialog("Choose one of the following: (R)Rock, (P)Paper, (S)Scissors,"+
                                     "\n(L)Lizard, (X)Spock"); 
            
            while(str1.length() == 0){
                str1 = JOptionPane.showInputDialog("Choose one of the following: (R)Rock, (P)Paper, (S)Scissors,"+
                                     "\n(L)Lizard, (X)Spock");
            }
            choice = str1.charAt(0);
            choice = Character.toLowerCase(choice);   
        }

       
       return choice;
    }
    
    //This method creates an integer via random number generator for the computers choice
    //and returns the value to main.
    public static int computerChoice(Random generator){
        int randNumber;
        
        randNumber = generator.nextInt(5);
        return randNumber;
    }
    
    //This method determines the winner via switch statements.
    public static int determineWinner(char char1, int num2){
        int winner = -1;
        
        switch(char1){
            case('r'):
                switch(num2){
                    case(0):
                        winner = 0;
                        JOptionPane.showMessageDialog(null, "The computer chose rock! \nIt's a tie!");
                        break;
                    case(1):
                        winner = 2;
                        JOptionPane.showMessageDialog(null, "The computer chose paper! \nThe computer wins!");
                        break;
                    case(2):
                        winner = 1;
                        JOptionPane.showMessageDialog(null, "The computer chose scissors! \nThe player wins!");
                        break;
                    case(3):
                        winner = 1;
                        JOptionPane.showMessageDialog(null, "The computer chose lizard! \nThe player wins!");
                        break;
                    case(4):
                        winner = 2;
                        JOptionPane.showMessageDialog(null,"The computer chose Spock! \nThe computer wins!");
                        break;                        
                }
        }
        // 0 = rock, 1 = paper, 2 = scissors, 3 = lizard, 4 = Spock
        switch(char1){
            case('p'):
                switch(num2){
                    case(0):
                        winner = 1;
                        JOptionPane.showMessageDialog(null, "The computer chose rock! \nThe player wins!");
                        break;
                    case(1):
                        winner = 0;
                        JOptionPane.showMessageDialog(null, "The computer chose paper! \nIt's a tie!");
                        break;
                    case(2):
                        winner = 2;
                        JOptionPane.showMessageDialog(null, "The computer chose scissors! \nThe computer wins!");
                        break;
                    case(3):
                        winner = 2;
                        JOptionPane.showMessageDialog(null, "The computer chose lizard! \nThe computer wins!");
                        break;
                    case(4):
                        winner = 1;
                        JOptionPane.showMessageDialog(null,"The computer chose Spock! \nThe player wins");
                        break;
                }
        }
        // 0 = rock, 1 = paper, 2 = scissors, 3 = lizard, 4 = Spock
        switch(char1){
            case('s'):
                switch(num2){
                    case(0):
                        winner = 2;
                        JOptionPane.showMessageDialog(null, "he computer chose rock! \nThe computer wins!");
                        break;
                    case(1):
                        winner = 1;
                        JOptionPane.showMessageDialog(null, "The computer chose paper! \nThe player wins!");
                        break;
                    case(2):
                        winner = 0;
                        JOptionPane.showMessageDialog(null, "The computer chose scissors! \nIt's a tie!");
                        break;
                    case(3):
                        winner = 1;
                        JOptionPane.showMessageDialog(null, "The computer chose lizard! \nThe player wins!");
                        break;
                    case(4):
                        winner = 2;
                        JOptionPane.showMessageDialog(null,"The computer Spock! \nThe computer wins!");
                        break;
                }
        }
        // 0 = rock, 1 = paper, 2 = scissors, 3 = lizard, 4 = Spock
        switch(char1){
            case('l'):
                switch(num2){
                    case(0):
                        winner = 2;
                        JOptionPane.showMessageDialog(null, "The computer chose rock! \nThe computer wins!");
                        break;
                    case(1):
                        winner = 1;
                        JOptionPane.showMessageDialog(null, "The computer chose paper! \nThe player wins!");
                        break;
                    case(2):
                        winner = 2;
                        JOptionPane.showMessageDialog(null, "The computer chose scissors! \nThe computer wins!");
                        break;
                    case(3):
                        winner = 0;
                        JOptionPane.showMessageDialog(null, "The computer chose lizard! \nIt's a tie!");
                        break;
                    case(4):
                        winner = 1;
                        JOptionPane.showMessageDialog(null,"The computer chose Spock! \nThe player wins");
                        break;
                }
        }
        // 0 = rock, 1 = paper, 2 = scissors, 3 = lizard, 4 = Spock
        switch(char1){
            case('x'):
                switch(num2){
                    case(0):
                        winner = 1;
                        JOptionPane.showMessageDialog(null, "The computer chose rock! \nThe player wins!");
                        break;
                    case(1):
                        winner = 2;
                        JOptionPane.showMessageDialog(null, "The computer chose paper! \nThe computer wins!");
                        break;
                    case(2):
                        winner = 1;
                        JOptionPane.showMessageDialog(null, "The computer chose scissors! \nThe player wins!");
                        break;
                    case(3):
                        winner = 2;
                        JOptionPane.showMessageDialog(null, "The computer chose lizard! \nThe computer wins!");
                        break;
                    case(4):
                        winner = 1;
                        JOptionPane.showMessageDialog(null,"The computer chose Spock!\nIt's a tie!");
                        break;
                }
        }
        return winner;
    }
    
    //This method prints the farewell message tallying the wins for the player, computer, and ties.
    public static void farewell(int num1, int num2, int num3){
        
        JOptionPane.showMessageDialog(null,"The player won "+  num2+ "time(s)."+
                                      "\nThe computer won "+ num3+ "time(s)."+
                                      "\nYou tied with the computer "+ num1+ "time(s).");
        
    }
    
}

