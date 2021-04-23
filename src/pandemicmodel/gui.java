/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
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
    public ArrayList<String> stringList = new ArrayList<>();
    public ArrayList<Integer> intList = new ArrayList<>();
    public ArrayList<String> cleanList = new ArrayList<>();
            
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
        employeeNumPrompt = new JLabel("Number of Employees: ");
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
        maxCapacity = Integer.parseInt(maximumCapacity.getText());
        percentCapacity = Double.parseDouble(percentCap.getText());
        percentInfected = Double.parseDouble(percentInf.getText());
        employeeNumber = Integer.parseInt(employeeNum.getText());
        minWage = Double.parseDouble(minimumWage.getText());
        ticketPrice = Double.parseDouble(tickPrice.getText());
        hours = Double.parseDouble(hrs.getText());
        
    }
    
    public void outputGui(int totalInfe){
        JPanel outputPanel1 = new JPanel();
        GridLayout layout = new GridLayout(0,3);
        outputPanel1.setLayout(layout);
        JLabel rideName = new JLabel("Name of Ride");
        JLabel infectNum = new JLabel("People Infected at Ride");
        JLabel sanitationStatus = new JLabel("Sanitation Status");
        outputPanel1.add(rideName);
        outputPanel1.add(sanitationStatus);
        outputPanel1.add(infectNum);
        
        while(!stringList.isEmpty() && !intList.isEmpty()){
            JLabel ride = new JLabel(stringList.get(0));
            JLabel infNum = new JLabel("\t"+Integer.toString(intList.get(0)));
            JLabel cleanStat = new JLabel(cleanList.get(0));
            outputPanel1.add(ride);
            outputPanel1.add(cleanStat);
            outputPanel1.add(infNum);
            stringList.remove(0);
            intList.remove(0);   
            cleanList.remove(0);
        }
        int result = JOptionPane.showConfirmDialog(null, outputPanel1, 
                    "Ride Specific Data", JOptionPane.CLOSED_OPTION);
        
        JPanel outputPanel2 = new JPanel();
        GridLayout layout2 = new GridLayout(0,2);
        outputPanel2.setLayout(layout2);
        JLabel tePrompt = new JLabel("Total Added Expenses");
        JLabel trPrompt = new JLabel("Total Ticket Revenue");
        JLabel tcPrompt = new JLabel("Total Capacity");
        JLabel iiPrompt = new JLabel("Initial Number of Infected");
        JLabel tiPrompt = new JLabel("Final Number of Infected");
        
        double employeeWage = employeeNumber*minWage*hours;
        int totCap = (int)((int)maxCapacity*percentCapacity);
        int totInf = (int)(maxCapacity*percentInfected*percentInfected);
        double priceRags = employeeNumber*100*50/250;
        double priceBleach = employeeNumber*60/8;
        double totExpenses = employeeWage+priceRags+priceBleach;
        double totTicketRev = percentCapacity*maxCapacity*ticketPrice;
        
        JLabel te = new JLabel(Double.toString(totExpenses));
        JLabel tr = new JLabel(Double.toString(totTicketRev));
        JLabel tc = new JLabel(Integer.toString(totCap));
        JLabel ii = new JLabel(Integer.toString(totInf));
        JLabel ti = new JLabel(Integer.toString(totalInfe));
        
        outputPanel2.add(tcPrompt);
        outputPanel2.add(tc);
        outputPanel2.add(iiPrompt);
        outputPanel2.add(ii);
        outputPanel2.add(tiPrompt);
        outputPanel2.add(ti);
        outputPanel2.add(tePrompt);
        outputPanel2.add(te);
        outputPanel2.add(trPrompt);
        outputPanel2.add(tr);
        int result2 = JOptionPane.showConfirmDialog(null, outputPanel2, 
                    "Park Results", JOptionPane.CLOSED_OPTION);
        
    }
        
}
