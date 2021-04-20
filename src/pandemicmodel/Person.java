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

    boolean doneWithDestination = false;
    double infected;
    static Point personPoint = new Point();
    static Point desPoint = new Point();
    static ArrayList<Integer> personCoord = new ArrayList<>();
    static ArrayList<Integer> desCoord = new ArrayList<>();
    static Random rand = new Random();

    int timeAtDestination;
    static int pace;
    static int dest;
    static double stepX, stepY;
    static int stepCount, requiredStepNum;
    static boolean walking = true;
    public Attraction currentAttraction;
    public static ThemePark Park;

    public Person(double infect, ThemePark park){
        infected = infect;
        Park = park;
        personPoint.setLocation(Park.layout.ent);
        stepSize();

    }

    
    public static int walkingSpeed(){
        pace = rand.nextInt(10) +1;
        return pace;
    }
    
    public static Point nextLoc(){
        int randX, randY;
        int bound = Park.layout.attractions.size() +1;
        dest = rand.nextInt(bound);
        //THIS NEXT PART NEEDS TO BE CHANGED TO SET desCoord TO CERTAIN LOCATION GIVEN IN PARK LAYOUT
        if (dest < bound-1) {
            desPoint = Park.layout.attractions.get(dest).location;
        }
        else{
            randX = rand.nextInt(51);
            randY = rand.nextInt(51);
            desPoint.setLocation(randX,randY);
        }
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
        doneWithDestination = false;
    }

    public void leaveAttraction(){
    }

    public void update(){


        double random = rand.nextDouble();
        if (random<infected){
            infected = 1;
        }
        else{
            infected = 0;
        }


        if (stepCount<requiredStepNum){
            personPoint.move((int)stepX, (int)stepY);
            stepCount+=1;
            System.out.println("just took a step");
        }
        else if (stepCount==requiredStepNum&&dest<Park.layout.attractions.size()){
            //do something based on where they are...i.e. enter ride or sit down at table
            if (walking){
                enterLine(dest);
            }
            else if (doneWithDestination){
                leaveAttraction();
                walking = true;
                stepCount=0;
            }
            else{
                //nothing, its handled by the attraction at this point

            }

        }
        else{
            stepSize();
            personPoint.move((int)stepX, (int)stepY);
            stepCount+=1;
            System.out.println("new location");
        }
    }
}
