/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lainiecederholm
 */
public class fileInOut {
    public fileInOut(){
        Scanner fileIn = null ; //initialiazed file to empty//initialiazed file to empty
        int counter = 0;
        double x,y;
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
            switch (next){
                case "Ride":
                    //build ride
                    break;
                case "FoodCourt":
                    //build foodCourt
                    break;
                case "Entrance":
                    //build entrance
                    break;
                default:
                    System.out.println("error");
                    break;
            }    
        }
    }
}
