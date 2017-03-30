/*
 * File: RockPaperScissors.java
 * Author: Christopher Clinard 
 * Date: 10/25/16
 * This program is the Rock, Paper, Scissors game nearly everyone played while growing up.
 * The program welcomes you to the game and gives you instructions on how to play. It will then
 * ask you if you want to play right now, if so, it will continue to play the game until
 * you decide you want to stop at the correct prompt.
 */
package lab4;
import java.util.*;

public class RockPaperScissors {
    public static void main(String[] args){

      //Declaration of variables
      char pChoice, cChoice, play;
      int winner, ties = 0, playerWins = 0, computerWins = 0;
      
      //Scanner for user input
      Scanner input = new Scanner(System.in);
      
      //Random number generator used to get the computers choice
      Random generator = new Random();
      
      play = welcomeUser(input);
      
      //Will keep playing as long as the users choice is 'y'
      while(play == 'y'){
        pChoice = playerChoice(input);
        cChoice = computerChoice(generator);
        winner = determineWinner(pChoice, cChoice);
        
        //If winner == 0 its a tie, if winner == 1 the player won, if winner == 2 the computer won.
        if(winner == 0)
          ties++;
        else if(winner == 1)
          playerWins++;
        else
          computerWins++;
        
        play = playAgain(input); //does the user want to play again?
        
      }  

        farewell(ties, playerWins, computerWins);
        System.exit(0);
    }
           
    

    
    //This method welcomes the user and gives instructions for playing the game.
    //This method also error checks the input to make sure the user gives a correct
    //input to determine if they want to play the game or not.
    public static char welcomeUser(Scanner input){
  
      char answer;
      System.out.println("Welcome to Rock, Paper, Scissors!" + 
                "\nTo play the game just enter the letter 'r' for rock,"+ 
                "\nthe letter 's' for scissors, and the letter 'p' for paper."+
                "\nWould you like to play right now?");
      System.out.print("Enter 'y' for yes or 'n' for no: ");
      answer = input.next().charAt(0);
      answer = Character.toLowerCase(answer);
      while(answer != 'y' && answer != 'n'){
        System.out.println("That was not a valid answer, enter 'y' for yes or 'n' for no: ");
        answer = input.next().charAt(0);
        answer = Character.toLowerCase(answer);
      }
      return answer;
    }
    
    //This method lets the user choose rock, paper, or scissors, and then
    //validates their input. The users choice is then sent back to main.
    public static char playerChoice(Scanner input){
      
      char pChoice;
      System.out.print("Enter 'r' for rock, 's' for scissors, or 'p' for paper: ");
      pChoice = input.next().charAt(0);
      pChoice = Character.toLowerCase(pChoice);
      while(pChoice != 'r' && pChoice != 's' && pChoice != 'p'){
        System.out.print("That was not a valid choice!"+
                        "\nPlease enter 'r' for rock, 's' for scissors,"+
                        " or 'p' for paper: ");
        pChoice = input.next().charAt(0);
        pChoice = Character.toLowerCase(pChoice);
      }
      return pChoice;
    }
    
    //This method uses a random number generator to determine the computers choice.
    //1 is for rock, 2 is for scissors, and 3 is for paper. The choice is then 
    //returned back to main.
    public static char computerChoice(Random generator){
      
      char cChoice;
      int randNumber;
      randNumber = generator.nextInt(3) + 1;
      switch (randNumber) {
        case 1:
          cChoice = 'r';
          break;
        case 2:
          cChoice = 's';
          break;
        default:
          cChoice = 'p';
          break;
      }
      
      return cChoice;
    }
    
    
    //This method determines if the game was a tie, the player won, or the computer won
    //via switch statements and returns a numeric result to main.
    public static int determineWinner(char player, char computer){
      
      int winner = -1; //winner variable initialized to -1 to not cause confusion
      
      //Switch case for players choice of 'r'
      switch(player){
        case 'r':
          switch(computer){
            case 'r':
              winner = 0;
              System.out.println("The computer chose rock!"+"\nIt's a tie!");
              break;              
            case 's':
              winner = 1;
              System.out.println("The computer chose scissors!"+"\nThe player wins!");
              break;
            case 'p':
              winner = 2;
              System.out.println("The computer chose paper"+"\nThe computer wins!");
              break;
          }
      }
      
      //Switch case for players choice of 's'
      switch(player){
        case 's':
          switch(computer){
            case 'r':
              winner = 2;
              System.out.println("The computer chose rock!"+"\nThe computer wins!");
              break;
            case 'p':
              winner = 1;
              System.out.println("The computer chose paper!" + "\nThe player wins!");
              break;
            case 's':
              winner = 0;
              System.out.println("The computer chose scissors!"+"\nIt's a tie!");
              break;
          }
      }
      
      //Switch case for palyers choice of 'p'
      switch(player){
        case'p':
          switch(computer){
            case 'r':
              winner = 1;
              System.out.println("The computer chose rock!"+"\nThe player wins!");
              break;
            case 's':
              winner = 2;
              System.out.println("The computer chose scissors!"+"\nThe computer wins!");
              break;
            case 'p':
              winner = 0;
              System.out.println("The computer chose paper!"+"\nIt's a tie!");
              break;
          }
      }
     return winner;
    }
    
    //This method just determines if the user wants to keep playing through more
    //iterations of the game and validates the user input.
    public static char playAgain(Scanner input){
      char answer; 
      System.out.print("\nDo you want to play again? Enter 'y' for yes or 'n' for no: ");
      answer = input.next().charAt(0);
      answer = Character.toLowerCase(answer);
      while(answer != 'y' && answer != 'n'){
        System.out.print("That was not a valid answer, enter 'y' for yes or 'n' for no: ");
        answer = input.next().charAt(0);
        answer = Character.toLowerCase(answer);
      }
      return answer;
    }
    
    //This method gives the scorecard of how many ties, how many times the player won,
    //how many times the computer won, and thanks the user for playing the game.
    public static void farewell(int num1, int num2, int num3){
      System.out.println("\nYou tied with the computer "+ num1+ " time(s)."+ "\nYou beat the computer "+
                        num2+ " time(s)."+ "\nThe computer beat you "+ num3+ " time(s)."+
                        "\nThanks for playing! Please play again soon!");

    }
}

    
