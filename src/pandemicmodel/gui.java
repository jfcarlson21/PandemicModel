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
    public String layoutFile;
    public int maxCapacity;
    public double percentCapacity;
    public double percentInfected;
    public int employeeNumber;
    public double minWage;
    public double ticketPrice;
    public double hours;
    
    public void parkInfoGUI() throws IOException{
        JPanel generalParkPanel = new JPanel();
        GridLayout layout = new GridLayout(0,2);
        generalParkPanel.setLayout(layout);
        JLabel filePrompt, maxCapPrompt, percentCapPrompt, percentInfPrompt, employeeNumPrompt;
        JLabel minWagePrompt, ticketPricePrompt, hoursPrompt;
        filePrompt = new JLabel("Park Layout File Name: ");
        JTextField fileName = new JTextField(20);
        maxCapPrompt = new JLabel("Maximum Capacity: ");
        JTextField maximumCapacity = new JTextField(20);
        percentCapPrompt = new JLabel("Percent Capacity: ");
        JTextField percentCap = new JTextField(20);
        percentInfPrompt = new JLabel("Initial Percent Infected: ");
        JTextField percentInf = new JTextField(20);
        employeeNumPrompt = new JLabel("Number of Sanitation Employees: ");
        JTextField employeeNum = new JTextField(20);
        minWagePrompt = new JLabel("State Minimum Wage: ");
        JTextField minimumWage = new JTextField(20);
        ticketPricePrompt = new JLabel("Ticket Price: ");
        JTextField tickPrice = new JTextField(20);
        hoursPrompt = new JLabel("Number of Hours Open: ");
        JTextField hrs = new JTextField(20);
        
        generalParkPanel.add(filePrompt);
        generalParkPanel.add(fileName);
        generalParkPanel.add(maxCapPrompt);
        generalParkPanel.add(maximumCapacity);
        generalParkPanel.add(percentCapPrompt);
        generalParkPanel.add(percentCap);
        generalParkPanel.add(percentInfPrompt);
        generalParkPanel.add(percentInf);
        generalParkPanel.add(employeeNumPrompt);
        generalParkPanel.add(employeeNum);
        generalParkPanel.add(minWagePrompt);
        generalParkPanel.add(minimumWage);
        generalParkPanel.add(ticketPricePrompt);
        generalParkPanel.add(tickPrice);
        generalParkPanel.add(hoursPrompt);
        generalParkPanel.add(hrs);
        
        int result = JOptionPane.showConfirmDialog(null, generalParkPanel, 
                    "Please enter some general park info", JOptionPane.CLOSED_OPTION);
        
        layoutFile = fileName.getText();
        maxCapacity = Integer.getInteger(maximumCapacity.getText());
        percentCapacity = Double.parseDouble(percentCap.getText());
        percentInfected = Double.parseDouble(percentInf.getText());
        employeeNumber = Integer.getInteger(employeeNum.getText());
        minWage = Double.parseDouble(minimumWage.getText());
        ticketPrice = Double.parseDouble(tickPrice.getText());
        hours = Double.parseDouble(hrs.getText());
    }        
}
