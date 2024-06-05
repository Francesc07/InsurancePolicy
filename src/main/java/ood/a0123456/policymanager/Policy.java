/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ood.a0123456.policymanager;

/**
 * This class represents a policy and calculates premiums based on different factors.
 * @author FRANCIS IKENNA OKOYE. C2680301
 */

public class Policy {

    private final double discount40 = 0.05; // Discount percentage for excess of £40
    private final double discount50 = 0.1;  // Discount percentage for excess of £50
    private final double discount60 = 0.15;  // Discount percentage for excess of £60
    private final double discount70 = 0.2;   // Discount percentage for excess of £70
    private final double annualDiscount = 0.1;  // Annual discount percentage
    private final int maxGadget1 = 500;     // Maximum value for gadget category 1
    private final int maxGadget2 = 800;     // Maximum value for gadget category 2
    private final int maxGadget3 = 1000;    // Maximum value for gadget category 3
    private String term;         // Term of the policy
    private final String clientName;     // Name of the client
    private final String reference;     // Reference number of the policy
    private final String paymentTerms;      // Payment terms of the policy
    private final int maxGadget;            // Maximum value for the gadget category
    private final int gadgetNum;        // Number of gadgets
    private double aPremium;            // Annual premium
    private final double excess;        // Excess amount
    private double premium1;            
    private double monthlyPremium;      // Monthly premium
    private double premium;             // Total premium
    private double year;                
    private String maxValue;
    private String status;               // Maximum value for the gadget category
    private double prem;                 // Premium amount

    /**
     * Constructs a new Policy object with the given parameters.
     *
     * 
     * @param clientName    the name of the client
     * @param reference     the reference number of the policy
     * @param paymentTerms  the payment terms of the policy
     * @param maxGadget     the value of gadgets
     * @param gadgetNum     the number of gadgets
     * @param excess        the excess amount
     */
    public Policy(String clientName, String reference, String paymentTerms, int maxGadget, int gadgetNum, double excess){
        
        this.clientName = clientName;
        this.reference = reference;
        this.paymentTerms = paymentTerms;
        this.maxGadget = maxGadget;
        this.gadgetNum = gadgetNum;
        this.excess = excess;
        
       
    
    }
   
 /**
 * Retrieves the reference number of the policy.
 *
 * @return the reference number of the policy
 */
    public String reference(){
         
   
    return reference;
}
     
