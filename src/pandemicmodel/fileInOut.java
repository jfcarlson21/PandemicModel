/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lainiecederholm
 */
public class fileInOut {
    static Point ent;
    public fileInOut(){
        Scanner fileIn = null ; //initialiazed file to empty//initialiazed file to empty
        int counter = 0;
        int x,y;
        try {
            // attempt to open the file
            fileIn = new Scanner(new FileInputStream ("disneyLayout.txt"));
        }
        
        catch (FileNotFoundException e) {
            // if the file could nnot be found, this code is executed
            // then the program exits
            System.out.println("File not found.");
            System.exit(0);
        }
        
        while(fileIn.hasNext()){
            String next = fileIn.next();
            x = fileIn.nextInt();
            y = fileIn.nextInt();
            Point loc = new Point(x,y);
            switch (next){
                case "Ride":
                    //build ride
                    Ride ride = new Ride(loc, 15, 8);
                    break;
                case "FoodCourt":
                    //build foodCourt
                    FoodCourt fc = new FoodCourt(loc);
                    break;
                case "Entrance":
                    //build entrance
                    ent = loc;
                    break;
                default:
                    System.out.println("error");
                    break;
            }    
        }
    }
}
