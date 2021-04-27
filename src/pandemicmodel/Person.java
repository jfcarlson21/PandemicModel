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
    boolean infect = false;
    double infected;
    Point personPoint = new Point();
    Point desPoint = new Point();
    Random rand = new Random();
    int rideCounter;
    int pace;
    int dest;
    double stepX, stepY;
    int stepCount, requiredStepNum;
    boolean walking = true;
    public Attraction currentAttraction;
    public ThemePark Park;
    public String output;

    public Person(double infect, ThemePark park){
        infected = infect;
        Park = park;
        personPoint.setLocation(Park.layout.ent);
        stepSize();
    }
    
    public int walkingSpeed(){
        pace = rand.nextInt(3) +1;
        return pace;
    }
    
    public Point nextLoc(){
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
    
    public void stepSize(){
        desPoint = nextLoc();
        pace = walkingSpeed();
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
            requiredStepNum = (int)totDist/pace;
            stepX = pace*Math.cos(theta);
            if(yInit>=yDes){
                stepY = -1*pace*Math.sin(theta);
            }
            else{
                stepY = pace*Math.sin(theta);
            }
            
        }
        else{
            totX = xInit - xDes;
            totY = yInit - yDes;
            totDist = Math.sqrt(Math.pow(totX, 2) + Math.pow(totY, 2));
            theta = Math.atan(totY/totX);
            requiredStepNum = (int)totDist/pace;
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
        output = "";
        double random = rand.nextDouble();
        if (random<infected && !infect){
            infected = 1;
            output += "INFECTED! SAD!\n";
            infect=true;
            //try catch because currentAttraction could be null
            try {
                currentAttraction.infectionCounter += 1;
            }
            catch (NullPointerException e){

            }
        }
        else{
            infected = 0;
        }

        if (stepCount<requiredStepNum){
            stepCount+=1;
            output+= "Taking step ("   + stepCount+"/"+requiredStepNum+") towards attraction " + dest;
            personPoint.move((int)stepX, (int)stepY);
        }
        else if (stepCount==requiredStepNum&&dest<Park.layout.attractions.size()){
            //do something based on where they are...i.e. enter ride or sit down at table
            if (walking){
                rideCounter+=1;
                enterLine(dest);
                output+="Entering line for attraction "+dest;
                walking = false;
            }
            else if (doneWithDestination){
                leaveAttraction();
                walking = true;
                stepCount+=1;
                doneWithDestination=false;
                output+="Leaving attraction " + dest;
            }
            else{
                output+="Still on attraction " + dest;
                //nothing, chillin on attraction
            }

        }
        else{
            stepSize();
            output += "Finding a new destination\n";
            personPoint.move((int)stepX, (int)stepY);
            stepCount+=1;
            output+= "Taking step ("   + stepCount+"/"+requiredStepNum+") towards attraction " + dest;

        }
    }
}
