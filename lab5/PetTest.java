/*
 * File: PetTest.java
 * Author: Christopher Matthew Clinard
 * Date: 11/10/16
 * This program first creates a pet via user input
 * that advances through a small story. Once the user
 * has created their pet then asked if they want to see
 * all attributes of the pet. If not the story advances 
 * and the program creates a pet Object which is then diplayed 
 * to the screen in the story.
 */
package lab5;
import java.util.*;

public class PetTest {
    
  //throw InterruptedException for Thread.sleep methods used.  
  public static void main(String[] args)throws InterruptedException{
    Scanner input = new Scanner(System.in);
    char userChoice;
    
    //This constructor creates new Pet Object with no args so the 
    //user can input the type, name, and age.
    Pet pet0 = new Pet();
    askForType(input, pet0);
    askForName(input, pet0);
    askForAge(input, pet0);
    userChoice = askSeeAttributes(input, pet0);
    
    if(userChoice == 'y'){
        System.out.println(pet0.toString());
    }
    
    //Constructor used in creating new class with 
    //arguments already filled out
    Pet pet1 = new Pet("Paulie", "Parrot", 22);
    Thread.sleep(2000);
    advanceStory(pet1);
    
  }
  
  //This method asks for the type of the pet that the pet store
  //has received. It sets the type of pet via a set method within
  //the  pet class.
  public static void askForType(Scanner input, Pet object){
    String type, type0;
    System.out.print("The pet store has received a new pet."+
                     "\nWhat kind of pet is it?"+
                     "\nEnter what kind of pet it is: ");
    type = input.next();
    type0 = UtilityMethods.verifyString(input, type);
    object.setType(type0);
  }
  
  //This method asks for the name of the pet that the pet store has
  //received. It then sets the name of the pet via a set method within
  //the pet class
  public static void askForName(Scanner input, Pet object){
    String name, name0;
    System.out.println("The pet store has received a(n) "+ object.getType()+
                     " and the owner wants you to name it."+
                     "\nEnter the name of the pet: ");
    name = input.next();
    name0 = UtilityMethods.verifyString(input, name);
    object.setName(name0);
    
  }
  
  //This method asks for the age of the pet that the pet store has
  //received. It then set the age of the pet via a set method within
  //the pet class.
  public static void askForAge(Scanner input, Pet object){
    String ageStr;
    int age=0;
    System.out.println("Enter an age (round to the nearest year) you think "+ object.getName()+ " looks:");
    ageStr = input.next();
    age = UtilityMethods.verifyInt(input, ageStr);
    object.setAge(age);
  }
  
  //This method allows the user if they want to see all attributes for the
  //pet they created. It uses a method called askIfYesOrNo from the 
  //UtilityMethods class to validate the user input.
  public static char askSeeAttributes(Scanner input, Pet object){
      char option, optionReturn;
      System.out.println("Would you like to see all attributes for the new pet?"+
                         "\nEnter 'y' or 'n': ");
      option = input.next().charAt(0);
      optionReturn = UtilityMethods.askIfYesOrNo(input, option);
      return optionReturn;
   }
  
  
  //This method is an advancement of the story that the user is walking through 
  //a pet store and looks at a cage of a pet. The pet is created automatically 
  //in main via constructor. Within the method the attributes of the pet is 
  //displayed via toString method.
  public static void advanceStory(Pet petObject)throws InterruptedException{
      System.out.println("Once you finish naming the new pet you decide");
      Thread.sleep(2250);
      System.out.println("to walk through the pet store. You come upon");
      Thread.sleep(2250);
      System.out.println("the first cage and read the card.");
      Thread.sleep(2250);
      System.out.println(petObject.toString());
      Thread.sleep(3500);
      System.out.println("Your mom calls your name telling you she's ready to go"+
                         "\nso you tell the owner goodbye and leave with your mom.");
  }
}
