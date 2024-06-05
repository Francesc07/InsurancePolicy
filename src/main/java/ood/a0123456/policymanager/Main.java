/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ood.a0123456.policymanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author FRANCIS IKENNA OKOYE. C2680301
 */
public class Main {
    /**
     * This is the main method that starts the policy management program.
     * It displays a menu of options and allows the user to perform various operations on policies.
     * The program continues to run until the user chooses to exit.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
       
        int option = -1;
        while (option != 0) {
            System.out.println(" ");
            System.out.println("PRESS 1 to Enter new policy\nPRESS 2 to Display Summary of policies\nPRESS 3 to Display Summary for selected month\nPRESS 4 to Find and display policy\nPRESS 0 to Exit");
            System.out.println("SELECT OPTION: ");
            
          
               try {
        option = input.nextInt();
    } catch (InputMismatchException e) {
        System.out.println("Invalid input! Please enter a number.");
        input.next(); 
        continue;
           } 
            switch (option) {
    case 0:
        System.out.println("PROGRAM ENDED");
        break;
    case 1:
        enterNewPolicy();
        break;
    case 2:
        displaySummaryOfPolicies();
        break;
    case 3:
        displaySummaryForSelectedMonth();
        break;
    case 4:
        findAndDisplayPolicy();
        break;
    default:
        System.out.println("WRONG INPUT!!! SELECT AN VALID OPTION ");
        option = input.nextInt();
        break;
}
        }
    }
    /**
     *This method enters a new policy into the system.
     * Prompts the user to enter the client's name, client reference number, number of gadgets, gadget value,
     * excess amount, and payment terms.
     * Validates the input for reference number, gadget number, gadget value, and excess amount.
     * Creates a new Policy object based on the entered information.
     * Saves the policy details to a text file.
     */
    private static void enterNewPolicy() {
    Scanner input = new Scanner(System.in);

            System.out.println("ENTER NEW POLICY");
            System.out.println("ENTER CLIENT NAME: ");
                String clientName = input.nextLine();

                System.out.println("ENTER CLIENT REFERENCE NUMBER: ");
            String reference = input.next();
                     while (reference.length() != 6) {
        System.out.println("Invalid Ref number!!!");
        System.out.println("Reference number must be 6 alphanumeric char: ");
       reference = input.next();
    }
            int gadgetNum = 0;
                while (true) {
               try {
        System.out.println("ENTER NUMBER OF GADGET: ");
        gadgetNum = input.nextInt();
        break;
     } catch (InputMismatchException e) {
        System.out.println("Invalid input: please enter a valid integer.");
        input.next(); 
    }
        }

            int maxGadget = 0;
            while (true) {
            try {
        System.out.println("ENTER GADGET VALUE: ");
        maxGadget = input.nextInt();
        break;
             } catch (InputMismatchException e) {
            System.out.println("Invalid input: please enter a valid integer.");
                input.next(); 
               }
                }

                double excess = 30;
                while (true) {
                try {
                         System.out.print("ENTER EXCESS AMOUNT\n (default: £30, max: £70 in multiples of 10): £");
                    excess = input.nextDouble();
                    if (excess < 30 || excess > 70 || excess % 10 != 0) {
            throw new IllegalArgumentException("Invalid input: excess amount must be between £30 and £70 in multiples of 10.");
                     }
                     break;
                } catch (InputMismatchException e) {
             System.out.println("Invalid input: please enter a valid number.");
                input.next();
                 } catch (IllegalArgumentException e) {
              System.out.println(e.getMessage());
                  }
                        }
              
                System.out.println("ENTER PAYMENT TERMS (M for MONTHLY OR  A for ANNUALLY)");
                 String paymentTerms = input.next();
           
            
            Policy policy1 = new Policy(clientName, reference, paymentTerms, maxGadget, gadgetNum, excess);
            String currentDate = DateHelper.getDate();
            String toString = policy1.toString();
            
       
        {
        try (PrintWriter writer = new PrintWriter(new FileWriter("policy.txt", true))) {
     writer.print(currentDate+"\t"+reference+"\t"+gadgetNum+"\t"+Math.round(maxGadget * 100)+"\t"+Math.round(   policy1.displayPremium()*100)+"\t"+ policy1.paymentStatus().toUpperCase()+"\t"+clientName);
     writer.println();          
     writer.close();
     System.out.println("File saved successfully.");
     } catch (IOException e) {
            e.printStackTrace();
       }
        }
     }
    /** This method displays a summary of policies.
     * Prompts the user to select either current policies or archived policies.
     * Reads the policy details from a text file and calculates various statistics based on the policies.
     * Prints the total number of policies, average number of items for accepted policies,
     * average monthly premium for accepted policies,
     * and the number of policies per month.
     */
    private static void displaySummaryOfPolicies(){    
     Scanner input = new Scanner(System.in);
      System.out.println("");
      System.out.println("PRESS 1 FOR CURRENT POLICY");
      System.out.println("PRESS 2 FOR ARCHIVE POLICY");
      int  policy;
       try {
        policy = input.nextInt();
    } catch (InputMismatchException e) {
        System.out.println("Invalid input! Please enter a valid integer.");
        input.nextInt();
        return;
    }
      int policyCount = 0;
        int fileCount = 0;
        int totalItemCount = 0;
        int premiumCount = 0;
        int monthlyTerm = 0;
        int jan = 0;
        int feb = 0;
        int mar = 0;
        int apr = 0;
        int may = 0;
        int jun = 0;
        int jul = 0;
        int aug = 0;
        int sep = 0;
        int oct = 0;
        int nov = 0;
        int dec = 0;
      switch (policy){
              case 1 : {
                  try {
                      File file = new File("policy.txt");
                      Scanner scanner = new Scanner(file);
                      while (scanner.hasNextLine()) {
                          String line = scanner.nextLine();
                          String[] parts = line.split("\t");
                          String date = parts[0];
                          String term = parts[5];
                          String[] dateStr = date.split("-");
                          String month = dateStr[1];
                          if (null != month)switch (month) {
                              case "Jan" : jan++;
                              break;
                              case "Feb" : feb++;
                              break;
                              case "Mar" : mar++;
                              break;
                              case "Apr" : apr++;
                              break;
                              case "May" : may++;
                              break;
                              case "Jun" : jun++;
                              break;
                              case "Jul" : jul++;
                              break;
                              case "Aug" : aug++;
                              break;
                              case "Sep" : sep++;
                              break;
                              case "Oct" : oct++;
                              break;
                              case "Nov" : nov++;
                              break;
                              case "Dec" : dec++;
                              break;
                              default: {
                              }
                          }
                          if ("M".equals(term) || "A".equals(term)){
                              int item = Integer.parseInt(parts[2]);
                              int premium = Integer.parseInt(parts[4]);
                              totalItemCount += item;
                              premiumCount += premium;
                              policyCount++;
                              monthlyTerm++;
                              
                          }
                          
                          fileCount++;
                          
                      }
                      double acceptedAverage = (double) totalItemCount / policyCount;
                      double monthlyAverage = (((double) premiumCount / monthlyTerm)/100);
                      System.out.println("Total number of policies: " + fileCount );
                      System.out.println("Average number of Items (Accepted policies): " + acceptedAverage);
                      System.out.println("Average monthly premium for accepted policies: " + Math.round(monthlyAverage * 100.0)/100.0);
                      System.out.println("Number of policies per month (Inc non-acceptance):");
                      System.out.println("");
                      System.out.println("Jan\tFeb\tMar\tApr\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec");
                      System.out.println("");
                      System.out.println(jan+"\t"+feb+"\t"+mar+"\t"+apr+"\t"+may+"\t"+jun+"\t"+jul+"\t"+aug+"\t"+sep+"\t"+oct+"\t"+nov+"\t"+dec);
                      
                  } catch (IOException e) {
                      e.printStackTrace();
                  } break;          }
              case 2 : {
                  try {
                      File file = new File("archive.txt");
                      Scanner scanner = new Scanner(file);
                      while (scanner.hasNextLine()) {
                          String line = scanner.nextLine();
                          String[] parts = line.split("\t");
                          String date = parts[0];
                          String[] dateStr = date.split("-");
                          String month = dateStr[1];
                          if (null != month)switch (month) {
                              case "Jan" : jan++;break;
                              case "Feb" : feb++;break;
                              case "Mar" : mar++;break;
                              case "Apr" : apr++;break;
                              case "May" : may++;break;
                              case "Jun" : jun++;break;
                              case "Jul" : jul++;break;
                              case "Aug" : aug++;break;
                              case "Sep" : sep++;break;
                              case "Oct" : oct++;break;
                              case "Nov" : nov++;break;
                              case "Dec" : dec++;break;
                              default : {
                              }
                              
                          }
                          String term = parts[5];
                          if ("M".equals(term)){
                              int premium = Integer.parseInt(parts[4]);
                              monthlyTerm++;
                              premiumCount += premium;
                          }
                          int item = Integer.parseInt(parts[2]);
                          if (item >= 1 && item <= 5) {
                              totalItemCount += item;
                              policyCount++;
                              
                          }
                          fileCount++;
                      }
                      
                      double acceptedAverage = (double) totalItemCount / policyCount;
                      double monthlyAverage = (((double) premiumCount / monthlyTerm)/100);
                      System.out.println("Total number of policies: " + fileCount);
                      System.out.println("Average number of Items (Accepted policies): " + Math.round(acceptedAverage));
                      System.out.println("Average monthly premium for accepted policies: " + Math.round(monthlyAverage*100.0)/100.0);
                      System.out.println("Number of policies per month (Inc non-acceptance):");
                      System.out.println("");
                      System.out.println("Jan\tFeb\tMar\tApr\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec");
                      System.out.println("");
                      System.out.println(jan+"\t"+feb+"\t"+mar+"\t"+apr+"\t"+may+"\t"+jun+"\t"+jul+"\t"+aug+"\t"+sep+"\t"+oct+"\t"+nov+"\t"+dec);
                      
                  } catch (IOException e) {
                      e.printStackTrace();
                  } break;    }
              default : System.out.println("Invalid selection!\n Please select either 1 for current policy \n Or 2 archive policy");
                   
      }
      
      System.exit(0);
      
 }
     /**
      *This method displays a summary of policies for a specific month.
      *Prompts the user to select either current policies or archived policies.
      * Reads the policy details from a text file,
      * and calculates various statistics based on the policies for the specified month.
      * Prints the total number of policies, average monthly policy fee, and percentage for price bands.
      */  
    private static void displaySummaryForSelectedMonth(){
        
     Scanner input = new Scanner (System.in);
     System.out.println("");
     System.out.println("PRESS 1 FOR CURRENT POLICY");
        System.out.println("PRESS 2 FOR ARCHIVE POLICY");
     int policy = input.nextInt();
     while (policy ==1 || policy == 2){
     System.out.println("ENTER MONTH\n Type the abbreviation only e.g jan for January ");
     String month = input.next();
     int monthCount = 0;
     int termCount = 0;
     int premiumCount = 0;
     int itemCount500 =0;
     int itemCount800 = 0;
     int itemCount1000 = 0;
     double itemCount = 0.00;
     double itemPercent500 =  0.00;
     double itemPercent800 = 0.00;
     double itemPercent1000 =  0.00;
     double average;
     switch (policy){
         case 1 : {
             try {
                     File file = new File("policy.txt");
                     Scanner scanner = new Scanner(file);
                     while (scanner.hasNextLine()) {
                         String line = scanner.nextLine();
                         String[] parts = line.split("\t");
                         String date = parts[0];
                         String[] dateStr = date.split("-");
                            String month1 = dateStr[1];
                             int item3 = Integer.parseInt(parts[3]);
                             
                              if (month.equalsIgnoreCase(month1)){
                                  itemCount += item3;
                              int premium = Integer.parseInt(parts[4]);
                               monthCount++;
                              premiumCount += premium;
                              termCount++;
                              if (item3 > 99 && item3 <= 50000) {
                                  itemCount500 +=item3;
                              itemPercent500 = (itemCount500 * 100) / itemCount;}
                              if (item3 > 50000 && item3 <= 80000) {
                                  itemCount800 += item3;
                               itemPercent800 = (itemCount800 * 100) / itemCount;}
                              if (item3 > 80000 && item3 <= 100000) {
                                  itemCount1000 += item3;
                                  itemPercent1000 = (itemCount1000 * 100) / itemCount;}
                                                     
                                                                 }
                              }
                     average = premiumCount/termCount;
                     System.out.println("");
                     System.out.println("Total Number of policies for " + month.toUpperCase() +": "+ monthCount);
                     System.out.println("Average monthly policy fee: " + average);
                     System.out.println("Percentage for price band 500 is : "+ Math.round(itemPercent500*100.0)/100.0+"%");
                     System.out.println("Percentage for price band 800 is : "+ Math.round(itemPercent800*100.0)/100.0+"%");
                     System.out.println("Percentage for price band 1000 is : "+ Math.round(itemPercent1000*100.0)/100.0+"%");
                  System.exit(0);
             }catch(FileNotFoundException e) {
                     System.out.println("Policy Not found");
                 } 
             }
               break;
         
                           case 2 : {
                 try {
                     File file = new File("archive.txt");
                     Scanner scanner = new Scanner(file);
                     while (scanner.hasNextLine()) {
                         String line = scanner.nextLine();
                         String[] parts = line.split("\t");
                         String date = parts[0];
                         String[] dateStr = date.split("-");
                            String month1 = dateStr[1];
                             int item3 = Integer.parseInt(parts[3]);
                             
                              if (month.equalsIgnoreCase(month1)){
                                  itemCount += item3;
                              int premium = Integer.parseInt(parts[4]);
                               monthCount++;
                              premiumCount += premium;
                              termCount++;
                              if (item3 > 99 && item3 <= 50000) {
                                  itemCount500 +=item3;
                              itemPercent500 = (itemCount500 * 100) / itemCount;}
                              if (item3 > 50000 && item3 <= 80000) {
                                  itemCount800 += item3;
                               itemPercent800 = (itemCount800 * 100) / itemCount;}
                              if (item3 > 80000 && item3 <= 100000) {
                                  itemCount1000 += item3;
                                  itemPercent1000 = (itemCount1000 * 100) / itemCount;}
                                                     
                                                                 }
                              }
                     average = premiumCount/termCount;
                     System.out.println("");
                     System.out.println("Total Number of policies for " + month.toUpperCase() +": "+ monthCount);
                     System.out.println("Average monthly policy fee: " + average);
                     System.out.println("Percentage for price band 500 is : "+ Math.round(itemPercent500*100.0)/100.0+"%");
                     System.out.println("Percentage for price band 800 is : "+ Math.round(itemPercent800*100.0)/100.0+"%");
                     System.out.println("Percentage for price band 1000 is : "+ Math.round(itemPercent1000*100.0)/100.0+"%");
                 System.exit(0);
                 }catch(FileNotFoundException e) {
                     System.out.println("Policy Not found");
                 } 
                 break;
             }
               default:System.out.println( "Wrong Input Select 1 or 2 for either policy"); 
                   
     }
         
             
    }
     
 System.out.println( "Wrong Input Select 1 or 2 for either policy");
            
    }
    /**
     * This method finds and displays policy details based on a search keyword.
     * Prompts the user to select either current policies or archived policies.
     * Reads the policy details from a text file,
     * and searches for lines containing the specified keyword.
     * Prints the matching lines found or displays a message if no matches are found.
     * @param 
     */
    private static void findAndDisplayPolicy(){
       System.out.println("");
    Scanner input = new Scanner(System.in);
    System.out.println("SELECT 1 FOR CURRENT POLICY");
    System.out.println("SELECT 2 FOR ARCHIVE POLICY");
    int policy = input.nextInt();
    input.nextLine();
        System.out.println("ENTER SEARCH KEYWORD");
        String search = input.nextLine();
    String fileName;
        switch (policy) {
            case 1:
                fileName = "policy.txt";
                break;
            case 2:
                fileName = "archive.txt";
                break;
            default:
                System.out.println("Invalid policy selected.");
                return;
        }

    try {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        boolean found = false;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.contains(search)) {
                found = true;
                System.out.println(line);
            }
        }

        if (!found) {
            System.out.println("No matching result found.");
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
    }
         catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    } finally {
        input.close();
}
}

  

}
    
    
    

     
 
       

