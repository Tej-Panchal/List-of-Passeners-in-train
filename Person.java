/*
- Name: Tejkumar Panchal
- CSC-20
- This project is about the list of the passengers in the train.
In that list they will provide you that passenger's first and last
name, Passenger's contact number, Seatnumber and passenger's class 
prefrence means, first class,coach class or business class.
After that you can also find the passenger by typing last name.
If you want to remove passenger you just have to enter the last name
of that passenger. And in the last it will give the updated list of 
the passenger.
*/

import java.util.*;

/*
This is a Person class and it is public class
Means it is a Parent class of the project, it contians 
so many important method for the project.
*/
public class Person {
   
   private String name;
   private String last;
   private String contact;
   
   // Declare Name, Last and Conatact as a String type.
   public Person(String name, String last, String contact) {
      this.name = name;
      this.last = last;
      this.contact = contact;
   }
   
   public Person() {
      name = null;
      last = null;
      contact = null;
   }
   
   // Get name Method
   public String getName() {
      return name;
   }
   
   // Get Last Method
   public String getLast() {
      return last;
   }
  
   // Get Pgone Mehtod and return the contact number
   public String getPhone() {
      return contact;
   }
  
   public void setName(String name) {
      this.name = name;
   }
   
   public void setLast(String last) {
      this.last = last;
   }
   
   // This is a equals method of the class its return type is boolean
   public boolean equals(Object o) {
      if (o instanceof Person) {
         Person p = (Person)o;
         return p.last.equalsIgnoreCase(this.last);
      } else {
         return false;
      }
   }
   
   // ToString method to get the structure of the output
   @Override
   public String toString() {
      return "\nName: " + name + "\nLast : "+ last + "\ncontact: "+ contact;
   }
}
//this class must extend the person class
class Passenger extends Person {
   
   // Declare Seatnumber and class type of the Passenger
   private int SeatNumber;
   private String Class;
   
   public Passenger(String name, String last, String contact,int SeatNumber, String Class) {
      super(name,last,contact);
      this.SeatNumber = SeatNumber;
      this.Class = Class;
   }
   
   public Passenger() {
      SeatNumber = 0;
      Class = null;
   }
   public int getSeatNumber() {
      return SeatNumber;
   }
   
   public String getclass() {
      return Class;
   }
   
   public void setSeatNumber(int SN) {
      this.SeatNumber = SN;
   }
   
   public void setClass(String C) {
      this.Class = C;
   }
   
   // This is a toString method of the passenger class, 
   // this method will aslo call the other toString method from the parent class 
   @Override
   public String toString() {
      String t = super.toString();
      return t + "\nSeatNo.= " + SeatNumber + "\nClass= " + Class;
   }
}

// This is interface list to search and delete the passenger from the list
interface list {
  
   public boolean add(Object o); 
   public Object search(Object o);
   public boolean delete(Object o);
   public void printLast();

}

/*
This is a Train class which has the implements list 
to update the passenger's list
*/
class Train implements list {
   Passenger[] train;  //list of the passengers
   private static int count = 0; // number of the passengers in the train
   
   public Train() {
      train = new Passenger[5];
   }
   
   public static int getCount() {
      return count;
   }
   
   //Implement the toString method by using a for loop traversing the list(array) of the passengers.
   public String toString() {
      String x="";
      // Use the if statement to compare the length of the passenger's list 
      if(train.length>0)
      {
         // For loop to get the x which is String
         for(int i = 0; i<count; i++) {
            
            if (train[i] != null) {
            x= x +(train[i].toString())+ "\n";
            }
         } 
      }
      return x;
   }
   
   /*
   This method gets the Object o as its parameter. 
   This method must check the class type of the Object o 
   by using the keyword instanceof. if the type is of type Passenger, 
   type cast it to the Passenger class then add it to the array. 
   */
   @Override
   public boolean add(Object o) {
      if (o instanceof Passenger) {
         Passenger p = (Passenger)o;
         train[count] = p;
         count++;
         return true;
      } else {
         return false;
      }
   } 
   
   /*
   This method gets the Object o as its parameter. 
   However, the Object o represents the passenger’s last name
   therefore using the keyword instanceof we check 
   the class of the Object o to see if it is string type.
   if it is then type cast o to String class. 
   Then search the array using the last name. 
   */
   @Override
   public Object search(Object o) {
      boolean b = o instanceof String; 
      if(!b) {
         return null;
      }
      String name = (String)o; 
      for(int i = 0; i < count; i++) {
         if(train[i].getLast().equalsIgnoreCase(name)) { 
            return train[i]; 
         }
      }
      return null;
   }
   
   /*
   This method is very similar to the search method. 
   Once you find the passenger in the list, 
   delete it from the list by setting it to null.
   */
   @Override
   public boolean delete(Object o) { 
      boolean b = o instanceof String; 
      int D = 0;
      if(!b) { 
         return false;
      }
      String name = (String)o; 
      for(int i = 0; i <= count; i++) {
         if(train[i].getLast().equalsIgnoreCase(name)) { 
            D = i;
         }
      }
      if (D == 0 || D != 0) {
         train[D] = null;
         count--;
         return true; 
      }
      
      return false;
   }
   
   // This method uses a for loop to display the last name of the passengers in the train. 
   @Override
   public void printLast() {
      for (int i = 0; i<train.length; i++) {
         System.out.println(train[i].getLast());
      }
   }
 
}

/*
This is a Tester class of the project which will 
print the code and the give the list and ask the 
user to enter the name to get the information or
to do editing in the list.
*/
class Driver {
   public static void main(String[] args) { 
   
      // Instantiate an object of the Train class
      Train myTrain = new Train();
      
      // Scanner object 
      Scanner s = new Scanner(System.in);
      System.out.println("Here is the list of the passengers in this train:");

      Passenger p1 = new Passenger ("Alex", "Mano","123-456-7893", 12, "First class");
      
      Passenger p2 = new Passenger ("Mary", "Trump","123-456-4894", 23, "Coach class");
    
      Passenger p3 = new Passenger ("Ali", "Busta","123-456-7890", 34, "Business class");
   
      Passenger p4 = new Passenger ("Jose", "Rodrigues","123-222-7899", 22, "First class");
      
      Passenger p5 = new Passenger ("Tej", "Panchal","123-445-8907", 43, "Business class");
      
      myTrain.add(p1);
      myTrain.add(p2);
      myTrain.add(p3); 
      myTrain.add(p4); 
      myTrain.add(p5); 
      
      System.out.println(myTrain.toString());
      System.out.println("Testing the static method getCount  \n");
 
      System.out.println("This train has " + Train.getCount() + " Passengers\n");
      
      /* Prompt the user for a last name to search the list of the passengers. 
      If the passenger found in the list display their information.
      */
      System.out.println("Testing the search method.");
      System.out.println("Enter the last name of the passenger: \n");
      String answer = s.nextLine(); 
      Passenger P=(Passenger)myTrain.search(answer);
      System.out.println(P.toString());
      
      System.out.println("");
      
      // Strat the delete method to get the passenger out of the list
      System.out.println("Testing the delete method.\n");
      
      System.out.println("Enter the last name of the passenger: \n");
      answer = s.nextLine(); 
     
      if(myTrain.delete(answer))
      {
         System.out.println("Passenger "+ answer + " has been removed from the list");
      }
      else
      {
         System.out.println("Passenger "+ answer + " is NOT present in the train");
              
      }
      
      myTrain.printLast();
      
      // It will print the updated list of the passengers.
      System.out.println("Print the Updated list:"); 
      System.out.println(myTrain.toString());
   }
}
