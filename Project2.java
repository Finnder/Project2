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
      int totalComputers;
      
      double highestPerformanceScore = 0;
      double lowestPerformanceScore = 0;
      boolean firstComputer = true;
      
      String resolution1 = "1280 x 720";
      String resolution2 = "1920 x 1080";
      String resolution3 = "2560 x 1440";
      String resolution4 = "3840 x 2160";
      
      System.out.print("How many computers are being processed? ");
      totalComputers = keyboard.nextInt();
      
      while(totalComputers > 0){
      // Initiating Variables For Future Use
      int gpuSpeed;
      int cpuSpeed;
      int amountOfCores;
      int menuChoice;
      int userResolutionChoice;
      String stringResolutionChoice = "";
      
      double multiplier = 0;
      double performanceScore;
      
      String output;
      // Getting info on the amount of computers
      
      // Getting Computer Information From User
      System.out.print("Enter The Clock Speed (In Megahertz) Of Your Graphics Card (GPU): ");
      gpuSpeed = keyboard.nextInt();
      
      while(gpuSpeed < 800 || gpuSpeed > 2000)
      {
         System.out.println("ERROR: Gpu speed must be greater then or equal too 800 OR less then or equal too 2000");
         System.out.print("Enter The Clock Speed (In Megahertz) Of Your Processor(GPU): ");
         gpuSpeed = keyboard.nextInt();
      }
      
      System.out.print("Enter The Clock Speed (In Megahertz) Of Your Processor(CPU): ");
      cpuSpeed = keyboard.nextInt();
      
      while(cpuSpeed < 1000 || cpuSpeed > 5500)
      {
         System.out.println("ERROR: Cpu speed must be greater then or equal too 1000 OR less then or equal too 5500");
         System.out.print("Enter The Clock Speed (In Megahertz) Of Your Processor(CPU): ");
         cpuSpeed = keyboard.nextInt();
      }
      
      System.out.print("Enter The Number Of Cores Your Processor(CPU) Has: ");
      amountOfCores = keyboard.nextInt();
      
      while(amountOfCores < 1 || amountOfCores > 16)
      {
         System.out.println("ERROR: You must input a number from 1 - 16");
         System.out.print("Enter The Number Of Cores Your Processor(CPU) Has: ");
         amountOfCores = keyboard.nextInt();    
      }
      
      System.out.println("1. " + resolution1);
      System.out.println("2. " + resolution2);
      System.out.println("3. " + resolution3);
      System.out.println("4. " + resolution4);
      System.out.print("Please select from the options above: ");
      userResolutionChoice = keyboard.nextInt();
      
      while(userResolutionChoice < 1 || userResolutionChoice > 4)
      {
         System.out.println("Please use a number from the list");
         System.out.println("1. " + resolution1);
         System.out.println("2. " + resolution2);
         System.out.println("3. " + resolution3);
         System.out.println("4. " + resolution4);
         System.out.print("Please select from the options above: ");
         userResolutionChoice = keyboard.nextInt();
      }
      
      //Changing Multiplier Depending On The Users Resolutions Choice

      if(userResolutionChoice == 1)
      {
         multiplier = 1;
         stringResolutionChoice = resolution1;
      }
      else if(userResolutionChoice == 2)
      {
         multiplier = 0.75;
         stringResolutionChoice = resolution2;
      }
      else if(userResolutionChoice == 3)
      {
         multiplier = 0.50;
         stringResolutionChoice = resolution3;
      }
      else if (userResolutionChoice == 4)
      {
         stringResolutionChoice = resolution4;
         multiplier = 0.25;
      }
      
      //Performance Score Equation
      performanceScore = ((5 * gpuSpeed) + (amountOfCores * cpuSpeed)) * multiplier;
      
      System.out.println(" ");
      System.out.println("GPU Clock Speed: " + gpuSpeed + " MHz");
      System.out.println("CPU Clock Speed: " + cpuSpeed + " MHz");
      System.out.println("Number Of Cores: " + amountOfCores);
      System.out.println("Monitor Resolution: " + stringResolutionChoice);
      System.out.printf("Performance Score: %.3f\n", performanceScore);
      
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
      
      if(performanceScore > highestPerformanceScore)
      {
         highestPerformanceScore = performanceScore;
      }
      
      // Detecting the lowest performance score
      if(firstComputer){
         lowestPerformanceScore = performanceScore;
         firstComputer = false;
      } else {
         if(performanceScore < lowestPerformanceScore)
         {
            lowestPerformanceScore = performanceScore;
         }
      }
      
      // FINAL OUTPUT TO CONSOLE
      System.out.println("Recommended Graphics Quality: " + output + "\n");
      
      // Subtracting the computers by one
      totalComputers--;
      }
      
      
      System.out.printf("The highest performance score was: %.3f\n", highestPerformanceScore);
      System.out.printf("The lowest performance score was: %.3f\n", lowestPerformanceScore);
      
   }
}