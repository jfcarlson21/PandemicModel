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
    public Financials(String fileName, double capacity, int employee){
        Scanner fileIn = null;
        double minWage, ticketPrice, totTicketRev, hours;
        double priceRags, priceBleach, employeeWage, totExpenses;
        int maxCapacity;
        try {
            // attempt to open the file
            fileIn = new Scanner(new FileInputStream (fileName));
        }
        catch (FileNotFoundException e) {
            // if the file could nnot be found, this code is executed
            // then the program exits
            System.out.println("File not found (finances).");
            System.exit(0);
        }
        fileIn.useDelimiter(",");
        minWage = fileIn.nextDouble();
        ticketPrice = fileIn.nextDouble();
        maxCapacity = fileIn.nextInt();
        hours = fileIn.nextInt();
        
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
