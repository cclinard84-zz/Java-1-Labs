/*
 * File: CarTest.java
 * Author: Christopher Matthew Clinard
 * Date: 11/10/16
 * This program intially creates its own car object that automatically sets
 * the make, year, and speed of the car. After creation the system will also
 * perform a speed test on the newly created object. Once that is complete the
 * program allows the user to create a new car object, declare the make, year, 
 * and initial speed for the speed test of the car.
 */
package lab5;
import java.util.*;
import static java.lang.Character.isDigit;

public class CarTest {
    
    //This program uses "throws InterruptedException" in conjunction with the
    //Thread.sleep() method to slow the output down so it is more human readable.
    public static void main(String[] args) throws InterruptedException{
        int printSpeed, year;
        char userChoice;
        String yearString, carMake;
        Scanner input = new Scanner(System.in);
        
        systemTest();
        userChoice = askUser(input);
        if(userChoice == 'y'){  
            yearString = getUserYear(input);
            year = Integer.parseInt(yearString);
            carMake = getUserMake(input);
            Car car1 = new Car(year, carMake);
            System.out.println("Your car's attributes are: \n"+ 
                              car1.toString());
            userChoice = askUser2(input);
            if(userChoice == 'y'){
                userChoice = askUser3(input);
                if(userChoice == 'y'){
                    userSetSpeed(input, car1);
                }
                for(int i = 0; i < 3; i++){
                    accelerateObject(car1);
                    Thread.sleep(1000);
                }
                for(int k = 0; k < 3; k++){
                    deccelerateObject(car1);
                    Thread.sleep(1000);
                }
                System.out.println("Speed test complete!");
            }
        }
        else{
            System.out.println("Thanks for using Car Tester!");
            System.exit(0);
        }
        System.out.println("Thanks for using Car Tester!");
            System.exit(0); 
    }
    
    //This method is a system test that automatically creates a new Car object, sets year, sets the model,
    //and then sets the speed. After setting attributes the method performs a speed test loop that accelerates
    //3 times then deccelerates 3 times.
    public static void systemTest()throws InterruptedException{
      System.out.println("The system will now create a new car.");
        Car car0 = new Car();
        Thread.sleep(2000);        
        System.out.println("New car created!");
        Thread.sleep(2000);
        System.out.println( "The system will now set year, make of car, and speed.");
        Thread.sleep(2000);
        car0.setYearModel(2012);
        car0.setMake("Chevrolet");
        System.out.println("The year of the car is "+ car0.getYearModel()+ "."+
                          "\nThe make of the car is "+ car0.getMake()+ "."+
                          "\nThe speed of the car is "+ car0.getSpeed()+ ".");
        Thread.sleep(2000);
        System.out.println("The system will now do a speed test.");
        Thread.sleep(2000);
        for(int i = 0;i < 3; i++){          
            accelerateObject(car0);
            Thread.sleep(1000);
        }
        for(int k = 0; k < 3; k++){
            deccelerateObject(car0);
            Thread.sleep(1000);
        }
        Thread.sleep(2000);        
        System.out.println("System test complete!");
        Thread.sleep(2000);
      
    }
    
    //This method asks the user if they would like to set a custom speed
    //for a speed test. The input is validated and returned back to main.
    public static char askUser3(Scanner input){
         char option, optionReturn;
        System.out.print("Would you like to set a custom speed for your speed test?"+
                         "\nEnter 'y' for yes or 'n' for no:");
        option = input.next().charAt(0);
        optionReturn = UtilityMethods.askIfYesOrNo(input, option);
        return optionReturn;
    }
    
    //This method asks the user if they would like to create a custom car.
    //The input is validated and returned back to main
    public static char askUser(Scanner input){
        char option, optionReturn;
        System.out.print("Would you like to create a custom car?"+
                         "\nEnter 'y' for yes or 'n' for no:");
        option = input.next().charAt(0);
        optionReturn = UtilityMethods.askIfYesOrNo(input, option);
        return optionReturn;
    }
    //This method asks the user if they would like to do a speed test.
    //The input is validated and returned back to main
    public static char askUser2(Scanner input){
        char option, optionReturn;
        System.out.print("Would you like to do a speed test?"+
                         "\nEnter 'y' for yes or 'n' for no:");
        option = input.next().charAt(0);
        optionReturn = UtilityMethods.askIfYesOrNo(input, option);
        return optionReturn;
        
    }
    
    //This method gets the year of the car from the user and returns it to main.
    //This method has some validation to make sure the number is valid.
    public static String getUserYear(Scanner input){
       int year;
       System.out.print("What year is your car: ");
          String str = input.next();
            for(int i = 0; i < str.length();){
                if(isDigit(str.charAt(i))){
                    i++;
                }
                else{
                    while(!(isDigit(str.charAt(i)))){
                        System.out.print("Invalid year, please enter a year: ");
                        str = input.next();
                        i = 0;
                    }
                }            
            }
        return str;
    }
    
    //This method gets the custom make of the car from the user. 
    //The information is then passed to main where the object method is used to set
    //the name of the car.
    public static String getUserMake(Scanner input){
       String userMake, userMake0;
       System.out.print("What make is your car? (Chevrolet, Toyota, Honda): ");
       userMake = input.next();
       userMake0 = UtilityMethods.verifyString(input, userMake);
       return userMake0;
    }
    
    //This method calls the class method object.accelerate() to speed up the car.
    public static void accelerateObject(Car carObject){
            int printSpeed;
            carObject.accelerate();
            printSpeed = carObject.getSpeed();
            System.out.println("The speed of the car is "+ printSpeed+ "mph.");
    }
    
    //This method calls the class method object.brake() to slow down the cars speed.
    public static void deccelerateObject(Car carObject){
            int printSpeed;
            carObject.brake();
            printSpeed = carObject.getSpeed();
            System.out.println("The speed of the car is "+ printSpeed+ "mph.");
    }
    //This method allows the user to set up a speed test with a custom speed that is less than
    //60 miles per hour. This method performs data validation to ensure it is a valid number less 
    //than 60. 
    public static void userSetSpeed(Scanner input, Car carObject){
        int speed, length;
        String speedStr;
        System.out.println("Enter a speed of 60mph or less for safety reasons: ");
        speedStr = input.next();
        length = speedStr.length();
        for(int i = 0; i<length; i++){
            char testChar = speedStr.charAt(i);
            
            if(Character.isDigit(testChar)){
            }
            else {
                i = 0;
                length = 0;
                System.out.print("You have entered an invalid speed."+
                                 "\nEnter a speed of 60mph or less:");
                speedStr = input.next();
                length = speedStr.length();
            }
        }
        speed = Integer.parseInt(speedStr);
        while(speed > 60){
            System.out.println("Enter a speed of 60mph or less for safety reasons: ");
        speed = input.nextInt();
        }
            carObject.setSpeed(speed);
    }
}

