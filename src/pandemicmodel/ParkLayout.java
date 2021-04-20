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
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author lainiecederholm
 */
public class ParkLayout {
    ArrayList<Attraction> attractions = new ArrayList();
    HashMap<Attraction, String> attractionsToNames = new HashMap<Attraction, String>();
    public Point ent = new Point();
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
        fileIn.useDelimiter(",|\\n");
        while(fileIn.hasNext()){

            String type = fileIn.next();
            String name = fileIn.next();
            x = fileIn.nextInt();
            y = fileIn.nextInt();
            int timeAt = fileIn.nextInt();
            Point loc = new Point(x,y);
            System.out.println(type);
            switch (type){
                case "Ride" -> {
                    //build ride
                    Attraction ride = new Attraction(loc, timeAt, 15, 8);
                    attractions.add(ride);
                    attractionsToNames.put(ride, name);
                    break;
                }
                case "FoodCourt" -> {
                    //build foodCourt
                    Attraction fc = new Attraction(loc, timeAt, 30, 4);
                    attractions.add(fc);
                    System.out.println("fc");
                    attractionsToNames.put(fc, name);
                    break;
                }
                case "Entrance" -> {//build entrance
                    ent = loc;
                    break;
                }

            }

        }
    }
    
    
    
}