 /**
 * Retrieves the textual representation of the gadget number.
 * for gadget number 1 to 5
 * 
 * @return the textual representation of the gadget number
 */  
    public String gadgetNum(){
        
        if (gadgetNum >= 1 && gadgetNum <= 5) {
    switch (gadgetNum) {
        case 1:
            return "One";
        case 2:
            return "Two";
        case 3:
            return "Three";
        case 4:
            return "Four";
        case 5:
            return "Five";
        default:
            break;
    }
}

return String.valueOf(gadgetNum);

    }
 /**
 * Retrieves the maximum gadget value as a string based on the given maximum gadget amount.
 *
 * @return the maximum gadget value as a string
 */
    public String gadgetValue(){

if (maxGadget <= 500 && maxGadget > 0) {
    maxValue = "500";
} else if (maxGadget <= 800) {
    maxValue = "800";
} else if (maxGadget <= 1000) {
    maxValue = "1000";
} else {
    maxValue = "Rejected";
}

return maxValue;

    }
/**
 * Calculates and returns the monthly premium based on the gadget number and maximum gadget amount.
 *
 * @return the calculated monthly premium
 */
    public double calculateMonthly(){

switch (gadgetNum) {
    case 1:
        if (maxGadget <= maxGadget1) {
            premium1 = 5.99;
        } else if (maxGadget <= maxGadget2) {
            premium1 = 7.15;
        } else if (maxGadget <= maxGadget3) {
            premium1 = 8.30;
        }
        break;
    case 2:
    case 3:
        if (maxGadget <= maxGadget1) {
            premium1 = 10.99;
        } else if (maxGadget <= maxGadget2) {
            premium1 = 13.35;
        } else if (maxGadget <= maxGadget3) {
            premium1 = 15.55;
        }
        break;
    case 4:
    case 5:
        if (maxGadget <= maxGadget1) {
            premium1 = 15.99;
        } else if (maxGadget <= maxGadget2) {
            premium1 = 19.60;
        } else if (maxGadget <= maxGadget3) {
            premium1 = 22.82;
        }
        break;

    default:System.out.println("Rejected");
        break;
}

return premium1;

    }
 /**
 * Calculates and returns the monthly premium based on the excess value.
 *
 * @return the calculated monthly premium
 */
    public double calculateDiscount(){
     if (excess > 70 || excess < 30 || (excess % 10 != 0)){
                   System.out.println("Rejected"); 
        }else if (excess == 30){
            monthlyPremium = calculateMonthly();
                return monthlyPremium;
        }else if (excess == 40){
            double discount = calculateMonthly() * discount40;
            monthlyPremium = calculateMonthly() - discount;
            return monthlyPremium;
        }else if (excess == 50){
            double discount = calculateMonthly() * discount50;
            monthlyPremium = calculateMonthly() - discount;
            return monthlyPremium;
        }else if (excess == 60){
            double discount = calculateMonthly()* discount60;
            monthlyPremium = calculateMonthly() - discount;
            return monthlyPremium;
        }else if (excess == 70){
            double discount = calculateMonthly() * discount70;
            monthlyPremium = calculateMonthly() - discount;
            return monthlyPremium;
    }
        System.exit(0);
        return 0;
              
    }
 /**
 * Calculates and returns the annual premium based on the excess value.
 *
 * @return the calculated annual premium
 */
    public double calculateAnnual(){
         
         if (excess > 70 || excess < 30 || (excess % 10 != 0)){
                   System.out.println("Rejected"); 
        }else if (excess == 30){
            monthlyPremium = calculateMonthly();
                year = 12 *  monthlyPremium ;
                aPremium = year * annualDiscount;
                 premium = year - aPremium;
                    return premium;
        }else if (excess == 40){
            double discount = calculateMonthly() * discount40;
            monthlyPremium = calculateMonthly() - discount;
             year = 12 *  monthlyPremium ;
                aPremium = year * annualDiscount;
                 premium = year - aPremium;
                    return premium;
        }else if (excess == 50){
            double discount = calculateMonthly() * discount50;
            monthlyPremium = calculateMonthly() - discount;
            year = 12 *  monthlyPremium ;
                aPremium = year * annualDiscount;
                 premium = year - aPremium;
                    return premium;
        }else if (excess == 60){
            double discount = calculateMonthly()* discount60;
            monthlyPremium = calculateMonthly() - discount;
             year = 12 *  monthlyPremium ;
                aPremium = year * annualDiscount;
                 premium = year - aPremium;
                    return premium;
        }else if (excess == 70){
            double discount = calculateMonthly() * discount70;
            monthlyPremium = calculateMonthly() - discount;
             year = 12 *  monthlyPremium ;
                aPremium = year * annualDiscount;
                 premium = year - aPremium;
                    return premium;
    }
        System.exit(0);
        return 0;
                 
         
    }
 /**
 * Returns the term of the insurance policy based on the payment terms.
 *
 * @return the term of the insurance policy ("Monthly" or "Annual")
 */
    public String getterm (){
       if (paymentTerms == null) {
    System.exit(0);
}

switch (paymentTerms) {
    case "M":
        term = "Monthly";
        break;
    case "A":
        term = "Annual";
        break;
    default:
        System.out.println("Wrong Input");
        return null;
}

return term;

           
    }
 /**
 * Determines the payment status based on the gadget number and maximum gadget value.
 *
 * @return the payment status ("R" for Rejected or the payment term)
 */        
    public String paymentStatus(){
     if ((gadgetNum < 1 || gadgetNum > 5) || (maxGadget <1 || maxGadget > 1000)){
              status = "R";
                return status;
        }else{
                status = paymentTerms;
                return status;
                        }
}

 /**
 * Displays the premium based on the payment terms.
 *
 * @return the calculated premium amount
 * @throws IllegalArgumentException if the payment terms are invalid
 */  
 public double displayPremium(){
 switch (paymentTerms) {
    case "M":
        prem = calculateDiscount();
        return prem;
    case "A":
        prem = Math.round(calculateAnnual()*100.0)/100.0;
        return prem;
    default:
        throw new IllegalArgumentException("Invalid payment terms: " + paymentTerms);
}


     }
 /**
 * Returns a string representation of the policy.
 *
 * @return a formatted string containing client information, policy details, and premium
 */
    @Override
 public String toString(){
     System.out.println("");           
     System.out.print("+");
     for (int i = 0; i < 45; i++){
     System.out.print("=");
     }   
     System.out.print("+");
     System.out.println(" "); 
     String currentDate = DateHelper.getDate();
     System.out.println("|\t"+"Client: "+clientName+"\t\t\t|");
     System.out.print("|\t"+ "Date: " + currentDate+ "\t"+ "Ref: "+ reference+ "\t|");
     System.out.println("");
     System.out.print("|\t"+  "Term: "+  getterm() +"\t\t"+ "Items: "+ gadgetNum() +"\t|");
     System.out.println("");
     System.out.println("|\t" + "Excess:£" + excess + "\t\t\t\t|");
     System.out.println("|\t\t\t\t\t\t|");
     System.out.print("|\t"+ getterm() + "\t\t\t"+ "Limit per" + "\t|");
     System.out.println("");
     System.out.print("|\t" + "Premium:£"+ displayPremium() +"\t\t" + "Gadget: " + gadgetValue() + "\t|" );    
     System.out.println("");          
     System.out.print("+");
     for (int k=0; k<45;k++){
        System.out.print("=");
        }
        System.out.print("+");
        System.out.println("");
         
        return null;
 }
 
     
 
} 

       
 
  



