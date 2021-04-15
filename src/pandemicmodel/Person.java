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
    static double stepX, stepY;
    static int stepCount, requiredStepNum;
    static boolean walking = true;
    public static ThemePark Park;
    public Attraction currentAttraction;

    public Person(boolean infect, ThemePark park){
        infected = infect;
        Person.enterPark();
        Park = park;
    }
    
    public static Point enterPark(){
        personPoint.setLocation(Park.layout.ent);
        stepSize();
        return personPoint;
    }
    
    public static int walkingSpeed(){
        pace = rand.nextInt(10);
        return pace;
    }
    
    public static Point nextLoc(){
        int randX, randY;
        dest = rand.nextInt(Park.layout.attractions.size() +1);
        //THIS NEXT PART NEEDS TO BE CHANGED TO SET desCoord TO CERTAIN LOCATION GIVEN IN PARK LAYOUT
        desPoint = Park.layout.attractions.get(dest).location;
        return desPoint;
    }
    
    public static void stepSize(){
        desPoint = Person.nextLoc();
        pace = Person.walkingSpeed();
        stepCount = 0;
        
        
        double totX, totY, theta, totDist;
        double xInit, xDes, yInit, yDes;
        
        xInit = personPoint.getX();
        yInit = personPoint.getY();
        xDes = desPoint.getX();
        yDes = desPoint.getY();
        
        if(xDes>=xInit){
            totX = xDes - xInit;
            totY = yDes - yInit;
            totDist = Math.sqrt(Math.pow(totX, 2) + Math.pow(totY, 2));
            theta = Math.atan(totY/totX);
            requiredStepNum = (int)totDist%pace;
            stepX = pace*Math.cos(theta);
            stepY = pace*Math.sin(theta);
            
        }
        else{
            totX = xInit - xDes;
            totY = yInit - yDes;
            totDist = Math.sqrt(Math.pow(totX, 2) + Math.pow(totY, 2));
            theta = Math.atan(totY/totX);
            requiredStepNum = (int)totDist%pace;
            stepX = -1*pace*Math.cos(theta);
            if(yInit>=yDes){
                stepY = -1*pace*Math.sin(theta);
            }
            else{
                stepY = pace*Math.sin(theta);
            }
        }
    }
    public void enterLine(int dest){
        currentAttraction = Park.layout.attractions.get(dest);
        currentAttraction.line.add(this);
    }
    public Point Update(){
        if (stepCount<requiredStepNum){
            personPoint.move((int)stepX, (int)stepY);
            stepCount+=1;
        }
        else if (stepCount==requiredStepNum){
            //do something based on where they are...i.e. enter ride or sit down at table
            if (walking){
                enterLine(dest);
            }
            else if (timeAtDestination<totalTime){
                //stay at attraction

            }
            else{
                walking = true;
                stepCount+=1;
            }
        }
        else{
            stepSize();
            personPoint.move((int)stepX, (int)stepY);
            stepCount+=1;
        }
        return personPoint;
    }
}
