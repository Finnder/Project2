import java.util.Scanner;

/*
Written By: Finnegan McGuire
Date: 3/6/2021
Class: CSC120-N890: Computing Fundementals 1
Prof: Colson Dunlap
*/

public class Project2
{
   public static void main(String[] args)
   {
      // Scanner to get user keyboard input
      Scanner keyboard = new Scanner(System.in);
      
      // Initiating Variables For Future Use
      int gpuSpeed;
      int cpuSpeed;
      int amountOfCores;
      int menuChoice;
      int userResolutionChoice;
      
      double multiplier;
      double performanceScore;
      
      String output;
      
      // Getting Computer Information From User
      System.out.print("Enter The Clock Speed (In Megahertz) Of Your Graphics Card (GPU): ");
      gpuSpeed = keyboard.nextInt();
      
      System.out.print("Enter The Clock Speed (In Megahertz) Of Your Processor(CPU): ");
      cpuSpeed = keyboard.nextInt();
      
      System.out.print("Enter The Number Of Cores Your Processor(CPU) Has: ");
      amountOfCores = keyboard.nextInt();
      
      System.out.println("1. 1280 x 720");
      System.out.println("2. 1920 x 1080");
      System.out.println("3. 2560 x 1440");
      System.out.println("4. 3840 x 2160");
      System.out.print("Please select from the options above: ");
      userResolutionChoice = keyboard.nextInt();
      
      //Changing Multiplier Depending On The Users Resolutions Choice
      if(userResolutionChoice == 1)
      {
         multiplier = 1;
      }
      else if(userResolutionChoice == 2)
      {
         multiplier = 0.75;
      }
      else if(userResolutionChoice == 3)
      {
         multiplier = 0.50;
      }
      else
      {
         multiplier = 0.25;
      }
      
      //Performance Score Equation
      performanceScore = ((5 * gpuSpeed) + (amountOfCores * cpuSpeed)) * multiplier;
      
      //Determining Recommended Graphics Quality
      if(performanceScore >= 17000)
      {
         output = "Ultra";
      }
      else if(performanceScore > 15000 && performanceScore < 17000)
      {
         output = "High";
      }
      else if(performanceScore > 13000 && performanceScore < 15000)
      {
         output = "Medium";
      }
      else if(performanceScore > 11000 && performanceScore < 13000)
      {
         output = "Low";
      }
      else
      {
         output = "Unable To Play";
      }
      
      // FINAL OUTPUT TO CONSOLE
      System.out.println("Recommended Graphics Quality: " + output);
   }
}