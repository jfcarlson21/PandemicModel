/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author lainiecederholm
 */
public class gui {
    public static void parkInfoGUI() throws IOException{
        JPanel generalParkPanel = new JPanel();
        GridLayout layout = new GridLayout(0,2);
        generalParkPanel.setLayout(layout);
        JLabel filePrompt, maxCapPrompt, percentCapPrompt, percentInfPrompt, employeeNumPrompt;
        filePrompt = new JLabel("New File Name: ");
        JTextField fileName = new JTextField(20);
        maxCapPrompt = new JLabel("Maximum Capacity: ");
        JTextField maxCapacity = new JTextField(20);
        percentCapPrompt = new JLabel("Percent Capacity: ");
        JTextField percentCapacity = new JTextField(20);
        percentInfPrompt = new JLabel("Initial Percent Infected: ");
        JTextField percentInfected = new JTextField(20);
        employeeNumPrompt = new JLabel("Number of Employees: ");
        JTextField employeeNum = new JTextField(20);
        
        generalParkPanel.add(filePrompt);
        generalParkPanel.add(fileName);
        generalParkPanel.add(maxCapPrompt);
        generalParkPanel.add(maxCapacity);
        generalParkPanel.add(percentCapPrompt);
        generalParkPanel.add(percentCapacity);
        generalParkPanel.add(percentInfPrompt);
        generalParkPanel.add(percentInfected);
        generalParkPanel.add(employeeNumPrompt);
        generalParkPanel.add(employeeNum);
        
        int result = JOptionPane.showConfirmDialog(null, generalParkPanel, 
                    "Please enter some general park info", JOptionPane.CLOSED_OPTION);
        String fName = fileName.getText()+".txt";
        Scanner fileIn = null ;
        try{
            File myObj = new File(fName);
            if(myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            }
            else{
                System.out.println("error file already exists");
            }
        }
        
        catch(IOException e){
            System.out.println("error");
            System.exit(0);
        }
        
        FileWriter mW = new FileWriter(fName);
        
        try{
                mW.write(maxCapacity.getText());
                mW.write(",");
                mW.write(percentCapacity.getText());
                mW.write(",");
                mW.write(percentInfected.getText());
                mW.write(",");
                mW.write(employeeNum.getText());
                mW.write(",");
                System.out.println("Success");
            }
        
            catch(IOException e){
                System.out.println("error");
                e.printStackTrace();
            }
        
        mW.close();
    }
    
    public static void financeInfoGUI() throws IOException{
        JPanel finPanel = new JPanel();
        GridLayout layout = new GridLayout(0,2);
        finPanel.setLayout(layout);
        JLabel filePrompt, minWagePrompt, ticketPricePrompt, hoursPrompt;
        filePrompt = new JLabel("New File Name: ");
        JTextField fileName = new JTextField(20);
        minWagePrompt = new JLabel("State Minimum Wage: ");
        JTextField minWage = new JTextField(20);
        ticketPricePrompt = new JLabel("Ticket Price: ");
        JTextField ticketPrice = new JTextField(20);
        hoursPrompt = new JLabel("Number of Hours Open: ");
        JTextField hours = new JTextField(20);
        
        finPanel.add(filePrompt);
        finPanel.add(fileName);
        finPanel.add(minWagePrompt);
        finPanel.add(minWage);
        finPanel.add(ticketPricePrompt);
        finPanel.add(ticketPrice);
        finPanel.add(hoursPrompt);
        finPanel.add(hours);
        
        int result = JOptionPane.showConfirmDialog(null, finPanel, 
                    "Please enter some general park info", JOptionPane.CLOSED_OPTION);
        String fName = fileName.getText()+".txt";
        Scanner fileIn = null ;
        try{
            File myObj = new File(fName);
            if(myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            }
            else{
                System.out.println("error file already exists");
            }
        }
        
        catch(IOException e){
            System.out.println("error");
            System.exit(0);
        }
        
        FileWriter mW = new FileWriter(fName);
        
        try{
                mW.write(minWage.getText());
                mW.write(",");
                mW.write(ticketPrice.getText());
                mW.write(",");
                mW.write(hours.getText());
                mW.write(",");
                System.out.println("Success");
            }
        
            catch(IOException e){
                System.out.println("error");
                e.printStackTrace();
            }
        
        mW.close();
        
    }
        
}
