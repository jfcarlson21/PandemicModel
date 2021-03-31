/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lainiecederholm
 */
public class Person {
    boolean infected;
    static ArrayList<Integer> personCoord = new ArrayList<>();
    static ArrayList<Integer> desCoord = new ArrayList<>();
    static Random rand = new Random();
    
    static int pace;
    static int dest;

    public Person(boolean infect){
        infected = infect;
    }
    
    public static ArrayList enterPark(){
        personCoord.add(50);
        personCoord.add(100);
        return personCoord;
    }
    
    public static int walkingSpeed(){
        pace = rand.nextInt(10);
        return pace;
    }
    
    public static ArrayList nextLoc(){
        int randX, randY;
        dest = rand.nextInt(7);
        switch(dest){
            case 0 -> {
                //FC1
                desCoord.add(15);
                desCoord.add(15);
            }
            case 1 -> {
                //R1
                desCoord.add(25);
                desCoord.add(50);
            }
            case 2 -> {
                //FC2
                desCoord.add(25);
                desCoord.add(80);
            }
            case 3 -> {
                //R2
                desCoord.add(80);
                desCoord.add(20);
            }
            case 4 -> {
                //R3
                desCoord.add(85);
                desCoord.add(45);
            }
            case 5 -> {
                //FC3
                desCoord.add(90);
                desCoord.add(80);
            }
            default -> {
                randX = 30+rand.nextInt(40);
                randY = rand.nextInt(100);
            }
        }
        return desCoord;
    }
    
    public static ArrayList move(){
        desCoord = Person.nextLoc();
        pace = Person.walkingSpeed();
        
        
        double totX, totY, theta, stepX, stepY, totDist, x, y;
        int xInit, xDes, yInit, yDes, stepNum;
        
        xInit = personCoord.get(0);
        yInit = personCoord.get(1);
        xDes = desCoord.get(0);
        yDes = desCoord.get(1);
        
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
        
        return personCoord;
    }
}
