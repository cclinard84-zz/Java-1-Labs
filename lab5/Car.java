/*
 * File: Car.java
 * Author: Christopher Matthew Clinard
 * Date: 11/10/16
 * This file is utilized by CarTest.java to create new car objects.
 */
package lab5;

public class Car {
    private int yearModel;
    private int speed;
    private String make;
    
    //No arg constructor. Sets speed equal to 0
    public Car(){
        speed = 0;
    }
    
    //Constructor
    public Car(int num1, String carStr){
        yearModel = num1;
        make = carStr;
        speed = 0;
    }
    
    //accelerate method used to increase speed
    public void accelerate(){
        speed += 5;
    }
    
    //brake method used to deccelerate speed
    public void brake(){
        speed -= 5;
    }
    
    //get method to return yearModel of car
    public int getYearModel(){
        return yearModel;
    }
    
    //get method used to return speed of car
    public int getSpeed(){
        return speed;
    }
    
    //get method used to return make of car
    public String getMake(){
        return make;
    }
    
    //set method used to set yearModel of car
    public void setYearModel(int num1){
        yearModel = num1;
    }
    
    //set method used to set the speed of the car
    public void setSpeed(int num1){
        speed = num1;
    }
    
    //set method used to set the make of the car
    public void setMake(String str1){
        make = str1;
    }
    
    //toString method used to return the output for
    //the user to see the attributes of the car.
    public String toString(){
        String speedStr = Integer.toString(speed);
        String yearModelStr = Integer.toString(yearModel);
        String output = "The year of the car is "+ yearModelStr+ "."+
                        "\nThe make of the car is "+ make+ "."+
                        "\nThe speed of the car is "+ speedStr+ "mph.";
        return output;
    }
}
