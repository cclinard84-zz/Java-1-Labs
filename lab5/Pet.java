/*
 * File: Pet.java
 * Author: Christopher Matthew Clinard
 * Date: 11/10/16
 * This file is utilized by PetTest.java to create new car objects.
 */
package lab5;

public class Pet {
  private String name;
  private String type;
  private int age;
  
  
  //No arg constructor
  public Pet(){
  
  }
  
  //Constructor
  public Pet(String str1, String str2, int num1){
      name = str1;
      type = str2;
      age = num1;
    
  }
  
  //set method for name
  public void setName(String str){
    name = str;
  }
  
  //set method for type
  public void setType(String str){
    type = str;
  }
  
  //set method for age
  public void setAge(int num){
    age = num;
  }
  
  //get method for name
  public String getName(){
    return name;
  }
  
  //get method for type
  public String getType(){
    return type;
  }
  
  //get method for age
  public int getAge(){
    return age;
  }
  
  //toString method for output
  public String toString(){
    String output = "The pet is a "+ type+  "."+
                    "\nThe name of the "+ type+ " is "+ name+ "."+
                     "\n"+ name+ " is "+ age+ " year(s) old.";
    return output;
  }
}
