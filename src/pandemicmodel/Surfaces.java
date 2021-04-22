/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author lainiecederholm
 */

public class Surfaces {
    static Random rand = new Random();
    double probInfect = 0;
    double INITIALPROBSPREAD;
    double cleanFactor =  1;
    double gettingInfectedProb = 1;
    HashMap<String, Double> surfaceInfectionRates = new HashMap<String, Double>();

    public Surfaces(String type) {
        surfaceInfectionRates.put("steel",0.1);
        surfaceInfectionRates.put("wood",0.1);
        surfaceInfectionRates.put("plastic",0.1);
        INITIALPROBSPREAD = surfaceInfectionRates.get(type);
    }
    
    public void infectSurface(){
        probInfect = cleanFactor * INITIALPROBSPREAD;
    }
    public void clean(){
        probInfect=0;
    }
}
