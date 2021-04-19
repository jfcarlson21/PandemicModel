/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;


import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lainiecederholm
 */
public class ParkLayout {
    ArrayList<Attraction> attractions = new ArrayList();
    public Point ent;
    public ParkLayout(String fileName){
        Scanner fileIn = null ; //initialiazed file to empty//initialiazed file to empty
        int counter = 0;
        int x,y;
        try {
            // attempt to open the file
            fileIn = new Scanner(new FileInputStream (fileName));
        }
        
        catch (FileNotFoundException e) {
            // if the file could nnot be found, this code is executed
            // then the program exits
            System.out.println("File not found(layout).");
            System.exit(0);
        }
        fileIn.useDelimiter(",");
        while(fileIn.hasNext()){
            String type = fileIn.next();
            String name = fileIn.next();
            x = fileIn.nextInt();
            y = fileIn.nextInt();
            int timeAt = fileIn.nextInt();
            Point loc = new Point(x,y);
            switch (type){
                case "Ride" -> {
                    //build ride
                    Ride ride = new Ride(loc, timeAt, 15, 8);
                    attractions.add(ride);
                }
                case "FoodCourt" -> {
                    //build foodCourt
                    FoodCourt fc = new FoodCourt(loc, timeAt);
                    attractions.add(fc);
                }
                case "Entrance" -> //build entrance
                    ent = loc;
                default -> System.out.println("error");
            }    
        }
    }
    
    
    
}
