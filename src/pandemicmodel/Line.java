/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;

import java.util.ArrayList;

/**
 *
 * @author lainiecederholm
 */
public class Line extends java.util.ArrayList<Person>{
    int leaveSize;
    int length = 0;
    Attraction attraction;
    public Line(int leaveRate, Attraction attraction1){
        attraction = attraction1;
        leaveSize = leaveRate;

    }

    
}
