/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lainiecederholm
 */
public class Person {
    boolean infected;
    static Point personPoint = new Point();
    static Point desPoint = new Point();
    static ArrayList<Integer> personCoord = new ArrayList<>();
    static ArrayList<Integer> desCoord = new ArrayList<>();
    static Random rand = new Random();
    
    static int pace;
    static int dest;

    public Person(boolean infect){
        infected = infect;
    }
    
    public static Point enterPark(){
        personPoint.move(50, 100);
        return personPoint;
    }
    
    public static int walkingSpeed(){
        pace = rand.nextInt(10);
        return pace;
    }
    
    public static Point nextLoc(){
        int randX, randY;
        dest = rand.nextInt(7);
        //THIS NEXT PART NEEDS TO BE CHANGED TO SET desCoord TO CERTAIN LOCATION GIVEN IN PARK LAYOUT
        switch(dest){
            case 0 -> {
                //FC1
                desPoint.setLocation(15, 15);
            }
            case 1 -> {
                //R1
                desPoint.setLocation(25,50);
            }
            case 2 -> {
                //FC2
                desPoint.setLocation(25, 80);
            }
            case 3 -> {
                //R2
                desPoint.setLocation(80, 20);
            }
            case 4 -> {
                //R3
                desPoint.setLocation(85, 45);
            }
            case 5 -> {
                //FC3
                desPoint.setLocation(90, 80);
            }
            default -> {
                randX = 30+rand.nextInt(40);
                randY = rand.nextInt(100);
                desPoint.setLocation(randX,randY);
            }
        }
        return desPoint;
    }
    
    public static Point move(){
        desPoint = Person.nextLoc();
        pace = Person.walkingSpeed();
        
        
        double totX, totY, theta, stepX, stepY, totDist;
        double xInit, xDes, yInit, yDes, stepNum;
        
        xInit = personPoint.getX();
        yInit = personPoint.getY();
        xDes = desPoint.getX();
        yDes = desPoint.getY();
        
        if(xDes>=xInit){
            totX = xDes - xInit;
            totY = yDes - yInit;
            totDist = Math.sqrt(Math.pow(totX, 2) + Math.pow(totY, 2));
            theta = Math.atan(totY/totX);
            stepNum = (int)totDist%pace;
            stepX = pace*Math.cos(theta);
            stepY = pace*Math.sin(theta);
            
        }
        else{
            totX = xInit - xDes;
            totY = yInit - yDes;
            totDist = Math.sqrt(Math.pow(totX, 2) + Math.pow(totY, 2));
            theta = Math.atan(totY/totX);
            stepNum = (int)totDist%pace;
            stepX = -1*pace*Math.cos(theta);
            if(yInit>=yDes){
                stepY = -1*pace*Math.sin(theta);
            }
            else{
                stepY = pace*Math.sin(theta);
            }
        }
        
        for(int i=0; i<stepNum; i++){
                x = personCoord.get(0);
                y = personCoord.get(1);
                personCoord.remove(0);
                personCoord.remove(1);
                personCoord.add((int)(x+stepX));
                personCoord.add((int)(y+stepY));
            }
        personCoord.remove(0);
        personCoord.remove(1);
        personCoord.add(desCoord.get(0));
        personCoord.add(desCoord.get(1));
        
        return personPoint;
    }
}
