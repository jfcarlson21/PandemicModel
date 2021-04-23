/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author lainiecederholm
 */
        
public class Financials {
    public Financials(gui inputs){
        Scanner fileIn = null;
        double minWage, ticketPrice, totTicketRev, hours;
        double priceRags, priceBleach, employeeWage, totExpenses;
        int maxCapacity;
        int employee = inputs.employeeNumber;
        minWage = inputs.minWage;
        hours = inputs.hours;
        double capacity = inputs.percentCapacity;
        maxCapacity = inputs.maxCapacity;
        ticketPrice = inputs.ticketPrice;
        
        
        employeeWage = employee*minWage*hours;
        priceRags = employee*100*50/250;
        priceBleach = employee*60/8;
        totExpenses = employeeWage+priceRags+priceBleach;
        totTicketRev = capacity*maxCapacity*ticketPrice;
        
        try{
                java.io.FileWriter mW = new java.io.FileWriter("financeOutput.txt");
                mW.write(Double.toString(totExpenses));
                mW.write("\n");
                mW.write(Double.toString(totTicketRev));
                mW.close();
            }
        
            catch(IOException e){
                System.out.println("error");
                e.printStackTrace();
            }
        
        
    }
  
    
}
